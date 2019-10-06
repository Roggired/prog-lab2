package pokemons;

import moves.Blizzard;
import moves.DoubleTeam;
import moves.DreamEater;
import moves.Present;
import ru.ifmo.se.pokemon.Type;

public class Blissey extends Chansey {
    public Blissey(String name, int[] stats, int level) {
        super(name, stats, level);
        setType(Type.NORMAL);
        setMove(new DoubleTeam(),
                new DreamEater(),
                new Present(),
                new Blizzard());
    }
}