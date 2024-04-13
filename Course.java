import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Course implements java.lang.Comparable<Course> {

    private int courseNum;
    private int creditHours;
    private String dept;
    private int maxCapacity;
    private Set<Student> registered;
    private String title;
    private LinkedList<Student> waitListed;

    public Course(String d, int num, String t, int cap, int hours) {
        dept = d;
        courseNum = num;
        creditHours = hours;
        maxCapacity = cap;
        registered = new HashSet<>();
        title = t;
        waitListed = new LinkedList<>();
    }

    public boolean addStudent(Person p) {
        if (isStudent(p)) {
            Student s = (Student) p;
            if (registered.contains(s)) {
                return false;
            } else {
                if (!registered.contains(s) && this.registered.size() < maxCapacity) {
                    s.addCourse(this);
                    registered.add(s);
                    s.dropFromWaitList(this);
                } else if (!registered.contains(s) && this.registered.size() >= maxCapacity) {
                    addToWaitList(s);
                }
                return true;
            }
        } else {
            return false;
        }
    }

    public boolean addToWaitList(Person p) {
        if (isStudent(p)) {
            Student s = (Student) p;
            if (registered.size() >= maxCapacity) {
                this.waitListed.add(s);
                s.addToWaitList(this);
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean dropStudent(Person p) {
        if (isStudent(p)) {
            Student s = (Student) p;
            if (registered.contains(s)) {
                registered.remove(s);
                s.dropCourse(this);

                if (!waitListed.isEmpty()) {
                    addStudent(waitListed.get(0));
                    waitListed.get(0).dropFromWaitList(this);
                    waitListed.remove(0);
                }
                return true;
            }
        }
        return false;
    }

    public int getCourseNum() {
        return courseNum;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public String getDept() {
        return dept;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public Set<Student> getRegistered() {
        return registered;
    }

    public String getTitle() {
        return title;
    }

    public LinkedList<Student> getWaitListed() {
        return waitListed;
    }

    private boolean isStudent(Person p) {
        if (p instanceof Student) {
            return true;
        }
        return false;
    }

    public String toString() {
        return dept + " " + courseNum;
    }

    public int compareTo(Course c) {
        int i = 0;
        while (i < dept.length()) {
            int val = this.dept.charAt(i) - c.dept.charAt(i);
            if (val == 0) {
                i++;
                continue;
            } else {
                return val;
            }
        }
        return courseNum - c.courseNum;
    }
}
