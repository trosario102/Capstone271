public class Professor extends Person {
    private String department;
    private String subject;

    public Professor(String firstName, String familyName, String department, String subject) {
        super(firstName, familyName);
        this.department = department;
        this.subject = subject;
    }

//    @Override
 /*   public void setGroceryBudget(double amount) {
        super.setGroceryBudget(amount);
    }

    @Override
    public double adjustGroceryBudget(double amount) {
        return super.adjustGroceryBudget(amount);
    }

    @Override
    public double calculateDiscount(GroceryList list) {
        return super.calculateDiscount(list);
    }*/
}