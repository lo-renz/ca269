import java.time.LocalDate;

/**
 * Represents an activity of deleting a post.
 */
class DeletePostActivity extends StreamObject {

    /**
     * Constructs a new DeletePostActivity object.
     *
     * @param person the Person who deleted the post
     * @param post   the CreatePostActivity object to be deleted
     * @param time   the date the post was deleted
     */
    DeletePostActivity(Person person, CreatePostActivity post, LocalDate time) {
        setType("Delete post");
        setURI(post.getURI() + "/deleted");
        setDeleted(time);

        // When this is set to true, the post will return an error message when trying
        // to view the post.
        post.setDeletedPost(true);
    }

    /**
     * Returns a string representation of the DeletePostActivity object.
     *
     * @return a string representation of the object
     */
    public String toString() {
        return "- URI: " + getURI() + "\n" +
                "- Type: " + getType() + "\n" +
                "- Deleted: " + getDeleted() + "\n\n";
    }
}