import java.util.List;

public class Graduate extends Student {
    private String expectedCompletion;

    public Graduate(String firstName, String familyName, int id, String expectedCompletion) {
        super(firstName, familyName, id);
        this.expectedCompletion = expectedCompletion;
    }

    public String getExpectedCompletion() {
        return expectedCompletion;
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

    @Override
    public void setGroceryBudget(double amount) {
        super.setGroceryBudget(amount);
    }

    @Override
    public double adjustGroceryBudget(double amount) {
        return super.adjustGroceryBudget(amount);
    }

    @Override
    public double calculateDiscount(GroceryList list) {
        return super.calculateDiscount(list) * 0.85; // 15% grocery discount for graduates
    }
}