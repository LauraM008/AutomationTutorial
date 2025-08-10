package tests;

import helperMethods.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.util.List;

public class WebTablesTest extends SharedData {

    @Test
    public void testMethod(){

        ElementHelper elementHelper = new ElementHelper(driver);

        WebElement elementsMenu = driver.findElement(By.xpath("//h5[text()='Elements']"));
        elementHelper.clickElement(elementsMenu);

        WebElement elementsWebMenu = driver.findElement(By.xpath("//span[text()='Web Tables']"));
        elementHelper.clickElement(elementsWebMenu);

        List<WebElement> tableList = driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        int tableSize = 3;
        elementHelper.validateListSize(tableList, tableSize);

        //identificam un element
        WebElement addElement=driver.findElement(By.id("addNewRecordButton"));
        elementHelper.clickElement(addElement);

        WebElement firstNameElement=driver.findElement(By.id("firstName"));
        String firstNameValue="John";
        elementHelper.fillElement(firstNameElement,firstNameValue);

        WebElement lastNameElement=driver.findElement(By.id("lastName"));
        String lastNameValue="Doe";
        elementHelper.fillElement(lastNameElement,lastNameValue);

        WebElement emailElement=driver.findElement(By.id("userEmail"));
        String emailValue="johndoe@gmail.com";
        elementHelper.fillElement(emailElement,emailValue);

        WebElement ageElement=driver.findElement(By.id("age"));
        String ageValue="27";
        elementHelper.fillElement(ageElement,ageValue);

        WebElement salaryElement=driver.findElement(By.id("salary"));
        String salaryValue="8000";
        elementHelper.fillElement(salaryElement,salaryValue);

        WebElement departmentElement=driver.findElement(By.id("department"));
        String departmentValue="Quality";
        elementHelper.fillElement(departmentElement,departmentValue);

        WebElement submitElement=driver.findElement(By.id("submit"));
        elementHelper.clickElement(submitElement);

        tableList = driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        elementHelper.validateListSize(tableList,tableSize+1);
        elementHelper.validateElementContainsText(tableList.get(tableSize), firstNameValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize), lastNameValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize), emailValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize), ageValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize), salaryValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize), departmentValue);

        //edit functionality
        WebElement editElement=driver.findElement(By.id("edit-record-4"));
        elementHelper.clickElement(editElement);

        WebElement editFirstNameElement=driver.findElement(By.id("firstName"));
        String editFirstNameValue="Marcus";
        elementHelper.clearFillElement(editFirstNameElement, editFirstNameValue);

        WebElement editLastNameElement=driver.findElement(By.id("lastName"));
        String editLastNameValue="Riga";
        elementHelper.clearFillElement(editLastNameElement, editLastNameValue);

        WebElement editEmailElement=driver.findElement(By.id("userEmail"));
        String editEmailValue="marcus.riga@gmail.com";
        elementHelper.clearFillElement(editEmailElement, editEmailValue);

        WebElement editAgeElement=driver.findElement(By.id("age"));
        String editAgeValue="68";
        elementHelper.clearFillElement(editAgeElement, editAgeValue);

        WebElement editSalaryElement=driver.findElement(By.id("salary"));
        String editSalaryValue="9999";
        elementHelper.clearFillElement(editSalaryElement, editSalaryValue);

        WebElement editDepartmentElement=driver.findElement(By.id("department"));
        String editDepartmentValue="Music";
        elementHelper.clearFillElement(editDepartmentElement, editDepartmentValue);

       WebElement editLine = driver.findElement(By.id("submit"));
       elementHelper.clickElement(editLine);

        tableList = driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        elementHelper.validateListSize(tableList,tableSize+1);
        elementHelper.validateElementContainsText(tableList.get(tableSize), editFirstNameValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize), editLastNameValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize), editEmailValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize), editAgeValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize), editSalaryValue);
        elementHelper.validateElementContainsText(tableList.get(tableSize), editDepartmentValue);

        //delete element
        WebElement deleteElement=driver.findElement(By.id("delete-record-4"));
        elementHelper.clickElement(deleteElement);

        tableList = driver.findElements(By.xpath("//div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        elementHelper.validateListSize(tableList, tableSize);
    }
}
