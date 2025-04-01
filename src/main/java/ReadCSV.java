import java.io.*;
import com.opencsv.*;

public class ReadCSV {
    public static void main(String[] args) throws Exception {
        String filePath = "D:\\BridgeLabz Development\\CSVfile_handling\\students.csv";
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] values;
            while ((values = reader.readNext()) != null) {
                System.out.println("ID: " + values[0] + ", Name: " + values[1] + ", Age: " + values[2] + ", Marks: " + values[3]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}