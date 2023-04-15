
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

    public String inboxDelivery() {
        return " Inbox Delivery\n" +
                "- " + getInbox().get(0).getURI() + "\n\n";
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

    public String outboxDelivery() {
        return " Outbox Delivery\n" +
                "- " + deliverNext().getURI() + "\n";
    }
}

class Person {
    // Person fields
    static int counter = 0;
    String name;
    String username;
    String URI = "https://JavaSoc.com/";
    String bio;
    List<Person> followers = new ArrayList<Person>();
    List<Person> following = new ArrayList<Person>();
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

    Person(String name, String username) {
        counter += 1;
        setName(name);
        setUsername(username);
    }

    Person(String name, String username, String bio, List<Person> followers, List<Person> following) {
        setName(name);
        setUsername(username);
        setBio(bio);
        setFollowers(followers);
        setFollowing(following);
    }

    public String toString() {
        return getUsername() + "'s Profile" + "\n" +
                "- URI: " + getURI() + getUsername() + "\n" +
                "- name: " + getName() + "\n" +
                "- followers: " + getFollowers().size() + "\n" +
                "- following: " + getFollowing().size() + "\n\n";
    }
}

class StreamObject implements Activity {
    String URI = "https://JavSoc.com/";
    String attatchment;
    String attributedTo;
    String type;
    String content;
    Audience audience;
    int likes;
    int shares;
    String name;
    String username;
    LocalDate published;
    LocalDate deleted;
    boolean deletedPost;

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

    public LocalDate getDeleted() {
        return this.deleted;
    }

    public boolean getDeletedPost() {
        return this.deletedPost;
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

    public void setDeleted(LocalDate deleted) {
        this.deleted = deleted;
    }

    public void setDeletedPost(boolean deletedPost) {
        this.deletedPost = deletedPost;
    }
}

// Implement actual activities here, e.g. Like, Post, which extends StreamObject
class CreatePostActivity extends StreamObject {
    static int count = 0;

    // Constructors
    CreatePostActivity(Person person, String content, Audience audience, int likes, int shares,
            LocalDate published) {
        count += 1;
        setURI(URI + person.getUsername() + "/post" + count);
        setUsername(person.username);
        setType("Post");
        setContent(content);
        setAudience(audience);
        setLikes(likes);
        setShares(shares);
        setPublished(published);
    }

    public String toString() {
        if(deletedPost) {
            return "Error: \n"+
                    "- This post was deleted\n";
        }
        return "- URI: " + getURI() + "\n" +
                "- Type: " + getType() + "\n" +
                "- audience: " + getAudience() + "\n" +
                "- content: " + getContent() + "\n" +
                "- likes: " + getLikes() + "\n" +
                "- shares: " + getShares() + "\n" +
                "- published: " + getPublished() + "\n\n";
    }
}

class DeletePostActivity extends StreamObject {
    static int count = 0;

    // Constructors
    DeletePostActivity(Person person, CreatePostActivity post, LocalDate time) {
        count += 1;
        setType("Delete post");
        setURI(post.getURI() + "/deleted");
        setDeleted(time);
        // implement this so that it deletes the CreatePostActivity
        post.setDeletedPost(true);
    }

    public String toString() {
        return "- URI: " + getURI() + "\n" +
               "- Type: " + getType() + "\n" +
               "- Deleted: " + getDeleted() + "\n\n";
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

        // Creating Person p, and their personal inbox and outbox
        In pInbox = new In();
        Out pOutbox = new Out();
        Person p = new Person("Renso", "osner");
        output += "Created " + p;

        // Creating Person q, and their personal inbox and outbox
        In qInbox = new In();
        Out qOutbox = new Out();
        Person q = new Person("Ronan", "bro");
        output += "Created " + q;

        // Creating a post by Person p
        CreatePostActivity post = new CreatePostActivity(p, "This is the first note in JavaSoc", Audience.GLOBAL, 0, 0, today);

        // Person p: adding an Activity to the outbox
        pOutbox.send(post);
        output += p.username + " added a " + post.type + " to Outbox\n";
        output += pOutbox.getNext().toString();

        // Person p: delivering the next message from outbox
        output += p.username + pOutbox.outboxDelivery() + "\n";

        // Person q: Liking Person p's post
        LikeActivity like = new LikeActivity(q, p, post);

        // Person q: adding LikeActivity to their outbox
        qOutbox.send(like);
        output += qOutbox.getNext().toString();

        // Person q: delivering the next message from outbox
        output += q.username + qOutbox.outboxDelivery() + "\n";

        // Adding like to Person p's inbox
        pInbox.receive(like);
        output += p.username + pInbox.inboxDelivery();

        // Person p: receives the like and removes it from their inbox
        output += p.username + " reads a LikeActivity from Inbox\n" +
                "- " + pInbox.readNext().getURI() + "\n\n";

        // Person p: checking that the likes on the post has increased by 1
        output += p.username + " is viewing a post\n" + post;

        // creating a follow
        FollowActivity follow = new FollowActivity(p, q);

        // adding the follow to the outbox
        pOutbox.send(follow);
        output += follow;

        // Person p: delivering the next message to Person p outbox
        output += p.username + pOutbox.outboxDelivery() +
                "- added " + q.username + " to Following list\n\n";

        // adding follow to Person q's inbox
        qInbox.receive(follow);
        output += q.username + qInbox.inboxDelivery();

        // Person q: receives the follow and removes it from their inbox
        output += q.username + " reads a FollowActivity from Inbox\n" +
                "- added " + p.username + " to Followers list\n\n";

        // Person p: checking their following
        output += p;

        // Person q: checking their followers
        output += q;

        // creating an unfollow
        UnfollowActivity unfollow = new UnfollowActivity(p, q);

        // adding the unfollow to the outbox
        pOutbox.send(unfollow);
        output += unfollow;

        // Person p: delivering the next message to Person p outbox
        output += p.username + pOutbox.outboxDelivery() +
                "- removed " + q.username + " from Following list\n\n";

        // adding unfollow to Person q's inbox
        qInbox.receive(unfollow);
        output += q.username + qInbox.inboxDelivery();

        // Peron q: receives the folow and removes it from their inbox
        output += q.username + "reads an UnfollowActivity from Inbox\n" +
                "- removed " + p.username + " from Followers list\n\n";

        // Person p: checking their following
        output += p;

        // Person q: checking their followers
        output += q;

        // creating a delete post
        DeletePostActivity deletePost = new DeletePostActivity(p, post, today);

        // Person p: adding delete to the outbox
        pOutbox.send(deletePost);
        output += p.username + " added a " + deletePost.type + " to Outbox\n";
        output += pOutbox.getNext().toString();

        // Person p: delivering the next message from outbox
        output += p.username + pOutbox.outboxDelivery() + "\n";

        // checking if post still exists.
        output += post;

        return output;
    }

    public static void main(String args[]) {
        ClientApp x = new ClientApp();
        System.out.println(x.demo());
    }
}
