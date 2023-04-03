class Q1c {
    private String title;
    public int number;
    private int marks;
    private static int MQUESTION_COUNT = 0;

    Q1c(String title, int number, int marks) {
        setTitle(title);
        setNumber(number);
        setMarks(marks);
        Q1c.MQUESTION_COUNT += 1;
    }

    Q1c() {
        setTitle("untitled");
        setNumber(0);
        setMarks(0);
        Q1c.MQUESTION_COUNT += 1;
    }

    Q1c(String title, int marks) {
        setTitle(title);
        setMarks(marks);
        Q1c.MQUESTION_COUNT += 1;
        setNumber(Q1c.MQUESTION_COUNT);
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
        Q1c x = new Q1c("The third part", -99);
        System.out.println(x);

        Q1c y = new Q1c("The third part, pt.2", 100);
        System.out.println(y);
    }
}