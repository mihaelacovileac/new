package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor executor;
    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this );
        wait = new WebDriverWait(driver, 10);
        executor = (JavascriptExecutor)driver;

    }
}
