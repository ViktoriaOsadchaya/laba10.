import java.io.*;
public class Task2 {
    public static void main(String[] args) throws IOException {
        File file = new File("test2.txt");
        FileWriter fwrite = new FileWriter(file, false);
        for (int i = 1; i < 10; i++){
            for (int j = 1; j < 10;j++){
                fwrite.write(i + " * " + j + " = " + i * j + "\t");
            }
            fwrite.write("\n");
        }
        fwrite.close();
    }
}
