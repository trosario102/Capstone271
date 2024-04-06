public class StudentCourseWaitlistsTester {
    public static void main(String[] args) {


        Student s1 = new Student("Mohammed", "Khursiwala", "m", 512172);
        Student s2 = new Student("John", "Johnson", "m", 509221);
        Student s3 = new Student("Mary", "John", "f",543491);
        Student s4 = new Student("Mark", "Mellon", "m", 578923);
        Student s5 = new Student("Tom", "Mellon","m", 571122);
        Student s6 = new Student("Mohammed", "Ahmed","m",567458);
        Student s7 = new Student("Aishah", "Raquib", "f", 568799);
        Student s8 = new Student("Umayma", "Raquib", "f",531456);
        Student s9 = new Student("Harry", "Berry", "m",573764);

        Course c1 = new Course("Comp", 271, "Data Structures I", 3, 4);
        Course c2 = new Course("Math", 212, "Linear Algebra", 3, 2);
        Course c3 = new Course("Stat", 203, "Intro to Statistics", 3, 4);


        s1.addCourse(c1);
        s1.addCourse(c3);
        s1.addCourse(c2);

        s2.addCourse(c1);
        s3.addCourse(c1);
        s4.addCourse(c1);
        s5.addCourse(c1);
        s6.addCourse(c1);
        s7.addCourse(c1);
        s8.addCourse(c1); // will be on wait list of Comp 271 course
        s9.addCourse(c1); // will be on the wait list of Comp 271 course

        System.out.println(s1);

        s2.dropCourse(c1);

        CourseRegistry courseRegistry = new CourseRegistry(c1);
        System.out.println("Registered Students in " + c1.getTitle() +  "\n" + courseRegistry.findRegisteredStudents(c1));
        System.out.println("WaitListed Students in " + c1.getTitle() + "\n" + courseRegistry.findWaitListStudents(c1));
        System.out.println("Mohammed Khursiwala in Comp 271: " + courseRegistry.contains(s1, c1)); // true
        System.out.println("Does Mohammed Khursiwala & John Johnson are in the same course? " + courseRegistry.equals(s1, s2, c1)); // true
    }
}