/**
 * Класс для хранения данных о продуктах
 *
 * @author Evgeniy Shvecov
 */
public class Product {
    private int id;
    private String name;

    /**
     *  Конструктор
     * @param i Айди продукта
     * @param s название продукта
     */
    Product(int i, String s){
        this.id=i;
        this.name=s;
    }

    /**
     * Геттер названия
     * @return название продукта
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
