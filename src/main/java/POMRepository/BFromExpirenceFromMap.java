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


public class BFromExpirenceFromMap
{
    WebDriver driver;
    public BFromExpirenceFromMap (WebDriver driver)
    {
        this.driver =driver;
        PageFactory.initElements(driver, this);
    }
    public  void MapBooking()throws InterruptedException
    {

        driver.findElement(By.xpath("//label[text()='Map ']")).click();
        Thread.sleep(2000);
       // driver.findElement(By.xpath("//button[@aria-label='Zoom in']")).click();
        List<WebElement> expicons = driver.findElements(By.xpath("//img[@class='icons' and @src='assets/svg/experience.svg']"));
        int noexpIcons = expicons.size();
        for (int i = 1; i <= noexpIcons; i++)
        {
           // driver.findElement(By.xpath("//button[@aria-label='Zoom in']")).click();
            String expIconPath = "(//img[@class='icons' and @src='assets/svg/experience.svg'])" + "[" + i + "]";
            WebElement expIcon = driver.findElement(By.xpath(expIconPath));
           // driver.findElement(By.xpath("//button[@aria-label='Zoom in']")).click();
            Thread.sleep(5000);
            expIcon.click();
            Thread.sleep(2000);
            WebElement expIconText =driver.findElement(By.xpath(expIconPath+"/../../div[2]/div[1]/div[1]/div"));
            String intoIcon = expIconPath+"/../../div[2]/div[1]/div[1]/div";
            Thread.sleep(5000);
            driver.findElement(By.xpath(intoIcon+"/../../../a/img")).click();
            Thread.sleep(2000);
            expIcon.click();
            Thread.sleep(5000);
            expIconText.click();
            Thread.sleep(5000);
            BFromMap bfm = new BFromMap(driver);
            bfm.verifyButton();
            driver.findElement(By.xpath("//div[text()='Experiences']/../div[2]/a")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//label[text()='Map ']")).click();
            Thread.sleep(10000);

        }



    }
    public  void SearchClear() throws InterruptedException , NoSuchElementException
    {

//        BFromMap.search.click();
//        BFromMap.search.clear();
//        BFromMap.search.sendKeys("chenn");
//        BFromMap.searchedSpot.click();
//        driver.findElement(By.xpath("//input[@type='search']")).click();
//
//        driver.findElement(By.xpath("//input[@type='search']")).clear();

//        //driver.findElement(By.xpath("//input[@type='search']")).sendKeys("BENGALURU");
//       driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Mysore");
//       // driver.findElement(By.xpath("//input[@type='search']")).sendKeys("CHENNAI");
//        //driver.findElement(By.xpath("//input[@type='search']")).sendKeys("GOA");
//        Thread.sleep(2000);
        String[] citys={"mysore","Bengaluru", "goa", "chennai","AHMEDABAD", "ALIBAG", "AMSTERDAM", "BHOPAL","BRUSSELS","COORG","DELHI","DUBAI","HYDERABAD"};
        for(String city:citys)
        {
            try
            {
                //img[@src='assets/svg/urbanaut_icon.svg']
                driver.findElement(By.xpath("//img[@src='assets/svg/urbanaut_icon.svg']")).click();
                driver.findElement(By.xpath("//input[@type='search']")).click();

                driver.findElement(By.xpath("//input[@type='search']")).clear();

                driver.findElement(By.xpath("//input[@type='search']")).sendKeys(city);
                driver.findElement(By.xpath("(//div[contains(text(),'list of destinations')])[2]/../div[2]/div/a")).click();
                Thread.sleep(2000);
                driver.findElement(By.xpath("//div[text()='Experiences']/../div[2]/a")).click();
                Thread.sleep(2000);
                driver.findElement(By.xpath("//label[text()='Map ']")).click();
                Thread.sleep(2000);
                BFromExpirenceFromMap bfem = new BFromExpirenceFromMap(driver);
                bfem.MapBooking();
            }
            catch (Exception e)
            {
                continue;

            }

        }


    }
}
