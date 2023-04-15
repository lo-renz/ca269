class Person {
    // Person fields
    static int counter = 0;
    String name;
    String username;
    String URI = "https://JavaSoc.com/";
    String bio;
    List<Person> followers = new ArrayList<Person>();
    List<Person> following = new ArrayList<Person>();
    List<Person> liked;

    // getters
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

    // setters
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

    Person(String name, String username) {
        counter += 1;
        setName(name);
        setUsername(username);
    }

    Person(String name, String username, String bio, List<Person> followers, List<Person> following) {
        setName(name);
        setUsername(username);
        setBio(bio);
        setFollowers(followers);
        setFollowing(following);
    }

    public String toString() {
        return getUsername() + "'s Profile" + "\n" +
                "- URI: " + getURI() + getUsername() + "\n" +
                "- name: " + getName() + "\n" +
                "- followers: " + getFollowers().size() + "\n" +
                "- following: " + getFollowing().size() + "\n\n";
    }
}
