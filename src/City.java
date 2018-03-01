import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class City {
    private int rows;
    private int columns;

    private int rides;
    private int bonus;
    private int steps;
    private ArrayList<Road> roads = new ArrayList<>();

    private ArrayList<Vehicle> vehicles = new ArrayList<>();

    public City(List<String> list) {
        String[] strings = list.get(0).split(" ");
        this.rows = Integer.parseInt(strings[0]);
        this.columns = Integer.parseInt(strings[1]);
        this.rides = Integer.parseInt(strings[3]);
        this.bonus = Integer.parseInt(strings[4]);
        this.steps = Integer.parseInt(strings[5]);

        for (int i =0 ; i < Integer.parseInt(strings[2]);i++){
            this.vehicles.add(new Vehicle(steps));
        }

        list.remove(0);

        list.stream().forEach(i -> roads.add(new Road(i)));
        this.roads.sort((a,b) -> a.getStartTime()-b.getStartTime());

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

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }
}
