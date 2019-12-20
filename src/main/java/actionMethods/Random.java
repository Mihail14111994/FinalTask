package actionMethods;

import org.openqa.selenium.WebElement;

import java.util.List;

public class Random {
    public static WebElement randomLink(List<WebElement> links) {
        int listSize = links.size();
        java.util.Random r = new java.util.Random();
        int linkNo = r.nextInt(listSize);
        WebElement link = links.get(linkNo);
        return link;
    }

}
