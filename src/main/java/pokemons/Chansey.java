package pokemons;

import moves.DoubleTeam;
import moves.DreamEater;
import moves.Present;
import ru.ifmo.se.pokemon.Type;

public class Chansey extends Happiny {
    public Chansey(String name, int[] stats, int level) {
        super(name, stats, level);
        setType(Type.NORMAL);
        setMove(new DoubleTeam(),
                new DreamEater(),
                new Present());
    }
}