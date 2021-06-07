package Lesson6_7;

public class Dish {
    //Объём миски
    private int volume;
    //Количество еды
    private int amountOfFood;

    //Конструктор класса с заданием объёма миски
    public Dish(int volume) {
        if (volume < 1) {
            throw new IllegalArgumentException("Объём миски не может быть таким маленьким!");
        }
        this.volume = volume;
    }

    //Метод добавления корма в миску
    public void addEat(int quantity) {
        if (amountOfFood + quantity > volume) {
            throw new IllegalArgumentException("Корм пересыпается через край!\nОбъем корма не может превышать объём тарелки!");
        } else if (quantity < 1) {
            throw new IllegalArgumentException("Количество еды должно быть положительным!");
        } else {
            amountOfFood +=quantity;
        }
    }

    //Метод кормления
    public int feed(int eating) {
        if (eating > amountOfFood) {
            return 0;
        } else {
            amountOfFood -=eating;
           return eating;
        }
    }

    public int getAmountOfFood() {
        return amountOfFood;
    }
}
