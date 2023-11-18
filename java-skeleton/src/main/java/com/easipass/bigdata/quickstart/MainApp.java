package com.easipass.bigdata.quickstart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import x.ConfigurationX;


public class MainApp {
    // 确保 Log4j2.xml 可以读取到 application.properties 中的配置
    // 并且该函数不得调用 Log4j2 API
    static {
        ConfigurationX.init();
    }
    private static final Logger logger = LoggerFactory.getLogger(MainApp.class);

    public static void main(String[] args) {
        System.out.println(System.getProperty("app.name"));
    }
}
