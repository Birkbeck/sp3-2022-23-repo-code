package first;

import student.Student;

import java.util.Arrays;
import java.util.List;

import static student.Student.printStudent;

public class Main {
    static List<Student> students = Arrays.asList(
        new Student("Steven", "King", 900),
        new Student("Neena", "Kochhar", 110),
        new Student("Jennifer", "Shalen", 10),
        new Student("Shelley", "Higgins", 800));

    public static String findStudentByID(int id) {
        for (var s : students) {
            if (s.getStuID() == id) {
                return printStudent(s);
            }
        }
        return "Not Found!";
    }

    public static void main(String[] args) {
        System.out.println(findStudentByID(110));
        System.out.println(findStudentByID(666));
    }
}
