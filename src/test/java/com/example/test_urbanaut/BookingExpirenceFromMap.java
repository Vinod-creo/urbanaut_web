package com.example.test_urbanaut;

import POMRepository.BFromExpirenceFromMap;
import Utility.UtilityClasss.BaseClass;
import org.testng.annotations.Test;

public class BookingExpirenceFromMap extends BaseClass
{
//    @Test
//    public static void BEFM() throws InterruptedException
//    {
//        driver.get("https://dev.urbanaut.app/");
//        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        BFromExpirenceFromMap.SearchClear();
//        BFromExpirenceFromMap.MapBooking();
//
//
//    }
    @Test
    public  void BEFMForAllCity() throws InterruptedException
    {
        driver.get("https://dev.urbanaut.app/");
        BFromExpirenceFromMap bfem = new BFromExpirenceFromMap(driver);
        bfem.SearchClear();

    }

}
