public class Room {
    private int Gold;
    private Monster npc;
    private boolean MonsterPresent;
    private boolean Blocked;
    private int x;
    private int y;

    public Room(int row, int column) {
        // sets gold from 1-5
        this.Gold = ((int) (Math.random() * 5) + 1);

        // flips a coin to decide if a monster is present
        int MonsterGen = ((int) (Math.random() * 2) + 1);
        if (MonsterGen == 2) {
            this.MonsterPresent = true;
            this.npc = new Monster();
        }
        else this.MonsterPresent = false;

        // sets the room's coordinates according to parameters, will be used in the for loops setting up the ArrayList
        this.y = row;
        this.x = column;
    }
    public int getGold() {
        return Gold;
    }

    public boolean isMonsterPresent() {
        return MonsterPresent;
    }

    public boolean isBlocked() {
        return Blocked;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Monster getNpc() {
        return npc;
    }

    // adds the gold in the room to the player's gold count, then sets the room's gold to zero to avoid double-dipping
    public void search(Player player) {
        player.gainGold(Gold);
        Gold = 0;
    }

    public void fight(Player player) {
        while (player.getHp() > 0 && npc.getHp() > 0) {

        }
    }

}
