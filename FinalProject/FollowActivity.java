/**
 * Represents an activity of following another user.
 */
class FollowActivity extends StreamObject {

    // Fields
    Person sender;
    Person receiver;

    // Getters
    public Person getSender() {
        return this.sender;
    }

    public Person getReceiver() {
        return this.receiver;
    }

    // Setters
    public void setSender(Person q) {
        this.sender = q;
    }

    public void setReceiver(Person p) {
        this.receiver = p;
    }

    /**
     * Constructs a new FollowActivity object.
     *
     * @param sender   the Person who initiated the follow activity
     * @param receiver the Person who received the follow activity
     */
    FollowActivity(Person sender, Person receiver) {
        setType("Follow");
        setSender(sender);
        setReceiver(receiver);
        setURI(URI + sender.username + "/follow");
        getSender().getFollowing().add(receiver);
        getReceiver().getFollowers().add(sender);
    }

    /**
     * Returns a string representation of the FollowActivity object.
     *
     * @return a string representation of the object
     */
    public String toString() {
        return getSender().username + " adds a Follow to Outbox\n" +
                "- URI: " + getURI() + "\n" +
                "- actor: " + getSender().getUsername() + "\n" +
                "- object: " + getReceiver().getUsername() + "\n" +
                "- Type: " + getType() + "\n\n";
    }
}