
import driverFactory.DriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main extends DriverManager {
    @Test
    public void run() throws InterruptedException {

//        WebDriver driver = new ChromeDriver();
        driver.get("https://fest.md/");

        WebDriverWait wait = new WebDriverWait(driver, 60);
//        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
