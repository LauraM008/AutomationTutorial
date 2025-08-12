package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertFrameWindowPage extends BasePage{

    public AlertFrameWindowPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Alerts']")
    public WebElement alertsElements;
    @FindBy(xpath = "//span[text()='Frames']")
    public WebElement framesElements;
    @FindBy(xpath = "//span[text()='Browser Windows']")
    public WebElement elementBrowserWindows;

    public void interactWithAlertsSubmenu(){
        elementHelper.clickElement(alertsElements);
    }
    public void interactWithFramesSubmenu(){
        elementHelper.clickElement(framesElements);
    }
    public void interactWithWindowsSubmenu(){ elementHelper.clickElement(elementBrowserWindows);}
}