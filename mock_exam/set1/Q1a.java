class Person {
    String name;
    String nickname;

    Person(String name) {
        setName(name);
    }

    // getters
    public String getName() {
        return this.name;
    }

    public String getNickname() {
        return this.nickname;
    }

    // setters
    public void setName(String name) {
        this.name = name;
        this.nickname = name.substring(0, 3);
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public static void main(String[] args) {
        Person person1 = new Person("Renso");
        System.out.println(person1.getNickname());
        person1.setName("Lorenzo");
        System.out.println(person1.getNickname());
        person1.setNickname("Rens");
        System.out.println(person1.getNickname());
        System.out.println(person1.getName());
    }
}
