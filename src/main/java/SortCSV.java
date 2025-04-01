import java.io.*;
import com.opencsv.*;
import com.opencsv.exceptions.CsvException;
import java.util.*;

public class SortCSV {
    public static void main(String[] args) {
        String filePath = "employees.csv";
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = reader.readAll();
            records.remove(0);
            records.sort((a, b) -> Integer.parseInt(b[3]) - Integer.parseInt(a[3]));
            System.out.println("Top 5 highest-paid employees:");
            for (int i = 0; i < Math.min(5, records.size()); i++) {
                System.out.println(String.join(", ", records.get(i)));
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}