class In implements Inbox {

    // Creating a new list to store activities
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
