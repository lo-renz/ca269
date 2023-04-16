import java.time.LocalDate;

/**
 * Represents an activity of creating a post.
 */
class CreatePostActivity extends StreamObject {

    // A static variable to keep track of the amount of posts created.
    static int count = 0;

    /**
     * Constructs a new CreatePostActivity object.
     *
     * @param person    the Person who created the post
     * @param content   the content of the post
     * @param audience  the audience who can view the post
     * @param likes     the number of likes the post has received
     * @param shares    the number of times the post has been shared
     * @param published the date the post was published
     */
    CreatePostActivity(Person person, String content, Audience audience, int likes, int shares, LocalDate published) {
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

    /**
     * Returns a string representation of the CreatePostActivity object.
     * If the post has been deleted, returns an error message.
     *
     * @return a string representation of the object
     */
    public String toString() {
        if (deletedPost) {
            return "Error: \n" +
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