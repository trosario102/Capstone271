package assignments;

public class GroceryItemOrder {
    private String name;
    private int quantity;
    private double pricePerUnit;

    public GroceryItemOrder(String name, int quantity, double pricePerUnit){
        this.name = name;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }

//    return the item's quantity price per unit.
    public double getCost(){
        return quantity * pricePerUnit;
    }

//    return the name by creating an accessor method for it.
    public String getName(){
        return this.name;
    }

//    return the quantity of each list
    public int getQuantity(){
        return quantity;
    }

}
