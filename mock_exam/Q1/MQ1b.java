class Q1b {
    private String title;
    public int number;
    private int marks;

    Q1b(String title, int number, int marks) {
        setTitle(title);
        setNumber(number);
        setMarks(marks);
    }

    Q1b() {
        setTitle("untitled");
        setNumber(0);
        setMarks(0);
    }

    // getters
    public String getTitle() {
        return this.title;
    }

    public int getNumber() {
        return this.number;
    }

    public int getMarks() {
        return this.marks;
    }

    // setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setMarks(int marks) {
        if(marks < 0) {
            this.marks = 0;
        }
        else {
            this.marks = marks;
        }
    }

    public String toString() {
        return number + " " + title + " (" + marks + " marks)";
    }

    public static void main(String args[]) {
        Q1b x = new Q1b("The second part", 2, -99);
        System.out.println(x);
    }
}