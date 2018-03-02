import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        try {
            List<String> list = Files.readAllLines(Paths.get("b_should_be_easy.in")).stream().collect(Collectors.toList());
            City city = new City(list);
            Manager manager = new Manager(city);
            manager.start();
            manager.out();


        } catch (Exception e) {
            e.printStackTrace();
        }




    }
}
