interface FamilyMember extends PersonalDetails {
    String getNickname();
    void setNickname(String name);
}

interface PersonalDetails {
    String getName();
    int getAge();
}

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

class Person extends Individual implements FamilyMember {
    protected String nickname;
    public int age;

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String name) {
        this.name = name;
    }

    Person(String name, String nickname) {
        super(name);
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