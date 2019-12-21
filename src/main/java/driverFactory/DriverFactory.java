package driverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;

public class DriverFactory {
    static WebDriver driver = null;

    public static WebDriver getDriver() {

        String browserName = System.getProperty("Browser", DriverType.CHROME.toString()).toUpperCase();
        DriverType driverType = DriverType.valueOf(browserName);
        switch (driverType) {
            case CHROME:
                if (driver == null) {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                }
                break;
            case IE:
                if (driver == null) {
                    InternetExplorerDriverService ieService;
                    ieService = new InternetExplorerDriverService.Builder()
                            .usingAnyFreePort()
                            .build();
                    try {
                        ieService.start();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    DesiredCapabilities ieCap = DesiredCapabilities.internetExplorer();
                    ieCap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver(ieCap);
                }
                break;
            default:
                if (driver == null) {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                }
                break;
        }
        return driver;
    }

    public static void setDriverNull() {
        driver = null;
    }
}
