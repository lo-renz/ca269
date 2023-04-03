class Q1a {
    public String title;
    public int number;
    public int marks;

    Q1a(String title, int number, int marks) {
        this.title = title;
        this.number = number;
        this.marks = marks;
    }

    public String toString() {
        return number + " " + title + " (" + marks + " marks)";
    }

    public static void main(String args[]) {
        Q1a x = new Q1a("The first question", 1, 100);
        System.out.println(x);
    }
}