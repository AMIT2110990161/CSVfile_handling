import java.io.*;
import com.opencsv.*;
import com.opencsv.exceptions.CsvException;
import java.util.List;

public class FilterCSV {
    public static void main(String[] args) {
        String filePath = "students.csv";
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = reader.readAll();
            System.out.println("Students with marks greater than 80:");
            for (String[] row : records.subList(1, records.size())) { // Skipping header
                if (Integer.parseInt(row[3]) > 80) {
                    System.out.println(String.join(", ", row));
                }
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}