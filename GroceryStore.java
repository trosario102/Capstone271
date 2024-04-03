package assignments;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroceryStore {
    private String name;
    private Map<GroceryItemOrder, Double> itemPrices;

    public GroceryStore(String name) {
        this.name = name;
        this.itemPrices = new HashMap<>();
    }

    // Method to add a new grocery item with its price to the store
    public void addItem(GroceryItem item, double price) {
        itemPrices.put(item, price);
    }

    // Method to remove a grocery item from the store
    public void removeItem(GroceryItem item) {
        itemPrices.remove(item);
    }

    // Method to get the price of a specific grocery item
    public double getPrice(GroceryItem item) {
        return itemPrices.getOrDefault(item, 0.0);
    }

    // Method to check if a grocery item exists in the store
    public boolean containsItem(GroceryItem item) {
        return itemPrices.containsKey(item);
    }

    // Method to get the name of the store
    public String getName() {
        return name;
    }
    public void getGroceryStores() {
        System.out.println("Grocery Store: " + name);
    }
    public void getGroceryItems() {
        System.out.println("Grocery Items: " + itemPrices);
    }
}

