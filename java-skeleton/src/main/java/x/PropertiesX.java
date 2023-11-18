package x;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * 说明：
 * 1. 如果希望 Log4j2.xml 可以读写到应用程序的 Properties，这里不能使用 Log4j2 & SLF4J API
 */
public class PropertiesX {
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
     * 将应用程序的属性添加到 System 全局属性
     */
    public static void addPropertiesToSystem(Properties props) {
        // JVM 属性
        Properties jvmProps = System.getProperties();
        // 合并应用属性和 JVM 属性，相同的部分应用属性覆盖 JVM 属性
        Properties finalProps = mergeProperties(jvmProps, props);
        // 直接 setProperties 将完全覆盖 JVM 的属性，导致异常错误
        System.setProperties(finalProps);
    }

    /**
     * 合并多个 Properties，相同的部分后者覆盖前者
     */
    public static Properties mergeProperties(Properties... propsList) {
        Properties finalProps = new Properties();
        for (Properties props: propsList) {
            finalProps.putAll(props);
        }
        return finalProps;
    }



}
