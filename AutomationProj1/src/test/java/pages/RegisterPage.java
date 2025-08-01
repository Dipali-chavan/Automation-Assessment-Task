
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
	
	
	
    private WebDriver driver;
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        driver.findElement(By.linkText("Create an Account")).click(); // Not ideal for POM but OK for quick setups
    }

    private By firstName = By.id("firstname");
    private By lastName = By.id("lastname");
    private By email = By.id("email_address");
    private By password = By.id("password");
    private By confirmPassword = By.id("password-confirmation");
    private By registerButton = By.cssSelector("button[title='Create an Account']");

  

    public void registerUser(String fName, String lName, String emailAddr, String pass) {
        driver.findElement(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(email).sendKeys(emailAddr);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(confirmPassword).sendKeys(pass);
        driver.findElement(registerButton).click();
    }

    public void enterFirstName(String fName) { driver.findElement(firstName).sendKeys(fName); }
    public void enterLastName(String lName) { driver.findElement(lastName).sendKeys(lName); }
    public void enterEmail(String emailAddr) { driver.findElement(email).sendKeys(emailAddr); }
    public void enterPassword(String pass) { driver.findElement(password).sendKeys(pass); }
    public void enterConfirmPassword(String pass) { driver.findElement(confirmPassword).sendKeys(pass); }
    public void submitForm() { driver.findElement(registerButton).click(); }
}