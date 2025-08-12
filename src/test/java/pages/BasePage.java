package pages;

import helperMethods.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public WebDriver driver;
    public ElementHelper elementHelper;
    public AlertHelper alertHelper;
    public FrameHelper frameHelper;
    public PageHelper pageHelper;
    public TabHelper tabHelper;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
        alertHelper = new AlertHelper(driver);
        frameHelper = new FrameHelper(driver);
        pageHelper = new PageHelper(driver);
        tabHelper = new TabHelper(driver);
        PageFactory.initElements(driver,this);
    }
}