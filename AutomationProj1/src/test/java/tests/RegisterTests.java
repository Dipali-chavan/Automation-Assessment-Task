package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class RegisterTests extends BaseTest {

    @Test
    public void TC01_successfulRegistration() {
        String email = "user" + UUID.randomUUID() + "@mail.com";
        registerPage.registerUser("Dipali", "Chavan", email, "Test@1234");
        Assert.assertTrue(driver.getPageSource().contains("Thank you for registering"));
    }

    @Test
    public void TC02_registrationWithExistingEmail() {
        registerPage.registerUser("Dipali", "Chavan", "existing@mail.com", "Test@1234");
        Assert.assertTrue(driver.getPageSource().contains("There is already an account"));
    }

    @Test
    public void TC03_registrationWithInvalidEmail() {
        registerPage.registerUser("Dipali", "Chavan", "invalidemail", "Test@1234");
        Assert.assertTrue(driver.getPageSource().contains("Please enter a valid email address"));
    }

    @Test
    public void TC04_blankFieldsRegistration() {
        registerPage.registerUser("", "", "", "");
        Assert.assertTrue(driver.getPageSource().contains("This is a required field"));
    }

    @Test
    public void TC05_mismatchedPasswords() {
        registerPage.enterFirstName("Dipali");
        registerPage.enterLastName("Chavan");
        registerPage.enterEmail("dipali@mail.com");
        registerPage.enterPassword("Test@1234");
        registerPage.enterConfirmPassword("Mismatch@1234");
        registerPage.submitForm();
        Assert.assertTrue(driver.getPageSource().contains("Please make sure your passwords match."));
    }

    @Test
    public void TC06_weakPassword() {
        registerPage.registerUser("Dipali", "Chavan", "dipali@test.com", "123");
        Assert.assertTrue(driver.getPageSource().contains("Minimum length of this field must be equal or greater than 8 symbols"));
    }
}