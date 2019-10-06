package pokemons;


import moves.DoubleTeam;
import moves.DreamEater;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Happiny extends Pokemon {
    public Happiny(String name, int[] stats, int level) {
        super(name, level);
        setStats(stats[0],
                 stats[1],
                 stats[2],
                 stats[3],
                 stats[4],
                 stats[5]);
        setType(Type.NORMAL);
        setMove(new DoubleTeam(),
                new DreamEater());
    }
}