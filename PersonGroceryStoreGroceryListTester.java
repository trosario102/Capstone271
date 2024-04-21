import java.util.Scanner;

public class PersonGroceryStoreGroceryListTester {
    /*
     * createAndAddGroceryItems() - static method returns grocery storesLists
     * create multiple GroceryItem objects, which take two parameters: name of the item and pricePerUnit of an item
     * create a GroceryStoreContainer object called storeLists
     * create GroceryStore objects that takes a parameter: name of the store
     * add grocery stores to storeLists
     * add groceryItems to each store
     */
    public static GroceryStoreContainer createAndAddGroceryItems() {
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

        GroceryStore store1 = new GroceryStore("mariano's");
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

        GroceryStore store2 = new GroceryStore("target");
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

        return storesLists;
    }

    /*
     * createCourses() - static method - void return type - takes a parameter called Registry
     * record multiple courses for students to enroll in a registry system
     */
    public static void createCourses(Registry registry) {
        // 3 courses
        // Assumed parameters departmentName, courseNumber, courseTitle, maxCapacity
        registry.recordCourse("COMP", 170, "Intro to OOP", 2, 3);
        registry.recordCourse("COMP", 271, "Data Structures I", 2, 3);
        registry.recordCourse("COMP", 272, "Data Structures II", 2, 3);
        registry.recordCourse("COMP", 453, "Database Programming", 3, 3);
        registry.recordCourse("COMP", 479, "Machine Learning", 3, 3);
    }

    /*
     * createAndAddPeople() - static method - returns registry
     * create Person objects that are of type Undergraduate or Professor
     * or Graduate or AtLarge or only Person since Undergrad, Grad, AtLarge are a Student
     * and Student and Professor are Person
     *
     * create a Registry object and add persons to the registry
     * Create Relationship objects that takes 2 partners as parameter: Male and Female
     * create child - person object and add children to those relationships that takes child's firstName, lastName, sex, and set the age
     * call the endRelationship() method to end some relationships
     * add children to the registry
     */
    public static Registry createAndAddPeople() {
        Person p1 = new Undergraduate("Donald", "Draper", "m", 111, "freshman");
        Person p2 = new Undergraduate("Natalie", "Mering", "f", 122, "sophomore");
        Person p3 = new Undergraduate("Lisa", "Simpson", "f", 345, "senior");
        Person p4 = new Professor("William", "Honig", "m", "COMP", "Data Structures I");
        Person p5 = new Professor("Yasin", "Silva", "m", "COMP", "Database Programming");
        Person p6 = new Graduate("Ezra", "Koenig", "m", 212, "May 2025");
        Person p7 = new Graduate("Leslie", "Knope", "f", 300, "December 2026");
        Person p8 = new AtLarge("Laura", "Marling", "f", 999, "Fall 2024");
        Person p9 = new AtLarge("James", "Murphy", "m", 717, "Spring 2025");
        Person p10 = new Person("Alex", "Giannascoli","m");
        Person p11 = new Person("Katie", "Crutchfield","f");
        Person p12 = new Person("Alan", "Palomo","m");
        Person p13 = new Person("Frankie", "Cosmos","f");

        Registry registry = new Registry();
        registry.addPerson(p1);
        registry.addPerson(p2);
        registry.addPerson(p3);
        registry.addPerson(p4);
        registry.addPerson(p5);
        registry.addPerson(p6);
        registry.addPerson(p7);
        registry.addPerson(p8);
        registry.addPerson(p9);
        registry.addPerson(p10);
        registry.addPerson(p11);
        registry.addPerson(p12);
        registry.addPerson(p13);

        //Create relationships and add children
        Relationship r1 = new Relationship(p1, p2);

        Person robert = r1.createChild("Robert",p1.getFamilyName(),"m");
        robert.setAge(39);
        Person sarah = r1.createChild("Sarah", p1.getFamilyName(), "f");
        sarah.setAge(38);

        Relationship r2 = new Relationship(p3, p6);
        Person steve = r2.createChild("Steve",p6.getFamilyName(),"m");
        steve.setAge(32);
        Person sophie = r2.createChild("Sophie", p6.getFamilyName(), "f");
        sophie.setAge(35);

        Relationship r3 = new Relationship(robert, sophie);
        Person david = r3.createChild("David", robert.getFamilyName(), "m");
        david.setAge(20);

        r1.endRelationship();
        Relationship r4 = new Relationship(p1,p8);
        Person samantha = r4.createChild("Samantha", p1.getFamilyName(), "f");
        samantha.setAge(14);
        Person brianna = r4.createChild("Brianna",p1.getFamilyName(), "f");
        brianna.setAge(16);

        Relationship r5 = new Relationship(p9, p11);
        Person axel = r5.createChild("Axel", p9.getFamilyName(), "m");
        axel.setAge(22);
        Person harper = r5.createChild("Harper", p9.getFamilyName(), "f");
        harper.setAge(21);

        Relationship r6 = new Relationship(david, harper);
        Person taylor = r6.createChild("Taylor", david.getFamilyName(), "f");
        taylor.setAge(6);

        registry.addPerson(robert);
        registry.addPerson(sarah);
        registry.addPerson(steve);
        registry.addPerson(sophie);
        registry.addPerson(david);
        registry.addPerson(samantha);
        registry.addPerson(brianna);
        registry.addPerson(axel);
        registry.addPerson(harper);
        registry.addPerson(taylor);

        return registry;
    }

