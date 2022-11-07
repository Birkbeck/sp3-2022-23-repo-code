package seven;

public record Student(
    String firstName,
    String lastName,
    long stuID) {

    public static String printStudent(Student stu) {
        return "id = " + stu.stuID() + " is student " +
            stu.firstName() + " " + stu.lastName();
    }
}
