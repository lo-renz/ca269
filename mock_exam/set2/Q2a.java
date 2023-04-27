import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

class Item { }
class Book extends Item {
    int LENDING_PERIOD = 28;
}

class AudioCD extends Item {
    int LENDING_PERIOD = 14;
}

class VideoDVD extends Item {
    int LENDING_PERIOD = 4;
}

class Loan {
    Item item;
    dateBorrowed;
    dateReturned;

    double calculateFine() { }
}

class Library {
    List<Item> inventory = new ArrayList<>();
    List<Loan> onLoan = new ArrayList<>();

    // check if Item is in inventory
    // if yes, take it out,
    // put it in a Loan record, set date borrwed,
    // add to onLoan
    Item lendItem(Item item) {
       if(inventory.contains(item)) {
           inventory.remove(item);
       }
    }

    // check if item is on loan
    // set return date
    // calculate fine if any
    // take book out of loan record
    // put item back in inventory
    double returnItem(Item item) {
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        System.out.println(list.remove(1));
    }
}
