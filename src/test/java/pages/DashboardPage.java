package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage  {

    public DashboardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@aria-label='User menu']")
    private WebElement userMenuButton;

    @FindBy(css = "button.fi-dropdown-list-item")
    private WebElement signOutButton;

    @FindBy(xpath = "//button[@title='Open notifications']")
    private WebElement notificationButton;

    @FindBy (xpath ="//button[@title='Close']")
    private WebElement cancelNotificationButton;

    @FindBy(xpath = "//button[@title='Collapse sidebar']")
    private WebElement collapseSidebarButton;


    @FindBy(xpath = "//div[@id='sidebar']") //
    private  WebElement sidebar;


    @FindBy(id = "input-1")
    private WebElement searchField;


    @FindBy(xpath = "//a[h4[text()='Mohammad Aldarawish - CDR']]")
    private WebElement searchButton;

    @FindBy(css = "a.fi-global-search-result-link")
    private WebElement editLink;


    public void logout() {
        userMenuButton.click();
        signOutButton.click();
    }

    public void clickNotificationButton() {
        notificationButton.click();
    }
    public void clickCancelNotificationButton() {
        cancelNotificationButton.click();
    }

    public boolean DisplayCancelNotificationButton() {
        return cancelNotificationButton.isDisplayed();
    }


    public void clickCollapseSidebarButton(){
        collapseSidebarButton.click();
    }

    public boolean isSidebarVisible() {
        return sidebar.isDisplayed();
    }

    public void toggleSidebar() {
        collapseSidebarButton.click();
    }
    public void search(String query) throws InterruptedException {
        searchField.click();
        searchField.sendKeys(query);
        searchButton.click();
    }

    public boolean isEditResultDisplayed() {
        return editLink.isDisplayed();
    }
    public WebElement getCancelNotificationButton() {
        return cancelNotificationButton;
    }
    public WebElement getSidebar() {
        return sidebar;
    }
    public WebElement getEditLink() {
        return editLink;
    }

}