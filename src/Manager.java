import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.List;

import java.util.stream.Collectors;

public class Manager {
    List<String> lines = new ArrayList<>();
    private Road currentRoad;
    private City city;
    private int steps = 100;

    public Manager(City city){
        this.city=city;
    }


    public void choseCar(Road road){
        ArrayList<Vehicle> vehicles = city.getVehicles();
        findNearest(vehicles.get(0));
        System.out.println(vehicles.get(0));
        }


    public Road findNearest  (Vehicle vehicle){
        try {
       ArrayList<Road> nearestRoads = city.getRoads();
        Comparator<Road> comparator = (i,j) ->
                (Math.abs(i.getStartRow()-vehicle.getRow()) + Math.abs(i.getStartColumn()-vehicle.getColumn()) - (Math.abs(j.getStartRow()-vehicle.getRow()) + Math.abs(j.getStartColumn()-vehicle.getColumn())));
        comparator.thenComparing((a,b) -> a.getStartTime()-b.getStartTime());
        nearestRoads.sort(comparator);
        List<Road> ridersRoads =
       nearestRoads.stream().filter( i -> {
           int stepsToRoad = Math.abs(i.getStartRow()-vehicle.getRow()) + Math.abs(i.getStartColumn()- vehicle.getColumn());
           int stepsOnRoad = Math.abs(i.getEndRow()-i.getStartRow()) + Math.abs(i.getEndColumn()-i.getStartColumn());
           int stepsOnStarts = 0;
         //int stepsOnEnd = 0;
           if((city.getSteps()-vehicle.getTtl())<i.getStartTime())
               stepsOnStarts = i.getStartTime()-(city.getSteps()-vehicle.getTtl());
            //steps = vehicle.getTtl()-stepsOnRoad-stepsOnStarts-stepsToRoad;
           if((vehicle.getTtl()-stepsOnRoad-stepsOnStarts-stepsToRoad)>=0){
               return true;}
               else {
               return false;
           }
       }).collect(Collectors.toList());

        if (ridersRoads.size()!=0){
            System.out.println("road work");
            vehicle.rideRoad(ridersRoads.get(0), steps);
                return ridersRoads.get(0);
            }else {
            System.out.println("ConFICliCT");
                return null;
            }}
            catch (ConcurrentModificationException e){
                return  currentRoad;
            }


    }
    public void start(){
        ArrayList<Road> changableRoad = city.getRoads();
        changableRoad.stream().forEach(i -> choseCar(i));
    }

    public void out() throws Exception{


        city.getVehicles().stream().forEach(i -> System.out.println(i.toString()));

//   Path file = Paths.get(Manager.class.getResource("1.out").toURI());
      //  Files.write(file,lines);
    }


}
