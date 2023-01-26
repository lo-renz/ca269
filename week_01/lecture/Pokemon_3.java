public class Pokemon_3 {
    static String region = "Kanto";
    String type = "Unknown";
    String name = "Unknown";

    Pokemon_3(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String toString() {
        return this.name + " - " + this.type;
    }

    public static void main(String[] args) {
        Pokemon_3 Bulbasaur = new Pokemon_3("Bulbasaur", "Grass");
        System.out.println(Bulbasaur);
        Pokemon_3 Charmander = new Pokemon_3("Charmander", "Fire");
        System.out.println(Charmander);
    }
}
