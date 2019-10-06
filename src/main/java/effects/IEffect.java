package effects;

import ru.ifmo.se.pokemon.Pokemon;

/**
 * Интерфейс, отвечающий за абстракцию адаптеров для встроенного в ru.itmo.se.pokemon класса Effect
 */
public interface IEffect {
    /**
     * Метод, отвечающий за применения эффекта к данному покемону
     * @param pokemon цель эффекта
     */
    public void apply(Pokemon pokemon);
}