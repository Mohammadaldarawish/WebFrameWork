package base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.*;
import java.lang.reflect.Method;
import java.util.Properties;

import static utils.ScreenshotHelper.TakePicture;

public class BaseTest {
    protected static WebDriver driver;
    public static Properties prop;

    public BaseTest() throws IOException {
        //Read the Important data from properties file, when create any object will run
        prop = new Properties();
        FileInputStream file = new FileInputStream("src/test/java/config/prop.properties");
        prop.load(file);
    }

    @BeforeMethod
    public void setup() throws IOException {
        driver = institutionalize();
    }

    public WebDriver institutionalize() {
        WebDriver driver = new ChromeDriver();
        driver.get(prop.getProperty("LoginURL"));
        return driver;
    }

    @AfterMethod
    public void tearDown(Method method) throws IOException {
        TakePicture(method.getName());
        driver.quit();
    }

}