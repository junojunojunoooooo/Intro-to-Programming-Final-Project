package com.example.whywontyouwork;
import java.util.ArrayList;

import com.example.whywontyouwork.classes.Monster;
import com.example.whywontyouwork.classes.Player;
import com.example.whywontyouwork.classes.Room;

import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class HelloController {
    int PlayerHealthValue = 20;
    int MonsterHealthValue = 20;
    int x = 5;
    int y = 5;

    // state 0 = movement | state 1 = fight | state 2 = sleep/search | state 3 = move + sleep/search
    int state = 0;
    @FXML
    public Label FART;
    @FXML
    private Label GOLD;
    @FXML
    private Label HEALTH;
    @FXML
    private Label WHATdo;
    @FXML
    private Label MHealth;
    @FXML
    private Label ErrorLabel;
    @FXML
    private Label ypos;
    @FXML
    private Label xpos;
    @FXML
    private Label STR;
    @FXML
    private Label DEX;
    @FXML
    private Label INT;

    Player player = new Player();
    ArrayList<ArrayList<Room>> grid = new ArrayList<>();
    @FXML
    private Label StateLabel;

    // sets up 10x10 map
    {for (int i = 0; i < 10; i++) {
        ArrayList<Room> row = new ArrayList<>();
        for (int j = 0; j < 10; j++) {
            row.add(new Room(i, j));
        }
        grid.add(row);
    }}
    @FXML
    public void onButtonSearch() {
        // search button YAYYYYY (if I remove this, the function bricks in starting room)
        WHATdo.setText("SEARCH");
        if (x == 5 && y == 5) {
            FART.setText("Cannot sleep or search in the entry room. Please move!");
            state = 0;
        } else {
            if (state == 2) {
                if (grid.get(x).get(y).wasActionTaken() == false) {
                    int goldGain = (int) (Math.random() * 5) + 2;
                    FART.setText("You have searched and gained " + goldGain + " gold.");
                    grid.get(y).get(x).action();
                    player.gainGold(goldGain);
                    GOLD.setText(String.valueOf(player.getGold()));
                    state = 0;
                    StateLabel.setText("You must move.");
                }
                GOLD.setText(String.valueOf(player.getGold()));
            } else {
                FART.setText("Please select an appropriate action.");
            }
        }
    }

    @FXML
    public void onButtonSleep() {
        WHATdo.setText("SLEEP");

        if (x == 5 && y == 5) {
            FART.setText("Cannot sleep or search in the entry room. Please move!");
            state = 0;
        } else {
            if (state == 2) {
                if (!grid.get(x).get(y).wasActionTaken()) {
                    grid.get(y).get(x).sleep(player);
                    HEALTH.setText(String.valueOf(player.getHp()));
                    grid.get(y).get(x).action();

                    // checks if a monster spawned and notifies the player
                    if (grid.get(y).get(x).isMonsterPresent()) {
                        FART.setText("You slept, but a monster found you!");
                        state = 1;
                        StateLabel.setText("You must fight or run.");
                        MHealth.setText(String.valueOf(grid.get(y).get(x).getNpc().getHp()));
                    } else {
                        FART.setText("You slept safely.");
                        state = 0;
                        StateLabel.setText("You must move.");
                    }
                } else {
                    FART.setText("Go to a different room to search or sleep!");
                }
            } else {
                FART.setText("Please select an appropriate action.");
            }
        }
    }

    @FXML
    public void onButtonRun() {
        WHATdo.setText("RUN");
        if (state == 1) {
                grid.get(y).get(x).run(player);
                state = 0;
        StateLabel.setText("You must move.");}
    else {FART.setText("Please select an appropriate action.");}
    }

    @FXML
    public void onButtonFight() {
        WHATdo.setText("FIGHT");

        if (state == 1) {
            grid.get(y).get(x).playerAttacks(player);

            if (grid.get(y).get(x).getNpc().getHp() < 0) {
                grid.get(y).get(x).getNpc().zeroHealth();;
                MHealth.setText(String.valueOf(grid.get(y).get(x).getNpc().getHp()));
                grid.get(y).get(x).clearMonster();
                FART.setText("You did " + player.getStr()/3 + " damage. The monster is dead!");

                if (grid.get(y).get(x).wasActionTaken()) {
                    state = 0;
                    StateLabel.setText("You must move.");
                } else { state = 2;
                    StateLabel.setText("You must search or sleep.");}

            } else {
                MHealth.setText(String.valueOf(grid.get(y).get(x).getNpc().getHp()));
                grid.get(y).get(x).monsterAttacks(player);
                HEALTH.setText(String.valueOf(player.getHp()));

                if (player.getHp() < 0) {
                    player.zeroHealth();
                    HEALTH.setText(String.valueOf(player.getHp()));
                    ErrorLabel.setText(" Monster did " +  grid.get(y).get(x).getNpc().getStr()/3 + " damage. You died! :(");
                } else {
                    FART.setText("You did " + player.getStr()/3 + " damage to the monster, who did " +  grid.get(y).get(x).getNpc().getStr()/3 + " damage to you!");}}
        }
        else { FART.setText("Please select an appropriate action.");}
    }
    @FXML
    public void onButtonUp() {
        WHATdo.setText("Up");
        if (state == 0){
            y--;
                if (y < 0 || grid.get(y).get(x).isBlocked()) {
                    FART.setText("Can't move there.");
                    y++;
                }
                else{
                    ypos.setText(String.valueOf(y));
                    FART.setText("You have moved up");
                    if (grid.get(x).get(y).isMonsterPresent()) {
                        state = 2;
                        StateLabel.setText("You must search or sleep.");
                    }
                    else{
                            state = 1;
                            StateLabel.setText("You must fight or run.");
                            MHealth.setText(String.valueOf(grid.get(y).get(x).getNpc().getHp()));}}
        } else {FART.setText("Please select an appropriate action.");}
    }

    @FXML
    public void onButtonDown() {
        WHATdo.setText("Down");
        if (state == 0){
        y++;
        if (y > 9 || grid.get(y).get(x).isBlocked()) {
            y--;
            FART.setText("Can't move there.");
        }
        else{
            ypos.setText(String.valueOf(y));
            FART.setText("You have moved down");
            if (grid.get(x).get(y).isMonsterPresent()) {
                state = 2;
                StateLabel.setText("You must search or sleep.");
            }
            else{
                state = 1;
                StateLabel.setText("You must fight or run.");
                MHealth.setText(String.valueOf(grid.get(y).get(x).getNpc().getHp()));}}

        }
        else {FART.setText("Please select an appropriate action.");}
    }


    @FXML
    public void onButtonLeft() {
        WHATdo.setText("Left");
        if (state == 0){
        x++;
        if (x > 9 || grid.get(y).get(x).isBlocked()) {
            x--;
            FART.setText("Can't move there.");
        }
        else{
        xpos.setText(String.valueOf(x));
            FART.setText("You have moved left");}
            if (grid.get(x).get(y).isMonsterPresent()) {
                state = 2;
                StateLabel.setText("You must search or sleep.");
            }
            else{
                state = 1;
                StateLabel.setText("You must fight or run.");
                MHealth.setText(String.valueOf(grid.get(y).get(x).getNpc().getHp()));}}

        else {FART.setText("Please select an appropriate action.");}
    }


    @FXML
    public void onButtonRight() {
        WHATdo.setText("Right");
        if (state == 0){
        x--;
        if (x < 0 || grid.get(y).get(x).isBlocked()) {
            x++;
            FART.setText("Can't move there.");
        }
        else{
        xpos.setText(String.valueOf(x));
            FART.setText("You have moved right");}
            if (grid.get(x).get(y).isMonsterPresent()) {
                state = 2;
                StateLabel.setText("You must search or sleep.");
            }
            else{
                state = 1;
                StateLabel.setText("You must fight or run.");
                MHealth.setText(String.valueOf(grid.get(y).get(x).getNpc().getHp()));}}

        else {FART.setText("Please select an appropriate action.");}
    }

}

// player stats
//