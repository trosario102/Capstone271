import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GroceryStore {
    private String storeName;
    private List<GroceryItem> groceryItems;
    private Map<String, GroceryStoreContainer> groceryStores;

    public GroceryStore(String storeName) {
        this.storeName = storeName;
        this.groceryItems = new LinkedList<>();
        this.groceryStores = new HashMap<>();
    }

    public void addItem(GroceryItem item) {
        groceryItems.add(item);
    }

    public void removeItem(GroceryItem item) {
        groceryItems.remove(item);
    }

    public String getStoreName() {
        return storeName;
    }

    public boolean containsItem(GroceryItem item) {
        return groceryItems.contains(item);
    }

    public List<GroceryItem> getItemName() {
        return groceryItems;
    }

    public List<GroceryItem> getItemCost() {
        return groceryItems;
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

