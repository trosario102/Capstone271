package assignments;

public class GroceryList {
//    Create a GroceryItemOrder array
    private GroceryItemOrder[] list;
    private int size = 0;

//    Create a constructor to initialize the list
//    Pre: GroceryList <= 10;
    public GroceryList(){
//put the size of the array in the bracket
        this.list = new GroceryItemOrder[9];
    }

//    get the list
    public GroceryItemOrder[] getList(){
        return this.list;
    }

//    return the number of items in the list
    public int getListLength(){
        return this.list.length;
    }

//    a new empty grocery list
    public void add(GroceryItemOrder item){

    }

//    get the total cost of all the groceries in a GroceryList
    public double getTotalCost(){
//        initialize a double variable that will hold the value that will be returned.
//        initailize it with 0

        double total = 0;
            for(int i = 0; i < size; i++){
//                Use the loop to add the item in the list together.
                total += list[i].getCost();
            }

//            return the total.
        return total;
    }

//    add the item
//    pre: size <= 10
    public void addItem(GroceryItemOrder lists){
        if(size <= 10){
            list[size++] = lists;
            System.out.println(lists.getQuantity() + " " + lists.getName() + " has been added to the grocery lists.");

        }else{
            System.out.println("Grocery List is filled up");
        }
    }

    public void addItem(String itemName, int quantity) {
        if (size < 10) {
            list[size++] = new GroceryItemOrder(itemName, quantity, 0);
        } else {
            System.out.println("Grocery List is filled up");
        }
    }
}


