import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.File;

public class ConfigurationTest {
    public static void main(String[] args) {
        Configurations configs = new Configurations();

        try {
            Configuration config = configs.properties(new File("application-dev.properties"));

            // 访问配置
            String host = config.getString("postgres.host");
            int port = config.getInt("postgres.port");
            String database = config.getString("postgres.database");
            String username = config.getString("postgres.username");
            String password = config.getString("postgres.password");
            long timeout = config.getLong("postgres.timeout");
            System.out.println(host + "\t" + port + "\t" + database + "\t" + username + "\t" + password + "\t" + timeout);

            // 更新配置
            config.setProperty("postgres.port", 54321);
            config.addProperty("postgres.type", "production");
            System.out.println(config.getInt("postgres.port") + "\t" + config.getString("postgres.type"));

            // 保存配置
            FileBasedConfigurationBuilder<PropertiesConfiguration> builder = configs.propertiesBuilder("application-dev.properties");
            PropertiesConfiguration pconfig = builder.getConfiguration();
            pconfig.addProperty("postgres.type", "production");

            builder.save();
        } catch (ConfigurationException cex) {
            cex.printStackTrace();
        }
    }
}
