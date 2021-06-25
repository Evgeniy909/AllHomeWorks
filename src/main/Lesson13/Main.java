package Lesson13;

import java.util.ArrayList;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Main {

    public static final int CARS_COUNT = 5;

    public static void main(String[] args) throws InterruptedException {

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");

        //Race - гонка
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));

        //Инициализация массива
        Car[] cars = new Car[CARS_COUNT];

        CyclicBarrier cyclicBarrier = new CyclicBarrier(CARS_COUNT);

        Semaphore semaphore = new Semaphore(Math.round(CARS_COUNT/2) );

        //Заполнение массива
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10),cyclicBarrier,semaphore);
        }

        ArrayList<Thread> threadArrayList = new ArrayList<Thread>();

        for (Car car : cars) {

            Thread th = new Thread(car);
            threadArrayList.add(th);
            th.start();
        }

        for (Thread td:threadArrayList) {
            td.join();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}
