package seven;

import student.Student;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static student.Student.printStudent;

public class Main {
    static List<Student> students = Arrays.asList(
        new Student("Steven", "King", 900),
        new Student("Neena", "Kochhar", 110),
        new Student("Jennifer", "Shalen", 10),
        new Student("Shelley", "Higgins", 800));

    public static void findStudentByID(List<Student> students,
                                       Predicate<Student> checker,
                                       Consumer<Student> stuPrint) {
        students.stream()
            //.parallel()
            .filter(checker::test)
            .forEach(stuPrint::accept);
    }

    public static void main(String[] args) {
        long id = 110;
        findStudentByID(students,
            (stu) -> stu.getStuID() > id,
            (stu) ->
                System.out.println(printStudent(stu))
        );
    }
}
