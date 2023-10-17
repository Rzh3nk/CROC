/**
 * Класс описывает песни
 */
public class Song {
    private String artist;
    private String name;
    private String storage;

    /**
     * Конструтор класса Song
     * @param artist имя артиста,группы
     * @param name название песни
     * @param storage устройство-носитель
     */
    public Song(String artist, String name, SongStorage storage){
        this.artist=artist;
        this.name=name;
        this.storage=storage.getStorageName();
    }

    /**
     * Метод для получения имени артиста/группы
     * @return имя артиста/группы
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Метод для получения названия песни
     * @return название песни
     */
    public String getName() {
        return name;
    }

    /**
     * Метод для получения носителя
     * @return носитель
     */
    public String getStorage() {
        return storage;
    }

    /**
     * Метод для преобразования объекта к строке для вывода
     * @return строку содержащую имя артиса, название песни и носитель
     */
    public String toString() {
        return "Исполнитель: "+artist+"\nНазвание: "+name+"\nНоситель: "+storage;
    }
}
