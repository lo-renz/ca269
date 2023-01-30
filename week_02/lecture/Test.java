public class Test {

    String name;
    int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public void printDetails() {
        System.out.println(getName() + ", " + getAge());
    }

    public static void main(String[] args) {
        Test a = new Test();

        a.setName("Renso");
        a.setAge(19);
        System.out.println(a.getName());
        System.out.println(a.getAge());

        a.printDetails();
    }
}
