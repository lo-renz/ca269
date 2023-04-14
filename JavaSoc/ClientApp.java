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

class Person implements Outbox {
    // Inbox implementation

    // Outbox implementation
    List<Activity> outbox = new ArrayList<Activity>();

    // sends a message and adds it to the Outbox
    public boolean send(Activity activity) {
        outbox.add(activity);
        return true;
    }

    // returns an Activity, or null if there are no messages
    public Activity deliverNext() {
        if (getOutbox().isEmpty()) {
            return null;
        }
        return getOutbox().remove(0);
    }

    // returns count of unsent messages in outbox
    public int getCount() {
        return getOutbox().size();
    }

    // Person fields
    static int counter = 0;
    String name;
    String username;
    String URI = "https://JavaSoc.com/";
    String bio;
    Inbox inbox;
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

    public String bio() {
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

    public List<Activity> getOutbox() {
        return this.outbox;
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

    public void setInbox(Inbox inbox) {
        this.inbox = inbox;
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
        setInbox(inbox);
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

// Implement actual activity, e.g. Like, Post, which extends StreamObject
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

// Implement Inbox and Outbox
class Out implements Outbox {
    List<Activity> outbox = new ArrayList<Activity>();

    public boolean send(Activity activity) {
        outbox.add(activity);
        return true;
    }

    public Activity deliverNext() {
        if (outbox.isEmpty()) {
            return null;
        }
        return outbox.remove(0);
    }

    public int getCount() {
        return outbox.size();
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

        Person p = new Person("Renso", "osner");
        output += p;

        // Person q = new Person("Troller", "DaTroll");
        // output += q;

        // Adding an activity to the outbox
        PostActivity post = new PostActivity(p, "Note", "This is the first note in JavaSoc", Audience.GLOBAL, 0, 0, today);
        p.send(post);
        output += post;
        //output += p.getCount() + "\n";

        // Removing Activity from the outbox
        output += p.deliverNext();
        output += p.username + " Outbox delivery\n"+
                "- " + p.getURI() + " posted\n";

        // checking if there are activities in the outbox
        // output += p.getCount();

        // PostActivity post1 = new PostActivity(q, true);
        // output += post1;

        return output;
    }

    public static void main(String args[]) {
        ClientApp x = new ClientApp();
        System.out.println(x.demo());
    }
}
