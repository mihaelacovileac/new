package cucumberTest.stepDefinition;

import java.util.concurrent.TimeUnit;

import Pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test_Steps {
    private WebDriver driver;
    private String url;
    private WebDriverWait wait;
    private EditCompanyPage editCompanyPage;
    private HeaderPage headerPage;
    private ProfilePanelPage profilePanelPage;
    private MainNavigationPage mainNavigationPage;
    private PaypalPage paypalPage;
    private EntitiesPage entitiesPage;



    //Test Login functionality
    @Given("^User is on Home Page$")
    public void user_is_on_Home_Page() {
        driver = new FirefoxDriver();
        url = "http://fits.qauber.com/#/page/login";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
        driver.get(url);

    }

    @When("^User enters \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_enters_Username_and_Password(String username, String password) throws InterruptedException{

        driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='exampleInputPassword1']")).sendKeys(password);
        //driver.findElement(By.id("login")).click();
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[contains(.,'Login')]")));

    }

    @Then("^Message displayed Login Successfully$")
    public void message_displayed_Login_Successfully(){
        String title = driver.getTitle();
       System.out.println(title);
       String x =  driver.findElement(By.xpath("/html/body/div[2]/header/nav/div[2]/ul[2]/li/a/span")).getText();
       System.out.println(x);
       Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[2]/header/nav/div[2]/ul[2]/li/a/span")).isDisplayed());
       driver.quit();
    }

    //Test change name test case

    @Given("^User is logged into application$")
        public void User_is_logged_into_application(){
        driver = new FirefoxDriver();
        url = "http://fits.qauber.com/#/page/login";
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
        driver.get(url);
        driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys("buquxahu@cars2.club");
        driver.findElement(By.xpath("//input[@id='exampleInputPassword1']")).sendKeys("kisulea");
        //driver.findElement(By.id("login")).click();
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[contains(.,'Login')]")));
        }
    @When("^Click on user's link$")
    public void Click_on_users_link() throws InterruptedException {
        driver.findElement(By.xpath("//span[@class='mr-sm ng-binding']")).click();
        Thread.sleep(3000);
    }
    @When("^Click on editProfile button$")
    public void Click_on_editProfile_button(){
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(.,'Edit Profile')]"))).click();

        driver.findElement(By.xpath("//button[contains(.,'Edit Profile')]")).click();
    }
    @When("^Type name into Name textInput field$")
    public void Type_name_into_changeName_textField(){
        driver.findElement(By.xpath("//input[@name='name']")).clear();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Lilia");

    }
    @When("^Click update Button$")
    public void Click_on_update_button(){
        driver.findElement(By.xpath("//button[@ng-click='$ctrl.submitGeneralForm()']")).click();
    }
    @Then("^Successful message is displayed$")
    public void Success_message_is_displayed(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]")));
    String sMessage = driver.findElement(By.xpath("/html/body/div[3]")).getText();
    Assert.assertEquals(sMessage, "The profile has been updated.");
    driver.quit();
    }

    @When("^Type all required fields$")
    public void typeAllRequiredFields() throws InterruptedException {

        headerPage = new HeaderPage(driver);
        headerPage.clickUserLink();
        Thread.sleep(3000);
        profilePanelPage = new ProfilePanelPage(driver);
        profilePanelPage.clickEditCompanyBtn();
        Thread.sleep(3000);
        editCompanyPage = new EditCompanyPage(driver);
        editCompanyPage.setCompanyName("Telecom");
        editCompanyPage.setCountry("Albania");
        editCompanyPage.setAddress1("123 adbfgr ");
        editCompanyPage.setAddress2("4 apt");
        editCompanyPage.setCity("tampa");
        editCompanyPage.setStateTextField("kjiogjidjfa");
        editCompanyPage.setZip("567676");
        editCompanyPage.setPhone("6578767877");
        editCompanyPage.setEmail("tampa@yahoo.com");
        editCompanyPage.setNotes("notes");
        editCompanyPage.clickUpdateBtn();
        Thread.sleep(2000);
    }
    @Then("^Successfully updated company info$")
    public void companyUpdateAssertion(){
        editCompanyPage = new EditCompanyPage(driver);
        Assert.assertTrue(editCompanyPage.getSuccessUpdateMessage().isDisplayed());

        driver.quit();
    }

    @When("^Type required fields \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" and pay subscription$")
    public void testAddEntity(String name,String country,String address1, String city, String state,
                              String zip, String phone, String email, String RUemail, String AUemail) throws InterruptedException {
        mainNavigationPage = new MainNavigationPage(driver);
        mainNavigationPage.clickEntitiesLink();
        entitiesPage = new EntitiesPage(driver);
        entitiesPage.clickAddEntityBtn();
        entitiesPage.setCompanyName(name);
        entitiesPage.setCountry(country);
        entitiesPage.setAddress1(address1);
        entitiesPage.setCity(city);
        entitiesPage.setState(state);
        entitiesPage.setZip(zip);
        entitiesPage.setPhone(phone);
        entitiesPage.setEmail(email);
        entitiesPage.clickNextStepBtn();
        Thread.sleep(4000);
        entitiesPage.clickNextStepBtn();
        Thread.sleep(8000);
        entitiesPage.setAddEmailRU(RUemail);
        Thread.sleep(8000);
        entitiesPage.clickNextStepBtn();
        entitiesPage.setAddEmailFieldAU(AUemail);
        entitiesPage.clickNextStepBtn();
        entitiesPage.clickFinishBtn();
        Thread.sleep(20000);
        paypalPage = new PaypalPage(driver);
        paypalPage.paypalSwitchAndPay();
        Thread.sleep(10000);

    }
    @Then("^Successful paymant message is displayed$")
        public void successfulPaymentMessage(){
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertTrue(title.equalsIgnoreCase("FITS - FITS Web Application"));
        driver.quit();
        }


}