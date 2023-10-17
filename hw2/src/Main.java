/**
 * Класс демонстрирубщий работу музыкальной системы с использованием классов SongStorage, SongPlayer, Song
 */
public class Main {
    /**
     * Главный метод программы
     * @param args Массив аргументов командной строки
     */
    public static void main(String[] args) {
        //Создаем носители
        SongStorage cd = new SongStorage("CD");
        SongStorage vinyl = new SongStorage("Vinyl");
        SongStorage flash = new SongStorage("Flash");
        //Создаем проигрыватели
        SongPlayer universalPlayer = new SongPlayer("Univeral Player");
        SongPlayer vinylPlayer = new SongPlayer("Vinyl Player",vinyl);
        SongPlayer mp3 = new SongPlayer("mp3","flash");
        //Создаем песни
        Song song1 = new Song("Twenty one pilots","Car Radio",cd);
        Song song2 = new Song("Twenty one pilots","Neon Gravestones",vinyl);
        Song song3 = new Song("Twenty one pilots","Heavydirtysoul",flash);
        //Проверяем сможем ли мы сыграть определенные песни на разных проигрывателях
        mp3.playSong(song1);
        mp3.playSong(song3);
        vinylPlayer.playSong(song2);
        universalPlayer.playSong(song1);
        universalPlayer.playSong(song2);
        //Присваеваем проигрывателю universalPlayer, что он может играть песни только с cd
        universalPlayer.setStorageNeeded(cd);
        universalPlayer.playSong(song1);
        universalPlayer.playSong(song2);

    }
}