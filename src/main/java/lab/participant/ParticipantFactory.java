package lab.participant;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

import jsonParser.JSONParser;

/**
 * Класс, отвечающий за создание участников эмуляции сдачи лабы,
 * несмотря на название не реализует паттернов GoF. Инскапсулирует
 * алгоритм создания участников, состоящий из двух простых шагов:
 * 1. Парсинг фраз из .json-файла.
 * 2. Создание Participant.
 */
public class ParticipantFactory {
    private final static String PATH_TO_JSON_DIRECTORY = "jsons/participants/";
    private final static String JSON_EXTENSION = ".json";
    private final static String FILE_CHARSET = "UTF-8";


    /**
     * Создает участника по имени.
     * @param participantName имя.
     * @return участник.
     */
    public static Participant create(String participantName) {
            JSONObject root = JSONParser.parseFile(PATH_TO_JSON_DIRECTORY
                                             + getFileName(participantName) 
                                             + JSON_EXTENSION, 
                                               FILE_CHARSET);

        return new Participant(participantName, 
                               createCommonPhrases(root, participantName),
                               createSpecialPhrases(root, participantName));
    }
    private static String getFileName(String participantName) {
        if (participantName.toLowerCase().contains("рома")) {
            return "kindValidator";
        }
        if (participantName.toLowerCase().contains("agly")) {
            return "aglyValidator";
        }
        if (participantName.toLowerCase().contains("письмак")) {
            return "quiteValidator";
        }
        if (participantName.toLowerCase().contains("алексей")) {
            return "student";
        }

        return "normalValidator";
    }
    private static List<String> createCommonPhrases(JSONObject root, String participantName) {
        JSONObject commonPhrases = (JSONObject) root.get("commonPhrases");
        return createPhraseList(commonPhrases, participantName);
    }
    private static List<String> createSpecialPhrases(JSONObject root, String participantName) {
        JSONObject specialPhrases = (JSONObject) root.get("specialPhrases");
        return createPhraseList(specialPhrases, participantName);
    } 
    private static List<String> createPhraseList(JSONObject source, String participantName) {
        List<String> list = new ArrayList<>();

        int quantityOfPhrases = Integer.parseInt((String) source.get("quantity"));

        for (int index = quantityOfPhrases; index > 0; index--) {
            list.add(concatName(participantName, (String) source.get("phrase" + index)));
        }

        return list;
    }
    private static String concatName(String name, String phrase) {
        return name + ": " + phrase;
    }
}