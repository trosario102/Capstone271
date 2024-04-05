import java.util.List;

public class Undergraduate extends Student {
    private String year;

    public Undergraduate(String firstName, String familyName, int id, String year) {
        super(firstName, familyName, id);
        this.year = year;
    }

    public String getYear() {
        return year;
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
    public double calculateDiscount(GroceryList list) {
        return super.calculateDiscount(list) * 0.9; // 10% grocery discount for undergraduates
    }
}