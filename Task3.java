import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task3 {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("test3.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    if (containsTwoConsecutiveLetters(word.toLowerCase())) {
                        System.out.println(word);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file");
            e.printStackTrace();
        }
    }

    public static boolean containsTwoConsecutiveLetters(String word) {
        for (int i = 0; i < word.length() - 1; i++) {
            if (Math.abs(word.charAt(i) - word.charAt(i + 1)) == 1) {
                return true;
            }
        }
        return false;
    }
}
