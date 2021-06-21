package Lesson12;

import java.math.RoundingMode;

import static java.lang.System.*;

public class Main {

    private static final int SIZE = 10000000;
    private static final int HALF = SIZE / 2;
    private static float[] arr;

    private static float[] arr1;
    private static float[] arr2;

    private static long a, b, ab, ba, aa;

    public static void main(String[] args) throws InterruptedException {

        arr = new float[SIZE];

        arr1 = new float[HALF];
        arr2 = new float[HALF];

        ThreadForOperation threadForOperation = new ThreadForOperation(arr);

        a = currentTimeMillis();
        threadForOperation.run();
        b = currentTimeMillis();
        out.println("Выполнение операции в одном потоке без разбивки массива: " + diffTime(a, b));

        a = currentTimeMillis();

        arraycopy(arr, 0, arr1, 0, HALF);
        arraycopy(arr, HALF, arr2, 0, HALF);

        aa = currentTimeMillis();

        ThreadForOperation threadForOperation1 = new ThreadForOperation(arr1);

        Thread thread1 = new Thread(threadForOperation1);
        thread1.start();
        thread1.join();

        ab = currentTimeMillis();

        ThreadForOperation threadForOperation2 = new ThreadForOperation(arr2);

        Thread thread2 = new Thread(threadForOperation2);
        thread2.start();
        thread2.join();

        ba = currentTimeMillis();

        arraycopy(arr1, 0, arr, 0, HALF);
        arraycopy(arr2, 0, arr, HALF, HALF);

        b = currentTimeMillis();


        out.println("Время разделения массива: " + diffTime(a, aa));
        out.println("Время выполнения операции в первом потоке: " + diffTime(aa, ab));
        out.println("Время выполнения операции во втором потоке: " + diffTime(ab, ba));
        out.println("Время выполнения операции объединения массивов: " + diffTime(ba, b));
        out.println("Время выполнения операции в двух потоках с разделением и объединением массивов: " + diffTime(a, b));
    }

    /*
    Выполнение операции в одном потоке без разбивки массива: 13184ms
    Время разделения массива: 10ms
    Время выполнения операции в первом потоке: 4771ms
    Время выполнения операции во втором потоке: 2729ms
    Время выполнения операции объединения массивов: 9ms
    Время выполнения операции в двух потоках с разделением и объединением массивов: 7519ms

    То, что одинаковые операции в двух потоках выполняются за разное время, это норм?
    Или же я допустил ошибку?

    В данном случае после thread1.join() выполнение основного потока тормозится и ждёт завершения
    первого потока, при этом второй поток тоже еще не запущен так?

    Если да, то предполагаю, что более правильно для подобной задачи будет прописать так:

    thread1.start();
    thread2.start();

    thread1.join();
    thread2.join();

    В таком случае запустятся оба потока параллельно и если первый поток
    закончит работу перывым, то останется дождаться второй поток...
    Или же я не правильно что-то понимаю?
    */

    public static String diffTime(long a, long b) {
        long n = b - a;
        return n + "ms";
    }

}
