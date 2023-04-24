import java.util.List;
import java.util.ArrayList;

class Student {
    private int marks;
    public int getMarks() { return this.marks; }
    public void setMarks(int marks) { this.marks = marks; }
}

class Classroom {
    private List<Student> classroom = new ArrayList<>();

    // getter
    public List<Student> getClassroom() {
        return this.classroom;
    }

    // setter
    public void setClassroom(List<Student> classroom) {
        this.classroom = classroom;
    }

    Classroom() {
        setClassroom(getClassroom());
    }

    /**
    * method that adds a student to the private list.
    *
    * @param student, a student that will be added to the list.
    */
    public void addStudent(Student student) {
        getClassroom().add(student);
    }

    /**
    * a method that will return a list of student that have marks greater than that passed as an arg.
    *
    * @param a mark that will be used when deciding which students are added to the list.
    * @return returns a list of students who's marks are greater than or equal to marks passed as an arg.
    */
    public List<Student> getGradedStudents(int marks) {
        List<Student> gradedStudents = new ArrayList<>();
        for(Student student: getClassroom()) {
            if(student.getMarks() >= marks) {
                gradedStudents.add(student);
            }
        }
        return gradedStudents;
    }

    /**
    * a method that returns the average marks of all students in the classroom.
    *
    * @return the average marks of all students in the classroom.
    */
    public int getAverageMarks() {
        int averageMarks = 0;
        for(Student student: getClassroom()) {
            averageMarks += student.getMarks();
        }
        return averageMarks / getClassroom().size();
    }

    public static void main(String[] args) {
        Student Renso = new Student();
        Renso.setMarks(85);

        Student Random1 = new Student();
        Random1.setMarks(39);

        Student Random2 = new Student();
        Random2.setMarks(39);

        Classroom classroom = new Classroom();
        classroom.addStudent(Renso);
        classroom.addStudent(Random1);
        classroom.addStudent(Random2);
        System.out.println(classroom.getGradedStudents(40));

        System.out.println(classroom.getAverageMarks());
    }
}
