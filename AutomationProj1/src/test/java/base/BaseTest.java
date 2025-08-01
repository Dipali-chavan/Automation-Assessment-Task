
package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pages.LoginPage;
import pages.RegisterPage;

public class BaseTest {
    protected WebDriver driver;
    protected RegisterPage registerPage;
    protected LoginPage loginPage;

     @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");

        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    
    @AfterMethod
    public void pauseAfterTest() throws InterruptedException {
        Thread.sleep(2000);  // Pause for 2 seconds
        
    }
}

