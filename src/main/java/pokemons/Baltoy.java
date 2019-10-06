package pokemons;

import moves.Extrasensory;
import moves.Phychic;
import moves.Swagger;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Baltoy extends Pokemon {
    public Baltoy(String name, int[] stats, int level) {
        super(name, level);
        setStats(stats[0],
                 stats[1],
                 stats[2],
                 stats[3],
                 stats[4],
                 stats[5]);
        setType(Type.GROUND,
                Type.PSYCHIC);
        setMove(new Swagger(),
                new Extrasensory(),
                new Phychic());
    }
}