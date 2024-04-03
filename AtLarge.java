import java.util.List;

public class AtLarge extends Student {

    public AtLarge(String firstName, String familyName, int id) {
        super(firstName, familyName, id);
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
        return super.calculateDiscount(list);
    }
}