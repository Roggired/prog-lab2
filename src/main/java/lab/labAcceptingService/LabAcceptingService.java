package lab.labAcceptingService;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import lab.eventSystem.Event;
import lab.eventSystem.EventSystem;
import lab.eventSystem.IObserver;
import lab.participant.Participant;

import ru.raid.sound.Sound;
import sound.SoundAdapter;

/**
 * Модуль, отвечающий за эмуляцию сдачи лабораторной, является частью
 * паттерна наблюдателя, реализует IObserver из eventSystem.
 */
public final class LabAcceptingService implements IObserver {
    private final String STUDENT_BATTLE_MUSIC = "sounds/studentBattle.wav";

    private final int FIRST_TURN_DELAY = 0;
    private final int ONE_TURN_TIME = 2000;

    private final int FIRST_SPECIAL_PHRASE_DELAY = ONE_TURN_TIME / 2 + ONE_TURN_TIME;
    private final int SPECIAL_PHRASE_ONE_TURN_TIME = 3 *ONE_TURN_TIME;

    private Timer timer;
    private List<Participant> participants;
    private Sound sound;


    /**
     * Конструктор
     * @param participants коллекция с участниками процесса сдачи лабы.
     */
    public LabAcceptingService(List<Participant> participants) {
        timer = new Timer();
        this.participants = participants;
    }

    /**
     * Начало приема лабораторной.
     */
    public void start() {
        timer.schedule(new SayTask(participants), 
                        FIRST_TURN_DELAY, 
                        ONE_TURN_TIME);
        timer.schedule(new SpecialSayTask(participants), 
                        FIRST_SPECIAL_PHRASE_DELAY, 
                        SPECIAL_PHRASE_ONE_TURN_TIME);

        sound = SoundAdapter.playSound(STUDENT_BATTLE_MUSIC);
    }

    /**
     * @see IObserver
     */
    @Override
    public void notify(Event event) {
        stop();
    }


    private void stop() {
        sound.stop();
        timer.cancel();
    }


    /**
     * Внутренний класс, используемый для передачи задачи таймеру из пакета util
     */
    private class SayTask extends TimerTask {
        private List<Participant> participants;
        private Participant next;


        public SayTask(List<Participant> participants) {
            this.participants = participants;
            next = participants.get(0);
        }

        @Override
        public void run() {
            if (next.wasLastPhrase()) {
                EventSystem.getSingleton().newEvent();
            }

            next.say(System.out);

            int index = 1 - participants.indexOf(next);
            next = participants.get(index);
        }
    }

    /**
     * Внутренний класс, используемый для передачи задачи таймеру из пакета util
     */
    private class SpecialSayTask extends TimerTask {
        private List<Participant> participants;
        private Participant next;


        public SpecialSayTask(List<Participant> participants) {
            this.participants = participants;
            next = participants.get(0);
        }

        @Override
        public void run() {
            next.saySpecial(System.out);

            int index = 1 - participants.indexOf(next);
            next = participants.get(index);
        }
    }
}