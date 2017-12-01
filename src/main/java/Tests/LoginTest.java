package Tests;

import Data.DataProviders;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;

    @BeforeClass
    public void loginBeforeClass(){

    }
    @Test(dataProviderClass = DataProviders.class,dataProvider= "usernamePassword")
    public void testLogin(String username, String password) throws InterruptedException {

        loginPage = new LoginPage(driver);
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickLoginBtn();
        Thread.sleep(5000);//app is too slow
        Assert.assertTrue(loginPage.getUserProfileLink().isDisplayed());
    }
}
