/**
 * Represents an activity of unfollowing another user.
 */
class UnfollowActivity extends StreamObject {

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
     * Creates a new UnfollowActivity object with the given sender and receiver.
     * Removes the receiver from the sender's following list and removes the sender
     * from the receiver's followers list.
     *
     * @param sender   the user who initiated the unfollow activity
     * @param receiver the user who is being unfollowed
     */
    UnfollowActivity(Person sender, Person receiver) {
        setType("Unfollow");
        setSender(sender);
        setReceiver(receiver);
        setURI(URI + sender.username + "/unfollow");
        getSender().getFollowing().remove(receiver);
        getReceiver().getFollowers().remove(sender);
    }

    /**
     * Returns a string representation of the UnfollowActivity object.
     *
     * @return a string representation of the UnfollowActivity object
     */
    public String toString() {
        return getSender().username + " adds a Unfollow to Outbox\n" +
                "- URI: " + getURI() + "\n" +
                "- actor: " + getSender().getUsername() + "\n" +
                "- object: " + getReceiver().getUsername() + "\n" +
                "- Type: " + getType() + "\n\n";
    }
}