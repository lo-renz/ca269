/**
 * Represents an activity of liking a post.
 */
class LikeActivity extends StreamObject {
    // Fields
    static int counter = 0;
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
    public void setSender(Person q) {
        this.sender = q;
    }

    public void setReceiver(Person p) {
        this.receiver = p;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    /**
     * Constructs a new LikeActivity object.
     * Increments the likes count of the Activity that was liked.
     * Sets the URI of the LikeActivity object.
     *
     * @param p        The Person who performed the like.
     * @param q        The Person who received the like.
     * @param activity The Activity that was liked.
     */
    LikeActivity(Person p, Person q, StreamObject activity) {
        setType("Like");
        setSender(p);
        setReceiver(q);
        setActivity(activity);
        activity.likes += 1;
        setURI(URI + getSender().username + "/liked/" + getReceiver().username + "/" + activity.getURI().split("/")[4]);
    }

    /**
     * Returns a string representation of the LikeActivity object.
     *
     * @return A string representation of the LikeActivity object.
     */
    public String toString() {
        return getSender().username + " added a Like to Outbox\n" +
                "- URI: " + getURI() + "\n" +
                "- Post: " + getActivity().getURI() + "\n" +
                "- Type: " + getType() + "\n\n";

    }
}