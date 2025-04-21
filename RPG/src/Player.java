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

    public int getHp() { return hp; }

    public int getStr() { return str; }

    public int getDex() { return dex; }

    public int getIntel() { return intel; }

    public int getGold() { return gold; }

    public void gainGold(int gain) { gold += gain; }

    public void heal() { hp = 20; }

    public int takeDamage(int strength) {
        // rounds up to one damage taken if needed, otherwise performs regular damage calculation
        if ( (int) strength/3 < 1) {
            hp --;
        } else hp -= (int) strength/3;

        return hp;
    }

}
