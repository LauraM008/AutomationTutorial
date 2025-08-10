package tests;

import helperMethods.AlertHelper;
import helperMethods.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import sharedData.SharedData;

public class AlertsTest extends SharedData {

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

        alertHelper.acceptAlert();

        WebElement alertWaitButtonElement = driver.findElement(By.id("timerAlertButton"));
        elementHelper.clickElement(alertWaitButtonElement);

        alertHelper.acceptAlert();

        WebElement alertOkCancelElement = driver.findElement(By.id("confirmButton"));
        elementHelper.clickElement(alertOkCancelElement);

        alertHelper.dismissAlert();

        WebElement alertPromptElement = driver.findElement(By.id("promtButton"));
        elementHelper.clickElement(alertPromptElement);

        alertHelper.fillAlert("Dumniezai");
    }
}