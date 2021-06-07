package Lesson8;

public class Wall implements IWall {

    private int height;

    public Wall(int height) {
        this.height = height;
    }
@Override
    public int getHeight() {
        return height;
    }
}
