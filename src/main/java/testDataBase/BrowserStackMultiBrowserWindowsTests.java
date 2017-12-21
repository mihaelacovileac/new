package testDataBase;

import java.net.URL;
import java.sql.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BrowserStackMultiBrowserWindowsTests {
    public static final String USERNAME = "millania1";
    public static final String AUTOMATE_KEY = "drTCQW5wgRWccV9ANzMk";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @Test(dataProvider = "givePlatformAndBrowsers")
    public static void testSearch(String browser, String version, String platform) throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", browser);
        caps.setCapability("browser_version", version);
        caps.setCapability("platform", platform);
        caps.setCapability("browserstack.debug", "true");

        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
        driver.get("http://www.google.com");
        WebElement element = driver.findElement(By.name("q"));

        element.sendKeys("BrowserStack");
        element.submit();

        System.out.println(driver.getTitle());
        driver.quit();

    }

    @DataProvider
    public Object[][] givePlatformAndBrowsers() throws Exception {
        int j = num();
        System.out.println(j);
        Object[][] giveBrowserstackPlatforms = new Object[j][3];
        //Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"
        String dbUrl = "jdbc:mysql://localhost:3306/mysql";


        //Database Username
        String username = "root";

        //Database Password
        String password = "";

        //Query to Execute
        String query = "select * from ConectionToMySQL;";

        //Load mysql jdbc driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        //Create Connection to DB
        Connection con = DriverManager.getConnection(dbUrl, username, password);
        //Create Statement Object
        Statement stmt = con.createStatement();

        // Execute the SQL Query. Store results in ResultSet

        ResultSet rs = stmt.executeQuery(query);
        int counter = 0;
        // While Loop to iterate through all data and print results
        while (rs.next()) {
            String browser = rs.getString(1);
            String version = rs.getString(2);
            String platform = rs.getString(3);
            System.out.println(browser);
            System.out.println(version);
            System.out.println(platform);

            giveBrowserstackPlatforms[counter][0] = browser;
            giveBrowserstackPlatforms[counter][1] = version;
            giveBrowserstackPlatforms[counter][2] = platform;
            counter++;

        }
//        // closing DB Connection
        con.close();

        return giveBrowserstackPlatforms;


    }

    public int num() throws Exception {
        int j = 0;
        //Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"
        String dbUrl = "jdbc:mysql://localhost:3306/mysql";


        //Database Username
        String username = "root";

        //Database Password
        String password = "";

        //Query to Execute
        String query = "select count(*) from ConectionToMySQL;";

        //Load mysql jdbc driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        //Create Connection to DB
        Connection con = DriverManager.getConnection(dbUrl, username, password);
        //Create Statement Object
        Statement stmt = con.createStatement();

        // Execute the SQL Query. Store results in ResultSet

        ResultSet rs = stmt.executeQuery(query);
        int counter = 0;
        // While Loop to iterate through all data and print results
        while (rs.next()) {
            j = rs.getInt(1);

        }

        con.close();

        return j;


    }
}
