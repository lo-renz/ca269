import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;

interface Comparable<T> {
    int compareTo(T other);
}

class Student implements Comparable<Student> {
    private int marks;
    public int getMarks() { return this.marks; }
    public void setMarks(int marks) { this.marks = marks; }

    // Comparable method
    /**
    * Returns -1, 0, 1, if the student's marks are less than, equal to or greater than the student's marks being compared.
    *
    * @param is of type student and represents the student to compare to.
    * @return returns an int depending on the comparison of marks.
    */
    public int compareTo(Student other) {
        if(this.getMarks() < other.getMarks()) {
            return -1;
        } else if(this.getMarks() > other.getMarks()) {
            return 1;
        }
        return 0;
    }
}

class Classroom {
    // fields
    private List<Student> students = new ArrayList<Student>();

    /**
    * Adds a student to the list of students.
    *
    * @param is of type Student and is a student.
    */
    public void addStudent(Student student) {
        this.students.add(student);
    }

    public Queue<Student> getGraduatingStudents() {
        List<Student> gradedStudents = new ArrayList<>();
        Queue<Student> graduatingStudents = new LinkedList<>();

        for(Student student: this.students) {
            if(student.getMarks() > 40) {
                gradedStudents.add(student);
            }
        }

        //Collections.sort(gradedStudents);

        for(Student student: gradedStudents) {
            graduatingStudents.add(student);
        }

        return graduatingStudents;
    }

    public int getAverageMarks() {
        int total = 0;

        for(Student student: students) {
            total += student.getMarks();
        }

        return total / students.size();
    }

    public String hasStudent(Student student) {

        if(students.contains(student)) {
            return "Student is in the class.";
        }

        return "Student is not in the class.";
    }

    public static void main(String args[]) {
        Classroom classroom = new Classroom();

        Student x = new Student();
        x.setMarks(100);
        classroom.addStudent(x);

        Student y = new Student();
        y.setMarks(90);
        classroom.addStudent(y);

        Student z = new Student();
        z.setMarks(80);

        //System.out.println(classroom.getGraduatingStudents());
        List<Integer> list = new ArrayList<>();
        list.add(9);
        list.add(5);
        list.add(7);
        list.add(4);

        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }
}
