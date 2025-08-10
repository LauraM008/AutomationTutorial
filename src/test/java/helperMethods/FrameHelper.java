package helperMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameHelper {
    public WebDriver driver;

    public FrameHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToFrameByElement(WebElement element) {
        driver.switchTo().frame(element);
    }

    public void switchToFrameByString(String frameName) {
        driver.switchTo().frame(frameName);
    }

    public void switchToParentFrame() {
        driver.switchTo().parentFrame();
    }
}
