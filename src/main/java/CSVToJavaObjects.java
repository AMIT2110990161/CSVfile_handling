import java.io.*;
import com.opencsv.*;
import com.opencsv.exceptions.CsvException;
import java.util.*;

class Student {
    String id, name;
    int age, marks;
    Student(String id, String name, int age, int marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Marks: " + marks;
    }
}

public class CSVToJavaObjects {
    public static void main(String[] args) {
        String filePath = "students.csv";
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = reader.readAll();
            List<Student> students = new ArrayList<>();
            for (String[] row : records.subList(1, records.size())) {
                students.add(new Student(row[0], row[1], Integer.parseInt(row[2]), Integer.parseInt(row[3])));
            }
            students.forEach(System.out::println);
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}