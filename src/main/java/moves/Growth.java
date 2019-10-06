package moves;

import effects.IEffect;
import effects.OneTurnEffect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

public class Growth extends StatusMove {
    public Growth() {
        super(Type.NORMAL, 0, 100);
    }


    @Override
    protected void applySelfEffects(Pokemon pokemon) {
        IEffect effect = new OneTurnEffect(Stat.ATTACK, 1);
        effect.apply(pokemon);

        effect = new OneTurnEffect(Stat.SPECIAL_ATTACK, 1);
        effect.apply(pokemon);
    }
}