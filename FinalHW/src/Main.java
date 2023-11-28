import java.time.LocalDate;
import java.util.HashMap;

/**
 * Стартовый класс.
 *
 * @author Evgeniy Shvecov
 */
public class Main {
    /**
     * Точка старта приложения
     *
     * @param args
     *          стартовые аргументы
     */
    public static void main(String[] args) {
        HashMap<Integer, Product> products = new HashMap<>();
        HashMap<Integer, Seller> sellers = new HashMap<>();
        HashMap<Integer, Available> available = new HashMap<>();
        HashMap<Integer, Sale> sale = new HashMap<>();
        try {
            ProductReader.read(products,"files/Products.xml");
            SellerReader.read(sellers,"files/Sellers.xml");
            AvailableReader.read(available,"files/Available.xml");
            SaleReader.read(sale,"files/Sales.xml");
            //Считываем все XML файлы
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        //1 задание
        HashMap<String, Integer> quantity = new HashMap<>();
        products.forEach((key, value) -> {
            quantity.put(value.getName(),0); //Считываем все названия продуктов
        });
        available.forEach((key, value) -> {
            if(quantity.containsKey(products.get(value.getIdProduct()).getName())){
                quantity.replace(products.get(value.getIdProduct()).getName(),
                        quantity.get(products.get(value.getIdProduct()).getName())+ value.getQuantity()); //считаем общее количество продукта в наличии
            }
        });
        try {
            WriteToXML.First(quantity); //Записываем результаты в файл
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        //2 задание
        HashMap<LocalDate,Double> avg = new HashMap<>();
        HashMap<LocalDate,Integer> perDay = new HashMap<>();
        //Считаем общее количество проданных товаров и количество сделок за день
        sale.forEach((key, value) -> {
            if(avg.containsKey(value.getDate())){
                avg.replace(value.getDate(),avg.get(value.getDate())+ value.getQuantity());
                perDay.replace(value.getDate(),perDay.get(value.getDate())+ 1);
            }
            else {
                avg.put(value.getDate(),(double) value.getQuantity()); //считаем среднее количество проданного товара за день
                perDay.put(value.getDate(),1);
            }
        });
        avg.forEach((key, value) -> {
            avg.replace(key,value/perDay.get(key));
        });
        try {
            WriteToXML.Second(avg);//Записываем результаты в файл
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}