package Tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Home;
import pages.Products;

public class SeleniumTest {

    public static WebDriver driver;
    public static ExtentReports report;
    public static ExtentTest test;
    public static ExtentReports extent = new ExtentReports();

    @BeforeSuite
    public static void Setup() throws Throwable{
        driver = new ChromeDriver();
        driver.get("https://anupdamoda.github.io/AceOnlineShoePortal/index.html");
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
        extent.attachReporter(spark);
        Home.clickHamburger();
        Home.clickOnlineProducts();
    }

    @Test
    void validateTitles_OnlineShoeProducts(){
        test = extent.createTest("Validate Shoe Titles","This test validates the different shoe types " +
                "are correct in online products page");
        Products.formalShoesXpath_getTitle();
        Products.sportsShoesXpath_getTitle();
        Products.sneakers_getTitle();
        extent.flush();
    }

    @Test
    void validateFirstFormalShoe(){
        test = extent.createTest("Validate First formal Shoe Titles","This test validates the different shoe types " +
                "are correct in online products page");
        Products.formalShoes_dropdownClickVerify();
    }

    @Test
    void validateFirstSportsShoe(){
        Products.sportShoes_dropdownClickVerify();
    }

    @Test
    void validateFirstSneaker(){
        Products.sneaker_dropdownClickVerify();
    }

    @AfterSuite
    public static void cleanup(){
        extent.flush();
    }
}
