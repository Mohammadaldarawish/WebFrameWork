package testcases;


import base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

@Feature("Login")
public class LoginTest extends BaseTest {

    public LoginTest() throws IOException {
    }

    @Test (description = "Test The URL of Site if Working or not", priority = 1)
    public void Check_URL_IsWorking() throws IOException {
        String ActualResult = driver.getCurrentUrl();
        String ExpectedResult = prop.getProperty("LoginURL");
        Assert.assertEquals(ActualResult, ExpectedResult);
    }

    //@Story("Login with Correct Username and Password")
    @Description("The test case contain Login by following Correct Email and Password")
    @Test (description = "Test The SignIn Button if Working or not", priority = 2)
    public void Check_SignInButton_IsWorking() throws IOException, InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(prop.getProperty("Email"), prop.getProperty("Password"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(prop.getProperty("MainPageURL")));
        String ExpectedResult = prop.getProperty("MainPageURL");
        String ActualResult = driver.getCurrentUrl();
        Assert.assertEquals(ActualResult, ExpectedResult);
        Assert.assertTrue(driver.getTitle().contains("Dashboard"), "Title does not contain 'Dashboard'");
    }


    @Test (description = "Test The Show Password Button if Working or not", priority = 3)
    public void Check_ShowPasswordButton() throws IOException, InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.InputPassword.sendKeys( prop.getProperty("Password"));
        loginPage.clickShowPassword();
        String passwordFieldValue = loginPage.getPasswordFieldValue();
        Assert.assertEquals(passwordFieldValue,  prop.getProperty("Password"), "Password is not displayed correctly.");

    }
    @Test (description = "Test The RememberMe Checkbox if Working or not", priority = 4)
    public void Check_RememberMeCheckbox() throws IOException, InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRememberMeCheckbox();
        Assert.assertTrue(loginPage.rememberMeCheckbox.isSelected(),"Remember Me checkbox is not selected" );
        // uncheck it and verify
        loginPage.clickRememberMeCheckbox();
        Assert.assertFalse(loginPage.rememberMeCheckbox.isSelected(), "Remember Me checkbox is not deselected.");
    }



}