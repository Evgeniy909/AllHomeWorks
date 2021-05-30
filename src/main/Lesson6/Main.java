package Lesson6;

public class Main {
    public static void main(String[] args) {

        Cat cat = new Cat("Барсик",3,200,2);
        cat.run(250);
        cat.jump(2);
        System.out.println("");

        Cat bigCat = new Cat("Пикси",4,300,2.6);
        bigCat.run(250);
        bigCat.jump(2);
        System.out.println("");

        Dog dog = new Dog("Брут",5,500,0.5,10);
        dog.run(100);
        dog.jump(2);
        dog.toSail(10);
        System.out.println("");

        Dog bigDog = new Dog("Мухтар",10,1000,3,100);
        bigDog.run(100);
        bigDog.jump(2);
        bigDog.toSail(99);
    }
}