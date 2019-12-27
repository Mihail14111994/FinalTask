package actionMethods;

import driverFactory.DriverFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFileConfig {

    public static String configProperties (String key) throws FileNotFoundException {
        InputStream inputStream;
        String Value = null;
        try {
            Properties prop = new Properties();
            String propFileName = "config.properties";

            inputStream = DriverFactory.class.getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
            Value = prop.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Value;
    }
}
