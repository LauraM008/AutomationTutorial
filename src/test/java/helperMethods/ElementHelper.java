package helperMethods;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class ElementHelper {
    public WebDriver driver;

    public ElementHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void clickElement (WebElement element){
        element.click();
    }

    public void printTextElement(WebElement element){
        System.out.println(element.getText());
    }

    public void fillElement(WebElement element, String value){
        element.sendKeys(value);
    }

    public void pressElement(WebElement element, Keys value){
        element.sendKeys(value);
    }

    public void validateListSize(List<WebElement> elementsList, int expectedSize){
        Assert.assertEquals(elementsList.size(), expectedSize, "Actual elements list size: " + elementsList.size() + " is different than " + expectedSize );
    }

    public void validateElementContainsText(WebElement element, String expectedText){
        Assert.assertTrue(element.getText().contains(expectedText), "Actual element text: " + element.getText() + " is different than " + expectedText);
    }

    public void validateElementEqualsText(WebElement element, String expectedText){
        Assert.assertEquals(element.getText(), expectedText, "Actual element text: " + element.getText() + " is different than " + expectedText);
    }

    public void clearElement(WebElement element){
        element.clear();
    }

    public void clearFillElement(WebElement element, String value){
        clearElement(element);
        fillElement(element,value);
    }

    public void fillPressElement(WebElement element, String value, Keys keyValue){
        fillElement(element, value);
        pressElement(element, keyValue);
    }

    public void waitVisibleElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitVisibleList(List<WebElement> elementsList){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfAllElements(elementsList));
    }

}