package driverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class DriverManager {
    protected static WebDriver driver;
    @BeforeAll
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
    }
    @AfterAll
    public static void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }



}
