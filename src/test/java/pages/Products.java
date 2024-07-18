package pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;

import static Tests.SeleniumTest.driver;
import static Tests.SeleniumTest.test;

public class Products {

    //validations: formal shoes, sports shoes, sneakers
    public static String formalShoesXPath = "//div[2]/center/h2";
    public static String sportsShoesXPath = "//div[3]/center/h2";
    public static String sneakers = "//div[4]/center/h2";

    //shoe dropdown xpath
    public static String formalShoeDropdown_XPath = "//i[contains(@class, \"fa fa-angle-double-down formalshoedropdown\")]";
    public static String sportsShoeDropdown_XPath = "//i[contains(@class, \"fa fa-angle-double-down sportsshoedropdown\")]";
    public static String sneakers_XPath = "//i[contains(@class, \"fa fa-angle-double-down sneakershoedropdown\")]";

    //shoe table data
    public static String fromalShoeTable_Firstdata = "//div[2]/table/tbody/tr[1]/td[1]";
    public static String sportsShoeTable_Firstdata = "//div[3]/table/tbody/tr[1]/td[1]";
    public static String sneakerShoeTable_Firstdata = "//div[4]/table/tbody/tr[1]/td[1]";

    public static void formalShoesXpath_getTitle(){
        String expectedTitle = "Formal Shoes";
        String actualTitle = driver.findElement(By.xpath(formalShoesXPath)).getText();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    public static void sportsShoesXpath_getTitle(){
        String expectedTitle = "Sports Shoes";
        String actualTitle = driver.findElement(By.xpath(sportsShoesXPath)).getText();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    public static void sneakers_getTitle(){
        String expectedTitle = "Sneakers";
        String actualTitle = driver.findElement(By.xpath(sneakers)).getText();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    //click operation on dropdown and verifying the first shoe.
    public static void formalShoes_dropdownClickVerify(){
        String expectedValue = "Classic Cheltenham";
        driver.findElement(By.xpath(formalShoeDropdown_XPath)).click();
        String actualValue = driver.findElement(By.xpath(fromalShoeTable_Firstdata)).getText().trim();
        Assert.assertEquals(actualValue,expectedValue);
        if(expectedValue.equals(actualValue))
            test.log(Status.PASS, "Test Pass for Formal Shoe Title.");
        else
            test.log(Status.FAIL, "Test Failed for Formal Shoe Title.");
    }

    public static void sportShoes_dropdownClickVerify(){
        String expectedValue = "Ultimate";
        driver.findElement(By.xpath(sportsShoeDropdown_XPath)).click();
        String actualValue = driver.findElement(By.xpath(sportsShoeTable_Firstdata)).getText().trim();
        Assert.assertEquals(actualValue,expectedValue);
    }

    public static void sneaker_dropdownClickVerify(){
        String expectedValue = "Archivo";
        driver.findElement(By.xpath(sneakers_XPath)).click();
        String actualValue = driver.findElement(By.xpath(sneakerShoeTable_Firstdata)).getText().trim();
        Assert.assertEquals(actualValue,expectedValue);
    }
}
