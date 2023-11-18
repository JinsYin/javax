package x.type;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ArrayXTest {
    String[] arr;

    @BeforeTest
    public void before() {
        arr = new String[]{"a1", "a2", "a3", "a3", "a4", "a5", "a6"};
    }

    //------------------------------------------------------------------------
    // 正常情况
    //------------------------------------------------------------------------

    @Test
    public void randIndex() {
        System.out.println(ArrayX.randIndex(arr));
        System.out.println(ArrayX.randIndex(arr));
    }

    @Test
    public void randElem() {
        System.out.println(ArrayX.randElem(arr));
        System.out.println(ArrayX.randElem(arr));
    }

    //------------------------------------------------------------------------
    // 异常情况
    //------------------------------------------------------------------------

    // 将抛出 IllegalArgumentException 异常
    @Test
    public void randIndexExp1() {
        String[] arr1 = null; // 数组为 null
        System.out.println(ArrayX.randIndex(arr1));
    }

    // 将抛出 IllegalArgumentException 异常
    @Test
    public void randIndexExp2() {
        String[] arr2 = {}; // 数组为空
        System.out.println(ArrayX.randIndex(arr2));
    }

    // 将抛出 IllegalArgumentException 异常
    @Test
    public void randElemExp1() {
        String[] arr1 = null; // 数组为 null
        System.out.println(ArrayX.randElem(arr1));
    }

    // 将抛出 IllegalArgumentException 异常
    @Test
    public void randElemExp2() {
        String[] arr2 = {}; // 数组为空
        System.out.println(ArrayX.randElem(arr2));
    }
}
