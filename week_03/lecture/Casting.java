// (1) Casting int to long.

int x = 0;
long y = (long) x;
    // This is okay because long is big enough to hold int.
int z = (int) y;
    // This isn't okay because int is not big enough to hold long.

// (2) Casting between subclasses and interfaces

class Animal {
    Animal() { }
}

interface Moves { }

class Bat extends Animal implements Moves {
    Bat() { }
}

// Testing
Animal a = (Animal) new Bat();
    // Create a new instance of Bat and cast to Animal.
    // Okay to do because Bat extends Animal,
    // and therefore all instances of Bat are compatible as instances of Animal.
    // This casting is implicit i.e. doesn't need to be declared.
    // The compiler automatically does it for us.

Bat b = (Bat) new Animal();
    // Not okay because Bat is broader than Animal.
    // i.e. Bat might have more data and methods than Animal
    // which an instance of Animal won't have implimented.

Moves m = (Moves) new Bat();
    // like earlier, this casting is okay and is done implicitly.

static void run(Animal x) { }
run(new Bat());
    // okay to do because the compiler converts Bat to Animal

static void run(Bat x) { }
run(new Animal());
    // not okay to do because Animal cannot be cast to Bat.

static void run(Object x) { }
run(new Bat());
    // okay to do because all objects can be cast to Object.

static void run(Object x) {
    Bat b = (Bat) x; // Convert Object to Bat.
    // should not be allowed.
    // BUT the compiler thinks there is a chance that this object
    // might really be a Bat instance - so no error!
}

run(new Bat()); // - no errors
run(new Animal()); // - error because Animal cannot be cast to Java.
