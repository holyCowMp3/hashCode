import java.util.ArrayList;

public class Vehicle {
    private int row;
    private int column;
    private int ttl;
    private ArrayList<Road> roads;



    public Vehicle(int steps){
        this.row = 0;
        this.column = 0;
        this.ttl = steps;
        this.roads = new ArrayList<Road>();

    }


    public int getRow() {
        return row;
    }

    public void rideRoad(Road road, int steps){
        addRoad(road);
        ttl-=steps;
        this.row=road.getEndRow();
        this.column=road.getEndColumn();

    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public ArrayList<Road> getRoads() {
        return roads;
    }

    public int getTtl() {
        return ttl;
    }

    public void setTtl(int ttl) {
        this.ttl = ttl;
    }

    public void addRoad(Road road){
        if (!roads.contains(road)) {
            roads.add(road);
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(roads.size()+" ");
        for (Road a: roads) {
            sb.append(a.getIdRoad() + " ");
        }
        return sb.toString();


    }
}
