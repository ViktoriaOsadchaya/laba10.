import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task4 {
    public static void main(String[] args) throws IOException {
        File file1 = new File("test4.txt");
        File file2 = new File("test4.2.txt");
        FileWriter fWr = new FileWriter(file2);
        FileReader fRead = new FileReader(file1);
        BufferedReader buffR =new BufferedReader(fRead);

        Pattern pat = Pattern.compile("\\d+\\w+");
        Matcher matc;
        String line;
        String [] mas_line;
        while (buffR.ready()){

            line= buffR.readLine();
            mas_line=line.split("[\\s_\\.,:;\\?!\\t]+");
            for(int i = 0;i<mas_line.length;i++){
                matc = pat.matcher(mas_line[i]);
                if (matc.find()){
                    fWr.write(mas_line[i] + "\n");
                }
            }
        }
        fWr.flush();
        fWr.close();
    }
}
