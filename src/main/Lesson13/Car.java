package Lesson13;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Car  implements Runnable{

    private static int CARS_COUNT;
    private Race race;
    private CyclicBarrier cyclicBarrier;
    private Semaphore semaphore;

    private int speed;
    private String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed, CyclicBarrier cyclicBarrier, Semaphore semaphore) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.cyclicBarrier = cyclicBarrier;
        this.semaphore = semaphore;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {

        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            cyclicBarrier.await();

            if (race.start.getAndSet(false)) {
                System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {

            Stage stage = race.getStages().get(i);

            if (stage instanceof Tunnel) {
                try {
                    System.out.println(this.getName() + " готовится к этапу(ждет): " + stage.description);
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            race.getStages().get(i).go(this);
            semaphore.release();
        }

        if (race.finish.getAndSet(false)) {
            System.out.println("Победил" + this.getName());
        }
    }
}
