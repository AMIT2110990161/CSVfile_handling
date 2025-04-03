import java.io.*;
import com.opencsv.*;
import com.opencsv.exceptions.CsvException;
import java.util.*;

public class DetectDuplicatesCSV {
    public static void main(String[] args) {
        String filePath = "D:\\BridgeLabz Development\\CSVfile_handling\\employees.csv";
        Set<String> uniqueIDs = new HashSet<>();
        Set<String[]> duplicates = new HashSet<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = reader.readAll();
            for (String[] row : records.subList(1, records.size())) {
                if (!uniqueIDs.add(row[0])) {
                    duplicates.add(row);
                }
            }
            System.out.println("Duplicate records:");
            for (String[] row : duplicates) {
                System.out.println(String.join(", ", row));
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}