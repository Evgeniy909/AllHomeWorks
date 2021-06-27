package Lesson14;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrCutterTest {

    //проходит
    @Test
    public void forArrOk() {
        Assert.assertArrayEquals(new int[]{5, 5, 1}, ArrCutter.forArr(new int[]{1, 3, 4, 5, 5, 1}));
    }

    //не проходит
    @Test
    public void forArrNotOk() {
        Assert.assertArrayEquals(new int[]{5, 5, 1}, ArrCutter.forArr(new int[]{1, 3, 2, 4, 5, 1}));
    }

    // Тут я пытался сделать проверку на исключение, но не понял как это делать
    // Предполагаю, что исключение должно передаваться наверх и тогда будет работать, но не уверен.

    //@Test
    //public void forArrEx() {
    //    Assert.assertThrows("Выходной массив нулевой длины", ArrCutter.forArr(new int[]{1, 3, 2, 4, 5, 4}));
    //}

    //проходит
    @Test
    public void checkOneAndForOk() {
        Assert.assertTrue(ArrCutter.checkOneAndFor(new int[]{1, 1, 4, 4, 1, 1}));
    }

    //не проходит
    @Test
    public void checkOneAndForNotOk() {
        Assert.assertTrue(ArrCutter.checkOneAndFor(new int[]{1, 1, 2, 4, 1, 1}));
    }

    //не проходит
    @Test
    public void checkOneAndForWithOut1() {
        Assert.assertTrue(ArrCutter.checkOneAndFor(new int[]{4, 4, 4, 4, 4, 4}));
    }

    //не проходит
    @Test
    public void checkOneAndForWithOut4() {
        Assert.assertTrue(ArrCutter.checkOneAndFor(new int[]{1, 1, 1, 1, 1, 1}));
    }
}