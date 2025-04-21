import java.util.ArrayList;

public class Main {

    public void move () {

    }

    public static void main(String[] args) {
        int x = 5;
        int y = 5;

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