package actionMethods;

import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class RandomLink {
    private static final Random randomInt = new Random();

    public static WebElement randomLink(List<WebElement> links) {
        int size = links.size();
        if (size == 0) return null;
        return links.get(randomInt.nextInt(size));
    }

}
