package Tests;

import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;


public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    private LoginPage loginPage;
    private String url;
    @BeforeClass
    public void baseBeforeClass(){
        driver = new ChromeDriver();
        url = "http://fits.qauber.com/#/page/login";
        //driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);

    }
    @Test(priority = 0, enabled = false)
    public void assertLogo(){

        loginPage = new LoginPage(driver);
        assertTrue(loginPage.getLogo().isDisplayed());}
    @AfterClass
    public void baseAfterClass(){

//        driver.quit();
    }

}
