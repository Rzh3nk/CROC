package croc.education.ws2023spb.knightsmove;

/**
 * Исключение, выбрасываемое в случае, если при перемещении шахматного коня из текущей клетки в следующую происходит с
 * нарушением правил.
 * 
 * @author Dmitry Malenok
 */
public class IllegalPositionException extends RuntimeException {
    /**
     * Стандартный конструктор.
     */
    public IllegalPositionException() {
        super();
    }
    /**
     * @param miss позиция, в которой произошла ошибка
     */
    public IllegalPositionException(String miss) {
        super("Задана неверная позиция: "+miss);
    }
    /**
     * @param miss сообщение
     * @param cause причина
     */
    public IllegalPositionException(String miss,Throwable cause) {
        super(miss,cause);
    }
}
