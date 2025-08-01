package tests;


import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void TC07_validLogin() {
        loginPage.login("existing@mail.com", "Test@1234");
        Assert.assertTrue(driver.getPageSource().contains("Welcome"));
    }

    @Test
    public void TC08_incorrectPassword() {
        loginPage.login("existing@mail.com", "WrongPass");
        Assert.assertTrue(driver.getPageSource().contains("The account sign-in was incorrect"));
    }

    @Test
    public void TC09_unregisteredEmail() {
        loginPage.login("notexist@mail.com", "Test@1234");
        Assert.assertTrue(driver.getPageSource().contains("The account sign-in was incorrect"));
    }

    @Test
    public void TC10_invalidEmailFormat() {
        loginPage.login("invalidemail", "Test@1234");
        Assert.assertTrue(driver.getPageSource().contains("Please enter a valid email address"));
    }

    @Test
    public void TC11_emptyLoginFields() {
        loginPage.login("", "");
        Assert.assertTrue(driver.getPageSource().contains("This is a required field"));
    }

    @Test
    public void TC12_emailOnlyLogin() {
        loginPage.login("user@mail.com", "");
        Assert.assertTrue(driver.getPageSource().contains("This is a required field"));
    }

    @Test
    public void TC13_passwordOnlyLogin() {
        loginPage.login("", "Test@1234");
        Assert.assertTrue(driver.getPageSource().contains("This is a required field"));
    }
}