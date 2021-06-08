package Lesson8;

import com.sun.xml.internal.bind.annotation.OverrideAnnotationOf;

public class Treadmill implements IBarrier {

    private int distance;

    public Treadmill(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }
}
