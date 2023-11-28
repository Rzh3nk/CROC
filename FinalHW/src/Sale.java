import java.time.LocalDate;

/**
 * Класс для хранения данных о продажах
 *
 * @author Evgeniy Shvecov
 */
public class Sale {
    private int idSale;
    private int idSeller;
    private int idProduct;
    private int quantity;
    private LocalDate date;

    /**
     * Конструктор
     * @param idSale Айди продажи
     * @param idSeller Айди продавца
     * @param idProduct Айди продукта
     * @param quantity количсетво проданного продукта
     * @param date дата продажи
     */
    public Sale(int idSale, int idSeller, int idProduct, int quantity, LocalDate date) {
        this.idSale = idSale;
        this.idSeller = idSeller;
        this.idProduct = idProduct;
        this.quantity = quantity;
        this.date = date;
    }

    /**
     * Геттер количсетва проданного продукта
     * @return количсетво проданного продукта
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Геттер даты продажи
     * @return дата продажи
     */
    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "idSale=" + idSale +
                ", idSeller=" + idSeller +
                ", idProduct=" + idProduct +
                ", quantity=" + quantity +
                ", date=" + date +
                '}';
    }
}
