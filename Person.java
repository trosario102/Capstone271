import java.util.Set;
import java.util.HashSet;

public class Person implements Shopper, Child, Comparable<Person> {
    private int age;
    private double budget;
    private Set<Person> children;
    private String familyName;
    private String firstName;
    private Person father;
    private Person mother;
    private Set<Relationship> pastRelationships;
    private Relationship relationship;
    private String sex;

    public Person(String firstName, String familyName, String sex) {
        this.age = 0;
        this.budget = 0;
        this.children = new HashSet<>();
        this.familyName = familyName;
        this.firstName = firstName;
        this.pastRelationships = new HashSet<>();
        this.relationship = new Relationship();
        this.sex = sex;
    }

    public void addChild(Person p) {
        children.add(p);
    }

    @Override
    public double adjustGroceryBudget(double amount) {
        return budget += amount;
    }

    @Override
    public double calculateDiscount(GroceryList list) {
        return list.getTotalCost();
    }

    public void endRelationship() {
        pastRelationships.add(relationship);
        setRelationship(null);
    }

    public int getAge() {
        return this.age;
    }
    public double getBudget() {
        return budget; // in US Dollars
    }

    public Set<Person> getChildren() {
        return children;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public Person getFather() {
        return this.father;
    }

    public Person getMother() {
        return this.mother;
    }

    public Person getPartner() {
        if (relationship != null){
            return relationship.getPartner(this);
        }
        return null;
    }

    public Set<Relationship> getPastRelationships() {
        return pastRelationships;
    }

    public Relationship getRelationship() {
        return relationship;
    }

    public String getSex(){
        return sex;
    }

    public void setAge(int n) {
        this.age = n;
    }
    public void setFather(Person p) {
        this.father = p;
    }

    @Override
    public void setGroceryBudget(double amount) {
        budget = amount;
    }

    public void setMother(Person p) {
        this.mother = p;
    }

    public void setRelationship(Relationship r) {
        this.relationship = r;
    }

    /*
     * Precondition: check that age is greater than 0
     * Post-condition: if precondition is met, return first & last name and age in String format
     * else return first and last name
     */
    public String toString() {
        if (age != 0) {
            return firstName + " " + familyName + " (" + age + ")";
        }
        return firstName + " " + familyName;
    }

    /*
     * compareTo imports the Comparable interface
     * first compares the names and then if names are equal, compare ages and return the age difference
     * else return String comparison and return the result
     */
    public int compareTo(Person p) {
        String name1 = this.firstName + " " + this.familyName;
        String name2 = this.firstName + " " + this.familyName;

        if (name1.equals(name2)) {
            return this.age - p.age;
        } else {
            return name1.compareTo(name2);
        }
    }

    /*
     * Precondition: check object o is instanceOf Person
     * check if this first name is equal to parameter other object first name
     * and if this family name is equal to parameter other object family name
     *
     * Overrides the default java equals method
     * check if two Person objects are equal based on their first name, family name, and sex
     */
    public boolean equals(Object o) {
        if (o instanceof Person){
            Person p = (Person) o;
            if (this.firstName.equals(p.firstName) && this.familyName.equals(p.familyName) && this.sex.equals(p.sex)){
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}