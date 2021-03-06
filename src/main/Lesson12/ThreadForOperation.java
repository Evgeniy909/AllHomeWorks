package Lesson12;

public class ThreadForOperation implements Runnable {

    private float[] arr;

    public ThreadForOperation(float[] arr) {
        this.arr = arr;
    }

    @Override
    public void run() {

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}
