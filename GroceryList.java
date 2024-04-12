import java.util.ArrayList;
public class GroceryList {
    private ArrayList<GroceryItemOrder> groceryList;
    private double totalCost;

    public GroceryList() {
        this.groceryList = new ArrayList<GroceryItemOrder>();
    }

    public ArrayList<GroceryItemOrder> getGroceryList() {
        return this.groceryList;
    }

    // return the number of items in the list
    public int getListLength() {
        return this.groceryList.size();
    }

    public void addItem(GroceryItemOrder item) {
        groceryList.add(item);
    }

    public void removeItem(GroceryItemOrder item) {
        groceryList.remove(item);
    }

    public double getTotalCost() {
        double total = 0;
        for (int i = 0; i < groceryList.size(); i++) {
            total += groceryList.get(i).getPricePerUnit() * groceryList.get(i).getQuantity();
        }

        return (double) Math.round(total*100)/100;
    }

    public String toString() {
        String result = "Grocery Cart:\n";
        for (GroceryItemOrder itemOrder : groceryList) {
            result += itemOrder + "\n";
        }
        result += "\nSubtotal: " + getTotalCost();
        return result;
    }
}
