package jsonParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

/**
 * Адаптер библиотеки simpleParser от GoogleCode
 */
public class JSONParser {
    /**
     * Парсит указанный файл и извлекает из него корневой JSON объект
     * @param fileName полное имя файла(.json) для парсинга
     * @param charset кодировка файла
     * @return корневой JSON объект
     */
    public static JSONObject parseFile(String fileName, String charset) {
        org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();

        JSONObject root = null;
        try {
            BufferedReader reader = new BufferedReader(
                                        new InputStreamReader(JSONParser.class.getClassLoader().getResourceAsStream(fileName), charset));

            root = (JSONObject) parser.parse(reader);
        } catch (IOException | ParseException exception) {
            exception.printStackTrace();
            System.exit(1);
        }

        return root;
    }
}