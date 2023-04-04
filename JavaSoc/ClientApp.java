import java.util.List;
import java.util.ArrayList;

interface Activity {
    String getURI();
}

/* receives a message and adds it to the Inbox */
interface ReceiveMessage {
    // returns a success / failure message
    boolean receive(Activity a);
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
    boolean send(Activity a);
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

public class ClientApp implements App {
    public Inbox inbox;
    public Outbox outbox;

    public Inbox getInbox() {
        return this.inbox;
    }

    public Outbox getOutbox() {
        return this.outbox;
    }

    public String demo() {
        return "This should include your demo output.";
    }
}

class Person {
    String name;
    String username;
    String bio;
    Inbox inbox;
    Outbox outbox;
    List followers;
    List following;
    List liked;

    // getters
    public String getName() {
        return this.name;
    }

    public String getUsername() {
        return this.username;
    }

    public String bio() {
        return this.bio;
    }

    public List getFollowers() {
        return this.followers;
    }

    public List getFollowing() {
        return this.following;
    }

    public List getLiked() {
        return this.liked;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    Person() {
        setName("");
        setUsername("");
    }

    Person(String name, String username) {
        setName(name);
        setUsername(username);
    }

    public String toString() {
        return "Name: "+getName()+"\n" + 
               "Username: "+getUsername()+"\n";
    }
}

class Test {
    public static void main(String args[]) {
        Person p = new Person("Renso", "osner");
        System.out.println(p);

        Person q = new Person();
        System.out.println(q);
    }
}