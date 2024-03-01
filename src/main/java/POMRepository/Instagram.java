package POMRepository;

import Utility.UtilityClasss.WebActionUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class Instagram extends BasePOMClass {
    WebDriverWait wait;
    public Instagram(WebDriver driver, WebActionUtil webActionUtil) {
        super(driver, webActionUtil);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @FindBy(xpath = "//img[contains(@alt, 'urbanaut_')]")
    public WebElement urbanautLogoInsta;
    public void verifyUrabanautLogoOnInsta() throws InterruptedException {
        Set<String> handles = driver.getWindowHandles();
        Iterator it = handles.iterator();
        String parentid = (String) it.next();
        String childid = (String) it.next();
        driver.switchTo().window(childid);
        webactionutil.waitUntilElementVisible(urbanautLogoInsta);
        if (urbanautLogoInsta.isDisplayed()) {
            System.out.println("urabanuat logo is displayed on insta");
        } else {
            System.out.println("urabanuat logo is not displayed on insta");
        }
    }
    public void verifuInstagramUrl()
    {
        webactionutil.switchToNewTab( driver,"https://www.instagram.com/urbanaut_/");
    }

}
