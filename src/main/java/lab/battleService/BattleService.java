package lab.battleService;

import lab.eventSystem.Event;
import lab.eventSystem.IObserver;
import pokemons.PokemonFactory;
import ru.ifmo.se.pokemon.Battle;
import ru.ifmo.se.pokemon.Pokemon;
import ru.raid.sound.Sound;
import sound.SoundAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс, агрегирующий объект типа ru.itmo.se.pokemon.Battle.
 * Реализует интерфейс IObserver пакета eventSystem.
 * Единственное его назначение - обеспечить корректный переход от стадии
 * эмуляции сдачи лабораторной работы к эмуляции битвы покемонов.
 * @see IObserver
 */
public final class BattleService implements IObserver {
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

    private final String POKEMON_BATTLE_MUSIC = "sounds/pokemonBattle.wav";

    private Battle battle;


    /**
     * Конструктор
     * @param battle агрегируемый объект
     */
    public BattleService(Battle battle) {

        this.battle = battle;
        List<Pokemon> pokemons = createPokemons();
        splitPokemonsInTwoCommands(battle, pokemons);
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