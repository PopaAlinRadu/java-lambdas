package ro.nila.functionalInterfaces;

import ro.nila.data.Student;
import ro.nila.data.StudentDataBase;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
    /*
    Lambdas for:
        -   [Print a student]
        -   [Print name and activities]
     */
    public static Consumer<Student> printStudent = student -> System.out.println(student);
    public static Consumer<Student> printStudentName = student -> System.out.println("Name: " + student.getName());
    public static Consumer<Student> printStudentActivities = student -> System.out.println("Activities: " + student.getActivities());

    /*
    Print all students using the Consumer<Student> implementation
     */
    public static void printStudents(Consumer<Student> consumer) {
        List<Student> studentList = StudentDataBase.getAllStudents();
        System.out.println("-----------------Print Name------------------------");
        studentList.forEach(consumer);
    }

    /*
    Print name and activities of a student using the Consumer<Student> implementation
    Use consumer chain
     */
    public static void printNameAndActivities(Consumer<Student> printName, Consumer<Student> printActivities) {
        List<Student> studentList = StudentDataBase.getAllStudents();
        System.out.println("-------------------Print Name And Activities----------------------");
        studentList.forEach(printName.andThen(printActivities));
    }

    /*
    Print name and activities using condition of a student
    Use consumer chain
     */
    public static void printNameAndActivitiesUsingCondition(Consumer<Student> printName, Consumer<Student> printActivities) {
        List<Student> studentList = StudentDataBase.getAllStudents();
        System.out.println("----------------Print Name And Activities Using Condition-------------------------");
        studentList.forEach(student -> {
            if (student.getGradeLevel() >= 3) {
                printName.andThen(printActivities).accept(student);
            }
        });
    }

    public static void main(String[] args) {

        printStudents(printStudent);
        printNameAndActivities(printStudentName, printStudentActivities);
        printNameAndActivitiesUsingCondition(printStudentName, printStudentActivities);

    }
}
