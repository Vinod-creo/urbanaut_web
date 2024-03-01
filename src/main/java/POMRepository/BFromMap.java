package POMRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;


public class BFromMap
{
    @FindBy(xpath = "//input[@type='search']")
    public static WebElement search;
    @FindBy(xpath = "//div[contains(text(),'list of destinations')]/../div[2]/div/a")
    public static WebElement searchedSpot;
    @FindBy(xpath = "//label[text()='Map ']")
    public static WebElement map;

    @FindBy(xpath = "//img[@class='icons']")
    public static WebElement mapIcons;

    public static String spotText = "Chennai_Airport";

    public static String spotText1=  "Yoga..";
    WebDriver driver;

    public BFromMap(WebDriver driver)
    {
        this.driver =driver;
        PageFactory.initElements(driver, this);
    }

    public  void SearchClear() throws InterruptedException
    {
        BFromMap.search.click();
        BFromMap.search.clear();
        BFromMap.search.sendKeys("chenn");
        BFromMap.searchedSpot.click();
//        driver.findElement(By.xpath("//input[@type='search']")).click();
//
//        driver.findElement(By.xpath("//input[@type='search']")).clear();
//
//        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("CHENNAI");
//        Thread.sleep(2000);
//
//        driver.findElement(By.xpath("(//div[contains(text(),'list of destinations')])[2]/../div[2]/div/a")).click();
//        Thread.sleep(2000);

//        driver.findElement(By.xpath("//label[text()='Map ']")).click();
//        Thread.sleep(10000);
        //driver.switchTo().frame(1);
       // driver.findElement(By.xpath("//button[@class='dismissButton']")).click();
    }
public   void MapBooking()throws InterruptedException
{
    driver.findElement(By.xpath("//label[text()='Map ']")).click();
    Thread.sleep(10000);
        //   List<WebElement> icons=driver.findElements(By.xpath("//img[@class='icons']"));
        //driver.findElement(By.xpath("//label[text()='Map ']")).click();
        List<WebElement> expicons = driver.findElements(By.xpath("//img[@class='icons' and @src='assets/svg/experience.svg']"));
        int noexpIcons = expicons.size();
        for (int i = 1; i <= noexpIcons; i++)
        {
            String expIconPath = "(//img[@class='icons' and @src='assets/svg/experience.svg'])" + "[" + i + "]";

            WebElement expIcon = driver.findElement(By.xpath(expIconPath));
            expIcon.click();
            WebElement expIconText =driver.findElement(By.xpath(expIconPath+"/../../div[2]/div[1]/div[1]/div"));
            String intoIcon = expIconPath+"/../../div[2]/div[1]/div[1]/div";
            String text =expIconText.getText();
           if(text.equals(spotText))
           {
               Thread.sleep(5000);
               driver.findElement(By.xpath(intoIcon+"/../../../a/img")).click();
               Thread.sleep(2000);
               expIcon.click();
               Thread.sleep(5000);
               expIconText.click();
               Thread.sleep(5000);
               BFromMap bfm = new BFromMap(driver);
               bfm.verifyButton();
               break;
           }
           else
           {
               System.out.println("expexted spot is not there");
           }

        }
}
public void verifyButton() throws InterruptedException
{
    Spot spot=new Spot(driver);
    WebElement button = driver.findElement(By.xpath("//div[contains(@class,'justify-content-end')]//button"));
    String buttonText = button.getText();
    //System.out.println(text);
    Thread.sleep(2000);

    switch (buttonText)
    {
        case "Coming Soon":
            spot.ComingSoon();
            break;
        case "Book Now":
            spot.BookNow();
            break;
        case "Sold Out":
            spot.SoldOut();
            break;
        case "Inquire Now":
            spot.InquireNow();
            break;
    }
}

}


