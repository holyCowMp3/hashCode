
public class Road {

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

    }





}
