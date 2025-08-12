package tests;

import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.IndexPage;
import pages.WebTablePage;
import sharedData.SharedData;

public class WebTableTest extends SharedData {

    @Test
    public void testMethod(){
        IndexPage indexPage = new IndexPage(driver);
        indexPage.interactWithElementsMenu();

        ElementsPage elementsPage = new ElementsPage(driver);
        elementsPage.interactWithWebTablesSubMenu();

        int tableSize = 3;
        //identificam un element

        String firstNameValue = "John";
        String lastNameValue = "Dose";
        String emailValue = "johndoe@gmail.com";
        String ageValue = "27";
        String salaryValue = "8000";
        String departmentValue = "Quality";
        String editFirstNameValue = "Marcus";
        String editLastNameValue = "Riga";
        String editEmailValue = "marcus.riga@gmail.com";
        String editAgeValue = "68";
        String editSalaryValue = "9999";
        String editDepartmentValue = "Music";

        WebTablePage webTablePage = new WebTablePage(driver);
        webTablePage.addNewEntry(tableSize, firstNameValue, lastNameValue, emailValue, ageValue,
                salaryValue, departmentValue);
        webTablePage.editNewEntry(tableSize, editFirstNameValue, editLastNameValue, editEmailValue,
                editAgeValue, editSalaryValue, editDepartmentValue);

        webTablePage.deleteNewEntry(tableSize);
    }
}