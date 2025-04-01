import java.io.*;
import com.opencsv.*;
import com.opencsv.exceptions.CsvException;
import java.util.List;
import java.util.Scanner;

public class SearchCSV {
    public static void main(String[] args) {
        String filePath = "employees.csv";
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee name to search: ");
        String searchName = scanner.nextLine();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = reader.readAll();
            for (String[] row : records.subList(1, records.size())) { // Skipping header
                if (row[1].equalsIgnoreCase(searchName)) {
                    System.out.println("Department: " + row[2] + ", Salary: " + row[3]);
                    return;
                }
            }
            System.out.println("Employee not found.");
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}