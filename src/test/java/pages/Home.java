package pages;

import org.openqa.selenium.By;

import static Tests.SeleniumTest.driver;

public class Home {
    public static String homeHamburgerMenu = "//input";
    public static String onlineProductsXPath = "//*[@id=\"menu\"]/a[3]/li";

    public static void clickHamburger(){
        driver.findElement(By.xpath(homeHamburgerMenu)).click();
    }

    public static void clickOnlineProducts() throws Throwable{
        Thread.sleep(2000);
        driver.findElement(By.xpath(onlineProductsXPath)).click();
    }


}
