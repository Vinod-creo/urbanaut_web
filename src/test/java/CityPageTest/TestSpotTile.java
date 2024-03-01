package CityPageTest;

import Utility.UtilityClasss.BaseClass;
import Utility.UtilityClasss.WebActionUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class TestSpotTile extends BaseClass {
    @Test(priority = 1)
    public void verifyExpirenceSpotTiles() throws InterruptedException {
        citypage.verifyAllSpotTiles("Experiences");
    }
    @Test(priority = 2)
    public void verifyEventsSpotTiles() throws InterruptedException {
        citypage.verifyAllSpotTiles("Events");
    }
    @Test(priority = 3)
    public void verifyDoSpotTiles() throws InterruptedException {
        citypage.verifyAllSpotTiles("Do");
    }
    @Test(priority = 4)
    public void verifyEatAndDrinkSpotTiles() throws InterruptedException {
        citypage.verifyAllSpotTiles("Eat / Drink");
    }
    @Test(priority = 5)
    public void verifyBuySpotTiles() throws InterruptedException {
        citypage.verifyAllSpotTiles("Buy");
    }
    @Test(priority = 6)
    public void verifyStaySpotTiles() throws InterruptedException {
        citypage.verifyAllSpotTiles("Stay");
    }
    @Test(priority = 7)
    public void verifyRealAndlocalSpotTiles() throws InterruptedException {
        citypage.verifyAllSpotTiles("Real local");
    }

}
