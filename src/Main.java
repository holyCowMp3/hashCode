import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        try {
            List<String> list = Files.readAllLines(Paths.get("a_example.in")).stream().collect(Collectors.toList());
            City city = new City(list);
            city.getRoads().forEach(i -> System.out.println(i.getIdRoad()));
        } catch (IOException e) {
            e.printStackTrace();
        }




    }
}
