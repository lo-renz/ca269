public class Test {
    String name;
    int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Test a = new Test();

        a.setName("Renso");
        a.setAge(19);

        //System.out.println(a.getName());
        //System.out.println(a.getAge());
        a.printDetails();
    }

    public void printDetails() {
        System.out.println(name + ", " + age);
    }
}