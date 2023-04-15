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
