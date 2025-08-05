package tests;

import helperMethods.AlertHelper;
import helperMethods.ElementHelper;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.time.Duration;

public class AlertsTest extends SharedData {

    public WebDriver driver;

    @Test
    public void testMethod() {

        ElementHelper elementHelper = new ElementHelper(driver);
        AlertHelper alertHelper = new AlertHelper(driver);

        WebElement alertFrameWindowsElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementHelper.clickElement(alertFrameWindowsElement);

        WebElement alertElement = driver.findElement(By.xpath("//span[text()='Alerts']"));
        elementHelper.clickElement(alertElement);

        WebElement alertOkButtonElement = driver.findElement(By.id("alertButton"));
        elementHelper.clickElement(alertOkButtonElement);

        Alert alertOk = driver.switchTo().alert();
        alertHelper.acceptAlert();

        WebElement alertWaitButtonElement = driver.findElement(By.id("timerAlertButton"));
        alertWaitButtonElement.click();

        //wait explicit pt alerta
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alertWait = driver.switchTo().alert();
        alertHelper.acceptAlert();

        WebElement alertOkCancelElement = driver.findElement(By.id("confirmButton"));
        elementHelper.clickElement(alertOkCancelElement);

        Alert alertOkCancel = driver.switchTo().alert();
        alertHelper.dismissAlert();

        WebElement alertPromptElement = driver.findElement(By.id("promtButton"));
        elementHelper.clickElement(alertPromptElement);

        alertHelper.fillAlert("Dumniezai");

        driver.quit();
    }
}