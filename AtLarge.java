import java.util.List;

public class AtLarge extends Student {
    String registeredSemester;

    public AtLarge(String firstName, String familyName, String sex, int id, String semester) {
        super(firstName, familyName, sex, id);
        registeredSemester = semester;
    }

    public String getRegisteredSemester() {
        return registeredSemester;
    }

}
