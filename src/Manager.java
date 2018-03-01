import java.util.ArrayList;

public class Manager {

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





}
