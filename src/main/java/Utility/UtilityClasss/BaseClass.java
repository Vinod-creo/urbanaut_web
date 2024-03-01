package Utility.UtilityClasss;


import POMRepository.CityPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseClass {
    String app_url = "https://dev.urbanaut.app/";
    //public Spot spot;
    public WebDriver driver;
    public WebActionUtil webactionutil;
    public CityPage citypage;

    @BeforeMethod
    public void OpenApplication() {
        driver = new ChromeDriver();
//        driver = new SafariDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://dev.urbanaut.app/");
        webactionutil = new WebActionUtil(driver);
        citypage = new CityPage(driver, webactionutil);
    }

    @AfterMethod
    public void CloseApplication() {
        driver.quit();
    }

}
