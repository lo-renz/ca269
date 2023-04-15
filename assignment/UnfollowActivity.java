class UnfollowActivity extends StreamObject {
    // fields
    Person sender;
    Person receiver;

    public Person getSender() {
        return this.sender;
    }

    public Person getReceiver() {
        return this.receiver;
    }

    public void setSender(Person q) {
        this.sender = q;
    }

    public void setReceiver(Person p) {
        this.receiver = p;
    }

    UnfollowActivity(Person sender, Person receiver) {
        setType("Unfollow");
        setSender(sender);
        setReceiver(receiver);
        setURI(URI + sender.username + "/unfollow");
        getSender().getFollowing().remove(receiver);
        getReceiver().getFollowers().remove(sender);
    }

    public String toString() {
        return getSender().username + " adds a Unfollow to Outbox\n" +
                "- URI: " + getURI() + "\n" +
                "- actor: " + getSender().getUsername() + "\n" +
                "- object: " + getReceiver().getUsername() + "\n" +
                "- Type: " + getType() + "\n\n";
    }
}
