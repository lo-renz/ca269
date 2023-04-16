/**
 * Represents an activity of sharing a post.
 */
class ShareActivity extends StreamObject {
    // Fields
    Person sender;
    Person receiver;
    Activity activity;

    // Getters
    public Person getSender() {
        return this.sender;
    }

    public Person getReceiver() {
        return this.receiver;
    }

    public Activity getActivity() {
        return this.activity;
    }

    // Setters
    public void setSender(Person sender) {
        this.sender = sender;
    }

    public void setReceiver(Person receiver) {
        this.receiver = receiver;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    /**
     * Constructs a new ShareActivity object.
     * Increments the shares count of the Activity that was shared.
     * Sets the URI of the ShareActivity object.
     *
     * @param p        The Person who performed the share.
     * @param q        The Person who received the share.
     * @param activity The Activity that was shared.
     */
    ShareActivity(Person p, Person q, StreamObject activity) {
        setType("Share");
        setSender(p);
        setReceiver(q);
        setActivity(activity);
        activity.shares += 1;
        setURI(URI + getSender().username + "/shared/" + getReceiver().username + "/"
                + activity.getURI().split("/")[4]);
    }

    /**
     * Returns a string representation of the ShareActivity object.
     *
     * @return A string representation of the ShareActivity object.
     */
    public String toString() {
        return getSender().username + " added a Share to Outbox\n" +
                "- URI: " + getURI() + "\n" +
                "- Post: " + getActivity().getURI() + "\n" +
                "- Type: " + getType() + "\n\n";
    }
}