public class GroceryItem {
    private String item;
    private double pricePerUnit;
    
    public GroceryItem(String item, double pricePerUnit) {
        this.item = item;
        this.pricePerUnit = pricePerUnit;
    }

    // Getter method for the name of the grocery item
    public String getItem() {
        return item;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    // Setter method for the name of the grocery item
    public void setItem(String item) {
        this.item = item;
    }

    // Override the toString method to provide a string representation of the grocery item
    public String toString() {
        return item;
    }
}
