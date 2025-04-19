import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {


        ArrayList<ArrayList<Room>> grid = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            ArrayList<Room> row = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                row.add(new Room(i, j));
            }
            grid.add(row);
        }
        

        }
    }