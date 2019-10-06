package moves;

import effects.IEffect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

public class Swagger extends StatusMove {
    public Swagger() {
        super(Type.NORMAL, 0, 85);
    }


    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        IEffect effect = new effects.MultiTurnEffect(Stat.ATTACK, 2);
        effect.apply(pokemon);
        pokemon.confuse();
    }
}