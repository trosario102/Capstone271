import java.beans.PropertyEditor;
import java.util.*;


public class PersonRegistry implements User {
    private Map<String, Person> registeredPeople;

    public PersonRegistry() {
        this.registeredPeople = new HashMap<>();
    }

    public void addPerson(Person person) {
        registeredPeople.put(person.getFirstName() + " " + person.getFamilyName(), person);
    }

    public Person getPerson(String firstName, String familyName, char sex) {
        String fullName = "";
        fullName += firstName + " " + familyName;
        if (registeredPeople.containsKey(fullName)) {
            return registeredPeople.get(fullName);
        }
        return makeNew(firstName, familyName, sex);
    }

    public Person makeNew(String firstName, String familyName, char sex){
        Scanner scan = new Scanner(System.in);
        System.out.println("Hi " + firstName + "! You are not in the system.");
        System.out.print("Are you atLarge, undergrad, graduate, professor, or a person? ");
        String response = scan.next();

        Person person;
        int id;
        String year;
        switch(response.toLowerCase()) {
            case "atlarge":
                System.out.print("Enter your studentID: ");
                id = scan.nextInt();
                scan.nextLine();
                person = new AtLarge(firstName, familyName, sex, id);
                break;
            case "undergrad":
                System.out.print("Enter your studentID: ");
                id = scan.nextInt();
                scan.nextLine();
                System.out.print("Enter your year: ");
                year = scan.nextLine();
                person = new Undergraduate(firstName, familyName, sex, id, year);
                break;
            case "graduate":
                System.out.print("Enter your studentID: ");
                id = scan.nextInt();
                scan.nextLine();
                System.out.print("Enter your expected completed date: ");
                year = scan.nextLine();
                person = new Graduate(firstName, familyName, sex, id, year);
                break;
            case "professor":
                System.out.print("Enter your department & subject: ");
                String dept = scan.next();
                String subject = scan.next();
                person = new Professor(firstName, familyName, sex, dept, subject);
                break;
            default:
                person = new Person(firstName, familyName, sex);
                System.out.println("im running default");
                break;
        }

        addPerson(person);
        return person;

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
    public double checkPersonDiscount(Person person, GroceryList list) {
        return (double) Math.round(person.calculateDiscount(list)*100)/100;
    }
}

