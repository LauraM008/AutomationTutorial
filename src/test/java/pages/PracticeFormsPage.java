package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.util.List;

public class PracticeFormsPage extends BasePage {

    public PracticeFormsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[placeholder='First Name']")
    public WebElement firstNameElement;
    @FindBy(css = "input[placeholder='Last Name']")
    public WebElement lastNameElement;
    @FindBy(css = "input[placeholder='name@example.com']")
    public WebElement emailElement;
    @FindBy(css = "input[placeholder='Mobile Number']")
    public WebElement mobileElement;
    @FindBy(id = "subjectsInput")
    public WebElement subjectsElement;
    @FindBy(css = "div[id='genterWrapper']>div>div>label[class = 'custom-control-label']")
    public List<WebElement> genderElementList;
    @FindBy(css = "div[id='hobbiesWrapper']>div>div>label[class='custom-control-label']")
    public List<WebElement> hobbiesElementList;
    @FindBy(id = "uploadPicture")
    public WebElement uploadElement;
    @FindBy(id = "currentAddress")
    public WebElement currentAddressElement;
    @FindBy(id = "state")
    public WebElement stateElement;
    @FindBy(id = "react-select-3-input")
    public WebElement stateInputElement;
    @FindBy(id = "city")
    public WebElement cityElement;
    @FindBy(id = "react-select-4-input")
    public WebElement cityInputElement;
    @FindBy(id = "submit")
    public WebElement submitElement;

    @FindBy(xpath = "//table//td[1]")
    public List<WebElement> tableDescriptionList;
    @FindBy(xpath = "//table//td[2]")
    public List<WebElement> tableValueList;



    public void fillEntireForm(String firstNameValue, String lastNameValue, String emailValue, String mobileValue, List<String> subjectsValue,
                               String genderValue, List<String> hobbyValues, String uploadValue, String currentAddressValue,
                               String stateValue, String cityValue) {

        elementHelper.fillElement(firstNameElement, firstNameValue);
        elementHelper.fillElement(lastNameElement, lastNameValue);
        elementHelper.fillElement(emailElement, emailValue);
        elementHelper.fillElement(mobileElement, mobileValue);
        for (int index = 0; index < subjectsValue.size(); index++) {
            elementHelper.fillPressElement(subjectsElement, subjectsValue.get(index), Keys.ENTER);
        }

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

        pageHelper.scrollPage(0, 400);

        for (int index = 0; index < hobbiesElementList.size(); index++) {
            if (hobbyValues.contains(hobbiesElementList.get(index).getText())) {
                elementHelper.clickElement(hobbiesElementList.get(index));
            }
        }

        File file = new File(uploadValue);
        String absolutePath = file.getAbsolutePath();
        elementHelper.fillElement(uploadElement, absolutePath);
        elementHelper.fillElement(currentAddressElement, currentAddressValue);
        elementHelper.clickElement(stateElement);
        elementHelper.fillPressElement(stateInputElement, stateValue, Keys.ENTER);
        elementHelper.clickElement(cityElement);
        elementHelper.fillPressElement(cityInputElement, cityValue, Keys.ENTER);
        elementHelper.clickElement(submitElement);
    }

    public void validateFormValues(String firstNameValue, String lastNameValue, String emailValue, String genderValue, String mobileValue, List<String> subjectsValue,
                                   List<String> hobbyValues, String filename, String currentAddressValue, String stateValue, String cityValue){
        elementHelper.validateElementEqualsText(tableDescriptionList.get(0),"Student Name");
        elementHelper.validateElementContainsText(tableValueList.get(0), firstNameValue);
        elementHelper.validateElementContainsText(tableValueList.get(0), lastNameValue);

        elementHelper.validateElementEqualsText(tableDescriptionList.get(1), "Student Email");
        elementHelper.validateElementEqualsText(tableValueList.get(1), emailValue);

        elementHelper.validateElementEqualsText(tableDescriptionList.get(2), "Gender");
        elementHelper.validateElementEqualsText(tableValueList.get(2), genderValue);


        elementHelper.validateElementEqualsText(tableDescriptionList.get(3), "Mobile");
        elementHelper.validateElementEqualsText(tableValueList.get(3), mobileValue);

        elementHelper.validateElementEqualsText(tableDescriptionList.get(5), "Subjects");
        String resultSubjects = String.join(", ", subjectsValue);
        elementHelper.validateElementEqualsText(tableValueList.get(5), resultSubjects);

        elementHelper.validateElementEqualsText(tableDescriptionList.get(6), "Hobbies");
        String resultHobbies = String.join(", ", hobbyValues);
        elementHelper.validateElementEqualsText(tableValueList.get(6), resultHobbies);

        //String uploadValueName = "turn.jpg";
        File file = new File(filename);
        elementHelper.validateElementEqualsText(tableDescriptionList.get(7), "Picture");
        elementHelper.validateElementEqualsText(tableValueList.get(7), file.getName());

        elementHelper.validateElementEqualsText(tableDescriptionList.get(8), "Address");
        elementHelper.validateElementEqualsText(tableValueList.get(8), currentAddressValue);

        elementHelper.validateElementEqualsText(tableDescriptionList.get(9), "State and City");
        elementHelper.validateElementContainsText(tableValueList.get(9), stateValue);
        elementHelper.validateElementContainsText(tableValueList.get(9), cityValue);
    }
}