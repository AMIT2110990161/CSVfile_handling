import java.io.*;
import com.opencsv.*;
import org.json.*;

public class JSONToCSV {
    public static void main(String[] args) {
        String jsonFile = "students.json";
        String csvFile = "students.csv";
        try {
            JSONArray jsonArray = new JSONArray(new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(jsonFile))));
            try (CSVWriter writer = new CSVWriter(new FileWriter(csvFile))) {
                writer.writeNext(new String[]{"ID", "Name", "Age", "Marks"});
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject obj = jsonArray.getJSONObject(i);
                    writer.writeNext(new String[]{obj.getString("ID"), obj.getString("Name"), obj.getString("Age"), obj.getString("Marks")});
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}