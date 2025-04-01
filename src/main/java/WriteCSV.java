import java.io.FileWriter;
import java.io.IOException;
import com.opencsv.CSVWriter;

public class WriteCSV {
    public static void main(String[] args) {
        String filePath = "D:\\BridgeLabz Development\\CSVfile_handling\\employees.csv";
        String[] header = {"ID", "Name", "Department", "Salary"};
        String[][] employees = {
                {"101", "John", "IT", "60000"},
                {"102", "Sarah", "HR", "55000"},
                {"103", "David", "Finance", "58000"},
                {"104", "Emily", "IT", "62000"},
                {"105", "Michael", "Marketing", "50000"}
        };

        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            writer.writeNext(header);
            for (String[] emp : employees) {
                writer.writeNext(emp);
            }
            System.out.println("CSV file written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}