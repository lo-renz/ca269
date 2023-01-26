public class Pokemon_4 {
    static String region = "Kanto";
    String type = "Unknown";
    String name = "Unknown";
    int damage = 1;
    static int damage_base = 15; // All pokemon use this as base.

    Pokemon_4(String name, String type, double damage_multiplier) {
        this.name = name;
        this.type = type;
        // A specific pokemon's damage is calculated by
        // multiplying the base damage with a provided multiplier.
        this.damage = (int) (Pokemon_4.damage_base * damage_multiplier);
    }

    public String toString() {
        return this.name + " (" + this.type + ")";
    }

    public String attack() {
        return this.name + " uses Cut for " + this.damage + " damage";
    }

    public static void main(String[] args) {
        Pokemon_4 Bulbasaur = new Pokemon_4("Bulbasaur", "Grass", 2.1);
        System.out.println(Bulbasaur);
        System.out.println(Bulbasaur.attack());
    }
}
