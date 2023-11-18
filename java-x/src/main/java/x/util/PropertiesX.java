package x.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/**
 * 说明：
 * 1. 如果希望 Log4j2.xml 可以读写到应用程序的 Properties，这里不能使用 Log4j2 & SLF4J API
 */
public class PropertiesX {
    //------------------------------------------------------------------------
    // utils
    //------------------------------------------------------------------------

    /**
     * 加载 Properties 文件
     */
    public static Properties load() {
        return System.getProperties();
    }

    /**
     * 读取 Properties 文件
     */
    public static Properties readPropertiesFile(String fileName) {
        FileInputStream fis = null;
        Properties props = null;

        try {
            fis = new FileInputStream(fileName);
            props = new Properties();
            props.load(fis);
        } catch (FileNotFoundException fnfe) {
            System.out.println(String.format("没有找到 %s 文件", fileName));
        } catch (IOException e) {
            System.out.println(String.format("加载属性文件 %s 异常", fileName));
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException ioe) {
                    System.out.println(String.format("关闭属性文件 %s 异常", fileName));
                }
            }
        }
        return props;
    }

    /**
     * 将 Properties 添加到 System Properties，相同时 Properties 覆盖 System Properties
     * 注：System.setProperties(...) 会完全覆盖 System Properties
     */
    public static void putToSystem(Properties props) {
        // or: System.setProperties(merge(System.getProperties(), props))
        System.getProperties().putAll(props);
    }

    /**
     * 将 System Properties 添加到 Properties，相同时 System Properties 覆盖 Properties
     */
    public static void mergeWithSystem(Properties props) {
        // or: System.setProperties(merge(System.getProperties(), props))
        props.putAll(System.getProperties());
        System.setProperties(props);
    }

    /**
     * 合并多个 Properties，相同的部分后者覆盖前者
     */
    public static Properties merge(Properties... propsList) {
        Properties finalProps = new Properties();
        for (Properties props: propsList) {
            finalProps.putAll(props);
        }
        return finalProps;
    }

    /**
     * 通过前缀获取 Properties 子集
     */
    public static Properties getPropertiesByPreffix(Properties properties, String preffix) {
        Properties finalProperties = new Properties();
        properties.forEach((k, v) -> {
            String key = String.valueOf(k); // Object to String
            String value = String.valueOf(v);
            if (key.startsWith(preffix)) {
                finalProperties.put(key, value);
            }
        });
        return finalProperties;
    }

    /**
     * 通过前缀获取 Properties 子集，但最终去除前缀
     */
    public static Properties getPropertiesByPreffixWithoutPreffix(Properties properties, String preffix) {
        Properties finalProperties = new Properties();
        Set<Object> keys = properties.keySet();
        for (Object keyObject: keys) {
            String key = String.valueOf(keyObject);
            if (key.startsWith(preffix)) {
                String keyWithoutPreffix = key.substring(preffix.length());
                finalProperties.put(keyWithoutPreffix, properties.getProperty(key));
            }
        }
        return finalProperties;
    }

    //-------------------------------------------------------------------------
    // Getter
    //-------------------------------------------------------------------------
    public int getIntProperty() {
        return 0;
    }

    public long getLongProperty() {
        return 0L;
    }


}
