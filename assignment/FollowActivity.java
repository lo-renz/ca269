class FollowActivity extends StreamObject {
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

    FollowActivity(Person sender, Person receiver) {
        setType("Follow");
        setSender(sender);
        setReceiver(receiver);
        setURI(URI + sender.username + "/follow");
        getSender().getFollowing().add(receiver);
        getReceiver().getFollowers().add(sender);
    }

    public String toString() {
        return getSender().username + " adds a Follow to Outbox\n" +
                "- URI: " + getURI() + "\n" +
                "- actor: " + getSender().getUsername() + "\n" +
                "- object: " + getReceiver().getUsername() + "\n" +
                "- Type: " + getType() + "\n\n";
    }
}
