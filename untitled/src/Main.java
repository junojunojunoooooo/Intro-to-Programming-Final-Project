import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        /*
        // Create the outer ArrayList
        ArrayList<ArrayList<Integer>> grid = new ArrayList<>();

        // Initialize each row
        for (int i = 0; i < 13; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < 13; j++) {
                row.add(0); // You can change the default value as needed
            }
            grid.add(row);
        }

        // Print the grid to verify
        for (ArrayList<Integer> row : grid) {
            System.out.println(row);
        }
        */


        Room room = new Room(2, 4);
        System.out.println(room.getX());
        System.out.println(room.getY());
        System.out.println(room.getGold());
        System.out.println(room.isMonsterPresent());


        }
    }