package POMRepository;

//import Utility.UtilityClass.BaseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;


public class Spot
{
    @FindBy(xpath = "//input[@type='search']")
    public WebElement search;
    @FindBy(xpath = "//button[text()='Book Now']")
    public  WebElement booknow;
    @FindBy(xpath = "//div[text()='Next']")
    public  WebElement next;
    @FindBy(xpath = "//button[text()='Inquire Now']")
    public  WebElement inquireNow;


    @FindBy(xpath = "//input[contains(@class, 'ng-touched')]")
    public WebElement inputStarTouched;

    WebDriver driver;
    public Spot(WebDriver driver)
    {
        this.driver =driver;
        PageFactory.initElements(driver, this);
    }
    public  void ComingSoon()
    {
        System.out.println("Coming soon Executed");
        driver.findElement(By.xpath("//img[@src='assets/svg/urbanaut_icon.svg']")).click();

    }
    public  void BookNow() throws InterruptedException, NoSuchElementException
    {
        booknow.click();
        Thread.sleep(2000) ;
        Set<String> handles = driver.getWindowHandles();
        //String Childid = handles.toArray(new String[0])[handles.size() - 1];
        Iterator it= handles.iterator();
        String parentid =(String) it.next();
        String childid = (String) it.next();
        driver.switchTo().window(childid);
        //driver.findElement(By.xpath("(//mat-chip-listbox/div/div/mat-chip-option//span)[2]/button")).click();
        WebElement dt =driver.findElement(By.xpath("//div[text()='Date']"));
        String text=dt.getText();
        if(text.equals("Date"))
        {
            // dt.click();
            driver.findElement(By.xpath("//img[@src='assets/svg/date.svg']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//span[text()=' 25 ']")).click();
        }
        else
        {
            System.out.println("DATE IS NOT THERE");
        }
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//mat-chip-listbox//div//mat-chip-option//span[2])[1]//button")).click();
        //driver.findElement(By.xpath("//mat-chip-listbox//div/div//mat-chip-option//button")).click();
        //driver.findElement(By.xpath("//span[text()=' 3:00 pm to 4:00 pm ']/../..")).click();
        //driver.findElement(By.xpath("//div[text()='Time']/../div[5]/mat-chip-listbox/div/mat-chip-option/span[2]/button/span[2]")).click();
        //driver.findElement(By.xpath("//div[text()='Time']/../div[4]/mat-chip-listbox/div/mat-chip-option/span[2]/button/span[2]")).click();
        Thread.sleep(2000);
        //List<WebElement> ques=driver.findElements(By.xpath("//app-details-book//form/div/div[contains(@class,'book-category')]/.."));
        List<WebElement> prices=driver.findElements(By.xpath("//form/div//input"));
        int noPrices= prices.size();
        for(int i=1; i<noPrices; i++)
        {
            String pricePath = "(//form/div//input)"+"[" + i + "]";
            WebElement price = driver.findElement(By.xpath(pricePath));
            //WebElement counter= price.findElement(By.xpath(price+"//input[@formcontrolname='quantity']"));
            // WebElement toggle = price.findElement(By.xpath(price+"//input[@formcontrolname='checkBox']"));
            String checkCount =price.getAttribute("class");
           String checkToggle =price.getAttribute("type");
           String checkDiscount=price.getAttribute("formcontrolname");
            if(checkCount.equals("form-control input form-control-sm ng-untouched ng-pristine ng-valid ng-star-inserted"))
            {
                price.clear();
                price.sendKeys("1");
                System.out.println("CHECK COUNTER");
                Thread.sleep(2000);
            }
            else if (checkToggle.equals("checkbox"))
            {
                price.click();
                System.out.println("CHECK TOGGLE");
                Thread.sleep(2000);
            }
            else if(checkDiscount.equals("discount_code"))
            {
                System.out.println("disscount code");
            }
            else
            {
                System.out.println("verify fbp");

            }

        }
//
        next.click();
        Thread.sleep(1000);
        List<WebElement> ques1 = driver.findElements(By.xpath("(//form)[2]/div//input"));
        int questions1 = ques1.size();
        for (int i = 1; i <= questions1; i++)
        {
            String elePath = "((//form)[2]/div//input)" + "[" + i + "]";
            WebElement eleAnswer = driver.findElement(By.xpath(elePath));
            String checkBool = eleAnswer.getAttribute("type");
            String checkNumeric = eleAnswer.getAttribute("class");
            //System.out.println("Type Attribute Value :" + checkBool);
            // System.out.println("Class Attribute Value :" + checkNumeric);
            if (checkBool.equals("checkbox"))
            {
                eleAnswer.click();
                Thread.sleep(2000);
            }
            else if (checkNumeric.equals("form-control input form-control-sm ng-untouched ng-pristine ng-valid"))
            {
                eleAnswer.sendKeys("2"); //Numeric Field
                Thread.sleep(2000);
            } else
            {
                eleAnswer.sendKeys("ANSWER"); // Text type anwser
                Thread.sleep(2000);
            }
        }
        Thread.sleep(5000);
        next.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys("Vinod Kore");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys("vinoda@creoit.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@formcontrolname='phone']")).sendKeys("8050313339");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[text()=' Next']")).click();
        Thread.sleep(2000);
        String pay=driver.findElement(By.xpath("//div[@class='total col-6 ng-star-inserted']")).getText();
        //System.out.println(pay);
        if(pay.equals("You Paid"))
        {
            driver.findElement(By.xpath("//button[text()='Keep exploring']")).click();
            WebElement  searchicon =driver.findElement(By.xpath("//img[@src='assets/png/search_icon.svg']"));
            if(searchicon.isDisplayed())
            {
                System.out.println("Home page displayed");
            }
            else
            {
                System.out.println("Keep exploring and Home page is not displayed");
            }
        }
        else if (pay.equals("You Pay"))
        {
            driver.findElement(By.xpath("//input[@type='checkbox']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//button[text()=' Pay now']")).click();
            Thread.sleep(2000);
            driver.switchTo().frame(1);


            driver.findElement(By.xpath("(//h3[text()='UPI, Cards & more']/../div/button)[1]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='UPI ID/ Mobile Number']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@type='text']")).sendKeys("abcdefg@ybl");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//button[text()='Pay Now']")).click();
            Thread.sleep(10000);

            driver.switchTo().defaultContent();

            WebElement confr=driver.findElement(By.xpath("//div[contains(text(),'confirmed')]"));
            String msg =confr.getText();
            if(msg.equals("Done! Your booking is confirmed"))
            {
                System.out.println("Test case is pass and booking is confirmed");
            }
            else
            {
                System.out.println("Test case is fail and booking is not confirmed");
            }
        }
        System.out.println("Book Now Executed");
        Thread.sleep(5000);
        driver.switchTo().window(parentid);
       driver.findElement(By.xpath("//img[@src='assets/svg/urbanaut_icon.svg']")).click();
        Thread.sleep(10000);

