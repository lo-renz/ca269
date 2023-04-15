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
