package origstudent;

import java.util.Objects;

public class Student {
    private final String firstName;
    private final String lastName;
    private final long stuID;

    public Student(String firstName, String lastName, long stuID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.stuID = stuID;
    }

    public static String printStudent(Student stu) {
        return "id = " + stu.getStuID() + " is student " +
            stu.getFirstName() + " " + stu.getLastName();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public long getStuID() {
        return stuID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return getStuID() == student.getStuID();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStuID());
    }

    @Override
    public String toString() {
        return "first.Student{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", stuID=" + stuID +
            '}';
    }
}
