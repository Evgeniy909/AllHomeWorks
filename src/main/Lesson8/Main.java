package Lesson8;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        //Препятствия
        IBarrier[] barriers = new IBarrier[2];

        //Спортсмены
        IAction[] testSubjects = new IAction[9];

        Random random = new Random();

        int length;
        int height;

        //Заполнение полосы препятствий
        for (int i = 0; i < barriers.length; i++) {

            length = random.nextInt(100);
            height = random.nextInt(10);

            if (i < barriers.length / 2) {
                barriers[i] = new Treadmill(length);
            } else {
                barriers[i] = new Wall(height);
            }
        }

        //Заполнение участников соревнований
        for (int i = 0; i < testSubjects.length; i++) {

            length = random.nextInt(150);
            height = random.nextInt(11);

            if (i < testSubjects.length / 3) {
                testSubjects[i] = new Man(length, height);
            } else if (i > testSubjects.length / 3 && i <= testSubjects.length - (testSubjects.length / 3)) {
                testSubjects[i] = new Cat(length, height);
            } else {
                testSubjects[i] = new Robot(length, height);
            }
        }

        for (int i = 0; i < testSubjects.length; i++) {

            System.out.println("участник " + i);

            if (barriers[0] instanceof Treadmill) {
                Treadmill treadmill = (Treadmill) barriers[0];
                testSubjects[i].run(treadmill);
                if (!testSubjects[i].isResult()) {
                    continue;
                }
            }

            if (barriers[1] instanceof Wall) {
                Wall wall = (Wall) barriers[1];
                testSubjects[i].jump(wall);
                if (!testSubjects[i].isResult()) {
                    continue;
                }
            }

        }

    }
}
