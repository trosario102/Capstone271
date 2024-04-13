public interface User {
    public void addGroceryItems(String item, int quantity, GroceryStore store, GroceryList list);
    public double checkPersonDiscount(Person person, GroceryList list); // checks if person is professor, or undergrad, or grad, or atLarge to implement percent discount behavior
    public boolean selectGroceryStore(String storeName, GroceryStoreContainer storesLists);
}