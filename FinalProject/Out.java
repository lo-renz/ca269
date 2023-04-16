import java.util.List;
import java.util.ArrayList;

/**
 * The Out class implements the Outbox interface and represents an outbox that
 * can store and deliver messages.
 * It keeps track of the messages in the outbox and allows new messages to be
 * added and delivered.
 */
class Out implements Outbox {

    // Creating a new list to store activites.
    List<Activity> outbox = new ArrayList<Activity>();

    // Getter
    public List<Activity> getOutbox() {
        return this.outbox;
    }

    // Setter
    public void setOutbox(List<Activity> outbox) {
        this.outbox = outbox;
    }

    /**
     * Sends a new activity and adds it to the outbox.
     *
     * @param activity The activity to send.
     * @return true if the activity was successfully sent and added to the outbox,
     *         false otherwise.
     */
    public boolean send(Activity activity) {
        this.outbox.add(activity);
        return true;
    }

    /**
     * Removes and delivers the next message from the outbox.
     *
     * @return The next activity in the outbox, or null if there are no activities.
     */
    public Activity deliverNext() {
        if (getOutbox().isEmpty()) {
            return null;
        }
        return getOutbox().remove(0);
    }

    /**
     * Gets the next activity in the outbox, without removing it.
     *
     * @return The next activity in the outbox, or null if there are no activities.
     */
    public Activity getNext() {
        if (getOutbox().isEmpty()) {
            return null;
        }
        return getOutbox().get(0);
    }

    /**
     * Gets the count of unsent messages in the outbox.
     *
     * @return The count of unsent messages in the outbox.
     */
    public int getCount() {
        return getOutbox().size();
    }

    // Constructs an empty outbox.
    Out() {
        setOutbox(outbox);
    }

    /**
     * Gets a string representation of the next activity in the outbox for delivery.
     *
     * @return A string representation of the next activity in the outbox for
     *         delivery.
     */
    public String outboxDelivery() {
        return " Outbox Delivery\n" +
                "- " + deliverNext().getURI() + "\n";
    }
}