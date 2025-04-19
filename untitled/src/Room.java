public class Room {
    private int Gold;
    private boolean MonsterPresent;
    private boolean Blocked;
    private int x;
    private int y;

    public Room(int row, int column) {
        this.Gold = ((int) (Math.random() * 5) + 1);

        int MonsterGen = ((int) (Math.random() * 2) + 1);
        if (MonsterGen == 2)
            this.MonsterPresent = true;
        else this.MonsterPresent = false;

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
}
