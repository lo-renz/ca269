interface Order {
    public boolean lessThan(Order other);
}

interface Comparable extends Order {
    public int compareTo(Object other);
}

public class Point implements Comparable {
    private double x, y;

    public Point(double newX, double newY) {
        x = newX;
        y = newY;
    }

    // Order method implementation
    public boolean lessThan(Order other) {
        Point otherPoint = (Point) other;

        if(this.x < otherPoint.x) {
            return true;

        } else if(this.y < otherPoint.y) {
            return true;
        } else if(this.equals(otherPoint)) {
            return false;
        }

        return false;
    }

    @Override
    public boolean equals(Object other) {
        Point otherPoint = (Point) other;

        if(this.x == otherPoint.x && this.y == otherPoint.y) {
            return true;
        }
        return false;
    }

    public int compareTo(Object other) {
        Point otherPoint = (Point) other;

        if(this.equals(otherPoint)) {
            return 0;
        } else if(this.lessThan(otherPoint)) {
            return -1;
        }
        return 1;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public static void main(String args[]) {
        Order O1 = new Point(0, 0);
        Order O2 = new Point(1, 1);
        Order O3 = new Point(0, 1);

        System.out.println("O1 less than O2: " + O1.lessThan(O2)); // true
        System.out.println("O1 less than O3: " + O1.lessThan(O3)); // true
        System.out.println("O2 less than O3: " + O2.lessThan(O3)); // false
        System.out.println("O3 less than O3: " + O3.lessThan(O3)); // false

        Comparable P1 = new Point(0, 0);
        Comparable P2 = new Point(1, 1);
        Comparable P3 = new Point(0, 1);

        System.out.println("P1 less than P2: " + P1.compareTo(P2)); // -1
        System.out.println("P1 less than P3: " + P1.compareTo(P3)); // -1
        System.out.println("P2 less than P3: " + P2.compareTo(P3)); // 1
        System.out.println("P3 less than P3: " + P3.compareTo(P3)); // 0
    }
}
