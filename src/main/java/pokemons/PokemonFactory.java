package pokemons;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import jsonParser.JSONParser;
import ru.ifmo.se.pokemon.Pokemon;

public class PokemonFactory {
    private static final String PATH_TO_JSON_DIRECTORY = "jsons/pokemons/";
    private static final String JSON_EXTENSION = ".json";
    private static final String CHARSET = "UTF-8";

    private static final Map<String, String> CLASS_BOOK = new HashMap<String, String>() {
        private static final long serialVersionUID = -315562317537444979L;

        {
            put("Happiny", "pokemons.Happiny");
            put("Comfey", "pokemons.Comfey");
            put("Chansey", "pokemons.Chansey");
            put("Baltoy", "pokemons.Baltoy");
            put("Blissey", "pokemons.Blissey");
            put("Claydol", "pokemons.Claydol");
        }
    };

    public static Pokemon create(String shortClassName) {
        JSONObject root = JSONParser.parseFile(PATH_TO_JSON_DIRECTORY 
                                             + shortClassName
                                             + JSON_EXTENSION,
                                               CHARSET);
        
        String name = getName(root);
        int[] stats = getStats(root);
        int level = getLevel(root);

        return createPokemonUsingReflection(shortClassName, name, stats, level);
    }
    private static Pokemon createPokemonUsingReflection(String shortClassName, 
                                                        String name, 
                                                        int[] stats, 
                                                        int level) {
        try {
            Class<?> clazz = Class.forName(CLASS_BOOK.get(shortClassName));
            Constructor<?> constructor = clazz.getConstructor(String.class,
                                                              int[].class,
                                                              int.class);
            return (Pokemon) constructor.newInstance(name, stats, level);
        } catch(Exception exception) {
            exception.printStackTrace();
            System.exit(1);
            return null;
        }
    }
    private static String getName(JSONObject root) {
        return (String) root.get("Name");
    }
    private static int[] getStats(JSONObject root) {
        int             hp = Integer.parseInt((String) root.get("HP"));
        int         attack = Integer.parseInt((String) root.get("Attack"));
        int        defense = Integer.parseInt((String) root.get("Defense"));
        int  specialAttack = Integer.parseInt((String) root.get("SpecialAttack"));
        int specialDefense = Integer.parseInt((String) root.get("SpecialDefense"));
        int          speed = Integer.parseInt((String) root.get("Speed"));

        int[] stats = {hp, attack, defense, specialAttack, specialDefense, speed};

        return stats;
    }
    private static int getLevel(JSONObject root) {
        return Integer.parseInt((String) root.get("Level"));
    }
}