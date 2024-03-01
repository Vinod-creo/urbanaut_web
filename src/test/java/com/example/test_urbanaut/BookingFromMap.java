package com.example.test_urbanaut;

import POMRepository.BFromMap;
import Utility.UtilityClasss.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class BookingFromMap extends BaseClass
{
    @Test
    public  void BFM() throws InterruptedException
    {
        BFromMap bfm =new BFromMap(driver);
        driver.get("https://dev.urbanaut.app/");
        bfm.SearchClear();
        bfm.MapBooking();

    }


}
