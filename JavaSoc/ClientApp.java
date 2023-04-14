
/*
* Ideas:
* - The Activity class will extend StreamObject.
* - Each activity will be a class that extends StreamObject and just pick whichever fields are revelevant to them.
* - The activiies will have constructors where one of the args are of type Person, where we will be able to access the Person's details and conect them to the activity.
* - Inbox and Outbox will be lists of activities.
*/
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

interface Activity {
    String getURI();
}

/* receives a message and adds it to the Inbox */
interface ReceiveMessage {
    // returns a success / failure message
    boolean receive(Activity activity);
}

/* removes and retrieves the next message from inbox */
interface ReadNextMessage {
    // returns an Activity, or null if there are no messages
    Activity readNext();
}

/* provides inbox functionality */
interface Inbox extends ReceiveMessage, ReadNextMessage {
    // returns count of unread messages in inbox
    int getCount();
}

/* sends a message and adds it to the Outbox */
interface SendMessage {
    boolean send(Activity activity);
}

/* removes and delivers the next message from outbox */
interface DeliverNextMessage {
    // returns an Activity, or null if there are no messages
    Activity deliverNext();
}

/* provides outbox functionality */
interface Outbox extends SendMessage, DeliverNextMessage {
    // returns count of unsent messages in outbox
    int getCount();
}

/* the client App that handles inboxes and outboxes */
interface App {
    Inbox getInbox(); // retrieves the inbox

    Outbox getOutbox(); // retrievs the outbox

    String demo(); // prints a demo of the app in action
}

enum Audience {
    GLOBAL, FRIENDS, CLOSEFRIENDS, PERSONAL
}

class In implements Inbox {
    List<Activity> inbox = new ArrayList<Activity>();

    public List<Activity> getInbox() {
        return this.inbox;
    }

    public void setInbox(List<Activity> inbox) {
        this.inbox = inbox;
    }

    // receives a message and adds it to the Inbox
    public boolean receive(Activity activity) {
        this.inbox.add(activity);
        return true;
    }

    // removes and retrives the next message from inbox
    public Activity readNext() {
        if (getInbox().isEmpty()) {
            return null;
        }
        return getInbox().remove(0);
    }

    public Activity getNext() {
        if (getInbox().isEmpty()) {
            return null;
        }
        return getInbox().get(0);
    }

    // returns count of unread messages in inbox
    public int getCount() {
        return getInbox().size();
    }
}

class Out implements Outbox {
    List<Activity> outbox = new ArrayList<Activity>();

    public List<Activity> getOutbox() {
        return this.outbox;
    }

    public void setOutbox(List<Activity> outbox) {
        this.outbox = outbox;
    }

    // sends a message and adds it to the Outbox
    public boolean send(Activity activity) {
        this.outbox.add(activity);
        return true;
    }

    // removes and delivers the next message from outbox
    // returns an Activity, or null if there are no messages
    public Activity deliverNext() {
        if (getOutbox().isEmpty()) {
            return null;
        }
        return getOutbox().remove(0);
    }

    public Activity getNext() {
        if (getOutbox().isEmpty()) {
            return null;
        }
        return getOutbox().get(0);
    }

    // returns count of unsent messages in outbox
    public int getCount() {
        return getOutbox().size();
    }

    Out() {
        setOutbox(outbox);
    }
}

class Person {

    // Person fields
    static int counter = 0;
    String name;
    String username;
    String URI = "https://JavaSoc.com/";
    String bio;
    List<Person> followers;
    List<Person> following;
    List<Person> liked;

    // getters
    public String getName() {
        return this.name;
    }

    public String getUsername() {
        return this.username;
    }

    public String getURI() {
        return this.URI;
    }

    public String getBio() {
        return this.bio;
    }

    public List<Person> getFollowers() {
        return this.followers;
    }

    public List<Person> getFollowing() {
        return this.following;
    }

    public List<Person> getLiked() {
        return this.liked;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setFollowers(List<Person> followers) {
        this.followers = followers;
    }

    public void setFollowing(List<Person> following) {
        this.following = following;
    }

    public void setLiked(List<Person> liked) {
        this.liked = liked;
    }

    Person() {
        counter += 1;
    }

    Person(String name, String username) {
        counter += 1;
        setName(name);
        setUsername(username);
    }

    Person(String name, String username, String bio, Inbox inbox, Outbox outbox, List<Person> followers,
            List<Person> following, List<Person> liked) {
        counter += 1;
        setName(name);
        setUsername(username);
        setBio(bio);
        setFollowers(followers);
        setFollowing(following);
        setLiked(liked);
    }

    public String toString() {
        return "Person" + counter + " added" + "\n" +
                "- URI: " + getURI() + getUsername() + "\n" +
                "- name: " + getName() + "\n\n";
    }
}

class StreamObject implements Activity {
    String URI = "https://JavSoc.com/";
    String attatchment;
    String attributedTo;
    String type;
    String content;
    String description;
    Audience audience;
    int likes;
    int shares;
    String name;
    String username;
    LocalDate published;
    boolean deleted;

