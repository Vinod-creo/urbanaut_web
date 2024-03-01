package CityPageTest;

import POMRepository.ExploreAll;
import Utility.UtilityClasss.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class TestCategory extends BaseClass {
    String[] myArray = {"EXPERIENCES", "EVENTS", "EAT / DRINK", "DO", "STAY", "REAL LOCAL", "BUY"};
    @Test(priority = 1)
    /*
     * This test case checks whether all categories are present or not.
     * It iterates through each category and verifies if it is present or not.
     */
    public void testCategories() throws InterruptedException {
        List<WebElement> categories = driver.findElements(By.xpath("//div[@class='swiper-head']/div/div[1]"));
        int nocategories = categories.size();
        for (int i = 1; i <= nocategories; i++) {
            String categoriesPath = "(//div[@class='swiper-head']/div/div[1])[" + i + "]";
            WebElement catagory = driver.findElement(By.xpath(categoriesPath));
            String categoryName = catagory.getText();
            webactionutil.checkListcontains(myArray, categoryName);
        }
        System.out.println("All the categories are verified");
    }
    ExploreAll exploreAll;
    @Test(priority = 2)
    /*
     * This test case checks the filter functionality for different categories.
     * It iterates through each category, clicks on the "Explore All" button for that category,
     * and verifies the functionality associated with it.
     */
    public void testCategoriesFilter() throws InterruptedException {
        List<WebElement> categories = driver.findElements(By.xpath("//div[@class='swiper-head']/div/div[1]"));
        int nocategories = categories.size();
        for (int i = 1; i <= nocategories; i++) {
            String categoriesPath = "(//div[@class='swiper-head']/div/div[1])[" + i + "]";
            WebElement catagory = driver.findElement(By.xpath(categoriesPath));
            String categoryName = catagory.getText();
            switch (categoryName) {
                case "EVENTS":
                    exploreAll = citypage.clickEventExploreall();
                    exploreAll.verifyEventExploreAll();
                    System.out.println("EVENTS category is present");
                    break;
                case "EXPERIENCES":
                    exploreAll = citypage.clickExpirenceExploreall();
                    exploreAll.verifyExpirenceExploreAll();
                    System.out.println("Expirence category is present");
                    break;
                case "EAT / DRINK":
                    exploreAll = citypage.clickEattDrinkExploreall();
                    exploreAll.verifyEatDrinkExploreAll();
                    System.out.println("Eat/Drink category is present");
                    break;
                case "REAL LOCAL":
                    exploreAll = citypage.clickRealLocalExploreall();
                    exploreAll.verifyRealLocalExploreAll();
                    System.out.println("Real Local category is present");
                    break;
                case "DO":
                    exploreAll = citypage.clickDoExploreAll();
                    exploreAll.verifyDoExploreAll();
                    System.out.println("Do category is present");
                    break;
                case "STAY":
                    exploreAll = citypage.clickStayExploreAll();
                    exploreAll.verifyStayExploreAll();
                    System.out.println("Stay category is present");
                    break;
                case "BUY":
                    exploreAll = citypage.clickBuyExploreAll();
                    exploreAll.verifyBuyExploreAll();
                    System.out.println("Buy category is present");
                    break;
                default:
                    System.out.println(categoryName + " category is not handled");
            }
            citypage.clickUrbanautLogo();
        }
    }
}
