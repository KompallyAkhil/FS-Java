
import java.util.*;

public class Students {
    List<Student> students;

    public Students() {
        this.students = new ArrayList<>();
    }

    public List<Student> getStudents() {
        return students;
    }

    public void readStudentData() {
        // Sample student data setup
        Student s1 = new Student("Alice", 101, Arrays.asList(
                new Marks("Math", 90),
                new Marks("Science", 95)
        ));

        Student s2 = new Student("Bob", 102, Arrays.asList(
                new Marks("Math", 80),
                new Marks("Science", 85)
        ));

        Student s3 = new Student("Charlie", 103, Arrays.asList(
                new Marks("Math", 88),
                new Marks("Science", 92)
        ));

        students.add(s1);
        students.add(s2);
        students.add(s3);
    }

    public static class Student {
        String name;
        int rollNumber;
        List<Marks> marks;

        public Student(String name, int rollNumber, List<Marks> marks) {
            this.name = name;
            this.rollNumber = rollNumber;
            this.marks = marks;
        }

        public String toString() {
            return name + " (Roll: " + rollNumber + ")";
        }
    }

    public static class Marks {
        String subject;
        int marks;

        public Marks(String subject, int marks) {
            this.subject = subject;
            this.marks = marks;
        }
    }

    public static void main(String[] args) {
        Students students = new Students();
        students.readStudentData(); // assume students are populated here

        Student topper = getTopper(students);
        int totalMarks = 0;
        for (Marks m : topper.marks) {
            totalMarks += m.marks;
        }
        System.out.println("Topper is: " + topper + " with total marks: " + totalMarks);
    }

    static Student getTopper(Students students2) {
        // Implement only this method. Do not alter the code.
        Student topper = null;
        int max = Integer.MIN_VALUE;
        for(Student s : students2.getStudents()){
            int total = 0;
            for(Marks m : s.marks){
                total += m.marks;
            }
            if(total > max){
                max = total;
                topper = s;
            }
        }
        return topper;
    }
}
