class Vehicle {
    // constructor
    Vehicle() {}

    /**
    * a method which prints "beep"
    */
    public void go() {
        System.out.println("beep");
    }
}

class Porsche extends Vehicle {
    Porsche() {}

    @Override
    public void go() {
        System.out.println("vrrrmm");
    }
}

class Banger extends Vehicle {
    Banger() {}

    @Override
    public void go() {
        System.out.println("bangbang");
    }
}

class Test {
    public static void main(String[] args) {
        Vehicle[] vehicles = {new Vehicle(), new Banger(), new Vehicle(), new Porsche()};
        for(Vehicle vehicle: vehicles) {
            vehicle.go();
        }
    }
}
