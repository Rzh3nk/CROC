import java.io.File;
import java.io.IOException;
import java.util.*;
/**
 * Стартовый класс.
 *
 * @author Evgeniy Shvecov
 */
public class Main {
    /**
     *  Метод принимает файлы, читает из них данные и вызывает фильтр.
     * @param inputFile файл из которого берутся комментарии
     * @param blackList файл со списком запрещенных слов
     * @param outputFile файл, в который мы записываем проверенные комментарии
     * @throws IOException ошибка, если файлов не существует
     */

    public static void clear(File inputFile, File blackList, File outputFile) throws IOException{
        Scanner scanner = new Scanner(inputFile);
        Scanner black = new Scanner(blackList);
        BlackListFilterImpl filter = new BlackListFilterImpl();
        HashSet<String> blacklist = new HashSet<String>();
        List<String> comments = new ArrayList<String>();
        while(black.hasNextLine()){
            String str = black.nextLine();
            Collections.addAll(blacklist,str. split(" ")); // записываем все слова из файла в HashSet
        }
        while(scanner.hasNextLine()){
            String str = scanner.nextLine();
            comments.add(str);  // записываем все комментарии в List
        }
        filter.setOutputFile(outputFile); //задаем файл в который надо все вывести
        filter.filterComments(comments, blacklist); //ффильтруем комментарии
    }
    /**
     * Точка старта приложения
     *
     * @param args
     *          стартовые аргументы
     */
    public static void main(String[] args) {
        File inputFile = new File("files/input.txt");
        File outputFile = new File("files/output.txt");
        File blackList = new File("files/blacklist.txt");

        try {
             clear(inputFile,blackList, outputFile);
        }
        catch (IOException e){
            System.out.println("Такого файла не существует");
        }
    }
}