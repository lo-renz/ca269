import java.util.List;
import java.util.ArrayList;

/**
 * The In class represents an inbox that receives and stores messages.
 */
class In implements Inbox {

    // Creating a new list to store activities.
    List<Activity> inbox = new ArrayList<Activity>();

    // Getter
    public List<Activity> getInbox() {
        return this.inbox;
    }

    // Setter
    public void setInbox(List<Activity> inbox) {
        this.inbox = inbox;
    }

    /**
     * Adds a new activity to the inbox.
     *
     * @param activity the activity to be added to the inbox
     * @return true if the activity was added successfully
     */
    public boolean receive(Activity activity) {
        this.inbox.add(activity);
        return true;
    }

    /**
     * Retrieves and removes the next activity from the inbox.
     *
     * @return the next activity in the inbox, or null if the inbox is empty
     */
    public Activity readNext() {
        if (getInbox().isEmpty()) {
            return null;
        }
        return getInbox().remove(0);
    }

    /**
     * Gets the next activity in the inbox without removing it.
     *
     * @return the next activity in the inbox, or null if the inbox is empty
     */
    public Activity getNext() {
        if (getInbox().isEmpty()) {
            return null;
        }
        return getInbox().get(0);
    }

    /**
     * Gets the number of activities in the inbox.
     *
     * @return the number of activities in the inbox
     */
    public int getCount() {
        return getInbox().size();
    }

    /**
     * Gets a string representation of the next activity in the inbox for delivery.
     *
     * @return a string with the next activity's URI for delivery
     */
    public String inboxDelivery() {
        return " Inbox Delivery\n" +
                "- " + getInbox().get(0).getURI() + "\n\n";
    }
}