import java.util.ArrayList;
public class GroceryList {
    // private GroceryItemOrder[] groceryList;
    private ArrayList<GroceryItemOrder> groceryList;
    private double totalCost;


    //    Pre: GroceryList <= 10;
    public GroceryList() {
        this.groceryList = new ArrayList<GroceryItemOrder>();
        // this.groceryList = new GroceryItemOrder[9];
    }

    public ArrayList<GroceryItemOrder> getGroceryList() {
        return this.groceryList;
    }

    //    return the number of items in the list
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
//        initialize a double variable that will hold the value that will be returned.
//        initailize it with 0

        double total = 0;
        for (int i = 0; i < groceryList.size(); i++) {
            total += groceryList.get(i).getPricePerUnit() * groceryList.get(i).getQuantity();
        }

        return total;
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


