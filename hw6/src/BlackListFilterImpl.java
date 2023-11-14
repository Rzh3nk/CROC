import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Фильтр комментариев, реализует интерфейс BlackListFilter
 *
 *  @author Evgeniy Shvecov
 */
public class BlackListFilterImpl implements BlackListFilter{
    private File outputFile ;

    /**
     * Сеттер для файла вывода
     * @param outputFile файл, в который хотим вывести данные
     */
    public void setOutputFile(File outputFile) {
        this.outputFile = outputFile;
    }

    /**
     * Метод, фильтрующий комментарии
     * @param comments list of comments; every comment
     *                 is a sequence of words, separated
     *                 by spaces, punctuation or line breaks
     * @param blackList list of words that should not
     *                  be present in a comment
     */
    public void filterComments(List<String> comments, Set<String> blackList)  {
        try {
            PrintWriter output = new PrintWriter(outputFile);


            for(String str : comments){
                boolean flag = true;
                HashSet<String> sts = new HashSet<String>(Arrays.asList(str. split("[\\p{P} \\t\\n\\r]"))); //записываем в HashSet только слова, без лишних знаков.

                Iterator<String> iter = sts.iterator();
                while (iter.hasNext()){ //смотрим в блэклист
                    if (blackList.contains(iter.next().toLowerCase()) ){
                        flag = false;
                        break;
                    }
                }
                if(flag){ //если у нас встретились запрещенные слова, то мы ничего не запишем
                    output.print(str+'\n');
                }
            }
            output.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Выходного файла нет");
        }


    }
}
