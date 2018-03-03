import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        try {
            List<String> list = Files.readAllLines(Paths.get("c_no_hurry.in")).stream().collect(Collectors.toList());
            System.out.println(list.get(0));
            City city = new City(list);
            Manager manager = new Manager(city);
            System.out.println(city.getVehicles().size());

            manager.start();
            manager.start();
            manager.out();


        } catch (Exception e) {
            e.printStackTrace();
        }




    }
}
