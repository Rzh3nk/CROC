package croc.education.ws2023spb.knightsmove;

/**
 * Исключение, выбрасываемое в случае, если при перемещении шахматного коня из текущей клетки в следующую происходит с
 * нарушением правил.
 * 
 * @author Dmitry Malenok
 */
public class IllegalMoveException extends RuntimeException {
    /**
     * Стандартный конструктор.
     */
    public IllegalMoveException() {
        super();
    }
    /**
     * @param miss ход, в котором произошла ошибка
     */
    public IllegalMoveException(String miss) {
        super("конь так не ходит: "+miss);
    }
    /**
     * @param miss сообщение
     * @param cause причина
     */
    public IllegalMoveException(String miss,Throwable cause) {
        super(miss,cause);
    }
}
