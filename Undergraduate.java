import java.util.List;
import java.util.Set;

public class Undergraduate extends Student {
    private String year;

    public Undergraduate(String firstName, String familyName, String sex, int id, String year) {
        super(firstName, familyName, sex, id);
        this.year = year;
    }

    public String getYear() {
        return year;
    }

    @Override
    public double calculateDiscount(GroceryList list) {
        return super.calculateDiscount(list) * 0.9; // 10% grocery discount for undergraduates
    }
}