package pokemons;

import moves.Growth;
import moves.MagicalLeaf;
import moves.PlayRough;
import moves.Swagger;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;


public class Comfey extends Pokemon {
    public Comfey(String name, int[] stats, int level) {
        super(name, level);
        setStats(stats[0],
                 stats[1],
                 stats[2],
                 stats[3],
                 stats[4],
                 stats[5]);
        setType(Type.FAIRY);
        setMove(new Growth(),
                new Swagger(),
                new PlayRough(),
                new MagicalLeaf());
    }
}