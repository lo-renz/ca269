import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class Item { }
class Book extends Item {
    public int LENDING_PERIOD = 28;
}

class AudioCD extends Item {
    int LENDING_PERIOD = 14;
}

class VideoDVD extends Item {
    int LENDING_PERIOD = 4;
}

class Loan {
    Item item;
    LocalDate dateBorrowed;
    LocalDate dateReturned;
    long noOfDaysBetween = ChronoUnit.DAYS.between(dateBorrowed, dateReturned);

    public double calculateFine() {
    }
}

class Library {
    List<Item> inventory = new ArrayList<>();
    List<Loan> onLoan = new ArrayList<>();

    // check if Item is in inventory
    // if yes, take it out,
    // put it in a Loan record, set date borrwed,
    // add to onLoan
    public void lendItem(Item item) {
        LocalDate today = LocalDate.now();
        for(int i=0; i<inventory.size();) {
            if(inventory.get(i) == item) {
                Loan newLoan = new Loan();
                newLoan.item = inventory.get(i);
                newLoan.dateBorrowed = today;
                onLoan.add(newLoan);
                inventory.remove(i);
                i -= 1;
            }
            i += 1;
        }
    }

    // check if item is on loan
    // set return date
    // calculate fine if any
    // take book out of loan record
    // put item back in inventory
    public void returnItem(Item item) {
        LocalDate today = LocalDate.now();
        for(int i=0; i<onLoan.size();) {
            if(onLoan.get(i).item == item) {
                onLoan.get(i).dateReturned = today;
            }
        }
    }

    public static void main(String[] args) {
        Library library = new Library();

        Book book = new Book();
        LocalDate today = LocalDate.now();
        book.dateBorrowed = today;
        book.dateReturned = today.plusDays(29);
        System.out.println(book.calculateFine());
    }
}
