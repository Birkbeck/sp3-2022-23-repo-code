package five;

import student.Student;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static student.Student.printStudent;

public class Main {
    static List<Student> students = Arrays.asList(
        new Student("Steven", "King", 900),
        new Student("Neena", "Kochhar", 110),
        new Student("Jennifer", "Shalen", 10),
        new Student("Shelley", "Higgins", 800));

    public static String findStudentByID(List<Student> students,
                                         Predicate<Student> checker) {
        for (var s : students) {
            if (checker.test(s)) {
                return printStudent(s);
            }
        }
        return "Not Found!";
    }

    public static void main(String[] args) {
        //long value = 110;
        System.out.println(findStudentByID(students, (stu) -> stu.getStuID() == 110));
        //value = 666;
        //long value1 = 666;
        System.out.println(findStudentByID(students, (stu) -> stu.getStuID() > 666));
    }
}
