import java.util.*;


public class Registry implements User {
    private HashMap<String, Course> courseFinder;
    private ArrayList<Course> courses;
    private Map<String, Person> registeredPeople;

    public Registry() {
        courseFinder = new HashMap<>();
        courses = new ArrayList<>();
        registeredPeople = new HashMap<>();
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

    public void addPerson(Person person) {
        registeredPeople.put(person.getFirstName() + " " + person.getFamilyName(), person);
    }

    @Override
    public double checkPersonDiscount(Person person, GroceryList list) {
        return (double) Math.round(person.calculateDiscount(list)*100)/100;
    }

    public void enrollStudent(String first, String last, String deptName, int cNum) {
        Course c = courseFinder.get(deptName + " " + cNum);
        Person p = registeredPeople.get(first + " " + last);
        if (p instanceof Student) {
            Student s = (Student) p;
            c.addStudent(s);
        }
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

    public Course getCourse(String dept, int num) {
        return courseFinder.get(dept + " " + num);
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public ArrayList<Person> getMaternalLine(Person p) {
        ArrayList<Person> maternalLine = new ArrayList<>();

        while (p != null && p.getMother() != null) {
            maternalLine.add(p.getMother());
            p = p.getMother();
        }
        return maternalLine;
    }

    public ArrayList<Person> getPaternalLine(Person p) {
        ArrayList<Person> paternalLine = new ArrayList<>();

        while (p != null && p.getFather() != null) {
            paternalLine.add(p.getFather());
            p = p.getFather();
        }
        return paternalLine;
    }

    public Person getPerson(String firstName, String familyName, String sex) {
        String fullName = "";
        fullName += firstName + " " + familyName;
        if (registeredPeople.containsKey(fullName)) {
            return registeredPeople.get(fullName);
        }
        return makeNewPerson(firstName, familyName, sex);
    }

    public Person makeNewPerson(String firstName, String familyName, String sex) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hi " + firstName + "! You are not in the system.");
        System.out.print("Are you (1) atLarge, (2) undergrad, (3) graduate, (4) professor, or a (5) person? ");
        int response = scan.nextInt();

        Person person;
        int id;
        String year;
        switch(response) {
            case 1:
                System.out.print("Enter your studentID: ");
                id = scan.nextInt();
                scan.nextLine();
                System.out.print("Enter your registered semester: ");
                String semester = scan.nextLine();
                person = new AtLarge(firstName, familyName, sex, id, semester);
                break;
            case 2:
                System.out.print("Enter your studentID: ");
                id = scan.nextInt();
                scan.nextLine();
                System.out.print("Enter your year: ");
                year = scan.nextLine();
                person = new Undergraduate(firstName, familyName, sex, id, year);
                break;
            case 3:
                System.out.print("Enter your studentID: ");
                id = scan.nextInt();
                scan.nextLine();
                System.out.print("Enter your expected completed date: ");
                year = scan.nextLine();
                person = new Graduate(firstName, familyName, sex, id, year);
                break;
            case 4:
                System.out.print("Enter your department & subject: ");
                String dept = scan.next();
                String subject = scan.next();
                person = new Professor(firstName, familyName, sex, dept, subject);
                break;
            default:
                person = new Person(firstName, familyName, sex);
                break;
        }

        addPerson(person);
        return person;

    }

    public void recordCourse(String dName, int cNum, String title, int maxCap, int hours) {
        Course c = new Course(dName, cNum, title, maxCap, hours);
        courses.add(c);
        courseFinder.put(dName + " " + cNum, c);
    }

    public void removeStudent(String first, String last, String deptName, int cNum) {
        Person p = registeredPeople.get(first + " " + last);
        Course c = courseFinder.get(deptName + " " + cNum);
        if (p instanceof Student) {
            Student s = (Student) p;
            c.dropStudent(s);
        }
    }

    public boolean selectGroceryStore(String storeName, GroceryStoreContainer storesLists) {
        GroceryStore store = storesLists.getGroceryStore(storeName);
        return store != null;
    }

    public String toString() {
        String result = "";
        for (Person p : registeredPeople.values()) {
            result += p + " ";
        }
        return result;
    }

}

