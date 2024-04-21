import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Student extends Person {
    private int id;
    private Set<Course> myCourseList;
    private List<Course> myWaitList;

    public Student(String firstName, String familyName, String sex, int id) {
        super(firstName, familyName, sex);
        this.id = id;
        this.myCourseList = new HashSet<>();
        this.myWaitList = new LinkedList<>();
    }

    /*
     * Precondition: check if the same student is not adding the same course again, if course is not null
     * and size of myCourseList is less than or equal to course max capacity
     * check if the course has enough space to add other students
     *
     * Postcondition: Each student can only add a particular course only one time
     * if student has space in myCourseList and if a particular course has space to add other students
     * add course to student courseList
  */
    public void addCourse(Course course) {
        if (!myCourseList.contains(course) && course != null && myCourseList.size() <= course.getMaxCapacity()) {
            if (course.getRegistered().size() <= course.getMaxCapacity()) {
                myCourseList.add(course);
                course.addStudent(this);
            }
            course.addStudent(this);
        }
    }

    public boolean addToWaitList(Course c) {
        myWaitList.add(c);
        return true;
    }

    /*
     * Pre-condition: check if a course students want to drop contains in myCourseList
     * Post-condition: remove that course from myCourseList and remove the student from the course roster
     */
    public void dropCourse(Course course) {
        if (myCourseList.contains(course)) {
            myCourseList.remove(course);
            course.dropStudent(this);
        }
    }

    /*
     * Pre-condition: check if myWaitList contains the course
     * it precondition is true, remove the course from student wait list, return true
     * else return false
     */
    public boolean dropFromWaitList(Course c) {
        if (myWaitList.contains(c)) {
            myWaitList.remove(c);
            return true;
        }
        return false;
    }

    public int getID() {
        return id;
    }

    public Set<Course> getMyCourseList() {
        return myCourseList;
    }

    public List<Course> getMyWaitList() {
        return myWaitList;
    }

    /*
     * calls the compareTo method of the superclass (Person) and checks if
     * it equals 0, indicating equal superclass attributes then return the difference of this.id - other.id
     *  else if superclass attributes are not equals, return superclass Person class compareTo
     */
    public int compareTo(Student other) {
        if (super.compareTo(other) == 0) {
            return this.id - other.id;
        } else {
            return super.compareTo(other);
        }
    }
}