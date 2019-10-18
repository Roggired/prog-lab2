package effects;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;

/**
 * OneTurnEffect реализует создание эффекта, изменяющего данный показатель
 * одной из характеристик покемона-цели на ровно 1 один ход
 */
public class    OneTurnEffect implements IEffect {
    private Effect nativeEffect;


    /**
     * Конструктор
     * @param stat изменяемая характеристика
     * @param modificator модификатор данной характеристики
     */
    public OneTurnEffect(Stat stat, int modificator) {
        nativeEffect = new Effect().turns(1).stat(stat, modificator);
    }

    /**
     * Конструктор
     * @param stat изменяемая характеристика
     * @param modificator модификатор данной характеристики
     * @param chance шанс срабатывания эффекта
     */
    public OneTurnEffect(Stat stat, int modificator, double chance) {
        nativeEffect = new Effect().turns(1).chance(chance).stat(stat, modificator);
    }


    /**
     * @see IEffect
     */
    @Override
    public void apply(Pokemon pokemon) {
        pokemon.addEffect(nativeEffect);
    }
}