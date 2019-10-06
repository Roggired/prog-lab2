package lab;

import java.util.ArrayList;
import java.util.List;

import lab.battleService.BattleService;
import lab.eventSystem.EventSystem;
import lab.labAcceptingService.LabAcceptingService;
import lab.participant.Participant;
import lab.participant.ParticipantFactory;
import pokemons.PokemonFactory;
import ru.ifmo.se.pokemon.Battle;
import ru.ifmo.se.pokemon.Pokemon;

/**
 * Общий класс лабораторной работы, включает в себя LabAcceptionService и BattleSerivce,
 * создает данные сервисы, используя dependency injection
 */
public final class Lab {
    private final List<String> POKEMONS_SHORT_CLASS_NAMES = new ArrayList<String>() {
        private static final long serialVersionUID = 4271875362570551157L;

        {
            add("Happiny");
            add("Comfey");
            add("Claydol");
            add("Chansey");
            add("Blissey");
            add("Baltoy");
        }
    };
    
    private Battle battle;
    private BattleService battleService;

    private LabAcceptingService labAcceptingService;


    /**
     * Конструктор
     * @param validatorName имя проверяющего
     * @param studentName имя студента
     */
    public Lab(String validatorName,
               String studentName) {
        createLabAcceptionService(validatorName, studentName);
        createBattleService();

        subscribeServicesToEventSystem();
    }
    private void createLabAcceptionService(String validatorName,
                                           String studentName) {
        List<Participant> participants = new ArrayList<Participant>();  
        participants.add(ParticipantFactory.create(validatorName));
        participants.add(ParticipantFactory.create(studentName));
                                    
        labAcceptingService = new LabAcceptingService(participants);
    }
    private void createBattleService() {
        List<Pokemon> pokemons = createPokemons();

        battle = new Battle();
        splitPokemonsInTwoCommands(battle, pokemons);

        battleService = new BattleService(battle);
    }
    private List<Pokemon> createPokemons() {
        List<Pokemon> pokemons = new ArrayList<Pokemon>();
        POKEMONS_SHORT_CLASS_NAMES.forEach(shortClassName -> {
            pokemons.add(PokemonFactory.create(shortClassName));
        });

        return pokemons;
    }
    private void splitPokemonsInTwoCommands(Battle battle, List<Pokemon> pokemons) {
        pokemons.forEach(pokemon -> {
            if (pokemons.indexOf(pokemon) < pokemons.size() / 2) {
                battle.addAlly(pokemon);
            } else {
                battle.addFoe(pokemon);
            }
        });
    }
    private void subscribeServicesToEventSystem() {
        EventSystem.getSingleton().subscribe(labAcceptingService);
        EventSystem.getSingleton().subscribe(battleService);
    }

    /**
     * Запуск лабораторной
     */
    public void start() {
        labAcceptingService.start();
    }
}