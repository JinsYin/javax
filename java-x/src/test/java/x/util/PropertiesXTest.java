package x.util;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Properties;

public class PropertiesXTest {
    private Properties properties;

    @BeforeTest
    public void before() {
        properties = new Properties();
        properties.setProperty("name", "PropertiesXTest"); // 自定义的
        properties.setProperty("os.name", "MYOS");        // JVM 的
    }

    @Test
    public void mergeProperties() {
        Properties props1 = new Properties();
        props1.setProperty("timeout", "60000");

        Properties props = PropertiesX.merge(properties, props1);
        props.list(System.out);
    }

    @Test
    public void addToSystem() {
        PropertiesX.putToSystem(properties);

        // success => JVM 属性被替换
        Assert.assertEquals(System.getProperties().getProperty("os.name"), "MYOS");
    }

    @Test
    public void getPropertiesByPreffix() {
        Properties properties = new Properties();
        properties.put("kafka.topic", "tpc");
        properties.put("kafka.group.id", "tpc");
        properties.put("kafka.boostrap.servers", "192.168.1.100:9092");
        properties.put("app.name", "Job");

        Properties kafkaPropertes = PropertiesX.getPropertiesByPreffix(properties, "kafka");

        kafkaPropertes.forEach((k, v) -> {
            System.out.println(k + "=" + v);
        });

        kafkaPropertes.list(System.out);
    }

    @Test
    public void getPropertiesByPreffixWithoutPreffix() {
        Properties properties = new Properties();
        properties.put("kafka.topic", "tpc");
        properties.put("kafka.group.id", "tpc");
        properties.put("kafka.boostrap.servers", "192.168.1.100:9092");
        properties.put("app.name", "Job");

        Properties kafkaPropertes = PropertiesX.getPropertiesByPreffixWithoutPreffix(properties, "kafka.");

        kafkaPropertes.forEach((k, v) -> {
            System.out.println(k + "=" + v);
        });

        kafkaPropertes.list(System.out);
    }
}
