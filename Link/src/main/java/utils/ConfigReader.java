package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties = new Properties();

    public static void loadProperties(String env) {    	
        try (FileInputStream fis = new FileInputStream("src/test/resources/config/" + env + ".properties")) {
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Could not load properties for environment: " + env, e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
