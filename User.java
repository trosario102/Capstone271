public interface User {
    public boolean selectGroceryStore(String storeName, GroceryStoreContainer storesLists);
    // public GroceryList createGroceryList(String listName);
    // public boolean hasGroceryList(String listName); // returns true if a grocery list exists for a person else return false
    // public List<GroceryItemOrder> getGroceryList(String listName);
    public void addGroceryItems(String item, int quantity, GroceryStore store, GroceryList list);
    public double checkPersonDiscount(Person person, Undergraduate undergrad, Graduate grad, GroceryList list); // checks if person is professor, or undergrad, or grad, or atLarge to implement percent discount behavior
}