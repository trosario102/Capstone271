import java.util.List;

public class AtLarge extends Student {

    public AtLarge(String firstName, String familyName, String sex, int id) {
        super(firstName, familyName, sex, id);
    }

    public List<Course> getMyCourselist() {
        return super.getMyCourseList();
    }

    public void addCourse(Course course) {
        super.addCourse(course);
    }

    public void dropCourse(Course course) {
        super.dropCourse(course);
    }
}
