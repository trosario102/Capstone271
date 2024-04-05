import java.util.*;
public class CourseRegistry {
    private Iterator<Student> nextStudent;
    private Iterator<Student> nextWaitListStudent;

    public CourseRegistry(Course course) {
        this.nextStudent = course.getCourseRoster().iterator();
        this.nextWaitListStudent = course.getCourseWaitList().iterator();
    }

    /*
     * find the registered students in a particular course
     * take Course as a parameter and returns a Set of type Student
     * using the Iterator nextStudent, traverse through nextStudent using while loop and
     * store the students from LinkedList courseRoster into Set called registeredStudents
     * return registeredStudents
     */
    public Set<Student> findRegisteredStudents(Course course) {
        Set<Student> registeredStudents = new TreeSet<>();
        while (nextStudent.hasNext()) {
            Student student = nextStudent.next();
            registeredStudents.add(student);
        }
        return registeredStudents;
    }

    /*
     * find the wait list students that want to register for the particular course since MAX_ENROLLMENT is full
     * takes Course as a parameter and returns a Set of type Student
     * using the Iterator nextWaitListStudent, traverse through the nextWaitListStudent using while loop and
     * store the students from LinkedList courseWaitList into Set called waitListStudents
     * return waitListStudents
     */
    public Set<Student> findWaitListStudents(Course course) {
        Set<Student> waitListStudents = new TreeSet<>();
        while (nextWaitListStudent.hasNext()) {
            Student student = nextWaitListStudent.next();
            waitListStudents.add(student);
        }
        return waitListStudents;
    }

    /*
     * check if a Student contains in particular course
     * return true if the Student contains in the course else return false
     */
    public boolean contains(Student student, Course course) {
        boolean studentInRoster = course.getCourseRoster().contains(student);
        boolean studentInWaitList = course.getCourseWaitList().contains(student);
        return studentInRoster || studentInWaitList;
    }

    /*
     * checks if the two Students take the same section of the course
     * takes the parameters Student s1, Student s2, and Course course
     * return true if two students are in the same course else return false
     */
    public boolean equals(Student s1, Student s2, Course course) {
        boolean s1InRoster = course.getCourseRoster().contains(s1);
        boolean s2InRoster = course.getCourseRoster().contains(s2);
        return s1InRoster == s2InRoster;
    }
}