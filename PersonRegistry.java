import java.util.*;


public class PersonRegistry implements User {
    private Map<String, Person> registeredPeople;

    public PersonRegistry() {
        this.registeredPeople = new HashMap<>();
    }

    public void addPerson(Person person) {
        registeredPeople.put(person.toString(), person);
    }

    public Person getPerson(String firstName, String familyName, String sex) {
        String fullName = "";
        fullName += firstName + " " + familyName;
        if (registeredPeople.containsKey(fullName)) {
            return registeredPeople.get(fullName);
        }
        Person newPerson = new Person(firstName, familyName, sex);
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

    public ArrayList<Person> getPaternalLine(Person p) {
        ArrayList<Person> paternalLine = new ArrayList<>();

        while (p != null && p.getFather() != null) {
            paternalLine.add(p.getFather());
            p = p.getFather();
        }
        return paternalLine;
    }

    public ArrayList<Person> getMaternalLine(Person p) {
        ArrayList<Person> maternalLine = new ArrayList<>();

        while (p != null && p.getMother() != null) {
            maternalLine.add(p.getMother());
            p = p.getMother();
        }
        return maternalLine;
    }

    public ArrayList<Person> getAllChildren(Person p) {
        ArrayList<Person> children = new ArrayList<>();

        children.addAll(p.getChildren());
        Collections.sort(children, new Comparator<Person>(){
            public int compare(Person p1, Person p2) {
                return p1.getAge() - p2.getAge();
            }
        });
        return children;
    }


    public boolean selectGroceryStore(String storeName, GroceryStoreContainer storesLists) {
        GroceryStore store = storesLists.getGroceryStore(storeName);
        return store != null;
    }


    @Override
    public void addGroceryItems(String itemName, int quantity, GroceryStore store, GroceryList list) {
        for (GroceryItem item : store.getItemName()) {
            if (item.getItem().equals(itemName)) {
                GroceryItemOrder itemOrder = new GroceryItemOrder(itemName, quantity, item.getPricePerUnit());
                list.addItem(itemOrder);
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

