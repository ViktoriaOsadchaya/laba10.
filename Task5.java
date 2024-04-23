import java.io.*;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task5 {
    public static void main(String[] args) throws IOException {
        File file1 = new File("test5.txt");
        File file2 = new File("test5_2.txt");

        BufferedReader strbuff= new BufferedReader(new FileReader(file1));
        FileWriter fwr2 = new FileWriter(file2,true);
        StringBuilder str= new StringBuilder();

        while (strbuff.ready()){
            str.append(Arrays.toString(strbuff.readLine().split("\r\n")));
        }

        String [] mas = str.toString().split("\\.");

        for (int i=0;i<mas.length;i++){
            String[] masStrok = mas[i].split("\\s+");
            for (int j = 0; j < masStrok.length; j++) {
                Pattern pat = Pattern.compile("[а-яА-Я]+");
                Matcher matc = pat.matcher(masStrok[j]);
                if (matc.find()) {
                    fwr2.write("\s"+prin(masStrok)+".");
                    break;
                }
            }
        }
        fwr2.flush();fwr2.close();
    }
    public static String prin(String [] mas){
        StringBuilder hj = new StringBuilder();
        for (int i = 0;i < mas.length;i++){
            hj.append(mas[i]);
        }
        return String.valueOf(hj);
    }
}
