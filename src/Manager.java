import java.io.BufferedWriter;
import java.nio.file.*;
import java.io.*;
import java.util.*;

import java.util.stream.Collectors;

public class Manager {

    private City city;
    private int steps;

    public Manager(City city){
        this.city=city;
    }


    public void choseCar(Road road){
        ArrayList<Vehicle> vehicles = city.getVehicles();


        if (findNearest(vehicles.get(0), city.getRoads())!=null)
            vehicles.forEach(i -> findNearest(i, city.getRoads()));

        }


    public Road findNearest  (Vehicle vehicle, ArrayList<Road> roads){
        try {
       ArrayList<Road> nearestRoads = roads;
        Comparator<Road> comparator = (i,j) ->
                (Math.abs(i.getStartRow()-vehicle.getRow()) + Math.abs(i.getStartColumn()-vehicle.getColumn()) - (Math.abs(j.getStartRow()-vehicle.getRow()) + Math.abs(j.getStartColumn()-vehicle.getColumn())));
        comparator.thenComparing((a,b) -> a.getStartTime()-b.getStartTime());
        nearestRoads.sort(comparator);
        List<Road> ridersRoads;
            ridersRoads = nearestRoads.stream().filter(i -> {
                int stepsToRoad = Math.abs(i.getStartRow()-vehicle.getRow()) + Math.abs(i.getStartColumn()- vehicle.getColumn());
                int stepsOnRoad = Math.abs(i.getEndRow()-i.getStartRow()) + Math.abs(i.getEndColumn()-i.getStartColumn());
                int stepsOnStarts = 0;
              //int stepsOnEnd = 0;
                if((city.getSteps()-vehicle.getTtl())<=i.getStartTime()) stepsOnStarts = i.getStartTime()-(city.getSteps()-vehicle.getTtl());
                 steps = vehicle.getTtl()-stepsOnRoad-stepsOnStarts-stepsToRoad;
                if((vehicle.getTtl()-stepsOnRoad-stepsOnStarts-stepsToRoad>=0)&&(steps<i.getEndTime())){
                    return true;}
                    else {
                    return false;
                }
            }).collect(Collectors.toList());
            if (ridersRoads.size()!=0){
            vehicle.rideRoad(ridersRoads.get(0), steps);
            return vehicle.getRoads().get(0);

            }else {

                return null;
            }}
            catch (ConcurrentModificationException e){
                return null;
            }


    }
    public void start(){
        for (int i = 0; i < city.getRoads().size() ; i++) {

            choseCar(city.getRoads().get(i));

        }
    }

    public void out() throws Exception{
        try (BufferedWriter bw = Files.newBufferedWriter (new File("2.out")
        .toPath())){
        for (int i = 0; i <city.getVehicles().size(); i++) {
            if (city.getVehicles().get(i).getRoads().size()!=0){
                    bw.append(city.getVehicles().get(i).toString());
                    bw.flush();
                    bw.newLine();
            }
        }
    } catch (Exception e){
            e.printStackTrace();
        }


}
}
