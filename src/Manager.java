import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Manager {
    List<String> lines = new ArrayList<>();
    private Road currentRoad;
    private City city;

    public Manager(City city){
        this.city=city;
    }



    public void start(){



    }


    public void out() throws Exception{
        city.getVehicles().forEach(i -> lines.add(new String(city.getVehicles().indexOf(i) +" " + i.getRoads().stream().map(j -> j.getIdRoad()+"").collect(Collectors.joining(" ")))));
        Path file = Paths.get(Manager.class.getResource("1.out").toURI());
        Files.write(file,lines);
    }


}
