public class Pokemon_5 {
    static String region = "Kanto";
    String type = "Unknown";
    String name = "Unknown";
    int damage = 1;
    static int damage_base = 15; // All pokemon use this as a base.
    // each pokemon have a set of moves.

    public static void main(String[] args) {
        Move Bulbasaur = new Move("Razor Leaf", 15);
        System.out.println(Bulbasaur);
        System.out.println(Bulbasaur.damage);
    }
}

class Move {
    String name = "";
    int damage = 0;
    public String toString() {
        return this.name;
    }

    Move(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }
}
