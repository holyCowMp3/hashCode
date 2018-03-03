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

    public  synchronized Vehicle rideRoad(Road road, int steps){
        addRoad(road);
        if (road!=null){
        setTtl(this.ttl-=steps);
        this.row=road.getEndRow();
        this.column=road.getEndColumn();
        City.roads.remove(road);
        return this;}
        else return null;

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
        sb.ensureCapacity(100000);
        sb.append(roads.size()+" ");
        if (roads.size()!=0) {
            for (Road a : roads) {

                sb.append(a.getIdRoad() + " ");
            }
            sb.delete(sb.toString().length()-1, sb.toString().length());
            return sb.toString();
        }
return "";
    }
}
