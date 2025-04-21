public class Room {
    private int Gold;
    private Monster npc;
    private boolean MonsterPresent;
    private boolean Blocked;
    private int x;
    private int y;

    public Room(int row, int column) {
        // sets gold to a value between 2-5
        this.Gold = ((int) (Math.random() * 5) + 2);

        // flips a coin to decide if a monster is present
        int MonsterGen = ((int) (Math.random() * 2) + 1);
        if (MonsterGen == 2) {
            this.MonsterPresent = true;
            this.npc = new Monster();
        }
        else this.MonsterPresent = false;

        // 1/8 chance for room to be blocked
        int BlockedGen = ((int) (Math.random() * 8) + 1);
        if (BlockedGen == 8) {
            this.Blocked = true;
        }
        else this.Blocked = false;

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

    public int search(Player player) {
        int roll = ((int) (Math.random() * 20) + 1);

        // rolls a d20, player gets gold if they roll below their intelligence
        if (roll <= player.getIntel()) {
            player.gainGold(Gold);}

        // sets gold to zero to avoid double-dipping
        Gold = 0;

        // changes to a moving state
        return 0;
    }

    public int sleep(Player player) {
        // heals the player to max and clears the room's gold (so you have to pick between searching and sleeping)
        player.heal();
        Gold = 0;

        // rolls a d6 die, spawns a new monster and starts a fight if it rolls a six
        int roll = ((int) (Math.random() * 6) + 1);

        if (roll == 6) {
            this.npc = new Monster();
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

}
