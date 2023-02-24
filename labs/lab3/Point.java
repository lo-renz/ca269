public class Point implements Comparable {
    private double x, y;

    public double getX() {
        return this.x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Point(double newX, double newY) {
        setX(newX);
        setY(newY);
    }

    public boolean lessThan(Order other) {
        Point point = (Point) other;
        if (this.x < point.x) {
            return true;
        }
        else if (this.x == point.x && this.y < point.y) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean equals(Object other) {
        Point point = (Point) other;
        if (this.x == point.x && this.y == point.y) {
            return true;
        }
        else {
            return false;
        }
    }

    public int compareTo(Object other) {
        Point point = (Point) other;
        if (this.equals(point)) {
            return 0;
        }
        else if (this.lessThan(point)) {
            return -1;
        }
        else {
            return 1;
        }
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public static void main(String[] args) {
        Order O1 = new Point(0, 0);
        Order O2 = new Point(1, 1);
        Order O3 = new Point(0 , 1);

        System.out.println("O1 less than O2: " + O1.lessThan(O2));
        System.out.println("O1 less than O3: " + O1.lessThan(O3));
        System.out.println("O2 less than O3: " + O2.lessThan(O3));
        System.out.println("O3 less than O3: " + O3.lessThan(O3));

        Comparable P1 = new Point(0, 0);
        Comparable P2 = new Point(1, 1);
        Comparable P3 = new Point(0, 1);

        System.out.println("P1 less than P2: " + P1.compareTo(P2));
        System.out.println("P1 less than P3: " + P1.compareTo(P3));
        System.out.println("P2 less than P3: " + P2.compareTo(P3));
        System.out.println("P3 less than P3: " + P3.compareTo(P3));
    }
}