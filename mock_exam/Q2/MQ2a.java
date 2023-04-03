class Individual {
    public String name;

    Individual(String name) {
        this.name = name;
    }

    Individual() {
    }

    public String toString() {
        return this.name;
    }
}

class Person extends Individual {
    protected String nickname;

    Person(String name, String nickname) {
        this.name = name;
        this.nickname = nickname;
    }

    public String toString() {
        return this.name + " (" + nickname + ")";
    }

    public static void main(String args[]) {
        Person x = new Person("Renso", "Ren");
        System.out.println(x);
    }
}