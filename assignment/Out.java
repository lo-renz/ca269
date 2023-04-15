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
