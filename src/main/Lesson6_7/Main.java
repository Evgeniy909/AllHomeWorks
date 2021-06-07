package Lesson6_7;

public class Main {
    public static void main(String[] args) {

        Dish generalDish = new Dish(200);
        generalDish.addEat(150);

        Cat cat = new Cat("Барсик",3,200,2,40);
        Cat bigCat = new Cat("Пикси",4,300,2.6,50);
        Dog dog = new Dog("Брут",5,500,0.5,10,100);
        Dog bigDog = new Dog("Мухтар",10,1000,3,100,150);

        Animal[] animals = new Animal[4];

        animals[0] = cat;
        animals[1] = bigCat;
        animals[2] = dog;
        animals[3] = bigDog;

        System.out.println("Изначально в миске еды: " + generalDish.getAmountOfFood());

        for (int n = 0; n < animals.length; n++) {

            if (!animals[n].isSatiety()) {
                animals[n].eating(generalDish);
            }
            System.out.println("Сытость " + animals[n].getName() + ": =" + animals[n].isSatiety());
        }

        System.out.println("В миске осталось еды: " + generalDish.getAmountOfFood());

    }
}