package Lesson9;

public class MyArrayDataException extends CustomException {

    public MyArrayDataException(int x,int y,String dat) {
        super("Не корректные данные в массиве по адресу [" + x + "][" + y + "]" +
                "\nЗначение '" + dat + "' не возможно преобразовать в число" );
    }
}
