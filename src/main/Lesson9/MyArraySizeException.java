package Lesson9;

public class MyArraySizeException extends CustomException{
    public MyArraySizeException() {
        super("Размер массива задан не корректно!\nЗадайте рзамер массива равным 4X4");
    }
}
