package Lesson14;

import com.sun.org.apache.bcel.internal.generic.SWITCH;

import static java.lang.System.arraycopy;

public class ArrCutter {

    public static int[] forArr(int[] arr) {

        int pos = -1;

        int lArr = arr.length - 1;

        for (int i = lArr; i >= 0; i--) {
            if (arr[i] == 4) {
                pos = i;
                break;
            }
        }

        int[] tmpArr;

        if (pos != -1) {

            int length = lArr - pos;

            if (length == 0) {
                throw new IllegalArgumentException("Выходной массив нулевой длины");
            }

            tmpArr = new int[length];

            arraycopy(arr, pos + 1, tmpArr, 0, length);
            return tmpArr;

        } else {
            throw new IllegalArgumentException("В массиве отсутствуют червёрки");
        }
    }

    public static boolean checkOneAndFor(int[] arr) {

        boolean have1 = false;
        boolean have4 = false;

        for (int val : arr) {

            if (val != 1 && val != 4) {
                return false;
            }

            if (!have1 && val == 1) {
                have1 = true;
            }

            if (!have4 && val == 4) {
                have4 = true;
            }
        }

        if (have1 && have4) {
            return true;
        } else {
            return false;
        }
    }
}
