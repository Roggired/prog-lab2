package moves;

import java.util.Random;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

public class Present extends PhysicalMove {
    public Present() {
        super(Type.NORMAL, 100, 90);
    }

    @Override
    protected void applyOppDamage(Pokemon pokemon, double power) {
        Random random = new Random();
        int value = random.nextInt(2);
        // 50 на 50 выбираем, какой эффект применить
        if (value == 0) {
            int damage = random.nextInt(81) + 40;
            //pokemon.setMod(Stat.HP, -damage);
            pokemon.setMod(Stat.HP, damage);
        } else {
            double baseHp = pokemon.getStat(Stat.HP);
            pokemon.setMod(Stat.HP, (int) (baseHp / 4));
        }
    }
}