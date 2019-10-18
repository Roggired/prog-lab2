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
        Battle battle = new Battle();
        battleService = new BattleService(battle);
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