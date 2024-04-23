import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

import static java.lang.Math.*;

public class Task11 {
    public static void main(String[] args) throws IOException {
        File file1 = new File("test11.txt");
        BufferedWriter fwr = new BufferedWriter(new FileWriter(file1));
        fwr.write("Формула z = sqrt(abs(cos(y)))+x*sin(y)+y,\n" +
                "x>=-1 && x<=5 x+=0.2, y>=-3 && y<=2 y+=0.1\n\n" +
                " X\t\t\t\t\t\t\t\t\tМатрица значений Z\n\n");
        DecimalFormat mm = new DecimalFormat("#.#");
        for (Double x=-1.0;x<=5.0;x+=0.2){
            fwr.write(mm.format(x)+"\t");
            for (double y=-3.0;y<=2.0;y+=0.1){
                Double z = sqrt(abs(cos(y)))+x*sin(y)+y;
                fwr.write(mm.format(z)+"\s");
            }
            fwr.write("\n");
        }
        fwr.write("\nY\t");
        for (Double y=-3.0;y<=2.0;y+=0.1){
            fwr.write(mm.format(y)+"\s");
        }
        fwr.flush();fwr.close();
    }
}
