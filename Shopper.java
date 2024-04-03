public interface Shopper {
    public void setGroceryBudget(double amount);
    public double adjustGroceryBudget(double amount);
    public double calculateDiscount(GroceryList list);
}