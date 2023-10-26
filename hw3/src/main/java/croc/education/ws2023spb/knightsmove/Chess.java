package croc.education.ws2023spb.knightsmove;

/**
 * Класс, который нужен для создания объекта, описывающего позицию фигуры, реалзует интерфейс ChessPosition
 *
 * @author Evgeniy Shvecov
 * @see ChessPosition
 */
public class Chess implements ChessPosition{
    /**
     * Переменные задающие позицию фигуры на доске
     */
    public int Hpos,Vpos;

    /**
     * Конструтор
     * @param h - позиция по горизонтали
     * @param v - позиция по горизонтали
     */
    public Chess(int h, int v){
        Hpos=h;
        Vpos=v;
    }

    /**
     * Конструктор
     * @param position - строка, в которой записано обычное представление позиции, например "а8"
     */
    public Chess(String position){
        Hpos=position.charAt(0)-'a';
        Vpos=position.charAt(1)-'1';
    }
    /**
     *
     * @return позицию по горизонтали
     */
    @Override
    public int x() {
        return Hpos;
    }
    /**
     *
     * @return позицию по вертикали
     */
    @Override
    public int y() {
        return Vpos;
    }

    /**
     *
     * @return строку с обычным представлением позиции
     */
    @Override
    public String toString() {
        String s= "";
        s+=(char)(Hpos+'a');
        s+=(char)(Vpos+'1');
        return  s;
    }



}
