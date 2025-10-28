package org.example.tests;
import org.example.pom.FormPom;
import org.example.utils.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

public class form_test {
    WebDriver driver;
    public static String URL = "https://demoqa.com/automation-practice-form";
    public static String FIRST_NAME = "Elvis";
    public static String LAST_NAME = "Babara";
    public static String GENDER = "Female";
    public static String EMAIL = "jirnovadic@gmail.com";
    public static String MOBILE_NUMBER = "0675999000";
    public static String SUBJECT = "Maths";
    public static String HOBBY = "Reading";
    public static String FILEPATH = "C:\\Users\\Elvis\\Desktop\\Wallpapers\\Backgrounds\\sea.jpg";
    public static String ADDRESS = "Liuba Dumitriu 20/3, AP 101";
    public static String STATE= "NCR";
    public static String CITY= "Noida";
    public static String BIRTHDATE = "10 Dec 2005";





    @BeforeClass
    public void beforeTest(){
        driver = Driver.getRemoteDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void form_test() throws InterruptedException {
        driver.get(URL);
        FormPom form = new FormPom(driver);
        form.setFirstName(FIRST_NAME);
        form.setLastName(LAST_NAME);
        form.setEmail(EMAIL);
        form.closeAdvert();
        form.setGender(GENDER);
        form.setMobileNumber(MOBILE_NUMBER);
        form.setSubject(SUBJECT);
        form.setHobby(HOBBY);
        form.uploadPicture(FILEPATH);
        form.setCurrentAddress(ADDRESS);
        form.setStateAndCity(STATE, CITY);
        form.setDateOfBirth(BIRTHDATE);
        form.submitForm();

        System.out.println();
        Assert.assertEquals(form.getActualFirstName(), FIRST_NAME);
        Assert.assertEquals(form.getActualLastName(), LAST_NAME);
        Assert.assertEquals(form.getActualGender(), GENDER);
        Assert.assertEquals(form.getActualEmail(), EMAIL);
        Assert.assertEquals(form.getActualNumber(), MOBILE_NUMBER);
        Assert.assertEquals(form.getActualSubject(), SUBJECT);
        Assert.assertEquals(form.getActualHobby(), HOBBY);
        String expectedFileName = new File(FILEPATH).getName();
        Assert.assertEquals(form.getActualPicture(), expectedFileName);
        Assert.assertEquals(form.getActualAddress(), ADDRESS);
        Assert.assertEquals(form.getActualState(), STATE);
        Assert.assertEquals(form.getActualCity(), CITY);
        Assert.assertEquals(form.getActualBirthdate(), BIRTHDATE);


        Thread.sleep(2000);


    }
    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}