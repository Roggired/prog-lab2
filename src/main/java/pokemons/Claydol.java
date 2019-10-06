package pokemons;

import moves.Extrasensory;
import moves.Phychic;
import moves.StoneEdge;
import moves.Swagger;
import ru.ifmo.se.pokemon.Type;

public class Claydol extends Baltoy {
    public Claydol(String name, int[] stats, int level) {
        super(name, stats, level);
        setType(Type.GROUND,
                Type.PSYCHIC); 
        setMove(new Swagger(),
                new Extrasensory(),
                new Phychic(),
                new StoneEdge());
    }
}