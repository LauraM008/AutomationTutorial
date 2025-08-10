package tests;

import helperMethods.AlertHelper;
import helperMethods.ElementHelper;
import helperMethods.PageHelper;
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

        ElementHelper elementHelper = new ElementHelper(driver);
        PageHelper pageHelper = new PageHelper(driver);

        WebElement elementsForm = driver.findElement(By.xpath("//h5[text()='Forms']"));
        elementHelper.clickElement(elementsForm);

        WebElement elementsPracticeForm = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        elementHelper.clickElement(elementsPracticeForm);

        // wait implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement firstNameElement = driver.findElement(By.cssSelector("input[placeholder ='First Name'"));
        String firstNameValue = "John";
        elementHelper.fillElement(firstNameElement,firstNameValue);

        WebElement lastNameElement = driver.findElement(By.cssSelector("input[placeholder ='Last Name'"));
        String lastNameValue = "Doe";
        elementHelper.fillElement(lastNameElement,lastNameValue);

        WebElement emailElement = driver.findElement(By.cssSelector("input[placeholder ='name@example.com'"));
        String emailValue = "johndoe@email.com";
        elementHelper.fillElement(emailElement,emailValue);

        WebElement phoneElement = driver.findElement(By.cssSelector("input[placeholder ='Mobile Number'"));
        String phoneValue = "0721523885";
        elementHelper.fillElement(phoneElement,phoneValue);

        WebElement subjectsElement = driver.findElement(By.id("subjectsInput"));
        List<String> subjectsValue = Arrays.asList("Accounting", "Arts", "Maths");
        for (int index = 0; index < subjectsValue.size(); index++) {
            elementHelper.fillPressElement(subjectsElement, subjectsValue.get(index), Keys.ENTER);
        }

        String genderValue = "Female";
        List<WebElement> genderElementList = driver.findElements(By.cssSelector("div[id='genterWrapper']>div>div>label[class='custom-control-label']"));
        switch (genderValue) {
            case "Male":
                elementHelper.clickElement(genderElementList.get(0));
                break;
            case "Female":
                elementHelper.clickElement(genderElementList.get(1));
                break;
            case "Other":
                elementHelper.clickElement(genderElementList.get(2));
                break;
        }

        //facem scroll in jos
        pageHelper.scrollPage(0,400);

        List<WebElement> hobbiesElementList = driver.findElements(By.cssSelector("div[id='hobbiesWrapper']>div>div>label[class='custom-control-label']"));
        List<String> hobbieValues = Arrays.asList("Reading", "Music");
        for (int index = 0; index < hobbiesElementList.size(); index++) {
            if (hobbieValues.contains(hobbiesElementList.get(index).getText())) {
                elementHelper.clickElement(hobbiesElementList.get(index));
            }
        }

        //upload picture
        WebElement uploadElement = driver.findElement(By.id("uploadPicture"));
        //ii dam path relativ -> path-ul din acest proiect
        String uploadValue = "src/test/resources/poza.png";
        //daca nu merge cu relativ path, extragem absolut path
        File file = new File(uploadValue);
        String absolutePath = file.getAbsolutePath();
        elementHelper.fillElement(uploadElement,absolutePath);

        WebElement currentAddressElement = driver.findElement(By.id("currentAddress"));
        String currentAddressValue = "Str. Campului 58, bl.7 BIS";
        elementHelper.fillElement(currentAddressElement,currentAddressValue);

        JavascriptExecutor executor = (JavascriptExecutor) driver;

        WebElement stateElement = driver.findElement(By.id("state"));
        elementHelper.clickElement(stateElement);

        WebElement stateInputElement = driver.findElement(By.id("react-select-3-input"));
        String stateValue = "Uttar Pradesh";
        elementHelper.fillPressElement(stateInputElement, stateValue, Keys.ENTER);

        WebElement cityInputElement = driver.findElement(By.id("react-select-4-input"));
        String cityValue = "Lucknow";
        elementHelper.fillPressElement(cityInputElement, cityValue, Keys.ENTER);

        WebElement submitElement = driver.findElement(By.id("submit"));
        elementHelper.clickElement(submitElement);

        //Wait explicit
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table//td[1]")));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table//td[2]")));

        List<WebElement> tableDescriptionList = driver.findElements(By.xpath("//table//td[1]"));
        List<WebElement> tableValueList = driver.findElements(By.xpath("//table//td[2]"));

        elementHelper.validateElementEqualsText(tableDescriptionList.get(0),"Student Name");
        elementHelper.validateElementContainsText(tableValueList.get(0), firstNameElement.getText());
        elementHelper.validateElementContainsText(tableValueList.get(0), lastNameElement.getText());

        elementHelper.validateElementEqualsText(tableDescriptionList.get(1),"Student Email");
        elementHelper.validateElementEqualsText(tableValueList.get(1), emailValue);

        elementHelper.validateElementEqualsText(tableDescriptionList.get(2), "Gender");
        elementHelper.validateElementEqualsText(tableValueList.get(2), genderValue);

        elementHelper.validateElementEqualsText(tableDescriptionList.get(3), "Mobile");
        elementHelper.validateElementEqualsText(tableValueList.get(3), phoneValue);

        //a se repeta pt restul campurilor: DoB, Subjects (!), Hobbies, Picture, Address, State and City

        elementHelper.validateElementEqualsText(tableDescriptionList.get(5), "Subjects");
        String resultSubjects = String.join(", ", subjectsValue);
        elementHelper.validateElementEqualsText(tableValueList.get(5), resultSubjects);

        elementHelper.validateElementEqualsText(tableDescriptionList.get(6), "Hobbies");
        String resultHobbies = String.join(", ", hobbieValues);
        elementHelper.validateElementEqualsText(tableValueList.get(6), resultHobbies);

        elementHelper.validateElementEqualsText(tableDescriptionList.get(7), "Picture");
        String uploadValueName = "poza.png";
        elementHelper.validateElementEqualsText(tableValueList.get(7), uploadValueName);

        elementHelper.validateElementEqualsText(tableDescriptionList.get(8), "Address");
        elementHelper.validateElementEqualsText(tableValueList.get(8), currentAddressValue);

        elementHelper.validateElementEqualsText(tableDescriptionList.get(9), "State and City");
        elementHelper.validateElementContainsText(tableValueList.get(9), stateValue);
        elementHelper.validateElementContainsText(tableValueList.get(9), stateValue);
    }
}