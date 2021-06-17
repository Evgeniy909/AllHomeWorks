package Lesson11;

import java.util.ArrayList;

public class Box<Fruit> {

    private double weight = 0;

    private ArrayList<Fruit> fruits = new ArrayList<>();

    public void add(Fruit fruit, double weight) {

        fruits.add(fruit);
        this.weight += weight;
    }

    public double getWeight() {
       return this.weight;
    }

    public boolean compare(Box theBox) {

        double a;
        double b;

        a = this.getWeight();
        b = theBox.getWeight();

        if (a == b) {
            return true;
        }
        return false;
    }

    public void overload(Box<Fruit> theBox) {

        for (int i = theBox.fruits.size()-1; i > 0 ; i--) {
            this.fruits.add(theBox.fruits.remove(i));
            theBox.weight = 0;
        }

    }

}
