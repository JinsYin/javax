package x.lang;

public final class SystemX {
    /**
     * 当对象为 null 时终止程序
     */
    public static void exitIfNull(Object obj) {
        if (obj == null) {
            System.exit(0);
        }
    }

    /**
     * 当对象为 true 时终止程序
     */
    public static void exitIfTrue(boolean bool) {
        if (bool) {
            System.exit(0);
        }
    }

    /**
     * 对象为空时退出
     */
    public static void exitIfNull(Object obj, int exitCode, String outInfo) {
        if (obj == null) {
            System.out.println(outInfo);
            System.exit(exitCode);
        }
    }

    /**
     * 两个对象相等时退出
     */
    public static void exitIfEqual(Object obj1, Object obj2, int exitCode, String outInfo) {
        if ( (obj1 == null && obj2 == null) || (obj1 != null && obj1.equals(obj2)) ) {
            System.out.println(outInfo);
            System.exit(exitCode);
        }
    }

    //------------------------------------------------------------------------
    // Properties
    //------------------------------------------------------------------------

    public static String getStringProperty(String name) {
        return System.getProperty(name);
    }

    public static int getIntProperty(String name) {
        return System.getProperty(name) == null
                ? 0
                : Integer.parseInt(System.getProperty(name));
    }

    public static long getLongProperty(String name) {
        return System.getProperty(name) == null
                ? 0L
                : Long.parseLong(System.getProperty(name));
    }

    public static boolean getBoolProperty(String name) {
        return System.getProperty(name) != null
                && Boolean.parseBoolean(System.getProperty(name));
    }
}
