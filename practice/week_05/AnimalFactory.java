interface SafetyRegulation {
    int getMaxItemsPermitted();
}

abstract class Item implements SafetyRegulation {
    final int maxItemsPermitted = 0;

    public int getMaxItemsPermitted() {
        return this.maxItemsPermitted;
    }
}

class Duck extends Item {
    final int maxItemsPermitted = 5;

    public int getMaxItemsPermitted() {
        return this.maxItemsPermitted;
    }
}

class Swan extends Item {
    final int maxItemsPermitted = 2;

    public int getMaxItemsPermitted() {
        return this.maxItemsPermitted;
    }
}

class Flamingo extends Item {
    final int maxItemsPermitted = 3;

    public int getMaxItemsPermitted() {
        return this.maxItemsPermitted;
    }
}

class Dog extends Item {
    final int maxItemsPermitted = 20;

    public int getMaxItemsPermitted() {
        return this.maxItemsPermitted;
    }
}

class Cat extends Item {
    final int maxItemsPermitted = 20;

    public int getMaxItemsPermitted() {
        return this.maxItemsPermitted;
    }
}

class AnimalFactory<T extends Item & SafetyRegulation> {
    private int unitsProduced = 0;

    public T continueProduction(T item) {
        if(this.unitsProduced < item.getMaxItemsPermitted()) {
            this.unitsProduced += 1;
            return item;
        }
        return null;
    }

    public int getCount() {
        return this.unitsProduced;
    }

    public static void main(String[] args) {
        // main() for testing:
        AnimalFactory<Duck> AF_D = new AnimalFactory<>();
        while(AF_D.continueProduction(new Duck()) != null);
        System.out.println("Total Ducks produced: " + AF_D.getCount());

        AnimalFactory<Swan> AF_S = new AnimalFactory<>();
        while(AF_S.continueProduction(new Swan()) != null);
        System.out.println("Total Swans produced: " + AF_S.getCount());

        AnimalFactory<Flamingo> AF_F = new AnimalFactory<>();
        while(AF_F.continueProduction(new Flamingo()) != null);
        System.out.println("Total Flamingos produced: " + AF_F.getCount());

        AnimalFactory<Dog> AF_G = new AnimalFactory<>();
        while(AF_G.continueProduction(new Dog()) != null);
        System.out.println("Total Dogs produced: " + AF_G.getCount());

        AnimalFactory<Cat> AF_C = new AnimalFactory<>();
        while(AF_C.continueProduction(new Cat()) != null);
        System.out.println("Total Cats produced: " + AF_C.getCount());

        // which produces the output
        // Total Ducks produced: 5
        // Total Swans produced: 2
        // Total Flamingos produced: 3
        // Total Dogs produced: 20
        // Total Cats produced: 20
    }
}