    /*
     * registerStudents() - static method - void return type - takes a parameter called Registry
     * enroll students to courses and if courses are full, add students to course wait list
     */
    public static void registerStudents(Registry registry) {
        registry.enrollStudent("Donald", "Draper", "COMP", 170);
        registry.enrollStudent("Natalie", "Mering", "COMP", 271);
        registry.enrollStudent("Ezra", "Koenig", "COMP", 272);
        registry.enrollStudent("Lisa", "Simpson", "COMP", 170);
        registry.enrollStudent("Ezra", "Koenig", "COMP", 170);     
        registry.enrollStudent("Laura", "Marling", "COMP", 170);
        registry.enrollStudent("James", "Murphy", "COMP", 170);
        registry.enrollStudent("Leslie", "Knope", "COMP", 272);
        registry.enrollStudent("Lisa", "Simpson", "COMP", 271);
        registry.enrollStudent("Donald", "Draper", "COMP", 271);
    }

    public static void main(String[] args) {
        GroceryStoreContainer storesLists = createAndAddGroceryItems();
        Registry registry = createAndAddPeople();
        createCourses(registry);
        registerStudents(registry);

        Scanner scan = new Scanner(System.in);
        // asks user's full name and sex and then give the options to choose from
        System.out.println("Welcome to the registry App!");
        System.out.print("Enter your first & last name & sex: ");
        String firstName = scan.next();
        String lastName = scan.next();
        String sex = scan.next();

        Person person = registry.getPerson(firstName, lastName, sex);
        System.out.println("Welcome " + person);
        System.out.print("Would you like to (1) look at ancestry, (2) add/drop a course, or (3) shop? ");
        String response = scan.next().toLowerCase();

        // look at ancestry if user selected option 1
        // add / drop courses if user selected option 2
        // shop for groceries from a store if user selected option 3
        if (response.equals("1")) {
                System.out.println("Maternal Line: " + registry.getMaternalLine(person));
                System.out.println("Paternal Line: " + registry.getPaternalLine(person));
                System.out.println("Children: " + registry.getAllChildren(person));

        } else if (response.equals("2")) {
            if (person instanceof Student) {
                Student student = (Student) person;
                System.out.println("Here are your current registered courses: " + student.getMyCourseList());
                System.out.println("Here are your current waitlisted courses: " + student.getMyWaitList());

                System.out.println("Available classes: " + registry.getCourses());

                while (true) {
                    System.out.print("Enter the name and number of the course you'd like to register for: ");
                    String dept = scan.next();
                    if (dept.equals("stop")){
                        break;
                    }
                    String num = scan.next();
                    Course course = registry.getCourse(dept, Integer.parseInt(num));
                    if (course == null) {
                        System.out.println("Not a valid course! Please try again!");
                        continue;
                    }
                    registry.enrollStudent(person.getFirstName(), person.getFamilyName(), dept, Integer.parseInt(num));
                }

                for (Course c: student.getMyCourseList()) {
                    System.out.println("Registered for " + c + ": " + c.getRegistered());
                    System.out.println("Waitlisted for " + c + ": " + c.getWaitListed());
                }

                while (true) {
                    System.out.print("Enter the name and number of the course you'd like to drop: ");
                    String dept = scan.next();
                    if (dept.equals("stop")){
                        break;
                    }
                    String num = scan.next();
                    Course course = registry.getCourse(dept, Integer.parseInt(num));
                    if (course == null) {
                        System.out.println("Not a valid course! Please try again!");
                        continue;
                    }
                    registry.removeStudent(person.getFirstName(), person.getFamilyName(), dept, Integer.parseInt(num));
                }

                System.out.println("Here are your registered courses: " + student.getMyCourseList());
                System.out.println("Here are your waitlisted courses: " + student.getMyWaitList());

                System.out.println();
                System.out.println("####### Total Course Registration Report #######");
                for (Course c: registry.getCourses()) {
                    System.out.println("Registered for " + c + ": " + c.getRegistered());
                    System.out.println("Waitlisted for " + c + ": " + c.getWaitListed());
                }

            } else {
                System.out.println("You're not a student! You can't add/drop classes!");
            }

        } else {

            System.out.print("You have no grocery lists saved. Type your Grocery Store: ");
            String store = scan.next().toLowerCase();

            while (!registry.selectGroceryStore(store, storesLists)) {
                store = scan.next().toLowerCase();
            }

            System.out.print("I can shop at " + store + ". Do you want to shop right now? ");
            String answer = scan.next();

            while (!answer.equals("ok")) {
                answer = scan.next().toLowerCase();
            }
            GroceryStore selectStore = storesLists.getGroceryStore(store);
            System.out.println(selectStore);

            GroceryList groceryList = new GroceryList();

            System.out.print("Enter your items one at a time and I'll give you a price if it's available: ");
            String item = scan.next();

            while (!item.equals("stop")) {
                System.out.print(item + ", Quantity? ");
                int quantity = scan.nextInt();
                scan.nextLine();
                registry.addGroceryItems(item, quantity, selectStore, groceryList);
                System.out.print("Next Item? ");
                item = scan.next();
            }

            System.out.println("\n" + groceryList);
            double discountedPrice = registry.checkPersonDiscount(person, groceryList);
            System.out.println("Total after discount applied: " + discountedPrice);
        }
    }
}