import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * Программа считывающая текст из файла и выводящая количество вхождений каждого символа в порядке убвания
 *
 * @author Evgeniy Shvecov
 */
public class Main {
    /**
     *
     * @param inputFile - файл из которого мы читаем данные
     * @param outputFile - файл в который мы записываем ответ
     * @return - возвращает HashMap, где ключом является символ из текста, а значением - сколько раз этот симмвол встретился
     * @throws IOException - исключение если файла не существует
     */
    public static HashMap<Character, Integer> find(File inputFile, File outputFile) throws IOException {
        HashMap<Character, Integer> Symbols = new HashMap<>();
        Reader r = new InputStreamReader(new FileInputStream(inputFile), StandardCharsets.UTF_8);//считываем файл посимвольно
            int c;
            while ((c = r.read()) != -1) {
                char ch = (char) c;
                if(ch!='\r' && ch!='\n' && ch!=' ' ) { // не записываем пробелы и переносы строк
                    if (Symbols.containsKey(ch)) {
                        Symbols.put(ch, Symbols.get(ch) + 1);
                    } else {
                        Symbols.put(ch, 1);
                    }
                }
            }
        r.close(); // закрываем Reader
        PrintWriter output = new PrintWriter(outputFile);
        Symbols.entrySet().stream().sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .forEach(k -> output.print(k+ ", ")); //записываем отсортированный HashMap
        output.close();
        return Symbols;

    }
    /**
     * Основной метод программы.
     *
     * @param args аргументы - не используются
     */
    public static void main(String[] args) {
        HashMap<Character, Integer> Symbols;
        File inputFile = new File("files/input.txt");
        File outputFile = new File("files/output.txt");
        try {
            Symbols = find(inputFile, outputFile);
            Symbols.entrySet().stream()
                    .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                    .forEach(k -> System.out.print(k+ ", "));
        }
        catch (IOException e){
            System.out.println("Такого файла не существует");
        }
    }
}