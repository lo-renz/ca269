import java.time.LocalDate;

interface Activity {
    String getURI();
}

/* Receives a message and adds it to the Inbox */
interface ReceiveMessage {
    // Returns a success / failure message.
    boolean receive(Activity activity);
}

/* Removes and retrieves the next message from inbox */
interface ReadNextMessage {
    // Returns an Activity, or null if there are no messages.
    Activity readNext();
}

/* Provides inbox functionality */
interface Inbox extends ReceiveMessage, ReadNextMessage {
    // Returns count of unread messages in inbox.
    int getCount();
}

/* Sends a message and adds it to the Outbox */
interface SendMessage {
    boolean send(Activity activity);
}

/* Removes and delivers the next message from inbox */
interface DeliverNextMessage {
    // Returns an Activity, or null if there are no messages.
    Activity deliverNext();
}

/* Provides outbox functionality */
interface Outbox extends SendMessage, DeliverNextMessage {
    // Returns count of unsent messages in outbox.
    int getCount();
}

/* The client App that handles inboxes and outboxes */
interface App {
    Inbox getInbox(); // Retrieves the inbox.

    Outbox getOutbox(); // Retrievs the outbox.

    String demo(); // Prints a demo of the app in action.
}

enum Audience {
    GLOBAL, FRIENDS, CLOSEFRIENDS, PERSONAL
}

/**
 * ClientApp class implements the App interface and provides functionality for
 * creating and managing social media activities.
 * It contains public fields for Inbox and Outbox, as well as methods for
 * accessing them and for demonstrating the functionality of the class.
 */
class ClientApp implements App {

    // Fields
    public Inbox inbox;
    public Outbox outbox;

    // Getters
    public Inbox getInbox() {
        return this.inbox;
    }

    public Outbox getOutbox() {
        return this.outbox;
    }

    /**
     * Demonstrates the functionality of the ClientApp class by creating and
     * managing social media posts and activities.
     *
     * @return A string representation of the output of the demonstration.
     */
    public String demo() {
        String output = "";
        LocalDate today = LocalDate.now();

        // Creating Person p, and their personal inbox and outbox.
        In pInbox = new In();
        Out pOutbox = new Out();
        Person p = new Person("Renso", "osner", "Hocus pocus, there's a pizza on my focus.");
        output += "Created " + p;

        // Creating Person q, and their personal inbox and outbox.
        In qInbox = new In();
        Out qOutbox = new Out();
        Person q = new Person("Dabro", "bro", "Winton");
        output += "Created " + q;

        // Creating a post by Person p.
        CreatePostActivity post = new CreatePostActivity(p, "This is the first note in JavaSoc", Audience.GLOBAL, 0, 0,
                today);

        // Person p: adding an Activity to the outbox.
        pOutbox.send(post);
        output += p.username + " added a " + post.type + " to Outbox\n";
        output += pOutbox.getNext().toString();

        // Person p: delivering the next message from outbox.
        output += p.username + pOutbox.outboxDelivery() + "\n";

        // Person q: Liking Person p's post.
        LikeActivity like = new LikeActivity(q, p, post);

        // Person q: adding LikeActivity to their outbox.
        qOutbox.send(like);
        output += qOutbox.getNext().toString();

        // Person q: delivering the next message from outbox.
        output += q.username + qOutbox.outboxDelivery() + "\n";

        // Adding like to Person p's inbox.
        pInbox.receive(like);
        output += p.username + pInbox.inboxDelivery();

        // Person p: receives the like and removes it from their inbox.
        output += p.username + " reads a LikeActivity from Inbox\n" +
                "- " + pInbox.readNext().getURI() + "\n\n";

        // Person p: checking that the likes on the post has increased by 1.
        output += p.username + " is viewing a post\n" + post;

        // Person q: sharing Person p's post.
        ShareActivity share = new ShareActivity(q, p, post);

        // Person q: adding ShareActivity to their outbox.
        qOutbox.send(share);
        output += qOutbox.getNext().toString();

        // Person q: delivering the next message from outbox.
        output += q.username + qOutbox.outboxDelivery() + "\n";

        // Adding share to Person p's inbox.
        pInbox.receive(share);
        output += p.username + pInbox.inboxDelivery();

        // Person p: receives the share and removes it from their inbox.
        output += p.username + " reads a ShareActivity from Inbox\n" +
                "- " + pInbox.readNext().getURI() + "\n\n";

        // Person p: checking that the shares on the post has increased by 1.
        output += p.username + " is viewing a post\n" + post;

        // Creating a follow.
        FollowActivity follow = new FollowActivity(p, q);

        // Adding the follow to the outbox.
        pOutbox.send(follow);
        output += follow;

        // Person p: delivering the next message to Person p outbox.
        output += p.username + pOutbox.outboxDelivery() +
                "- added " + q.username + " to Following list\n\n";

        // Adding follow to Person q's inbox.
        qInbox.receive(follow);
        output += q.username + qInbox.inboxDelivery();

        // Person q: receives the follow and removes it from their inbox.
        output += q.username + " reads a FollowActivity from Inbox\n" +
                "- added " + p.username + " to Followers list\n\n";

        // Person p: checking their following.
        output += p;

        // Person q: checking their followers.
        output += q;

        // Creating an unfollow.
        UnfollowActivity unfollow = new UnfollowActivity(p, q);

        // Adding the unfollow to the outbox.
        pOutbox.send(unfollow);
        output += unfollow;

        // Person p: delivering the next message to Person p outbox.
        output += p.username + pOutbox.outboxDelivery() +
                "- removed " + q.username + " from Following list\n\n";

        // Adding unfollow to Person q's inbox.
        qInbox.receive(unfollow);
        output += q.username + qInbox.inboxDelivery();

        // Peron q: receives the folow and removes it from their inbox.
        output += q.username + "reads an UnfollowActivity from Inbox\n" +
                "- removed " + p.username + " from Followers list\n\n";

        // Person p: checking their following.
        output += p;

        // Person q: checking their followers.
        output += q;

        // Creating a delete post.
        DeletePostActivity deletePost = new DeletePostActivity(p, post, today);

        // Person p: adding delete to the outbox.
        pOutbox.send(deletePost);
        output += p.username + " added a " + deletePost.type + " to Outbox\n";
        output += pOutbox.getNext().toString();

        // Person p: delivering the next message from outbox.
        output += p.username + pOutbox.outboxDelivery() + "\n";

        // Checking if post still exists.
        output += post;

        return output;
    }

    public static void main(String args[]) {
        ClientApp x = new ClientApp();
        System.out.println(x.demo());
    }
}