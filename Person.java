import java.util.*;

public class Person implements Shopper, Child, Comparable<Person>{
    private String firstName;
    private String familyName;
    private double budget;
    private String sex;
    private Relationship relationship;
    private Set<Relationship> pastRelationships;
    private Person mother;
    private Person father;
    private Set<Person> children;
    private int age;

    public Person(String firstName, String familyName, String sex) {
        this.firstName = firstName;
        this.familyName = familyName;
        this.age = 0;
        this.budget = 0;
        this.relationship = new Relationship();
        this.pastRelationships = new HashSet<>();
        this.children = new HashSet<>();
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

    public Set<Relationship> getPastRelationships(){
        return pastRelationships;
    }

    public Relationship getRelationship(){
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


    public String toString() {
        if (age != 0) {
            return firstName + " " + familyName + " (" + age + ")";
        }
        return firstName + " " + familyName;
    }

    public int compareTo(Person p) {
        String name1 = this.firstName + " " + this.familyName;
        String name2 = this.firstName + " " + this.familyName;

        if (name1.equals(name2)) {
            return this.age - p.age;
        } else {
            return name1.compareTo(name2);
        }
    }

    public boolean equals(Object o){
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