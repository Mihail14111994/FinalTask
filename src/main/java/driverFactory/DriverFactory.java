package driverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class DriverFactory {
    static WebDriver driver = null;
    static Logger logger = Logger.getLogger(DriverFactory.class);
    public static WebDriver getDriver() {
        InputStream inputStream;
        try {
            Properties prop = new Properties();
            String propFileName = "config.properties";

            inputStream = DriverFactory.class.getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
            String browserName = prop.getProperty("browserName");

            switch (browserName.toUpperCase()) {
                case "CHROME":
                    if (driver == null) {
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver();
                    }
                    break;
                case "IE":
                    if (driver == null) {
                        System.setProperty("webdriver.ie.driver", "C:\\Users\\dospataru\\Downloads\\IEDriverServer_x64_3.150.1\\IEDriverServer.exe");
                        InternetExplorerOptions ieOptions = new InternetExplorerOptions()
                                .destructivelyEnsureCleanSession();
                        ieOptions.setCapability("se:ieOptions", ieOptions);
                        ieOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                        ieOptions.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                        driver=new InternetExplorerDriver(ieOptions);
                    }
                    break;
                default:
                    throw new NullPointerException("Wrong Browser Name!");
            }
        } catch (Exception e) {
            logger.error(e);
        }
        return driver;
    }

    public static void setDriverNull() {
        driver = null;
    }
}
