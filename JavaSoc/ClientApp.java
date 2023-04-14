import java.util.List;
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

/* removes and delivers the next message from inbox */
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

class Person {
    static int counter = 0;
    String name;
    String username;
    String URI = "https://JavaSoc.com/";
    String bio;
    Inbox inbox;
    Outbox outbox;
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

    public void setOutbox(Outbox outbox) {
        this.outbox = outbox;
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

    Person(String name, String username, String bio, Inbox inbox, Outbox outbox, List<Person> followers, List<Person> following, List<Person> liked) {
        counter += 1;
        setName(name);
        setUsername(username);
        setBio(bio);
        setInbox(inbox);
        setOutbox(outbox);
        setFollowers(followers);
        setFollowing(following);
        setLiked(liked);
    }

    public String toString() {
        return "Person"+counter+" added"+"\n"+
               "- URI: "+getURI()+getUsername()+"\n" +
               "- name: "+getName()+"\n";
    }
}

class StreamObject implements Activity{
    String URI;
    String attatchment;
    String attributedTo;
    Audience audience;
    int likes;
    int shares;
    String content;
    String name;
    LocalDate published;
    LocalDate deleted;

    public String getURI() {
        return this.URI;
    }
}

class ActivityObject implements Activity {
    String URI;

    public String getURI() {
        return this.URI;
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
        return "";
    }
}

class Test {
    public static void main(String args[]) {
        Person p = new Person("Renso", "osner");
        System.out.println(p);

        Person q = new Person("Troller", "DaTroll");
        System.out.println(q);

        Person r = new Person();
        System.out.println(r);

        //ClientApp x = new ClientApp();
        //System.out.println(x.demo());
    }
}
