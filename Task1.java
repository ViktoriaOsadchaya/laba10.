import java.io.*;
import java.util.Objects;

public class Task1 {
    public static void main(String[] args) throws IOException {
        File file1 = new File("test1.txt");
        FileWriter fWr = new FileWriter(file1,true);
        BufferedReader fread = new BufferedReader(new FileReader(file1));
        String s = fread.readLine();
        String [] masS = s.split("");

        String chisB = fread.readLine();

        String chisV= fread.readLine();

        int cntCifr = 0, cntV = 0;
        for (int i = 0; i < masS.length; i++) {
            if (equa(masS[i])) {
                cntCifr++;
            }
        }
        fWr.write("\r\nВывод\r\n\n");
        fWr.write("Кол-во цифр = " + cntCifr + "\r\n"+" Кол-во чисел 'Б' = "
                + count(String.join("", masS), chisB)+"\r\n");
        for (int i = 0; i < chisV.length(); i++) {
            if (cifriVchis(String.join("", masS), chisV)) {
                cntV++;
            }
        }
        if (cntV == chisV.length()) {
            fWr.write("Все цифры присутствуют в последовательности В"+"\r\n");
        } else fWr.write("Не все числа присутствуют в последовательности В"+"\r\n");

        int cnt = 0;            //Задание Г
        for (int i = 0; i < masS.length - 1; i++) {
            if (Objects.equals(masS[i], "{") & Objects.equals(masS[i + 1], "}")) {
                fWr.write("{,} присутствует в последовательности"+"\r\n");
            }
            if (Objects.equals(masS[i], "(") & Objects.equals(masS[i + 1], ")")) {
                fWr.write("(,) присутствует в последовательности"+"\r\n");
            }
            if (Objects.equals(masS[i], "[") & Objects.equals(masS[i + 1], "]")) {
                fWr.write("[,] присутствует в последовательности"+"\r\n");
            }
            if ((Objects.equals(masS[i], "[") & Objects.equals(masS[i + 1], "}")) ||
                    Objects.equals(masS[i], "(") & Objects.equals(masS[i + 1], "}") ||
                    Objects.equals(masS[i], "[") & Objects.equals(masS[i + 1], ")") ||
                    Objects.equals(masS[i], "{") & Objects.equals(masS[i + 1], ")") ||
                    Objects.equals(masS[i], "(") & Objects.equals(masS[i + 1], "]") ||
                    Objects.equals(masS[i], "{") & Objects.equals(masS[i + 1], "]")) {
                cnt++;
            }
        }
        if (cnt > 0) {
            fWr.write("Есть закрытые скобки других сочетаний 'Г' и их " + cnt+"\r\n");
        } else {
            fWr.write("Закрытых скобок других сочетаний нет 'Г' "+"\r\n");
        }
        //Задание Д
        int cnt1 = 0;
        for (int i = 0; i < masS.length - 1; i++) {
            if (equal(masS, i) & (Objects.equals(masS[i], masS[i + 1]))) {
                cnt1++;
            }
        }
        if (cnt1 > 0) {
            fWr.write("Присутствуют соседствующие знаки препинания 'Д', их " + cnt1+"\r\n");
        } else {
            fWr.write("Нет соседствующих знаков препинания 'Д' "+"\r\n");
        }
        int cnt2 = 0;     //E
        for (int i = 0; i < masS.length - 2; i++) {
            for (int j = i + 1; j < masS.length - 1; j++) {
                if (equa(masS[i]) & equa(masS[i + 1]) & equa(masS[j]) & equa(masS[j + 1])) {
                    if (Integer.parseInt(masS[i]) + 1 == Integer.parseInt(masS[i + 1]) & Integer.parseInt(masS[j]) - 1 == Integer.parseInt(masS[j + 1])) {
                        cnt2++;
                    }
                }
            }
        }
        if (cnt > 0) {
            fWr.write("Такие последовательности есть 'Е' " + cnt2);
        } else {
            fWr.write("Такие последовательностей нет 'Е' ");
        }
        fWr.flush();
        fWr.close();
    }
    private static boolean equa(String m) {
        if (m == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(m);
        }
        catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    private static boolean equal(String[] x, int n) {
        if (!Objects.equals(x[n], ".")||!Objects.equals(x[n], ",")||!Objects.equals(x[n], "!")||!Objects.equals(x[n], "?")) {
            return true;
        }
        return false;
    }
    public static int count(String str, String target) {
        return (str.length() - str.replace(target, "").length()) / target.length();
    }
    public static boolean cifriVchis(String x, String n){
        for(int i=0;i<n.length();i++) {
            for (int j = 0; j < x.length(); j++) {
                if (x.charAt(j) == n.charAt(i)) {
                    return true;
                }
            }
        }
        return false;
    }
}
