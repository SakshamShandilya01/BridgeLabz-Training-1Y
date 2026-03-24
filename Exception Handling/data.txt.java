import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileExample {
    public static void main(String[] args) {
        try {
            
            BufferedReader br = new BufferedReader(new FileReader("data.txt"));
            String line;

            System.out.println("Reading file content:\n");

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();
        } 
        catch (IOException e) {
          
            System.out.println("Error: File 'data.txt' not found or cannot be read.");
        }
    }
}