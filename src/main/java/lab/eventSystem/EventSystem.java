package lab.eventSystem;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс, реализующий одновременно два паттерна:
 * одиночка и наблюдатель.
 * Его задача хранить в себе наблюдателей за событиями и уведомлять их.
 * В данной версии(0.1.0alpha) единственное события - переход программы
 * из одного состояния в другое: от эмуляции сдачи лабы к жмуляции битвы покемонов.
 */
public final class EventSystem {
    private static EventSystem singleton = null;

    private static List<IObserver> observers;


    /**
     * Доступ к синглтону, его ленивая инициализая.
     * @return синглтон
     */
    public static EventSystem getSingleton() {
        if (singleton == null) {
            singleton = new EventSystem();
            observers = new ArrayList<IObserver>();
        }

        return singleton;
    }


    /**
     * Добавить наблюдателя.
     * @param observer наблюдатель
     */
    public void subscribe(IObserver observer) {
        if (observers.indexOf(observer) < 0) {
            observers.add(observer);   
        }
    }

    /**
     * Убрать наблюдателя
     * @param observer наблюдатель
     */
    public void unsubscribe(IObserver observer) {
        observers.remove(observer);
    }

    /**
     * Создать новое событие.
     * По сути является недоделанным, так как поддерживает всего 1 вид события.
     */
    public void newEvent() {
        Event event = new Event();
        observers.forEach(observer -> {
            observer.notify(event);
        });
    }
}