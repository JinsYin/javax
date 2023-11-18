package x;

public final class ConfigurationX {
    /**
     * 初始化应用程序配置文件
     */
    public static void init() {
        String defualtConfigFile = "src/main/resources/application.properties";
        String appConfigFile = Variable.get(System.getProperty("app.configurationFile"), defualtConfigFile);
        // 添加应用程序属性到 System 全局属性中
        PropertiesX.addPropertiesToSystem(PropertiesX.readPropertiesFile(appConfigFile));
    }
}
