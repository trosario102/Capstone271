import java.util.HashSet;
import java.util.Set;

public class Relationship {
    private Person partnerA;
    private Person partnerB;
    private Set<Child> children;

    public Relationship() {
        this(null, null);
    }

    public Relationship(Person a, Person b){
        this.partnerA = a;
        if (this.partnerA != null){
            this.partnerA.setRelationship(this);
        }
        this.partnerB = b;
        if (this.partnerB != null){
            this.partnerB.setRelationship(this);
        }
        this.children = new HashSet<>();
    }

    public Person getPartner(Person p) {
        if (p.equals(partnerA)){
            return partnerB;
        } else {
            return partnerA;
        }
    }

    public Set<Child> getChildren(){
        return children;
    }

    public void addPartners(Person p1, Person p2) {
        this.partnerA = p1;
        p1.setRelationship(this);
        this.partnerB = p2;
        p2.setRelationship(this);
    }

    public Child createChild(String firstName, String familyName, String sex) {
        if ((partnerA.getSex().equals("m") && partnerB.getSex().equals("f")) || (partnerA.getSex().equals("f") && partnerB.getSex().equals("m"))) {
            Child kid = new Child(partnerA, partnerB, firstName, familyName, sex);
            children.add(kid);
            return kid;
        } else {
            System.out.println("Same sex partners cannot create a child.");
            return null;
        }
    }

    public void endRelationship() {
        partnerA.endRelationship();
        partnerB.endRelationship();
    }

    public String toString(){
        return partnerA + " & " + partnerB;
    }
}
