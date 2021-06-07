package Lesson8;

public interface IAction {
    void run(Treadmill treadmill);
    void jump(Wall wall);
    boolean isResult();
}
