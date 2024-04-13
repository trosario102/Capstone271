public class GroceryItemOrder extends GroceryItem{
    private int quantity;

    public GroceryItemOrder(String name, int quantity, double pricePerUnit){
        super(name, pricePerUnit);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPricePerQuantity() {
        return quantity * super.getPricePerUnit();
    }
}
