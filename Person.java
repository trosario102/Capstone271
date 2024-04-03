import java.util.*;

public class Person implements Shopper {
    private String firstName;
    private String familyName;
    private double budget;

    public Person(String firstName, String familyName) {
        this.firstName = firstName;
        this.familyName = familyName;
        this.budget = 0;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public double getBudget() {
        return budget; // in US Dollars
    }

    public String toString() {
        return firstName + " " + familyName;
    }

    @Override
    public void setGroceryBudget(double amount) {
        budget = amount;
    }

    /*
     * increases the grocery budget by a given amount
     */
    @Override
    public double adjustGroceryBudget(double amount) {
       return budget += amount;
    }

    @Override
    public double calculateDiscount(GroceryList list) {
        return list.getTotalCost();
    }
}