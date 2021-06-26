package Lesson12;

import java.math.RoundingMode;

import static java.lang.System.*;

public class Main {

    private static final int SIZE = 10000000;
    private static final int HALF = SIZE / 2;
    private static float[] arr;

    private static float[] arr1;
    private static float[] arr2;

    private static long a, b, aa, ab;

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
        ThreadForOperation threadForOperation2 = new ThreadForOperation(arr2);

        Thread thread1 = new Thread(threadForOperation1);
        Thread thread2 = new Thread(threadForOperation2);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        ab = currentTimeMillis();

        arraycopy(arr1, 0, arr, 0, HALF);
        arraycopy(arr2, 0, arr, HALF, HALF);

        b = currentTimeMillis();

        out.println("Время разделения массива: " + diffTime(a, aa));
        out.println("Время выполнения операции в двух потоках: " + diffTime(aa, ab));
        out.println("Время выполнения операции объединения массивов: " + diffTime(ab, b));
        out.println("Время выполнения операции в двух потоках с разделением и объединением массивов: " + diffTime(a, b));
    }


    public static String diffTime(long a, long b) {
        long n = b - a;
        return n + "ms";
    }

}
