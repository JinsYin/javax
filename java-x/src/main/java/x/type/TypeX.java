package x.type;

/**
 * Type Converter
 * https://blog.csdn.net/huangbaokang/article/details/100902104
 * https://blog.csdn.net/zte1055889498/article/details/88531552
 */
public class TypeX {

    // -----------------------------------------------------------------------
    // String
    // -----------------------------------------------------------------------

    public static String getString(Object object) {
        // Unlike `String.valueOf()`, its default value is null instead of "null"
        return getString(object, null);
    }

    public static String getString(Object obj, String defaultValue) {
        return (obj == null) ? defaultValue : obj.toString();
    }


    // -----------------------------------------------------------------------
    // Integer & int
    // -----------------------------------------------------------------------

    public static int getInt(Object object) {
        return getInt(object, 0);
    }

    public static int getInt(Object object, int defaultValue) {
        return 0;
    }

}
