class Person {
    private String name;
}
class Employee extends Person {
    private String empoyeeID;
}
interface VIP {
    String VIPStatus();
}

class CompanyGathering {
    public static boolean admitPerson(Person p) {
        if((p instanceof Employee) || (p instanceof VIP)) {
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String args[]) {
        Person x = new Employee();
        Person y = new Person();

        System.out.println(admitPerson(x));
        System.out.println(admitPerson(y));
    }
}