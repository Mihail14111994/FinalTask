package driverFactory;

import actionMethods.PropertiesFileConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.io.FileNotFoundException;

public class DriverFactory {
    private static WebDriver driver = null;
    private static Logger logger = Logger.getLogger(DriverFactory.class);
    public static WebDriver getDriver() {

        String browserName = null;
        try {
            browserName = PropertiesFileConfig.configProperties("browserName");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        switch (browserName.toUpperCase()) {
                case "CHROME":
                    if (driver == null) {
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver();
                    }
                    break;
                case "IE":
                    if (driver == null) {
                      //  System.setProperty("webdriver.ie.driver", "C:\\Users\\dospataru\\Downloads\\IEDriverServer_x64_3.150.1\\IEDriverServer.exe");
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
        return driver;
    }

    public static void setDriverNull() {
        driver = null;
    }
}
