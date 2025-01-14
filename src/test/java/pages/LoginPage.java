package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "data.email")
    private WebElement InputEmailAddress;

    @FindBy(id = "data.password")
    public WebElement InputPassword;

    // Locate the Show Password button
    @FindBy(css = "button[title='Show password']")
    private WebElement showPasswordButton;

    @FindBy(css ="button[type='submit']")
    public WebElement signInButton;

    @FindBy(css = "input[type='checkbox']")
    public WebElement rememberMeCheckbox;

    //@Step("Login") if you need rename the step
    @Step
    public DashboardPage login(String Name, String Password) {
        InputEmailAddress.sendKeys(Name);
        InputPassword.sendKeys(Password);
        signInButton.click();
        return new DashboardPage(driver);
    }


    // Method to click on Show Password button
    public void clickShowPassword() {
        showPasswordButton.click();
    }

    // Method to get the current value of the password field
    public String getPasswordFieldValue() {
        return InputPassword.getAttribute("value");
    }

    public void clickRememberMeCheckbox() {
        rememberMeCheckbox.click();
    }


}