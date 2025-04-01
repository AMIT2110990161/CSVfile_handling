import java.io.*;
import com.opencsv.*;
import com.opencsv.exceptions.CsvException;
import java.util.*;

public class MergeCSV {
    public static void main(String[] args) {
        String file1 = "students1.csv";
        String file2 = "students2.csv";
        String outputFile = "merged_students.csv";
        Map<String, String[]> studentData = new HashMap<>();

        try (CSVReader reader1 = new CSVReader(new FileReader(file1));
             CSVReader reader2 = new CSVReader(new FileReader(file2));
             CSVWriter writer = new CSVWriter(new FileWriter(outputFile))) {

            List<String[]> records1 = reader1.readAll();
            List<String[]> records2 = reader2.readAll();

            for (String[] row : records1.subList(1, records1.size())) {
                studentData.put(row[0], row);
            }
            for (String[] row : records2.subList(1, records2.size())) {
                studentData.put(row[0], new String[]{row[0], studentData.get(row[0])[1], studentData.get(row[0])[2], row[1], row[2]});
            }
            writer.writeNext(new String[]{"ID", "Name", "Age", "Marks", "Grade"});
            for (String[] row : studentData.values()) {
                writer.writeNext(row);
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}