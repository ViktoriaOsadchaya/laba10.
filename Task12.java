import java.io.*;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task12 {
    public static void main(String[] args) {
        String inputFile = "test12_1.txt";
        String outputFile = "test12_2.txt";
        String vhodText = formatirovanieTexta(inputFile); // форматирование первого файла
        // Запись отредактированного текста в выходной файл
        writeText(outputFile, vhodText); //записываем текст во второй файл
    }
    private static String formatirovanieTexta(String filename) {
        StringBuilder forma = new StringBuilder();
        try (BufferedReader b= new BufferedReader(new FileReader(filename))) {
            String stroka;
            while ((stroka = b.readLine()) != null) {
                forma.append(formatirovanieStroki(stroka)).append(System.lineSeparator());
            }
        } catch (IOException a) {
            a.printStackTrace();
        }
        return forma.toString();
    }
    private static String formatirovanieStroki(String text) {
        // Алгоритм форматирования, как в вашей исходной программе
        String m = text;
        String[] mas = {"эй", "депутатик", "мужчинка", "сынок", "эй ", "депутатик ", "мужчинка ", "сынок ",
                "ну ", "будем говорить ", "значит так ", "короче ", "типа ", "будем говорить", "значит так",
                "короче", "типа", "\\s+\\s+"};
        for (int i = 0; i < mas.length; i++) {
            Pattern q1 = Pattern.compile(numb(mas, i));
            Matcher textDeda1 = q1.matcher(m);
            while (textDeda1.find()) {
                if (i <= 7) {
                    m = textDeda1.replaceAll("Алексей Генадьевич");
                } else if (i > 7 || i <= 16) {
                    m = textDeda1.replaceAll("");
                } else if (i == 17) {
                    m = textDeda1.replaceAll(" ");
                }
            }
        }
        String[] pp = m.split(" ");
        for (int j = 0; j < pp.length - 2; j++) {
            if (Objects.equals(pp[j], pp[j + 1])) {
                pp[j + 1] = "";
            } else if (Objects.equals(pp[j], pp[j + 2])) {
                pp[j + 2] = "";
            }
        }
        m = String.join(" ", pp);
        Pattern q1 = Pattern.compile(numb(mas, 17));
        Matcher textDeda1 = q1.matcher(m);
        m = textDeda1.replaceAll(" ");
        return m;
    }
    private static void writeText(String filename, String text) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(text);
        } catch (IOException a) {
            a.printStackTrace();
        }
    }
    public static String numb(String[] m, int n) {
        return m[n];
    }     // получаем элемент массива по индексу
}
