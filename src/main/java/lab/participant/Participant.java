package lab.participant;

import java.io.PrintStream;
import java.util.List;
import java.util.Random;

/**
 * Класс участника эмуляции сдачи лабораторной.
 * Обладает двумя полями листов обычных и специальных фраз.
 * Важно! В целях удобства доступ к обычным фразам реализован по принципу стека.
 */
public class Participant {
    private String name;
    //Используется в виде стека
    private List<String> commonPhrases;

    private List<String> specialPhrases;


    /**
     * Конструктор
     * @param name имя участника
     * @param commonPhrases обычные фразы
     * @param specialPhrases специальные фразы
     */
    public Participant(String name,
                       List<String> commonPhrases,
                       List<String> specialPhrases) {
        this.name = name;
        this.commonPhrases = commonPhrases;
        this.specialPhrases = specialPhrases;
    }


    /**
     * Геттер имени.
     * @return имя
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает true, если лист обычных фраз пуст.
     * @return boolean
     */
    public Boolean wasLastPhrase() {
        return !havePhrase();
    }

    /**
     * Вывод обычной фразы (верхней в стеке) на PrintStream
     * @param printStream поток для вывода
     */
    public void say(PrintStream printStream) {
        if (havePhrase()) {
            printStream.println(getLastPhrase());
            removeLastPhrase();
        }
    }
    private Boolean havePhrase() {
        return commonPhrases.size() != 0;
    }
    private String getLastPhrase() {
        return commonPhrases.get(commonPhrases.size() - 1);
    }
    private void removeLastPhrase() {
        commonPhrases.remove(commonPhrases.size() - 1);
    }

    /**
     * Вывод специальной, случайной фразы на PrintStream
     * @param printStream поток для вывода
     */
    public void saySpecial(PrintStream printStream) {
        if (!specialPhrases.isEmpty()) {
            printStream.println();
            printStream.println(getLastSpecialPhrase());
            printStream.println();
        }
    }
    private String getLastSpecialPhrase() {
        Random random = new Random();
        int randomNumber = random.nextInt(specialPhrases.size());

        return specialPhrases.get(randomNumber);
    }
}