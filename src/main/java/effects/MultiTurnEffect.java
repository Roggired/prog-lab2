package effects;

import java.util.Random;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;

/**
 * MultiTurnEffect реализует создание эффекта, изменяющего данный показатель
 * одной из характеристик покемона-цели на случайное число ходов (от 2 до 5)
 */
public class MultiTurnEffect implements IEffect {
    private Effect nativeEffect;


    /**
     * Конструктор
     * @param stat изменяемая характеристика
     * @param modificator модификатор данной характеристики
     */
    public MultiTurnEffect(Stat stat, int modificator) {
        Random random = new Random();
        int turns = random.nextInt(4) + 2; //Генерация случайных чисел от 2 до 5

        nativeEffect = new Effect().turns(turns).stat(stat, modificator);
    }


    /**
     * Конструктор
     * @param stat изменяемая характеристика
     * @param modificator модификатор данной характеристики
     * @param chance шанс наложения эффекта
     */
    public MultiTurnEffect(Stat stat, int modificator, double chance) {
        Random random = new Random();
        int turns = random.nextInt(4) + 2; //Генерация случайных чисел от 2 до 5

        nativeEffect = new Effect().turns(turns).stat(stat, modificator).chance(chance);
    }


    /**
     * @see IEffect
     */
    @Override
    public void apply(Pokemon pokemon) {
        pokemon.addEffect(nativeEffect);
    }
}