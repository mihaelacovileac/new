package Tests;

import Pages.MainNavigationPage;
import Pages.SearchReportPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchReportTest extends LoginTest {

    //different types of test cases for searching report
    //1) Search by case id
    //2) Search by first name and last name
    //4) Search by date
    //5) search by text content
    private MainNavigationPage mainNavigationPage;
    private SearchReportPage searchReportPage;

    @Test(dependsOnMethods = "testLogin")
    public void searchByNameTest(){
        //search by first/last name
        mainNavigationPage = new MainNavigationPage(driver);
        mainNavigationPage.clickReportsLink();
        searchReportPage = new SearchReportPage(driver);
        searchReportPage.setLnSearchKey("iafiuho");//lname = iafiuho
        searchReportPage.setFnSearchKey("zmowbr");//fname = zmowbr
        searchReportPage.clickPublishedCheckBox();
        searchReportPage.setClickView();
        String x = searchReportPage.getValidateLastName();
        System.out.println(x);
        Assert.assertEquals(x, "iafiuho");//assert that last name is same with what i search



    }
}
