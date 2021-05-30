package Lesson6;

public abstract class Animal {

    private String name;
    private int age;
    private int maxDistance;
    private double maxJump;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    protected Animal(String name, int age, int maxDistance, double maxJump) {
        this.name = name;
        this.age = age;
        this.maxDistance = maxDistance;
        this.maxJump = maxJump;
    }

    public void run(int distance) {
        if (distance > getMaxDistance()) {
            System.out.println("К сожалению " + getName() + " так далеко не бегает");
        } else if (distance <= 0) {
            System.out.println("Дистанция должна быть положительным числом");
        } else {
            System.out.println("Дистанция пройдена!");
        }
    }

    public void jump(double length) {

        if (length > getMaxJump()) {
            System.out.println("К сожалению " + getName() + " так высоко не прыгает");
        } else if (length <= 0) {
            System.out.println("Высота должна быть положительным числом");
        } else {
            System.out.println("Я запрыгнул, хозяин!");
        }
    }

    public int getMaxDistance() {
        return maxDistance;
    }

    public double getMaxJump() {
        return maxJump;
    }
}

