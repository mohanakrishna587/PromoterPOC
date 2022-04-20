package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {

    public String getProperty(String propName) {
        String prop = "";
        try {
            File reader = new File(System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties");
            FileInputStream inputStream = null;
            Properties properties = new Properties();
            inputStream = new FileInputStream(reader);
            properties.load(inputStream);
            prop =  properties.getProperty(propName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    public ConfigProperties() throws FileNotFoundException {
    }
}
