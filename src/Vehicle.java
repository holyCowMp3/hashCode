import java.util.ArrayList;

public class Vehicle {
    private ArrayList<Road> roads;

    public Vehicle(){
    }


    public ArrayList<Road> getRoads() {
        return roads;
    }

    public boolean addRoad(Road road){
        roads.add(road);
    }
}
