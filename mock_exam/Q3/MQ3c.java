import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;

enum Grade {
    GradeFail, GradePass, GradeDistinction;
}

class Student implements Comparable<Student> {
    private int marks;
    public int getMarks() { return this.marks; }
    public void setMarks(int marks) { this.marks = marks; }

    // implemented method
    /**
    * a method which compares the marks of two students.
    *
    * @param another student, which we want to compare marks with.
    * @return -1, 0, 1 based on whether a student's marks are less than,
    *         equal to or greater than the other specified student.
    */
    public int compareTo(Student other) {
        if(this.getMarks() < other.getMarks()) {
            return -1;
        } else if(this.getMarks() == other.getMarks()) {
            return 0;
        }
        return 1;
    }
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

    // MQ3c.java implementation
    public static Map<Grade, Integer> gradedStudents = new HashMap<>();

    public void calculateGradeStatistics() {
        int fail = 0;
        int pass = 0;
        int distinction = 0;

        for(Student student: getClassroom()) {
            if(student.getMarks() < 40) {
                fail += 1;
            } else if(student.getMarks() >= 40 && student.getMarks() <= 75) {
                pass += 1;
            } else if(student.getMarks() > 75) {
                distinction += 1;
            }
        }

        gradedStudents.put(Grade.GradeFail, fail);
        gradedStudents.put(Grade.GradePass, pass);
        gradedStudents.put(Grade.GradeDistinction, distinction);
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
    public Queue<Student> getGraduatingStudents(int marks) {
        List<Student> gradedStudents = new ArrayList<>();
        for(Student student: getClassroom()) {
            if(student.getMarks() >= marks) {
                gradedStudents.add(student);
            }
        }

        Collections.sort(gradedStudents);
        Collections.reverse(gradedStudents);
        Queue<Student> graduatingStudents = new LinkedList<>();

        for(Student student: gradedStudents) {
            graduatingStudents.add(student);
        }
        return graduatingStudents;
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

        Student Random3 = new Student();
        Random3.setMarks(74);

        Classroom classroom = new Classroom();
        classroom.addStudent(Renso);
        classroom.addStudent(Random1);
        classroom.addStudent(Random2);
        classroom.addStudent(Random3);

        //System.out.println(classroom.getAverageMarks());

        //Queue<Student> graduating = classroom.getGraduatingStudents(30);
        //System.out.println(graduating.remove().getMarks());

        classroom.calculateGradeStatistics();
        System.out.println(classroom.gradedStudents);
    }
}
