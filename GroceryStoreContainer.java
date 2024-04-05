
import java.util.HashMap;
import java.util.Map;

public class GroceryStoreContainer {
    private Map<String, GroceryStore> groceryStores;

    public GroceryStoreContainer() {
        this.groceryStores = new HashMap<>();
    }

    // Method to add a new grocery store to the container
    public boolean addGroceryStore(String storeName) {
        if(!groceryStores.containsKey(storeName)) {
            GroceryStore store = new GroceryStore(storeName);
            groceryStores.put(storeName, store);
            return true;
        } else{
            return false;
        }
    }

    // Method to remove a grocery store from the container
    public void removeGroceryStore(String storeName) {
        groceryStores.remove(storeName);
    }

    // Method to get a grocery store by name
    public GroceryStore getGroceryStore(String storeName) {
        return groceryStores.get(storeName);
    }

    // Method to check if a grocery store exists in the container
    public boolean containsGroceryStore(String storeName) {
        return groceryStores.containsKey(storeName);
    }
}