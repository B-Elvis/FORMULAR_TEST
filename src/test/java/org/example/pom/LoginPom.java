package org.example.pom;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Date;

import static org.example.utils.Util1.explicitWait;

public class LoginPom
{
    JavascriptExecutor js;
    WebDriver driver;
    @FindBy(xpath = "//input[@id='userName']")

    WebElement userName;
    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(xpath = "//*[@id='login']")
    WebElement login;

    @FindBy(xpath = "//*[@id='userName-value']")
    WebElement userNameValue;


    public LoginPom(WebDriver driver){
        this.driver=driver;
        this.js= (JavascriptExecutor) driver;
        PageFactory.initElements(driver,this);
    }


    public String clickLogin(){

        login.click();
        explicitWait(driver, ExpectedConditions.visibilityOf(userNameValue),10);
        return userNameValue.getText();
    }

    public void setPassword(String passParam){
        password.clear();
        password.sendKeys(passParam);
    }

    public void setUserName(String userNameParam){
       userName.clear();
       userName.sendKeys(userNameParam);
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