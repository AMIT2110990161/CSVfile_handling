import java.io.*;
import com.opencsv.*;
import com.opencsv.exceptions.CsvException;
import java.util.*;

public class UpdateCSV {
    public static void main(String[] args) {
        String filePath = "employees.csv";
        String newFilePath = "updated_employees.csv";
        try (CSVReader reader = new CSVReader(new FileReader(filePath));
             CSVWriter writer = new CSVWriter(new FileWriter(newFilePath))) {
            List<String[]> records = reader.readAll();
            writer.writeNext(records.get(0)); // Writing header
            for (String[] row : records.subList(1, records.size())) {
                if (row[2].equals("IT")) {
                    row[3] = String.valueOf((int) (Integer.parseInt(row[3]) * 1.1));
                }
                writer.writeNext(row);
            }
            System.out.println("Updated CSV file saved as " + newFilePath);
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}

