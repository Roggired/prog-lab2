package moves;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Status;
import ru.ifmo.se.pokemon.Type;

public class DreamEater extends SpecialMove {
    public DreamEater() {
        super(Type.PSYCHIC, 100, 100);
    }


    @Override
    protected void applyOppDamage(Pokemon pokemon, double power) {
        if (pokemon.getCondition().equals(Status.SLEEP)) {
            super.applyOppDamage(pokemon, power);
        }
    }

    @Override
    protected void applySelfDamage(Pokemon pokemon, double power) {
        pokemon.setMod(Stat.HP,  -(int) (power / 2));
    }
}