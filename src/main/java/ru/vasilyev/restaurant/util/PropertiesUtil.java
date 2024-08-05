package ru.vasilyev.restaurant.util;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;


public class PropertiesUtil {
    public static final Properties PROPERTIES = new Properties();
    public static final String PROPERTIES_FILE = "application.properties";

    static {
        loadProperties();
    }

    public PropertiesUtil() {
    }

    public static String getProperties(String key) {
        return PROPERTIES.getProperty(key);
    }

    private static void loadProperties() {
        try (InputStream inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            PROPERTIES.load(inputStream);
        } catch (Exception exception) {
            throw new IllegalStateException();
        }
    }
}
