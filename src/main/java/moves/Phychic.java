package moves;

import effects.IEffect;
import effects.OneTurnEffect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

public class Phychic extends SpecialMove {
    public Phychic() {
        super(Type.PSYCHIC, 90, 100);
    }


    @Override
    protected void applyOppDamage(Pokemon pokemon, double power) {
        super.applyOppDamage(pokemon, power);

        IEffect effect = new OneTurnEffect(Stat.SPECIAL_DEFENSE, -1, 0.1);
        effect.apply(pokemon);
    }
}