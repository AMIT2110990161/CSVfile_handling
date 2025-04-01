import java.io.FileReader;
import java.io.IOException;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.util.List;

public class CountCSVRows {
    public static void main(String[] args) throws Exception{
        String filePath = "D:\\BridgeLabz Development\\CSVfile_handling\\employees.csv";
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = reader.readAll();
            System.out.println("Total records: " + (records.size() - 1)); // Excluding header
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}