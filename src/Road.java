
public class Road {
   private static int roadsCout;
   private int idRoad;
   private int startRow;
   private int startColumn;
   private int endRow;
   private int endColumn;
   private int startTime;
   private int endTime;
   private int roadLength;


    public Road(String input) {
        String[] strings = input.split(" ");
        this.startRow = Integer.parseInt(strings[0]);
        this.startColumn = Integer.parseInt(strings[1]);
        this.endRow = Integer.parseInt(strings[2]);
        this.endColumn = Integer.parseInt(strings[3]);
        this.startTime = Integer.parseInt(strings[4]);
        this.endTime = Integer.parseInt(strings[5]);
        this.roadLength = Math.abs(endRow-startRow) + Math.abs(endColumn-endColumn);
        this.idRoad = roadsCout++;


    }

    public int getIdRoad() {
        return idRoad;
    }

    public int getStartRow() {
        return startRow;
    }

    public int getStartColumn() {
        return startColumn;
    }

    public int getRoadLength() {
        return roadLength;
    }

    public int getEndTime() {
        return endTime;
    }

    public int getEndRow() {
        return endRow;
    }

    public int getEndColumn() {
        return endColumn;
    }

    public int getStartTime() {
        return startTime;
    }

    public static int getRoadsCout() {
        return roadsCout;
    }
}
