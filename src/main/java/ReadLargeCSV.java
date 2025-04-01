import java.io.*;
import com.opencsv.*;

public class ReadLargeCSV {
    public static void main(String[] args) {
        String filePath = "large_data.csv";
        int chunkSize = 100;
        int count = 0;
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] row;
            while ((row = reader.readNext()) != null) {
                count++;
                if (count % chunkSize == 0) {
                    System.out.println("Processed " + count + " records so far...");
                }
            }
            System.out.println("Total records processed: " + count);
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}