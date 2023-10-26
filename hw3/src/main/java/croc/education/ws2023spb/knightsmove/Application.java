package croc.education.ws2023spb.knightsmove;

/**
 * Приложение, проверяющее возможность прохождения последовательности клеток на шахматной доске ходом коня.
 */
public final class Application {

    /**
     * Основной метод приложения.
     *
     * @param args
     *            аргументы
     */
    public static void main(final String[] args) {
        KnightsMoveChecker checker = KnightsMoveCheckerFactory.get();
        try {
            checker.check(args);
            System.out.print("OK");//если проблем не возникло, то получим ОК
        }
        catch (IllegalMoveException e){
            System.out.print(e.getMessage()); //был совершен неверный ход
        }
        catch (IllegalPositionException e){
            System.out.print(e.getMessage()); //Попытались поставить коня на несуществующую позицию
        }

    }
}
