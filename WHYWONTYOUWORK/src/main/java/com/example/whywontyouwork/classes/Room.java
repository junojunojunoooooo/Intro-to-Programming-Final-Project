package com.example.whywontyouwork.classes;

public class Room {
    private int Gold;
    private Monster npc;
    private boolean monsterPresent;
    private boolean Blocked;
    private int x;
    private int y;
    private boolean actionTaken;

    public Room(int row, int column) {
        // sets gold to a value between 2-5
        this.Gold = ((int) (Math.random() * 5) + 2);

        this.npc = new Monster();

        // sets the room's coordinates according to parameters, will be used in the for loops setting up the ArrayList
        this.y = row;
        this.x = column;

        if (x != 5 && y != 5) {
            // 1/8 chance for room to be blocked
            if (Math.random() < 0.125) {
                this.Blocked = true;
            } else this.Blocked = false;

            // flips a coin to decide if a monster is present
            if (Math.random() < 0.5) {
                this.monsterPresent = true;
            }
        }

        if (x == 5 && y ==5) {
            this.actionTaken = true;
        } else { this.actionTaken = false; }
    }

    public int getGold() { return Gold; }

    public boolean isBlocked() { return Blocked; }

    public int getX() { return x; }

    public int getY() { return y; }

    public Monster getNpc() { return npc; }

    public boolean wasActionTaken() { return actionTaken; }

    public boolean isMonsterPresent() { return monsterPresent; }

    public int search(Player player) {
        int roll = ((int) (Math.random() * 20) + 1);
        // rolls a d20, player gets gold if they roll below their intelligence
        if (roll <= player.getIntel()) {
            player.gainGold(Gold); }

        // sets gold to zero to avoid double-dipping
        Gold = 0;
        actionTaken = true;

        // changes to a moving state
        return 0;
    }

    public int sleep(Player player) {
        // heals the player to max and clears the room's gold (so you have to pick between searching and sleeping)
        player.heal();
        Gold = 0;
        actionTaken = true;

        // rolls a d6 die, spawns a new monster and starts a fight if it rolls a six
        int roll = ((int) (Math.random() * 6) + 1);

        if (roll == 6) {
            monsterPresent = true;
            return 1; }
        // returns a moving state if no monster attacks
        else return 0;
    }

    public void playerAttacks(Player player) {
        int roll = ((int) (Math.random() * 20) + 1);

        // player attacks if they roll above the enemy's dexterity
        if (roll >= npc.getDex()) {
            npc.takeDamage(player.getStr()); }
    }

    public void monsterAttacks(Player player) {
        int roll = ((int) (Math.random() * 20) + 1);

        // monster attacks if it rolls above the player's dexterity
        if (roll >= player.getDex()) {
            player.takeDamage(npc.getStr()); }
    }

    public int run(Player player) {
        int roll = ((int) (Math.random() * 20) + 1);

        // monster attacks if it rolls below its intelligence
        if (roll <= npc.getIntel()) {
            player.takeDamage(npc.getStr()); }

        // returns a moving state
        return 0;
    }

    public void action() { actionTaken = true;}

    public void clearMonster() { monsterPresent = false; }
}
