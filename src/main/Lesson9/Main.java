package Lesson9;

public class Main {

    public static void main(String[] args) {

        String arr[][] = new String[][]

                {
                        {"1", "2", "3", "4"},
                        {"5", "6", "7"},
                        {"9", "0", "4", "1"},
                        {"3", "7", "2", "D"}
                };

        try {
            System.out.println("Сумма значений массива: " + arr(arr));
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int arr(String arr[][]) throws CustomException {

        //Проверяем размерность массива
        if (arr.length != 4) {
            throw new MyArraySizeException();
        }

        for (int i = 0; i < arr.length; i++) {

            if (arr[i].length != 4) {
                throw new MyArraySizeException();
            }
        }

        //Суммируем все значения массива

        int s = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {

                try {
                    s += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j, arr[i][j]);
                }
            }
        }
        return s;
    }
}