/**
 * Класс описывает устройства носители
 */
public class SongStorage {
    String storageName;

    /**
     * Конструктор класса SongStorage
     * @param storageName название носителя
     */
    public SongStorage(String storageName){
        this.storageName=storageName;
    }

    /**
     * Метод для получения названия устройства носителя
     * @return название носителя
     */
    public String getStorageName() {
        return storageName;
    }
}
