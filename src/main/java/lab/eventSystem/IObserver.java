package lab.eventSystem;


/**
 * Интерфейс наблюдателя из одноименного паттерна
 */
public interface IObserver {
    /**
     * Уведомить о наступившем событии.
     * @param event событие.
     */
    public void notify(Event event);
}