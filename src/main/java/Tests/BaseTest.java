package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;


public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
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
    @AfterClass
    public void baseAfterClass(){

        driver.quit();
    }

}
