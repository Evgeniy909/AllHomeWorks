package Lesson6;

public class Dog extends Animal {

    public Dog(String name, int age, int maxDistance, double maxJump, int maxDistanceSail,int satietyLevel) {
        super(name,age,maxDistance,maxJump, satietyLevel);
        this.maxDistanceSail = maxDistanceSail;
    }

    private int maxDistanceSail;

    public int getMaxDistanceSail() {
        return maxDistanceSail;
    }

    public void toSail(int distance) {
        if (distance > maxDistanceSail) {
            System.out.println("Ты хочешь меня утопить?...");
        } else if (distance <= 0) {
            System.out.println("Это как понимать?");
        } else {
            System.out.println("Брр... так себе водичка!");
            System.out.println("В следующий раз сам поплывёшь!");
        }
    }

}
