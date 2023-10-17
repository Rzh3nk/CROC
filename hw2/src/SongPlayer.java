/**
 * Класс описывает проигрывающее устройство
 */
public class SongPlayer {

    private String playerName;
    private String storageNeeded;

    /**
     * Конструктор класса SongPlayer, устанавливает storageNeeded "ALL", так как нам не дали ограничений с какого хранилища воспроизводить
     * @param playerName название устройства
     */
    public SongPlayer(String playerName){
        this.playerName=playerName;
        this.storageNeeded = "ALL";
    }

    /**
     * Конструктор класса SongPlayer
     * @param playerName название устройства
     * @param storageNeeded строка, с какого хранилища можем воспроизвести песню
     */
    public SongPlayer(String playerName, String storageNeeded){
        this.playerName=playerName;
        this.storageNeeded = storageNeeded;
    }

    /**
     * Конструктор класса SongPlayer
     * @param playerName название устройства
     * @param storageNeeded объект SongStorage, с какого хранилища можем воспроизвести песню
     */
    public SongPlayer(String playerName, SongStorage storageNeeded){
        this.playerName=playerName;
        this.storageNeeded = storageNeeded.getStorageName();
    }

    /**
     * Метод, который устанавливает с какого хранилища можем воспроизвести песню
     * @param storageNeeded строка с типом необходимого хранилища
     */
    public void setStorageNeeded(String storageNeeded) {
        this.storageNeeded = storageNeeded;
    }

    /**
     Метод, который устанавливает с какого хранилища можем воспроизвести песню
     * @param storageNeeded объект SongStorage с типом необходимого хранилища
     */
    public void setStorageNeeded(SongStorage storageNeeded) {
        this.storageNeeded = storageNeeded.getStorageName();
    }

    /**
     * Метод, проверяет можем ли мы воспроизвести песню на устройстве
     * @param song Песня, хранилище которую хотим проверить
     * @return true, если устройство совместимо с песней, иначе false.
     */
    public boolean isPlayebleOn(Song song) {
        return storageNeeded.equalsIgnoreCase(song.getStorage());
    }

    /**
     * Метод вопсроизводящий песню, выводит данные, если может ее сыграть, иначе выводит ошибку
     * @param song песня, которую хотим сыграть
     */
    public void playSong(Song song){
        if(storageNeeded.equals("ALL") || isPlayebleOn(song)){
        System.out.println(song+"\nПроигрыватель: "+playerName+"\n");
        }
        else {
            System.out.println("Проигрывающее устройство и носитель не совместимы, ожидаемый носитель:"+storageNeeded+"\n");
        }
    }
}
