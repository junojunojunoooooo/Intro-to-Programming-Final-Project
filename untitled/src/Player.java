public class Player {
    private int hp;
    private int str;
    private int dex;
    private int intel;
    private int gold;

    public Player() {
        this.hp = 20;
        this.str = ((int) (Math.random() * 6) + 1) + ((int) (Math.random() * 6) + 1) + ((int) (Math.random() * 6) + 1);
        this.dex = ((int) (Math.random() * 6) + 1) + ((int) (Math.random() * 6) + 1) + ((int) (Math.random() * 6) + 1);
        this.intel = ((int) (Math.random() * 6) + 1) + ((int) (Math.random() * 6) + 1) + ((int) (Math.random() * 6) + 1);
        this.gold = 0;
    }

    public int getHp() {
        return hp;
    }

    public int getStr() {
        return str;
    }

    public int getDex() {
        return dex;
    }

    public int getIntel() {
        return intel;
    }

    public int getGold() {
        return gold;
    }
}
