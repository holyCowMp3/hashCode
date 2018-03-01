import java.util.ArrayList;
import java.util.List;

public class City {
    private int rows;
    private int columns;
    private int numberOfVehicles;
    private int rides;
    private int bonus;
    private int steps;
    private ArrayList<Road> roads;

    private ArrayList<Vehicle> vehicles;

    public City(List<String> list) {
        String[] strings = list.get(0).split(" ");
        rows = Integer.parseInt(strings[1]);
        columns = Integer.parseInt(strings[2]);
        vehicles = Integer.parseInt(strings[3]);
        rides = Integer.parseInt(strings[4]);
        bonus = Integer.parseInt(strings[5]);
        steps = Integer.parseInt(strings[6]);
        System.out.println(list.get(0));
        list.remove(0);
        System.out.println(list.get(0));
        list.stream().forEach(i -> roads.add(new Road(i)));

    }

    public ArrayList<Road> getRoads() {
        return roads;
    }

    public int getBonus() {
        return bonus;
    }

    public int getColumns() {
        return columns;
    }

    public int getRides() {
        return rides;
    }

    public int getRows() {
        return rows;
    }

    public int getSteps() {
        return steps;
    }

    public int getVehicles() {
        return vehicles;
    }
}
