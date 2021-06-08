package Lesson8;

public class Wall implements IBarrier {

    private int height;

    public Wall(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }
}
