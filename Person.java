import java.util.*;

public class Person implements Shopper {
    private String firstName;
    private String familyName;
    private double budget;
    private String sex;
    private Relationship relationship;
    private Set<Relationship> pastRelationships;

    public Person(String firstName, String familyName, String sex) {
        this.firstName = firstName;
        this.familyName = familyName;
        this.budget = 0;
        this.relationship = new Relationship();
        this.pastRelationships = new HashSet<>();
        this.sex = sex;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getSex(){
        return sex;
    }

    public double getBudget() {
        return budget; // in US Dollars
    }

    public String toString() {
        return firstName + " " + familyName;
    }

    public Relationship getRelationship(){
        return relationship;
    }

    public Set<Relationship> getPastRelationships(){
        return pastRelationships;
    }

    public Person getPartner() {
        if (relationship != null){
            return relationship.getPartner(this);
        }
        return null;
    }

    public void setRelationship(Relationship r) {
        this.relationship = r;
    }

    public void endRelationship() {
        pastRelationships.add(relationship);
        setRelationship(null);
    }

    @Override
    public void setGroceryBudget(double amount) {
        budget = amount;
    }

    /*
     * increases the grocery budget by a given amount
     */
    @Override
    public double adjustGroceryBudget(double amount) {
       return budget += amount;
    }

    @Override
    public double calculateDiscount(GroceryList list) {
        return list.getTotalCost();
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