package croc.education.ws2023spb.knightsmove;
/**
 * Обработчик, проверяющий возможность хода конем
 *
 * @author Evgeniy Shvecov
 * @see KnightsMoveChecker
 */
public class MoveCheck implements KnightsMoveChecker{
    /**
     *
     * @param positions
     *            последовательность клеток на шахматной доске, которую надо обойти от предыдущей клетки к следующей
     * @throws IllegalMoveException если при перемещении шахматного коня из текущей клетки в следующую происходит с нарушением правил
     */
    public void check(String[] positions) throws IllegalMoveException {
        if (positions.length > 0) {
            ChessPosition pos = ChessPositionParser.parse(positions[0]); //задаеи начальную позицию
            for (int i = 1; i < positions.length; i++) {
                ChessPosition newpos = ChessPositionParser.parse(positions[i]);//задаем позицию, куда хотим сходить
                if ((Math.abs(newpos.x() - pos.x()) == 2 && Math.abs(newpos.y() - pos.y()) == 1) || (Math.abs(newpos.x() - pos.x()) == 1 && Math.abs(newpos.y() - pos.y()) == 2)) {
                    pos = newpos; //если ход возможен, меняем позицию
                } else {
                    String message;
                    message = pos.toString() + " -> " + newpos.toString();
                    throw new IllegalMoveException(message); //если ход невозможен, то выкидываем исключение
                }
            }
        }
    }
}
