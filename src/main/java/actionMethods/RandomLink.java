package actionMethods;

import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class RandomLink {
    public static WebElement randomLink(List<WebElement> links) {
        int size = links.size();
        if (size == 0) return null;
        Random randomInt = new Random();
        return links.get(randomInt.nextInt(size));
    }

}
