package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class FormsPage extends BasePage{

    public FormsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath= "//span[text()='Practice Form']")
    public WebElement elementPracticeForm;

    public void interactWithPracticeFormsSubmenu(){
        elementHelper.clickElement(elementPracticeForm);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}