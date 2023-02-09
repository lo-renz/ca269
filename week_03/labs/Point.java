interface Order {
    boolean lessThan(Order other);
    boolean lessThan(Point other);
}

class Point implements Order {
    private double x, y;

    public Point(double newX, double newY) {
        x = newX;
        y = newY;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public boolean lessThan(Order other) {
        return lessThan((Point) other);
    }

    public boolean lessThan(Point other) {
        if(this.equals(other)) {
            return false;
        }
        else if(this.x > other.x) {
            return false;
        }
        else if(this.y > other.y) {
            return false;
        }
        return true;
    }

    static public void main(String[] args) {
        Order O1 = new Point(0, 0);
        Order O2 = new Point(1, 1);
        Order O3 = new Point(0, 1);

        System.out.println("O1 less than O2: " + O1.lessThan(O2));
        System.out.println("O1 less than O3: " + O1.lessThan(O3));
        System.out.println("O2 less than O3: " + O2.lessThan(O3));
        System.out.println("O3 less than O3: " + O3.lessThan(O3));
    }
}
