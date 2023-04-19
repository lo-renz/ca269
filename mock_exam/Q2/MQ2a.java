class Individual {
    // fields
    public String name;

    // getter
    public String getName() {
        return this.name;
    }

    // setter
    public void setName(String name) {
        this.name = name;
    }

    // constructor
    /**
    * @param takes and sets the name of an individual.
    */
    Individual(String name) {
        setName(name);
    }

    public String toString() {
        return getName();
    }
}

class Person extends Individual {
    // fields
    protected String nickname;

    // getter
    public String getNickname() {
        return this.nickname;
    }

    // setter
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    // constructor
    /**
    * @param name, the name of the person
    * @param nickname, the nickname of the person
    */
    Person(String name, String nickname) {
        super(name);
        setNickname(nickname);
    }

    public String toString() {
        return getName() + " (" + getNickname() + ")";
    }

    public static void main(String args[]) {
        Person a = new Person("Renso", "osner");
        System.out.println(a);
    }
}
