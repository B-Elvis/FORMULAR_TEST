package org.example.pom;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Date;

public class FormPom
{
    JavascriptExecutor js;
    WebDriver driver;

    @FindBy(xpath = "//input[@id='firstName']")
WebElement firstName;
    @FindBy(xpath = "//input[@id='lastName']")

    WebElement lastName;

    @FindBy(xpath = "//input[@id='userEmail']")

    WebElement email;

    @FindBy(xpath = "//input[@id='userNumber']")

    WebElement mobileNumber;

    @FindBy(xpath = "//input[@id='subjectsInput']")
    WebElement subjectsInput;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-1']")
    WebElement userHobby;

    @FindBy(xpath = "//input[@id='uploadPicture']")
    WebElement uploadPicture;

    @FindBy(xpath = "//textarea[@id='currentAddress']")
    WebElement currentAddress;

    @FindBy(xpath = "//input[@id='react-select-3-input']")
    WebElement state;

    @FindBy(xpath = "//input[@id='react-select-4-input']")
    WebElement city;

    @FindBy(xpath = "//input[@id='dateOfBirthInput']")
    WebElement calendar;

    @FindBy(xpath = "//button[@id='submit']")
    WebElement submit;

    @FindBy(xpath = "//div[@class='modal-content']//table/tbody/tr[1]/td[2]")
    WebElement actualName;

    @FindBy(xpath = "//div[@class='modal-content']//table/tbody/tr[2]/td[2]")
    WebElement actualEmail;

    @FindBy(xpath = "//div[@class='modal-content']//table/tbody/tr[3]/td[2]")
    WebElement actualGender;

    @FindBy(xpath = "//div[@class='modal-content']//table/tbody/tr[4]/td[2]")
    WebElement actualMobile;

    @FindBy(xpath = "//div[@class='modal-content']//table/tbody/tr[5]/td[2]")
    WebElement actualBirthdate;

    @FindBy(xpath = "//div[@class='modal-content']//table/tbody/tr[6]/td[2]")
    WebElement actualSubject;

    @FindBy(xpath = "//div[@class='modal-content']//table/tbody/tr[7]/td[2]")
    WebElement actualHobby;

    @FindBy(xpath = "//div[@class='modal-content']//table/tbody/tr[8]/td[2]")
    WebElement actualPicture;

    @FindBy(xpath = "//div[@class='modal-content']//table/tbody/tr[9]/td[2]")
    WebElement actualAddress;

    @FindBy(xpath = "//div[@class='modal-content']//table/tbody/tr[10]/td[2]")
    WebElement actualStateAndCity;









    public FormPom(WebDriver driver){
        this.driver=driver;
        this.js= (JavascriptExecutor) driver;
        PageFactory.initElements(driver,this);
    }

    public void setFirstName(String FirstNameParam){
    firstName.clear();
    firstName.sendKeys(FirstNameParam);
    }

    public void setLastName(String LastNameParam){
        lastName.clear();
        lastName.sendKeys(LastNameParam);
    }

    public void setEmail(String EmailParam){
        email.clear();
        email.sendKeys(EmailParam);
    }

    public void setGender(String genderParam) {
        WebElement gender = driver.findElement(By.xpath("//*[text()='" + genderParam + "']"));
        gender.click();
    }

    public void setMobileNumber(String MobileNumberParam){
        mobileNumber.clear();
        mobileNumber.sendKeys(MobileNumberParam);
    }

    public void setSubject(String SubjectParam) {
        subjectsInput.clear();
        subjectsInput.sendKeys(SubjectParam);
        subjectsInput.sendKeys(Keys.ENTER);
    }

    public void setHobby(String hobbyParam) {
        WebElement hobby = driver.findElement(By.xpath("//label[normalize-space(text())='" + hobbyParam + "']"));
        hobby.click();
    }


//    public void uploadPicture(String filePath) {
//        uploadPicture.sendKeys(filePath);
//    }

    public void setCurrentAddress(String CurrentAddressParam) {
      currentAddress.sendKeys(CurrentAddressParam);
    }

    public void setStateAndCity(String StateParam, String CityParam) {
        state.sendKeys(StateParam);
        state.sendKeys(Keys.ENTER);
        city.sendKeys(CityParam);
        city.sendKeys(Keys.ENTER);
    }

    public void setDateOfBirth(String DateOfBirthParam) {
        calendar.sendKeys(Keys.CONTROL + "a");
        calendar.sendKeys(DateOfBirthParam);
        calendar.sendKeys(Keys.ENTER);
    }


    public String getActualName() {
        return actualName.getText();
    }

    public String getActualFirstName() {
        String fullName = actualName.getText();
        String[] parts = fullName.split(" ");
        return parts[0];
    }

    public String getActualLastName() {
        String fullName = actualName.getText();
        String[] parts = fullName.split(" ");
        return parts.length > 1 ? parts[1] : "";
    }

    public String getActualEmail(){
        return actualEmail.getText();
    }

    public String getActualGender(){
        return actualGender.getText();
    }

    public String getActualNumber(){
        return actualMobile.getText();
    }

    public String getActualBirthdate() {
        String textComplet = actualBirthdate.getText().replaceAll(",", " ").trim();
        String[] parti = textComplet.split("\\s+");

        if (parti.length == 3) {
            String luna = parti[1].substring(0, 3);
            return parti[0] + " " + luna + " " + parti[2];
        } else {
            return textComplet;
        }
    }


    public String getActualSubject(){
        return actualSubject.getText();
    }

    public String getActualHobby(){
        return actualHobby.getText();
    }

    public String getActualPicture(){
        return actualPicture.getText();
    }

    public String getActualAddress(){
        return actualAddress.getText();
    }

    public String getActualStateAndCity() {
        return actualStateAndCity.getText();
    }

    public String getActualState() {
        String textComplet = actualStateAndCity.getText();
        String[] parti = textComplet.split(" ");
        return parti[0];
    }

    public String getActualCity() {
        String textComplet = actualStateAndCity.getText();
        String[] parti = textComplet.split(" ");
        return parti.length > 1 ? parti[1] : "";
    }




    public void submitForm(){
        submit.click();
    }


    public void closeAdvert() {
        try {
            js.executeScript(
                    "var elem = document.querySelector('#adplus-anchor'); if(elem) elem.remove();"
            );
        } catch (Exception ignored) {}
        try {
            js.executeScript(
                    "var foot = document.querySelector('footer'); if(foot) foot.remove();"
            );
        } catch (Exception ignored) {}
    }
}
