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
