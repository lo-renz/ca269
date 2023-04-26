import java.util.List;
import java.util.ArrayList;

class Mirror {
    public List<String> list;

    Mirror() {
        this.list = new ArrayList<String>();
    }

    public void addItem(String item) {
        this.list.add(item);
    }

    public List<String> getList() {
        return this.list;
    }

    /**
    * a method which checks if two lists of strings mirror each other
    * I take the size of the other list and iterate from the start to the end
    * of one list, and iterate from the end to the start of the other, checking
    * whether each of the strings are the same along the way.
    *
    * @param an object of type Mirror
    * @return returns a boolean depending on whether the two lists mirror each other or not.
    */
    public boolean isMirrored(Mirror obj) {
        int other_size = obj.getList().size();
        for(int i=0; i < getList().size(); ++i) {
            if(getList().get(i) != obj.getList().get(other_size-1-i)) {
                return false;
            }
        }
        return true;
    }

    /**
    *
    */
    public boolean isPalindrome() {
        int size = getList().size();
        if(size % 2 == 0) {
            for(int i=0; i < size / 2; ++i) {
                if(getList().get(i) != getList().get(size-1-i)) {
                    return false;
                }
            }
        } else {
        }
        return true;
    }

    public static void main(String[] args) {
        /* my tests for the Q1ab.java
        Mirror mirror1 = new Mirror();
        mirror1.addItem("a");
        mirror1.addItem("b");
        mirror1.addItem("c");
        System.out.println(mirror1.getList());

        Mirror mirror2 = new Mirror();
        mirror2.addItem("c");
        mirror2.addItem("b");
        mirror2.addItem("a");
        System.out.println(mirror2.getList());

        System.out.println(mirror2.isMirrored(mirror1));*/

        // tests for isPalindrome(), if the list is even
        Mirror m1 = new Mirror();
        m1.addItem("a");
        m1.addItem("b");
        m1.addItem("b");
        m1.addItem("a");
        System.out.println(m1.getList());
        System.out.println(m1.isPalindrome());

        // tests for isPalindrome(), if the list is odd
        Mirror m2 = new Mirror();
        m2.addItem("l");
        m2.addItem("e");
        m2.addItem("v");
        m2.addItem("e");
        m2.addItem("l");
        System.out.println(m2.getList());
        System.out.println(m2.isPalindrome());
    }
}
