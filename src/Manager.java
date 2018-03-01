import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;

public class Manager {
    List<String> lines = new ArrayList<>();
    private Road currentRoad;
    private City city;

    public Manager(City city){
        this.city=city;
    }


    public void choseCar(ArrayList<Vehicle> vehicles, Road road){
        ArrayList<Vehicle> cars = new ArrayList<>();
        for (Vehicle vehicle : vehicles ) {
            int way = Math.abs(vehicle.getRow() - road.getStartRow()) + Math.abs(vehicle.getColumn()-road.getStartColumn()) +
                    Math.abs(road.getStartColumn() - road.getEndColumn()) + Math.abs(road.getStartRow() - road.getEndRow());
            if (way < vehicle.getTtl() && way < road.getEndTime() - road.getStartTime())
                if (vehicle.getRoads().size() > 0)
                    if (!(vehicle.getRoads().get(vehicle.getRoads().size()-1).getEndTime() < road.getStartTime()))

        }
        

    }


    public void out() throws Exception{
        city.getVehicles().stream().filter(i -> i.getRoads().size()!=0).forEach(i -> lines.add(new String(city.getVehicles().indexOf(i) +" " + i.getRoads().stream().map(j -> j.getIdRoad()+"").collect(Collectors.joining(" ")))));
        Path file = Paths.get(Manager.class.getResource("1.out").toURI());
        Files.write(file,lines);
    }


}
