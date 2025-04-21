public class Monster {
    private int hp;
    private int str;
    private int dex;
    private int intel;

    public Monster() {
        this.hp = (int) (Math.random() * 6) + 1;
        this.str = this.hp * 2;
        this.dex = this.hp * 2;
        this.intel = this.hp * 2;
    }

    public int getHp() { return hp; }

    public int getStr() { return str; }

    public int getDex() { return dex; }

    public int getIntel() { return intel; }

    public int takeDamage(int strength) {
        hp -= (int) strength/3;
        return hp;
    }

}
