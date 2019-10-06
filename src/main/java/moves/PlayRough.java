package moves;

import effects.IEffect;
import effects.OneTurnEffect;
import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

public class PlayRough extends PhysicalMove {
    public PlayRough() {
        super(Type.FAIRY, 90, 90);
    }


    @Override
    protected void applyOppDamage(Pokemon pokemon, double power) {
        super.applyOppDamage(pokemon, power);

        IEffect effect = new OneTurnEffect(Stat.ATTACK, -1, 0.1);
        effect.apply(pokemon);
    }
}