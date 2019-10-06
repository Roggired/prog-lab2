package moves;


import effects.IEffect;
import effects.OneTurnEffect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

public class DoubleTeam extends StatusMove {
    public DoubleTeam() {
        super(Type.NORMAL, 0, 100);
    }


    @Override
    protected void applySelfEffects(Pokemon pokemon) {
        IEffect effect = new OneTurnEffect(Stat.EVASION, 1);
        effect.apply(pokemon);
    }
}