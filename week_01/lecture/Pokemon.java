public class Pokemon {
        // Variables
        String type = "Unknown";
        int health_max = 100;

        // Constructors - "construct" an instance using this method.
        Pokemon() {
        }
        // There can be more than one.
        // Arguments must be different.
        Pokemon(String type) {
            this.type = type;
        }

        public static void main(String[] args) {
            // Create "new" instances
            Pokemon Egg = new Pokemon(); // 'Default' constructor
            System.out.println(Egg.type);
            // Constructor with String parameter
            Pokemon Bulbasaur = new Pokemon("Grass");
            System.out.println(Bulbasaur.type);
        }
    }
