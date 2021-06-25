package Lesson11;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Box appleBox = new Box<Apple>();
        appleBox.add(new Apple(),1);
        appleBox.add(new Apple(),1);
        appleBox.add(new Apple(),1);

        Box orangeBox = new Box<Orange>();
        orangeBox.add(new Orange(),1.5);
        orangeBox.add(new Orange(),1.5);
        orangeBox.add(new Orange(),1.5);

        if (orangeBox.compare(appleBox)) {

            System.out.println("Ящики равны!");
        } else {
            System.out.println("Ящики не равны!");
        }

        Box appleBox1 = new Box<Apple>();

        appleBox1.add(new Apple(),1);
        appleBox1.add(new Apple(),1);
        appleBox1.add(new Apple(),1);


        if (appleBox.compare(appleBox1)) {

            System.out.println("Ящики равны!");
        } else {
            System.out.println("Ящики не равны!");
        }

        appleBox.overload(appleBox1);

        if (appleBox.compare(appleBox1)) {

            System.out.println("Ящики равны!");
        } else {
            System.out.println("Ящики не равны!");
        }

    }

    public static Object[] exchange(Object[] arr, int a, int b) {
        Object tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
        tmp = null;
        return arr;
    }

    public static <T> ArrayList<T> arrToArrList(T[] arr) {
        return new ArrayList<T>(Arrays.asList(arr));
    }


}
