package configuration;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.File;

public class AppConfiguration {
    /**
     * 初始化配置文件
     */
    public static void load() {
        // 来自 JVM 的配置文件路径参数
        String configFilePath = System.getProperty("app.configurationFile");


    }

    /**
     * 获取 properties 配置文件
     */
    public static Configuration getPropConfig(String propFileName) throws ConfigurationException {
        Configurations configs = new Configurations();
        return configs.properties(new File(propFileName));
    }
}
