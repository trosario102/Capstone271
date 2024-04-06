public class Child extends Person {
    private Person mother;
    private Person father;

    public Child(Person p1, Person p2, String firstName, String familyName, String sex) {
        super(firstName, familyName, sex);
        if (p1.getSex().equals("m")){
            this.father = p1;
            this.mother = p2;
        } else {
            this.father = p2;
            this.mother = p1;
        }
    }

    public Person getMother(){
        return mother;
    }

    public Person getFather(){
        return father;
    }
}
