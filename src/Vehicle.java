import java.util.ArrayList;

public class Vehicle {
    private int row;
    private int column;
    private int startTtl;
    private int ttl;
    private ArrayList<Road> roads;



    public Vehicle(int steps){
        this.row = 0;
        this.column = 0;
        this.ttl = steps;
        this.startTtl=steps;

        this.roads = new ArrayList<Road>();

    }


    public int getRow() {
        return row;
    }

    public void rideRoad(Road road){
        addRoad(road);
        int stepsToStart = Math.abs(road.getStartRow()-row) + Math.abs(road.getStartColumn()-column);
        row = road.getStartRow();
        column = road.getStartColumn();
        ttl-=stepsToStart;
        if(startTtl-ttl>road.getStartTime()){
            ttl-=road.getStartTime()-(startTtl-ttl);
        }
        ttl-=Math.abs(road.getEndRow()-road.getStartRow()) + Math.abs(road.getEndColumn()-road.getStartColumn());
        row=road.getEndRow();
        column=road.getEndColumn();

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
        roads.add(road);
    }
}
