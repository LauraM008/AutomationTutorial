package tests;

import helperMethods.ElementHelper;
import helperMethods.TabHelper;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import sharedData.SharedData;

public class WindowsTest extends SharedData {

    @Test
    public void testMethod() {

        ElementHelper elementHelper = new ElementHelper(driver);
        TabHelper tabHelper = new TabHelper(driver);

        WebElement alertFrameWindows = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementHelper.clickElement(alertFrameWindows);

        WebElement elementsBrowserWindows = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        elementHelper.clickElement(elementsBrowserWindows);

        WebElement newTab = driver.findElement(By.id("tabButton"));
        elementHelper.clickElement(newTab);

        tabHelper.switchToSpecificTab(1);
        //inchidem tabul curent
        tabHelper.closeCurrentTab();
        tabHelper.switchToSpecificTab(0);

        WebElement newWindow = driver.findElement(By.id("windowButton"));
        elementHelper.clickElement(newWindow);

        tabHelper.switchToSpecificTab(1);
        tabHelper.closeCurrentTab();
        tabHelper.switchToSpecificTab(0);
    }
}
