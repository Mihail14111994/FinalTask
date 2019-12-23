package driverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class DriverFactory {

    static WebDriver driver = null;

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

            switch (browserName) {
                case "CHROME":
                    if (driver == null) {
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver();
                    }
                    break;
                case "IE":
                    if (driver == null) {
//                        InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions()
//                                .introduceFlakinessByIgnoringSecurityDomains()
//                                .disableNativeEvents()
//                                .ignoreZoomSettings()
//                                .enablePersistentHovering()
//                                .destructivelyEnsureCleanSession()
//                                .setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
//                        InternetExplorerDriverService ieService;
//                        ieService = new InternetExplorerDriverService.Builder()
//                                .usingAnyFreePort()
//                                .build();
//                        ieService.start();
//                        DesiredCapabilities ieCap = DesiredCapabilities.internetExplorer();
//                        ieCap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                        WebDriverManager.iedriver().setup();
                        driver = new InternetExplorerDriver();
                    }
                    break;
                default:
                    throw new NullPointerException("Wrong Browser Name!");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return driver;
    }

    public static void setDriverNull() {
        driver = null;
    }
}
