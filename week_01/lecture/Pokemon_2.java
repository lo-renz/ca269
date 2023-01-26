class Pokemon_2 {
    // Class Variables declared using keyword static
    static String region = "Kanto";
    // Instance Variables
    String type = "Unknown";
    int health_max = 100;

    Pokemon_2() {
    }

    public static void main(String[] args) {
        // Class Variables are accessed with Class name.
        System.out.println(Pokemon_2.region);
        // But are also available with instances.
        Pokemon_2 Bulbasaur = new Pokemon_2();
        System.out.println(Bulbasaur.region);
        // Class instances are 'shared' amongst instances.
        Pokemon_2 Charmander = new Pokemon_2();
        Charmander.region = "Johto";
        System.out.println(Bulbasaur.region);
    }
}
