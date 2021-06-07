package Lesson8;

public class Cat implements IAction {
    private int maxlength;
    private int maxHeight;
    private boolean result;

    public Cat(int maxlength, int maxHeight) {
        this.maxlength = maxlength;
        this.maxHeight = maxHeight;
    }

    @Override
    public void run(Treadmill treadmill) {
        if (treadmill.getDistance() <= maxlength) {
            result = true;
            System.out.println("Пробежал");
        } else {
            result = false;
            System.out.println("Не пробежал");
        }
    }

    @Override
    public void jump(Wall wall) {
        if (wall.getHeight() < maxHeight) {
            result = true;
            System.out.println("Перепрыгнул");
        } else {
            result = false;
            System.out.println("Не перепрыгнул");
        }
    }
    @Override
    public boolean isResult() {
        return result;
    }
}
