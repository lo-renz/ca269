import java.util.List;
import java.util.ArrayList;

class Student {
    private int marks;
    public int getMarks() { return this.marks; }
    public void setMarks(int marks) { this.marks = marks; }
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

    /**
    * A method that returns a list of students that have marks greater than or equal to what is specified
    *
    * @param a specified mark, that decides whether a student is added to the gradedStudents list.
    */
    public List<Student> getGradedStudents(int marks) {
        List<Student> gradedStudents = new ArrayList<Student>();

        for(Student student: gradedStudents) {
            if(student.getMarks() == marks || student.getMarks() > marks) {
                gradedStudents.add(student);
            }
        }
        return gradedStudents;
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

        System.out.println(classroom.hasStudent(z));
    }
}
