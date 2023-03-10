import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

class PrintJob {
    String name;
    PrintJob(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }
}

// PrintingQueue can be iterated by taking one PrintJob at a time
class PrintingQueue implements Iterable<PrintJob> {
    // how print jobs are maintained
    // this can change later e.g. to optimise the code
    private List<PrintJob> list = new ArrayList<>();

    //iterator method has to be implemented for Iterable implementation
    // note the return type is Iterator, and the parameter is the same as
    // the iterable i.e. PrintJob
    // this means that the iterator will provide one printjob at a time
    // from the list declared above
    public Iterator<PrintJob> iterator() {
        // return a new instance of PrintJobIterator which provides the
        // iterator methods for this class
        return new PrintJobIterator();
    }

    // a method that allows adding print jobs but hides how they are stored
    public void add(String item) {
        this.list.add(new PrintJob(item));
    }

    // note a private class - this means nothing outside PrintingQueue
    // can see or use this class, which helps keep this code as a local
    // dependency that only this class uses
    private class PrintJobIterator implements Iterator<PrintJob> {
        private int iterated = 0;

        // if there are more elements to iterate
        public boolean hasNext() {
            // if the amount of iterated elements is less than the list
            // of the list, then there are more elements to be iterated
            // Note that in this "inner class" we can access the fields of 
            // the "outer class" i.e. PrintingQueue.list
            // This is because the scoep of PrintingJobIterator lies within
            // the class PrintingQueue, hence just like methods this class
            // can also 'see' the elements from the outer class.
            return iterated < list.size();
        }

        public PrintJob next() {
            if(hasNext()) {
                PrintJob item = list.get(iterated);
                iterated += 1; // increment index / counter
                return item;
            }
            return null; // if there aren't more elements
        }
    }
}

public class Run {
    public static void main(String[] args) {
        PrintingQueue queue = new PrintingQueue();
        queue.add("job#1");
        queue.add("job#2");

        // Method 1 - directly iterating using the class
        // iterator is implicitly used by the loop
        for(PrintJob job: queue) {
            System.out.println(job);
        }

        // Method 2 - using an iterator
        // iterator can be paused at any state, and be passed around
        // to other methods as a parameter
        Iterator<PrintJob> iter = queue.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
        // verify queue is empty
        System.out.println("queue has elements? " + iter.hasNext());
        // test queue is empty
        System.out.println("queue elements: " + iter.next());
    }
}