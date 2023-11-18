package x.type;

/**
 * 变量
 */
public class Variable {
    /**
     * 给变量赋予默认值
     */
    public static <T> T get(T value, T defalutValue) {
        return value == null ? defalutValue : value;
    }
}

