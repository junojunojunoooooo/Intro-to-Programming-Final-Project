package com.example.whywontyouwork.classes;
import java.util.ArrayList;
public class Main { public static void main(String[] args) {
    // sets current state: 0 = move, 1 = fight, 2 = sleep/search
    int state = 0;

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
Player player = new Player();
Monster monster = new Monster();

// grid.get(y).get(x).search(player);

}

}
