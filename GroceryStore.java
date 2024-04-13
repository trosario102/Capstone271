import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GroceryStore {
    private String storeName;
    private List<GroceryItem> groceryItems;

    public GroceryStore(String storeName) {
        this.storeName = storeName;
        this.groceryItems = new LinkedList<>();
    }

    public void addItem(GroceryItem item) {
        groceryItems.add(item);
    }

    public boolean containsItem(GroceryItem item) {
        return groceryItems.contains(item);
    }

    public List<GroceryItem> getItemCost() {
        return groceryItems;
    }

    public List<GroceryItem> getItemName() {
        return groceryItems;
    }

    public String getStoreName() {
        return storeName;
    }

    public void removeItem(GroceryItem item) {
        groceryItems.remove(item);
    }

    public String toString() {
        String result = "";
        result += "Items at " + storeName + ":\n";
        for (GroceryItem item : groceryItems) {
            result += item.getItem() + " " + item.getPricePerUnit() + "\n";
        }
        return result;
    }
}
