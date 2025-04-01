import java.io.*;
import com.opencsv.*;
import java.util.*;
import java.util.Base64;

public class EncryptDecryptCSV {
    public static void main(String[] args) {
        String filePath = "employees.csv";
        String encryptedFile = "encrypted_employees.csv";
        String decryptedFile = "decrypted_employees.csv";
        try (CSVReader reader = new CSVReader(new FileReader(filePath));
             CSVWriter encryptWriter = new CSVWriter(new FileWriter(encryptedFile));
             CSVWriter decryptWriter = new CSVWriter(new FileWriter(decryptedFile))) {

            List<String[]> records = reader.readAll();
            encryptWriter.writeNext(records.get(0)); // Header
            decryptWriter.writeNext(records.get(0));
            for (String[] row : records.subList(1, records.size())) {
                row[3] = Base64.getEncoder().encodeToString(row[3].getBytes());
                encryptWriter.writeNext(row);
            }
            for (String[] row : records.subList(1, records.size())) {
                row[3] = new String(Base64.getDecoder().decode(row[3]));
                decryptWriter.writeNext(row);
            }
            System.out.println("Encryption and decryption completed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
