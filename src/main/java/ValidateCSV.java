import java.io.*;
import com.opencsv.*;
import com.opencsv.exceptions.CsvException;
import java.util.List;
import java.util.regex.*;

public class ValidateCSV {
    public static void main(String[] args) {
        String filePath = "D:\\BridgeLabz Development\\CSVfile_handling\\employees.csv";
        Pattern emailPattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
        Pattern phonePattern = Pattern.compile("^\\d{10}$");
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = reader.readAll();
            for (String[] row : records.subList(1, records.size())) {
                if (!emailPattern.matcher(row[4]).matches() || !phonePattern.matcher(row[5]).matches()) {
                    System.out.println("Invalid entry: " + String.join(", ", row));
                }
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}