    public String getURI() {
        return this.URI;
    }

    public String getAttatchment() {
        return this.attatchment;
    }

    public String getAttributedTo() {
        return this.attributedTo;
    }

    public String getType() {
        return this.type;
    }

    public String getContent() {
        return this.content;
    }

    public String getDescription() {
        return this.description;
    }

    public Audience getAudience() {
        return this.audience;
    }

    public int getLikes() {
        return this.likes;
    }

    public int getShares() {
        return this.shares;
    }

    public String getName() {
        return this.name;
    }

    public String getUsername() {
        return this.username;
    }

    public LocalDate getPublished() {
        return this.published;
    }

    public boolean getDeleted() {
        return this.deleted;
    }

    // Setters
    public void setURI(String URI) {
        this.URI = URI;
    }

    public void setAttachment(String attatchment) {
        this.attatchment = attatchment;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDesciption(String description) {
        this.description = description;
    }

    public void setAudience(Audience audience) {
        this.audience = audience;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPublished(LocalDate published) {
        this.published = published;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}

// Implement actual activities here, e.g. Like, Post, which extends StreamObject
class PostActivity extends StreamObject {
    static int count = 0;

    // Constructors
    PostActivity() {
    }

    PostActivity(Person person, String type, String content, Audience audience, int likes, int shares,
            LocalDate published) {
        count += 1;
        setURI(URI + person.username + "/post" + count);
        setUsername(person.username);
        setType(type);
        setContent(content);
        setAudience(audience);
        setLikes(likes);
        setShares(shares);
        setPublished(published);
        setDeleted(false);
    }

    PostActivity(Person person, boolean deleted) {
        setURI(URI);
        setUsername(person.username);
        setDeleted(true);
    }

    public String toString() {
        if (deleted) {
            return username + " added a " + type + " to Outbox\n" +
                    "- Post was deleted.\n\n";
        }
        return username + " added a " + type + " to Outbox\n" +
                "- URI: " + getURI() + "\n" +
                "- audience: " + getAudience() + "\n" +
                "- content: " + getContent() + "\n" +
                "- likes: " + getLikes() + "\n" +
                "- shares: " + getShares() + "\n" +
                "- published: " + getPublished() + "\n" +
                "- deleted: " + getDeleted() + "\n" +
                "\n";
    }
}

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
        setSender(q);
        setReceiver(p);
        setActivity(activity);
        activity.likes += 1;
        setURI(URI + getSender().username + "/liked/" + getReceiver().username + "/" + activity.getURI().split("/")[4]);
    }

    public String toString() {
        return getSender().username + " added a Like to Outbox\n" +
                "- URI: " + getURI() + "\n" +
                "- Post: " + getActivity().getURI() + "\n" +
                "- Action: " + getSender().username + " liked " + getReceiver().username + "'s post\n\n";

    }
}

class ClientApp implements App {
    public Inbox inbox;
    public Outbox outbox;

    public Inbox getInbox() {
        return this.inbox;
    }

    public Outbox getOutbox() {
        return this.outbox;
    }

    public String demo() {
        String output = "";
        LocalDate today = LocalDate.now();

        In pInbox = new In();
        Out pOutbox = new Out();
        Person p = new Person("Renso", "osner");
        output += p;

        Out qOutbox = new Out();
        Person q = new Person("Troller", "DaTroll");
        output += q;

        // Creating a post
        PostActivity post = new PostActivity(p, "Note", "This is the first note in JavaSoc", Audience.GLOBAL, 0, 0,
                today);

        // Adding an Activity to the outbox
        pOutbox.send(post);
        output += pOutbox.getNext().toString();

        // output += pOutbox.getCount() + "\n";

        // Delivering the next message from outbox
        output += p.username + " Outbox delivery\n" +
                "- " + pOutbox.deliverNext().getURI() + "\n" +
                "- Action: Post\n\n";

        // output += pOutbox.getCount() + "\n";

        // Liking a post
        LikeActivity like = new LikeActivity(p, q, post);

        // Adding an Activity to outbox and adding it to receiver's inbox
        qOutbox.send(like);
        output += qOutbox.getNext().toString();

        // Delivering the next message from outbox
        output += q.username + " Outbox delivery\n" +
                "- " + qOutbox.deliverNext().getURI() + "\n" +
                "- Action: Like\n\n";

        // Adding activity to Receiver's inbox
        pInbox.receive(like);

        // checking something is in the inbox
        // output += pInbox.getCount();

        output += p.username + " Inbox delivery\n" +
                "- " + pInbox.getNext().getURI() + "\n\n";

        // checking inbox
        // output += pInbox.getCount();

        output += p.username + " reads a LikeActivity from Inbox\n" +
        "- " + pInbox.readNext().getURI() + "\n\n";

        return output;
    }

    public static void main(String args[]) {
        ClientApp x = new ClientApp();
        System.out.println(x.demo());
    }
}
