package actionMethods;

import driverFactory.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Screenshot {

    private Screenshot() {
        throw new IllegalStateException("Utility class");
    }

    public static void takeScreenshot() throws IOException {
        WebDriver driver = DriverFactory.getDriver();
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        String path = PropertiesFileConfig.configProperties("pathForScreenshots");
        File destFile = new File(path + File.separator + "scenarioName" + File.separator + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss")) + ".jpg");
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, destFile);
    }
}
