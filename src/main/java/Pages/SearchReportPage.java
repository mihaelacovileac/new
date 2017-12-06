package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class SearchReportPage extends BasePage {
    public SearchReportPage(WebDriver driver){super(driver);}
    @FindBy(xpath = "//input[@ng-model='slnSearchKey']")
    private WebElement lnSearchKey;
    @FindBy(xpath = "//input[@ng-model='sfnSearchKey']")
    private WebElement fnSearchKey;
    @FindBy(xpath = "//input[@ng-model='ciSearchKey']")
    private WebElement ciSearchKey;
    @FindBy(xpath = "//select[@ng-model='stSearchKey']")
    private WebElement stSearchKey;
    @FindBy(xpath = "//label[text()='Published On']")
    private WebElement publishedCheckBox;
    @FindBy(xpath = "//input[@is-open='openedSearchFrom']")
    private WebElement openedSearchFrom;
    @FindBy(xpath = "//input[@ng-model='ctSearchKey']")
    private WebElement ctSearchKey;
    @FindBy(xpath = "//a[@class='btn btn-info btn-sm mt-sm ng-scope' and @title= 'View']")
    private WebElement clickView;
    @FindBy(xpath = ".//*[@id='reportBody']/div[1]/div/div[2]/div[1]/div")
    private WebElement validateLastName;

    /*
    @FindBy(xpath = "")
    private WebElement ;
     */

    public String getValidateLastName() {
        return validateLastName.getText();
    }

    public void setLnSearchKey(String strLnSearchKey) {
        lnSearchKey.sendKeys(strLnSearchKey);
    }
    public void setFnSearchKey(String strFnSearchKey) {
        fnSearchKey.sendKeys(strFnSearchKey);
    }
    public void setCiSearchKey(String strCiSearchKey) {
        ciSearchKey.sendKeys(strCiSearchKey);
    }
    public void setOpenedSearchFrom(String strOpenedSearchFrom) {
        openedSearchFrom.sendKeys(strOpenedSearchFrom);
    }
    public void setCtSearchKey(String strCtSearchKey) {
        ctSearchKey.sendKeys(strCtSearchKey);
    }
    public void clickPublishedCheckBox(){publishedCheckBox.click();}
    public void setStSearchKey(String status){
        Select s =new Select(stSearchKey);
        s.selectByValue(status);}
    public void setClickView(){wait.until(ExpectedConditions.visibilityOf(clickView));
    executor.executeScript("arguments[0].scrollIntoView(true);",clickView);
    clickView.click();}

}
