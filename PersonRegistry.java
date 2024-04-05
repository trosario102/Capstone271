import java.util.HashMap;
import java.util.Map;

/*
public class PersonRegistry implements User {
    private Map<String, Person> registeredPeople;

    public PersonRegistry() {
        this.registeredPeople = new HashMap<>();
    }

    public void addPerson(Person person) {
        registeredPeople.put(person.toString(), person);
    }

    public Person getPerson(String firstName, String familyName) {
        String fullName = "";
        fullName += firstName + " " + familyName;
        if (registeredPeople.containsKey(fullName)) {
            return registeredPeople.get(fullName);
        }
        Person newPerson = new Person(firstName, familyName);
        addPerson(newPerson);
        return registeredPeople.get(fullName);
    }

    public String toString() {
        String result = "";
        for (Person p : registeredPeople.values()) {
            result += p + " ";
        }
        return result;
    }

    public boolean selectGroceryStore(String storeName, GroceryStoresLists storesLists) {
        GroceryStore store = storesLists.getGroceryStore(storeName);
        return store != null;
    }


    @Override
    public void addGroceryItems(String itemName, int quantity, GroceryStore store, GroceryList list) {
        for (GroceryItem item : store.getGroceryItems()) {
            if (item.getItemName().equals(itemName)) {
                GroceryItemOrder itemOrder = new GroceryItemOrder(itemName, quantity, item.getItemCost());
                list.add(itemOrder);
            }
        }
    }

    @Override
    public double checkPersonDiscount(Person person, Undergraduate undergrad, Graduate grad, GroceryList list) {
        double discount;
        if (person.getFirstName().equals(undergrad.getFirstName()) &&
                person.getFamilyName().equals(undergrad.getFamilyName())) {
            discount = undergrad.calculateDiscount(list);
            return discount;
        } else if (person.getFirstName().equals(grad.getFirstName()) &&
                person.getFamilyName().equals(grad.getFamilyName())) {
            discount = grad.calculateDiscount(list);
            return discount;
        }
        discount = person.calculateDiscount(list);
        return discount;
    }
}

 */