package actionMethods;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screenshot {

    public static void takeScreenshot(WebDriver driver, String path) throws IOException {
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        File DestFile=new File(path);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(SrcFile, DestFile);
    }
}
