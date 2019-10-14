package ro.nila.functionalInterfaces;

import ro.nila.data.Student;
import ro.nila.data.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;


public class BiConsumerExample {

    /*
    BiConsumer implementation to print name and activities
     */
    public static BiConsumer<String, List<String>> nameAndActivities = ((name, activities) -> {
        System.out.println(name);
        System.out.println(activities);
    });

    /*
    Print name and activities using BiConsumer
     */
    public static void nameAndActivities() {
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach(student -> nameAndActivities.accept(student.getName(), student.getActivities()));
    }

    public static void main(String[] args) {
        nameAndActivities();
    }
}
