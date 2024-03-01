package CityPageTest;

import Utility.UtilityClasss.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class TestHorizontalScroll extends BaseClass {
    /*verify the right scroll and left scroll*/
    @Test
    public void testHorizontalScroll1() throws InterruptedException {
        String[] urls = {"https://dev.urbanaut.app/?city=Mysore", "https://dev.urbanaut.app/?city=Bengaluru", "https://dev.urbanaut.app/?city=Delhi", "https://dev.urbanaut.app/?city=Mumbai", "https://dev.urbanaut.app/?city=Goa"};
        for (String url : urls) {
            driver.get(url);
            List<WebElement> spotsRails = driver.findElements(By.xpath("//div[@class='ngu-touch-container']"));
            int nospotsRails = spotsRails.size();
            for (int i = 1; i <= nospotsRails; i++) {
                String spotsRailPath = "(//div[@class='ngu-touch-container'])[" + i + "]";
                WebElement spotsRail = driver.findElement(By.xpath(spotsRailPath));
                List<WebElement> spotTiles = driver.findElements(By.xpath(spotsRailPath + "//div/ngu-tile"));
                int nospotTiles = spotTiles.size();
                WebElement firstTile = driver.findElement(By.xpath(spotsRailPath + "//div/ngu-tile[1]"));
                String lastTilePath = spotsRailPath + "//div/ngu-tile[" + nospotTiles + "]";
                WebElement lastTile = driver.findElement(By.xpath(lastTilePath));
                int rightClicks = 0;
                int leftClicks = 0;
                while (nospotTiles > 1) {
                    if (!lastTile.isDisplayed()) {
                        System.out.println("last element is not displayed");
                        citypage.clickRightScroll(i);
                        rightClicks++;
                    } else if (lastTile.isDisplayed()) {
                        System.out.println("last element is displayed");
                        break;
                    }
                }
                while (rightClicks > 0) {
                    if (!firstTile.isDisplayed()) {
                        System.out.println("first element is not displayed");
                        citypage.clickLeftScroll(i);
                        leftClicks++;
                    } else if (firstTile.isDisplayed()) {
                        System.out.println("first element is displayed");
                        break;
                    }
                }
            }
            System.out.println("right scroll and left scroll is verified");
        }
    }
}














