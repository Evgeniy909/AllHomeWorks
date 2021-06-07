package Lesson8;

import com.sun.xml.internal.bind.annotation.OverrideAnnotationOf;

public class Treadmill implements ITreadmill {

    private int distance;

    public Treadmill(int distance) {
        this.distance = distance;
    }
@Override
    public int getDistance() {
        return distance;
    }
}
