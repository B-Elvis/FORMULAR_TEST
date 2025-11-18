package org.example.tests;
import org.example.pom.FormPom;
import org.example.pom.LoginPom;
import org.example.utils.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

public class login_test {
    WebDriver driver;
    public static String URL = "https://demoqa.com/login";
    public static String USER_NAME = "Elvis";
    public static String PASSWORD = "Abc12345!";



    @BeforeClass
    public void beforeTest(){
        driver = Driver.getRemoteDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void login_test() throws InterruptedException {
        System.out.println("start test!");
        driver.get(URL);
        LoginPom loginPom = new LoginPom(driver);
        loginPom.setUserName(USER_NAME);
        System.out.println("set username");

        loginPom.setPassword(PASSWORD);
        System.out.println("set password");
        loginPom.closeAdvert();
        Assert.assertEquals(loginPom.clickLogin(),USER_NAME);
        System.out.println("finish_assert");
        Thread.sleep(2000);


    }
    @AfterClass
    public void afterTest(){
        driver.quit();
    }
}