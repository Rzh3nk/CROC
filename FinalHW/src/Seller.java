/**
 * Класс для хранения данных о продавцах
 *
 * @author Evgeniy Shvecov
 */
public class Seller {
    private int id;
    private String name;
    private String lastName;

    /**
     * Конструктор
     * @param i Айди продавца
     * @param s Имя продавца
     * @param last Фамиилия продавца
     */
    Seller(int i, String s, String last){
        this.id=i;
        this.name=s;
        this.lastName=last;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
