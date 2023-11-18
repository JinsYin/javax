package x.type;

import x.annotation.NotNull;

import java.util.Random;

/**
 * 扩展数组
 */
public class ArrayX {

    /**
     * 随机返回一个数组索引
     */
    public static <T> int randIndex(@NotNull T[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("The array is null or empty");
        }
        // 范围是 [0, arr.length)
        return (new Random()).nextInt(arr.length - 1);
    }

    /**
     * 随机返回一个数组元素
     */
    public static <T> T randElem(@NotNull T[] arr) {
        return arr[randIndex(arr)];
    }
}
