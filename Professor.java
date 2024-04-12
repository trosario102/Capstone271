public class Professor extends Person {
    private String department;
    private String subject;

    public Professor(String firstName, String familyName, String sex, String department, String subject) {
        super(firstName, familyName, sex);
        this.department = department;
        this.subject = subject;
    }
}
