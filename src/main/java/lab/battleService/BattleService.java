package lab.battleService;

import lab.eventSystem.Event;
import lab.eventSystem.IObserver;
import ru.ifmo.se.pokemon.Battle;
import ru.raid.sound.Sound;
import sound.SoundAdapter;

/**
 * Класс, агрегирующий объект типа ru.itmo.se.pokemon.Battle.
 * Реализует интерфейс IObserver пакета eventSystem.
 * Единственное его назначение - обеспечить корректный переход от стадии
 * эмуляции сдачи лабораторной работы к эмуляции битвы покемонов.
 * @see IObserver
 */
public class BattleService implements IObserver {
    private final String POKEMON_BATTLE_MUSIC = "sounds/pokemonBattle.wav";

    private Battle battle;


    /**
     * Конструктор
     * @param battle агрегируемый объект
     */
    public BattleService(Battle battle) {
        this.battle = battle;
    }


    /**
     * @see IObserver
     */
    @Override
    public void notify(Event event) {
        start();
    }

    private void start() {
        System.out.println();
        SoundAdapter.playSound(POKEMON_BATTLE_MUSIC);
        battle.go();
    }
}