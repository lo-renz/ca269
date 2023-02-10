class Duck {
    private String colour;
    private Size size;
    private double cost;
    private String manufacturer_sign;

    Duck(String colour, Size size, double cost, String manufacturer_sign) {
        this.colour = colour;
        this.size = size;
        this.cost = cost;
        this.manufacturer_sign = manufacturer_sign;
    }

    public String getColour() {
        return colour;
    }
    public Size getSize() {
        return size;
    }
    public double getCost() {
        return cost;
    }
    public String getManufacturer_sign() {
        return manufacturer_sign;
    }
}

public class DuckFactory {
    private static int counter;
    public static int MAX_COUNTER;
    public static Duck getNewDuck() {
        counter += 1;
        if (counter < MAX_COUNTER) {
            return new Duck();
        }
        return null;
    }
}
