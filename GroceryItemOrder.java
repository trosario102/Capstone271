public class GroceryItemOrder extends GroceryItem{
    private int quantity;

    public GroceryItemOrder(String name, double pricePerUnit, int quantity){
        super(name, pricePerUnit);
        this.quantity = quantity;
    }

    public int getQuantity(){
        return quantity;
    }

    public double getPricePerQuantity(){
        return quantity * super.getPricePerUnit();
    }
}
