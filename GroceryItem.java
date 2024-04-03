package assignments;

public class GroceryItem extends GroceryItemOrder{
    private String name;

    // Constructor for the GroceryItem class
    public GroceryItem(String name, int quantity, double pricePerUnit) {
        super(name, quantity, pricePerUnit);
        this.name = name;
    }

    // Getter method for the name of the grocery item
    public String getName() {
        return name;
    }

    // Setter method for the name of the grocery item
    public void setName(String name) {
        this.name = name;
    }

    // Override the toString method to provide a string representation of the grocery item
    @Override
    public String toString() {
        return name;
    }
}

