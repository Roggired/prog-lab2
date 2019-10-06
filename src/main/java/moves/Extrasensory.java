package moves;

import java.util.Random;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Type;

public class Extrasensory extends SpecialMove {
    public Extrasensory() {
        super(Type.PSYCHIC, 80, 100);
    }


    @Override
    protected void applyOppDamage(Pokemon pokemon, double power) {
        super.applyOppDamage(pokemon, power);

        Random random = new Random();
        //Вероятность 10%
        if (random.nextInt(10) == 0) {
            Effect.flinch(pokemon);
        }
    }
}