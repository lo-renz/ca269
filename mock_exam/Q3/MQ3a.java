import java.util.List;
import java.util.ArrayList;

class Student {
    private int marks;
    public int getMarks() { return this.marks; }
    public void setMarks(int marks) { this.marks = marks; }
}

class Classroom {
    private List students<Student>;

    public void addStudent(Student s) {
        students.add(s);
    }
}
