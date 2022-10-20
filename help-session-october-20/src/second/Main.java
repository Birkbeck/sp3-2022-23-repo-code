package second;

import student.Student;

import java.util.Arrays;
import java.util.List;

import static student.Student.printStudent;

interface StudentIDChecker {
    boolean checkID(Student stu, long value);
}

class StudentIDEqualCheckerImpl implements StudentIDChecker {
    @Override
    public boolean checkID(Student stu, long value) {
        return stu.getStuID() == value;
    }
}

class StudentIDGreaterThanCheckerImpl implements StudentIDChecker {
    @Override
    public boolean checkID(Student stu, long value) {
        return stu.getStuID() > value;
    }
}

public class Main {
    static List<Student> students = Arrays.asList(
        new Student("Steven", "King", 900),
        new Student("Neena", "Kochhar", 110),
        new Student("Jennifer", "Shalen", 10),
        new Student("Shelley", "Higgins", 800));

    public static String findStudentByID(List<Student> students,
                                         StudentIDChecker checker,
                                         long id){
        for (var s : students){
            if (checker.checkID(s,id)){
                return printStudent(s);
            }
        }
        return "Not Found!";
    }

    public static void main(String[] args) {
        System.out.println(findStudentByID(students,
            new StudentIDEqualCheckerImpl(),110));
        System.out.println(findStudentByID(students,
            new StudentIDGreaterThanCheckerImpl(),666));
    }
}
