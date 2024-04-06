import java.util.Scanner;


public class PersonGroceryStoreGroceryListTester {
    public static void main(String[] args) {
        GroceryItem item1 = new GroceryItem("apple", 0.68);
        GroceryItem item2 = new GroceryItem("strawberry", 2.11);
        GroceryItem item3 = new GroceryItem("eggs", 3.88);
        GroceryItem item4 = new GroceryItem("bread", 3.79);
        GroceryItem item5 = new GroceryItem("milk", 4.99);
        GroceryItem item6 = new GroceryItem("tomatoes", 1.19);
        GroceryItem item7 = new GroceryItem("cucumber", 1.00);
        GroceryItem item8 = new GroceryItem("olives", 6.99);
        GroceryItem item9 = new GroceryItem("avocado", 1.99);
        GroceryItem item10 = new GroceryItem("lettuce", 1.99);
        GroceryItem item11 = new GroceryItem("pasta", 5.93);
        GroceryItem item12 = new GroceryItem("blueberry", 3.39);
        GroceryItem item13 = new GroceryItem("orange", 0.98);
        GroceryItem item14 = new GroceryItem("lemon", 0.99);

        GroceryStoreContainer storesLists = new GroceryStoreContainer();

        GroceryStore store1 = new GroceryStore("Mariano's");
        storesLists.addGroceryStore(store1);
        store1.addItem(item5);
        store1.addItem(item12);
        store1.addItem(item4);
        store1.addItem(item8);
        store1.addItem(item6);
        store1.addItem(item7);
        store1.addItem(item11);
        store1.addItem(item1);
        store1.addItem(item13);
        store1.addItem(item14);
        store1.addItem(item3);

        GroceryStore store2 = new GroceryStore("Target");
        storesLists.addGroceryStore(store2);
        store2.addItem(item2);
        store2.addItem(item3);
        store2.addItem(item9);
        store2.addItem(item10);
        store2.addItem(item13);
        store2.addItem(item14);
        store2.addItem(item5);
        store2.addItem(item12);
        store2.addItem(item11);
        store2.addItem(item4);

        Person p1 = new Person("Mohammed", "Khursiwala", "m");
        Person p2 = new Person("Mike", "James", "m");
        Person p3 = new Person("Aishah", "Raquib", "f");
        Person p4 = new Person("Umayma", "Raquib", "f");

        Professor prof = new Professor(p2.getFirstName(), p2.getFamilyName(), p2.getSex(), "Comp", "Data Structures I");
        Undergraduate undergrad = new Undergraduate(p1.getFirstName(), p1.getFamilyName(), p1.getSex(), 516111,"freshmen");
        Graduate grad = new Graduate(p3.getFirstName(), p3.getFamilyName(), p3.getSex(), 567128,"May 2025");
        AtLarge at = new AtLarge(p4.getFirstName(), p4.getFamilyName(), p4.getSex(), 514766);

        PersonRegistry registry = new PersonRegistry();
        registry.addPerson(prof);
        registry.addPerson(undergrad);
        registry.addPerson(grad);

        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to Grocery Shopping App!");
        System.out.print("Enter your first & last name & sex: ");
        String firstName = scan.next();
        String lastName = scan.next();
        String sex = scan.next();

        System.out.println("Welcome " + registry.getPerson(firstName, lastName, sex));
        System.out.print("You have no grocery lists saved. Type your Grocery Store: ");
        String store = scan.next();

        while (!registry.selectGroceryStore(store, storesLists)) {
            store = scan.next();
        }

        System.out.print("I can shop at " + store + " Would you want to shop right now? ");
        String answer = scan.next();

        while (!answer.equals("ok")) {
            answer = scan.next();
        }
        GroceryStore selectStore = storesLists.getGroceryStore(store);
        System.out.println(selectStore);

        GroceryList groceryList = new GroceryList();

        System.out.print("Enter your items one at a time and I'll give you a price if it's available ");
        String item = scan.next();

        while (!item.equals("stop")) {
            System.out.print(item + ", Quantity? ");
            int quantity = scan.nextInt();
            registry.addGroceryItems(item, quantity, selectStore, groceryList);
            System.out.println("Next Item? ");
            item = scan.next();
        }

        System.out.println(groceryList);
        double discountedPrice = registry.checkPersonDiscount(new Person(firstName, lastName, sex), undergrad, grad, groceryList);
        System.out.println("Total after discount applied: " + discountedPrice);
    }
}

