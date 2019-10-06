package sound;

import ru.raid.sound.Sound;

import java.io.File;
import java.net.URISyntaxException;

/**
 * Класс, реализующий паттерн Адаптер, его единственная задача -
 * обеспечить правильную работу с библиотекой ru.raid.sound, так как
 * она не поддерживает работу с ресурсами.
 */
public class SoundAdapter {

    /**
     * Метод, запускающий проигрывание звука, загружает файл со звуком в виде ресурса.
     * @param pathToSoundFile путь к файлу со звуком.
     * @return возвращает экземпляр класса ru.raid.sound.Sound.
     */
    public static Sound playSound(String pathToSoundFile) {
        try {
            Sound sound = new Sound(new File(SoundAdapter.class.getClassLoader().getResource(pathToSoundFile).toURI()));
            sound.play();
            return sound;
        } catch (URISyntaxException e) {
            e.printStackTrace();
            System.exit(1);
            return null;
        }
    }
}
