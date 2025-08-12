package tests;

import org.testng.annotations.Test;
import pages.FormsPage;
import pages.IndexPage;
import pages.PracticeFormsPage;
import sharedData.SharedData;

import java.util.Arrays;
import java.util.List;

public class PracticeFormTest extends SharedData {

    @Test
    public void testMethod() {
        IndexPage indexPage = new IndexPage(driver);
        indexPage.interactWithFormsMenu();

        FormsPage formsPage = new FormsPage(driver);
        formsPage.interactWithPracticeFormsSubmenu();

        String firstNameValue = "John";
        String lastNameValue = "Dose";
        String emailValue = "johndoe@email.com";
        String mobileValue = "0721523885";
        List<String> subjectsValue = Arrays.asList("Accounting", "Arts", "Maths");
        String genderValue = "Female";
        List<String> hobbyValues = Arrays.asList("Reading", "Music");
        String uploadValue = "src/test/resources/poza.png";
        String currentAddressValue = "Str. Campului 58, bl.7 BIS";
        String stateValue = "Uttar Pradesh";
        String cityValue = "Lucknow";

        PracticeFormsPage practiceFormsPage = new PracticeFormsPage(driver);
        practiceFormsPage.fillEntireForm(firstNameValue, lastNameValue, emailValue, mobileValue, subjectsValue, genderValue, hobbyValues, uploadValue, currentAddressValue,
                stateValue, cityValue);
        practiceFormsPage.validateFormValues(firstNameValue, lastNameValue, emailValue, genderValue, mobileValue,
                subjectsValue, hobbyValues, uploadValue, currentAddressValue, stateValue, cityValue );
    }
}