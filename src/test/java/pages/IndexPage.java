package pages;

import helperMethods.ElementHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage extends BasePage{

    public IndexPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']")
    public WebElement elementAlertsFrameWindows;
    @FindBy(xpath ="//h5[text()='Elements']" )
    public WebElement elementsMenu;
    @FindBy(xpath = "//h5[text()='Forms']")
    WebElement elementForms;


    public void interactWithAlertsFrameWindowMenu(){
        elementHelper.clickElement(elementAlertsFrameWindows);
    }

    public void interactWithElementsMenu(){ elementHelper.clickElement(elementsMenu);}

    public void interactWithFormsMenu(){ elementHelper.clickElement(elementForms); }
}