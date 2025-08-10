package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.io.File;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class PracticeFormTest extends SharedData {

    @Test
    public void testMethod() {

        WebElement elementsForm = driver.findElement(By.xpath("//h5[text()='Forms']"));
        elementsForm.click();

        WebElement elementsPracticeForm = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        elementsPracticeForm.click();

        //Wait implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement firstnameElement = driver.findElement(By.cssSelector("input[placeholder ='First Name'"));
        String firstnameValue = "John";
        firstnameElement.sendKeys(firstnameValue);

        WebElement lastnameElement = driver.findElement(By.cssSelector("input[placeholder ='Last Name'"));
        String lastnameValue = "Doe";
        lastnameElement.sendKeys(lastnameValue);

        WebElement emailElement = driver.findElement(By.cssSelector("input[placeholder ='name@example.com'"));
        String emailValue = "johndoe@email.com";
        emailElement.sendKeys(emailValue);

        WebElement phoneElement = driver.findElement(By.cssSelector("input[placeholder ='Mobile Number'"));
        String phoneValue = "0721523885";
        phoneElement.sendKeys(phoneValue);

//        WebElement subjectsElement = driver.findElement(By.id("subjectsInput"));
//        String subjectsValue = "Accounting";
//        subjectsElement.sendKeys(subjectsValue);
//        subjectsElement.sendKeys(Keys.ENTER);
//        String subjectsValue2 = "Ar";
//        subjectsElement.sendKeys(subjectsValue2);
//        subjectsElement.sendKeys(Keys.ENTER);

        WebElement subjectsElement = driver.findElement(By.id("subjectsInput"));
        List<String> subjectsValue = Arrays.asList("Accounting", "Arts", "Maths");
        for (int index = 0; index < subjectsValue.size(); index++) {
            subjectsElement.sendKeys(subjectsValue.get(index));
            subjectsElement.sendKeys(Keys.ENTER);
        }

        String genderValue = "Female";
        List<WebElement> genderElementList = driver.findElements(By.cssSelector("div[id='genterWrapper']>div>div>label[class='custom-control-label']"));
        switch (genderValue) {
            case "Male":
                genderElementList.get(0).click();
                break;
            case "Female":
                genderElementList.get(1).click();
                break;
            case "Other":
                genderElementList.get(2).click();
                break;
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)", "");

        List<WebElement> hobbiesElementList = driver.findElements(By.cssSelector("div[id='hobbiesWrapper']>div>div>label[class='custom-control-label']"));
        List<String> hobbieValues = Arrays.asList("Reading", "Music");
        for (int index = 0; index < hobbiesElementList.size(); index++) {
            if (hobbieValues.contains(hobbiesElementList.get(index).getText())) {
                hobbiesElementList.get(index).click();
            }
        }

        WebElement uploadElement = driver.findElement(By.id("uploadPicture"));
        String uploadValue = "src/test/resources/poza.png";
        File file = new File(uploadValue);
        uploadElement.sendKeys(file.getAbsolutePath());

        WebElement currentAddressElement = driver.findElement(By.id("currentAddress"));
        String currentAddressValue = "Str. Campului 58, bl.7 BIS";
        currentAddressElement.sendKeys(currentAddressValue);

        JavascriptExecutor executor = (JavascriptExecutor) driver;

        WebElement stateElement = driver.findElement(By.id("state"));
        executor.executeScript("arguments[0].click();", stateElement);

        WebElement stateInputElement = driver.findElement(By.id("react-select-3-input"));
        String stateValue = "Uttar Pradesh";
        stateInputElement.sendKeys(stateValue);
        stateInputElement.sendKeys(Keys.ENTER);

        WebElement cityElement = driver.findElement(By.id("react-select-4-input"));
        executor.executeScript("arguments[0].click();", cityElement);

        WebElement cityInputElement = driver.findElement(By.id("react-select-4-input"));
        String cityValue = "Lucknow";
        cityInputElement.sendKeys(cityValue);
        cityInputElement.sendKeys(Keys.ENTER);

        WebElement submitElement = driver.findElement(By.id("submit"));
        executor.executeScript("arguments[0].click();", submitElement);

        //Wait explicit
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table//td[1]")));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table//td[2]")));

        List<WebElement> tableDescriptionList = driver.findElements(By.xpath("//table//td[1]"));
        List<WebElement> tableValueList = driver.findElements(By.xpath("//table//td[2]"));

        Assert.assertEquals(tableDescriptionList.get(0).getText(), "Student Name", "Student Name  text is not diplayed right in the table");
        Assert.assertTrue(tableValueList.get(0).getText().contains(firstnameValue),"First Name text is not displayed in the table");
        Assert.assertTrue(tableValueList.get(0).getText().contains(lastnameValue),"Last Name text is not displayed in the table");

        Assert.assertEquals(tableDescriptionList.get(1).getText(), "Student Email", "Student Email text is not diplayed right in the table");
        Assert.assertEquals(tableValueList.get(1).getText(), emailValue, "Student Email  text is not diplayed right in the table");

        Assert.assertEquals(tableDescriptionList.get(2).getText(), "Gender", "Gender text is not diplayed right in the table");
        Assert.assertEquals(tableValueList.get(2).getText(), genderValue, "Gender text is not diplayed right in the table");

        Assert.assertEquals(tableDescriptionList.get(3).getText(), "Mobile", "Mobile text is not diplayed right in the table");
        Assert.assertEquals(tableValueList.get(3).getText(), phoneValue, "Mobile text is not diplayed right in the table");
        //a se repeta pt restul campurilor: DoB, Subjects (!), Hobbies, Picture, Address, State and City
    }
}