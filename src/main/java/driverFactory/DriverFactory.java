package driverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

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
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
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
