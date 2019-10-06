package moves;

import java.util.Random;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Type;

public class Blizzard extends SpecialMove {
    public Blizzard() {
        super(Type.ICE, 110, 70);
    }


    @Override
    protected void applyOppDamage(Pokemon pokemon, double power) {
        super.applyOppDamage(pokemon, power);

        Random randomizator = new Random();
        //Шанс выпадения 0 из 10 целых чисел 10%
        if(randomizator.nextInt(10) == 0) {
            Effect.freeze(pokemon);
        }
    }
}