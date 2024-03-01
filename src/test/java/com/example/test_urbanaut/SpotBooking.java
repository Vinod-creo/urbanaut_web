package com.example.test_urbanaut;

import POMRepository.Spot;
import Utility.UtilityClasss.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class SpotBooking extends BaseClass
{
    @Test
    public void Expirence() throws InterruptedException
    {
        Spot spot = new Spot(driver);
        String [] urls={"https://dev.urbanaut.app/spot/chennai_airport","https://dev.urbanaut.app/spot/gowda-mangalorean-oota"};
        //String[] urls = {"https://dev.urbanaut.app/spot/yoga-4038","https://dev.urbanaut.app/spot/test-preview","https://dev.urbanaut.app/spot/clay-play-session"};
        // String[] urls = {"https://dev.urbanaut.app/spot/test-preview","https://dev.urbanaut.app/spot/clay-play-session"};
        //String[] urls = {"https://dev.urbanaut.app/spot/chennai_airport"};
       // https://dev.urbanaut.app/spot/cont-test-exp   https://dev.urbanaut.app/spot/test-preview
        //String[] urls = {"https://dev.urbanaut.app/spot/rsvp-v2"};
        //driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        for (String url : urls)
        {
            driver.get(url);
           // driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
            Thread.sleep(2000);
            WebElement button = driver.findElement(By.xpath("//div[contains(@class,'justify-content-end')]//button"));
            String buttonText = button.getText();
            //System.out.println(text);
           Thread.sleep(2000);
//            Spot spot = new Spot(driver);
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
}





