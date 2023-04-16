import java.util.List;
import java.util.ArrayList;

/**
 * Represents a user.
 */
class Person {
    // Fields
    String name;
    String username;
    String URI = "https://JavaSoc.com/";
    String bio;
    List<Person> followers = new ArrayList<Person>();
    List<Person> following = new ArrayList<Person>();
    List<Person> liked;

    // Getters
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

    // Setters
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

    /**
     * Creates a person object with a name, username, and bio.
     *
     * @param name     the name of the person.
     * @param username the username of the person.
     * @param bio      the bio of the person.
     */
    Person(String name, String username, String bio) {
        setName(name);
        setUsername(username);
        setBio(bio);
    }

    /**
     * Creates a person object with a name, username, bio, followers, and following.
     *
     * @param name      the name of the person.
     * @param username  the username of the person.
     * @param bio       the bio of the person.
     * @param followers the list of followers of the person.
     * @param following the list of people followed by the person.
     */
    Person(String name, String username, String bio, List<Person> followers, List<Person> following) {
        setName(name);
        setUsername(username);
        setBio(bio);
        setFollowers(followers);
        setFollowing(following);
    }

    /**
     * Returns a String representation of this Person object.
     *
     * @return a String containing the person's username followed by their account
     *         details.
     */
    public String toString() {
        return getUsername() + "'s Profile" + "\n" +
                "- URI: " + getURI() + getUsername() + "\n" +
                "- name: " + getName() + "\n" +
                "- bio: " + getBio() + "\n" +
                "- followers: " + getFollowers().size() + "\n" +
                "- following: " + getFollowing().size() + "\n\n";
    }
}