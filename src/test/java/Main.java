
import driverFactory.DriverFactory;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main extends DriverFactory {
    @Test
    public void run() throws InterruptedException {

        WebDriver driver = newDriver();
        WebDriverWait wait = new WebDriverWait(driver, 2);
        driver.get("https://fest.md/");


    }
}
