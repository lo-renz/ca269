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
    public boolean admitPerson(Person person) {
        if(person instanceof Employee || person instanceof VIP) {
            return true;
        }
        return false;
    }
}
