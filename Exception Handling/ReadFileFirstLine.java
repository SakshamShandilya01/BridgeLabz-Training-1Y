import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileFirstLine {
    public static void main(String[] args) {

       
        try (BufferedReader br = new BufferedReader(new FileReader("info.txt"))) {

            String line = br.readLine();  // read first line

            if (line != null) {
                System.out.println("First line: " + line);
            } else {
                System.out.println("File is empty!");
            }

        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}