class LikeActivity extends StreamObject {
    // fields
    static int counter = 0;
    Person sender;
    Person receiver;
    Activity activity;

    public Person getSender() {
        return this.sender;
    }

    public Person getReceiver() {
        return this.receiver;
    }

    public Activity getActivity() {
        return this.activity;
    }

    public void setSender(Person q) {
        this.sender = q;
    }

    public void setReceiver(Person p) {
        this.receiver = p;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    // Constructors
    LikeActivity() {
    }

    LikeActivity(Person p, Person q, StreamObject activity) {
        setSender(p);
        setType("Like");
        setReceiver(q);
        setActivity(activity);
        activity.likes += 1;
        setURI(URI + getSender().username + "/liked/" + getReceiver().username + "/" + activity.getURI().split("/")[4]);
    }

    public String toString() {
        return getSender().username + " added a Like to Outbox\n" +
                "- URI: " + getURI() + "\n" +
                "- Post: " + getActivity().getURI() + "\n" +
                "- Type: " + getType() + "\n\n";

    }
}
