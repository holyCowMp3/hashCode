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


    public void out{
        city.getVehicles().forEach(i -> new String(city.getVehicles().indexOf(i) +" " + i.getRoads().stream().map(i -> i.getIdRoad()).collect(Collectors.joining(" "))));
    }


}
