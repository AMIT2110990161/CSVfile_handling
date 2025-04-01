import java.io.*;
import com.opencsv.*;

public class GenerateCSVReport {
    public static void main(String[] args) {
        String filePath = "db_report.csv";
        String[][] employees = {
                {"201", "Alice", "Engineering", "75000"},
                {"202", "Bob", "Sales", "50000"},
                {"203", "Charlie", "HR", "62000"}
        };
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            writer.writeNext(new String[]{"Employee ID", "Name", "Department", "Salary"});
            for (String[] emp : employees) {
                writer.writeNext(emp);
            }
            System.out.println("CSV report generated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}