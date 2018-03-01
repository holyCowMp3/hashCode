import java.util.List;

public class City {
    private int rows;
    private int columns;
    private int vehicles;
    private int rides;
    private int bonus;
    private int steps;

    public City(List<String> list) {
        String[] strings = list.get(0).split(" ");
        rows = Integer.parseInt(strings[1]);
        columns = Integer.parseInt(strings[2]);
        vehicles = Integer.parseInt(strings[3]);
        rides = Integer.parseInt(strings[4]);
        bonus = Integer.parseInt(strings[5]);
        steps = Integer.parseInt(strings[6]);

    }
}
