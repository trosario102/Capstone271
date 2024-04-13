import java.util.List;
import java.util.Set;

public class Graduate extends Student {
    private String expectedCompletion;

    public Graduate(String firstName, String familyName, String sex, int id, String expectedCompletion) {
        super(firstName, familyName, sex, id);
        this.expectedCompletion = expectedCompletion;
    }

    public String getExpectedCompletion() {
        return expectedCompletion;
    }

    public Set<Course> getMyCourselist() {
        return super.getMyCourseList();
    }

    public void addCourse(Course course) {
        super.addCourse(course);
    }

    public void dropCourse(Course course) {
        super.dropCourse(course);
    }

    @Override
    public double calculateDiscount(GroceryList list) {
        return super.calculateDiscount(list) * 0.85; // 15% grocery discount for graduates
    }
}