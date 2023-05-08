public class E23N1 {
    private String title;
    private String published;
    private int number;
    private boolean approvedForPublication;

    // getters
    public String getTitle() {
        return title;
    }

    public String getPublished() {
        return published;
    }

    public int getNumber() {
        return number;
    }

    public boolean getApproved() {
        return approvedForPublication;
    }

    // setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setApproved(boolean approved) {
        this.approvedForPublication = approved;
    }

    E23N1() {
        setTitle("Untitled");
        setPublished("not set");
        setNumber(0);
        setApproved(false);
    }

    E23N1(String title) {
        setTitle(title);
        setPublished("not set");
        setNumber(0);
        setApproved(false);
    }
}