        System.out.println("Before tab closing");
        driver.close();
        System.out.println("After tab closing");
    }
    public void SoldOut() throws InterruptedException
    {
        driver.findElement(By.xpath("//button[text()='Notify Me']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys("Vinod");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys("Vinoda@creoit.com");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[text()='NOTIFY ME!']")).click();

        String sucessmsg=driver.findElement(By.xpath("(//div[@class='success'])[2]")).getText();
        if(sucessmsg.equals("We will notify you as soon as we have updates."))
        {
            driver.findElement(By.xpath("//button[text()='Close']")).click();
            System.out.println("Sold out is pass");
        }
        else
        {
            System.out.println("sold out is fail");
        }
        System.out.println("Sold Out Executed");
        driver.findElement(By.xpath("//img[@src='assets/svg/urbanaut_icon.svg']")).click();
    }
    public void InquireNow() throws InterruptedException
    {
        inquireNow.click();
        Thread.sleep(2000) ;
        Set<String> handles = driver.getWindowHandles();
        //String Childid = handles.toArray(new String[0])[handles.size() - 1];
        Iterator it= handles.iterator();
        String parentid =(String) it.next();
        String childid = (String) it.next();
        driver.switchTo().window(childid);
        //driver.findElement(By.xpath("(//mat-chip-listbox/div/div/mat-chip-option//span)[2]/button")).click();
        WebElement dt =driver.findElement(By.xpath("//div[text()='Date']"));
        String text=dt.getText();
        if(text.equals("Date"))
        {
            // dt.click();
            driver.findElement(By.xpath("//img[@src='assets/svg/date.svg']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//span[text()=' 25 ']")).click();
        }
        else
        {
            System.out.println("DATE IS NOT THERE");
        }
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//mat-chip-listbox//div//mat-chip-option//span[2])[1]//button")).click();
        //driver.findElement(By.xpath("//mat-chip-listbox//div/div//mat-chip-option//button")).click();
        //driver.findElement(By.xpath("//span[text()=' 3:00 pm to 4:00 pm ']/../..")).click();
        //driver.findElement(By.xpath("//div[text()='Time']/../div[5]/mat-chip-listbox/div/mat-chip-option/span[2]/button/span[2]")).click();
        //driver.findElement(By.xpath("//div[text()='Time']/../div[4]/mat-chip-listbox/div/mat-chip-option/span[2]/button/span[2]")).click();
        Thread.sleep(2000);
        //List<WebElement> ques=driver.findElements(By.xpath("//app-details-book//form/div/div[contains(@class,'book-category')]/.."));
        List<WebElement> prices=driver.findElements(By.xpath("//form/div//input"));
        int noPrices= prices.size();
        for(int i=1; i<noPrices; i++)
        {
            String pricePath = "(//form/div//input)"+"[" + i + "]";
            WebElement price = driver.findElement(By.xpath(pricePath));
            //WebElement counter= price.findElement(By.xpath(price+"//input[@formcontrolname='quantity']"));
            // WebElement toggle = price.findElement(By.xpath(price+"//input[@formcontrolname='checkBox']"));
            String checkCount =price.getAttribute("class");
            String checkToggle =price.getAttribute("type");
            String checkDiscount=price.getAttribute("formcontrolname");
            if(checkCount.equals("form-control input form-control-sm ng-untouched ng-pristine ng-valid ng-star-inserted"))
            {
                price.sendKeys("1");
                System.out.println("CHECK COUNTER");
            }
            else if (checkToggle.equals("checkbox"))
            {
                price.click();
                System.out.println("CHECK TOGGLE");
            }
            else if(checkDiscount.equals("discount_code"))
            {
                System.out.println("disscount code");
            }
            else
            {
                System.out.println("verify fbp");

            }

        }
//
        next.click();
        Thread.sleep(1000);
        List<WebElement> ques1 = driver.findElements(By.xpath("(//form)[2]/div//input"));
        int questions1 = ques1.size();
        for (int i = 1; i <= questions1; i++)
        {
            String elePath = "((//form)[2]/div//input)" + "[" + i + "]";
            WebElement eleAnswer = driver.findElement(By.xpath(elePath));
            String checkBool = eleAnswer.getAttribute("type");
            String checkNumeric = eleAnswer.getAttribute("class");
            //System.out.println("Type Attribute Value :" + checkBool);
            // System.out.println("Class Attribute Value :" + checkNumeric);
            if (checkBool.equals("checkbox"))
            {
                eleAnswer.click();
            }
            else if (checkNumeric.equals("form-control input form-control-sm ng-untouched ng-pristine ng-valid"))
            {
                eleAnswer.sendKeys("2"); //Numeric Field
            } else
            {
                eleAnswer.sendKeys("ANSWER"); // Text type anwser
            }
        }
        Thread.sleep(5000);
        next.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys("Vinod Kore");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys("vinoda@creoit.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@formcontrolname='phone']")).sendKeys("8050313339");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[text()=' Check availability']")).click();
        Thread.sleep(2000);
        String pay=driver.findElement(By.xpath("//div[@class='total col-6 ng-star-inserted']")).getText();
        //System.out.println(pay);
        if(pay.equals("You Paid"))
        {
            driver.findElement(By.xpath("//button[text()='Keep exploring']")).click();
            WebElement  searchicon =driver.findElement(By.xpath("//img[@src='assets/png/search_icon.svg']"));
            if(searchicon.isDisplayed())
            {
                System.out.println("Home page displayed");
            }
            else
            {
                System.out.println("Keep exploring and Home page is not displayed");
            }
        }
        else if (pay.equals("You Pay")) {
            WebElement reqtext = driver.findElement(By.xpath("//div[@class='head-content ng-star-inserted']"));
            String ReqText = reqtext.getText();
            if (ReqText.equals("We have received your request!"))
            {
                System.out.println("InquireNow is pass");

            }
            else
            {
                System.out.println("InquireNow is pass fail");
            }

        }

        System.out.println("Before tab closing");
        driver.close();
        System.out.println("After tab closing");
    }
    public static void Action_FBP()
    {
        System.out.println("FIXED BASE PRICE");
    }
    public static void Action_toggle(WebElement toggle)
    {
//        driver.findElement(By.xpath("//input[@role='switch']")).click();
//        toggle.findElement(By.xpath("//input[@role='switch']")).click();
        toggle.click();
    }
    public static void Action_Count(WebElement counter)
    {
        counter.sendKeys("1");
//        counter.findElement(By.xpath("//span[text()='+']")).click();
    }
}
