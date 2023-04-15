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
