import java.util.LinkedList;
import java.util.List;

public class Student extends Person {
    private int id;
    private List<Course> myCourseList;
    private List<Course> myWaitList;

    public Student(String firstName, String familyName, String sex, int id) {
        super(firstName, familyName, sex);
        this.id = id;
        this.myCourseList = new LinkedList<>();
        this.myWaitList = new LinkedList<>();
    }

    public int getID() {
        return id;
    }

    public List<Course> getMyCourseList() {
        return myCourseList;
    }

    /*
    Precondition: check if the same student is not adding the same course again
    Postcondition: Each student can only add a particular course only one time
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

    public void dropCourse(Course course) {
        if (myCourseList.contains(course)) {
            myCourseList.remove(course);
            course.dropStudent(this);
        }
    }

    public int compareTo(Student other) {
        if (super.compareTo(other) == 0) {
            return this.id - other.id;
        } else {
            return super.compareTo(other);
        }
    }

    public String toString() {
        String result = "";
        result += super.toString() + " " + id + "\n\n" + "My Course List:\n";
        for (Course course : myCourseList) {
            result += course;
        }
        return result;
    }
    public boolean addToWaitList(Course c) {
        myWaitList.add(c);
        return true;
    }

    public boolean dropFromWaitList(Course c) {
        if (myWaitList.contains(c)) {
            myWaitList.remove(c);
            return true;
        }
        return false;
    }
}