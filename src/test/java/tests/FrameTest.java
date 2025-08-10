package tests;

import helperMethods.ElementHelper;
import helperMethods.FrameHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import sharedData.SharedData;

public class FrameTest extends SharedData {

    @Test
    public void testMethod() {

        ElementHelper elementHelper = new ElementHelper(driver);
        FrameHelper frameHelper = new FrameHelper(driver);

        WebElement alertFrameWindowsElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementHelper.clickElement(alertFrameWindowsElement);

        WebElement frameElement = driver.findElement(By.xpath("//span[text()='Frames']"));
        elementHelper.clickElement(frameElement);

        frameHelper.switchToFrameByElement(driver.findElement(By.xpath("//iframe[@id='frame1']")));

        WebElement firstBlockElement = driver.findElement(By.id("sampleHeading"));
        elementHelper.printTextElement(firstBlockElement);

        frameHelper.switchToParentFrame();

        frameHelper.switchToFrameByString("frame2");

        WebElement secondBlockElement = driver.findElement(By.id("sampleHeading"));
        elementHelper.printTextElement(secondBlockElement);
    }
}