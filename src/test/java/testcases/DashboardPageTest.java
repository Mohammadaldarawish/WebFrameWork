package testcases;

import base.BaseTest;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utils.WaitHelper;

import java.io.IOException;

@Feature("Dashboard Page")

public class DashboardPageTest extends BaseTest {

    public DashboardPageTest() throws IOException {
    }

    @Test
    public void Check_LogoutButton_IsWorking() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage= loginPage.login(prop.getProperty("Email"), prop.getProperty("Password"));
        WaitHelper.waitForUrlToBe(prop.getProperty("MainPageURL"), 10);
        dashboardPage.logout();
        String actualResult= driver.getCurrentUrl();
        Assert.assertEquals(prop.getProperty("LoginURL"), actualResult);
    }

    @Test
    public void Check_notificationButtonAndCancelNotificationButton_IsWorking() {
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = loginPage.login(prop.getProperty("Email"), prop.getProperty("Password"));
        WaitHelper.waitForUrlToBe(prop.getProperty("MainPageURL"), 10);
        dashboardPage.clickNotificationButton();
        WaitHelper.waitForElementToBeVisible(dashboardPage.getCancelNotificationButton(), 10);
        dashboardPage.clickCancelNotificationButton();
        WaitHelper.waitForElementToDisappear(dashboardPage.getCancelNotificationButton(), 10);
        Assert.assertFalse(dashboardPage.DisplayCancelNotificationButton());
    }


    @Test
    public void Check_collapseSidebarButton_IsWorking() {
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = loginPage.login(prop.getProperty("Email"), prop.getProperty("Password"));
        WaitHelper.waitForElementToBeVisible(dashboardPage.getSidebar(), 10);
        Assert.assertTrue(dashboardPage.isSidebarVisible(), "Sidebar should be visible initially.");
        dashboardPage.clickCollapseSidebarButton();
        WaitHelper.waitForElementToDisappear(dashboardPage.getSidebar(), 10);
        Assert.assertFalse(dashboardPage.isSidebarVisible(), "Sidebar should be hidden after collapsing.");
        dashboardPage.toggleSidebar();
        WaitHelper.waitForElementToBeVisible(dashboardPage.getSidebar(), 10);
        Assert.assertTrue(dashboardPage.isSidebarVisible(), "Sidebar should be visible after toggling back.");
    }

    @Test
    public void Check_searchButton_IsWorking() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = loginPage.login(prop.getProperty("Email"), prop.getProperty("Password"));
        WaitHelper.waitForUrlToBe(prop.getProperty("MainPageURL"), 10);
        dashboardPage.search("Mohammad Aldarawish - CDR");
        WaitHelper.waitForElementToBeVisible(dashboardPage.getEditLink(), 10);
        Assert.assertTrue(dashboardPage.isEditResultDisplayed(), "Edit Mohammad Aldarawish - CDR is not displayed.");
    }

}