package x.util;

import java.util.Properties;

public class PropertyX {
    private Properties props;

    public PropertyX(Properties props) {
        this.props = props;
    }

    public String getRequired(String key) {
        String value = this.props.getProperty(key);
        if (value == null) {
            throw new RuntimeException("No data for required key '" + key + "'");
        } else {
            return value;
        }
    }

    public String get(String key) {
        return this.props.getProperty(key);
    }

    public String get(String key, String defaultValue) {
        String value = this.get(key);
        return value == null ? defaultValue : value;
    }

    public int getInt(String key) {
        String value = this.get(key);
        return Integer.parseInt(value);
    }

    public long getLong(String key) {
        String value = this.get(key);
        return Long.parseLong(value);
    }
}
