public class Main {

    public static void main(String[] args) {

        Player player = new Player();
        System.out.println(player.getDex());
        System.out.println(player.getStr());
        System.out.println(player.getIntel());

        Monster monster = new Monster();
        System.out.println(monster.getHp());
        System.out.println(monster.getDex());
        System.out.println(monster.getStr());
        System.out.println(monster.getIntel());

    }
}