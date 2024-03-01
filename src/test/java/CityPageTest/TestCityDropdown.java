package CityPageTest;

import Utility.UtilityClasss.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TestCityDropdown extends BaseClass {
    WebDriverWait wait;

    @Test(priority =1)
    /*
     * This test case verifies the functionality of a search icon on the city page.
     * It clicks on the search icon and checks whether the dropdown appears.
     */ public void testSearchIcon() throws InterruptedException {
        citypage.clickSearchIcon();
        String message2 = citypage.dropdown.isDisplayed() ? "Dropdown is displyed" : "Dropdown is not displayed";
        System.out.println(message2);
        System.out.println("Search icon is clicked and verified");
    }

    @Test(priority = 2)
    /*
     * This test case picks a popular city from the popular city list.
     * and verifies the URL after selecting city.
     */ public void pickPopularCity() throws InterruptedException {
        String city = "Delhi";
        citypage.pickPopularCity(city);
        webactionutil.verifyUrlAfterElementClick("https://dev.urbanaut.app/?city=" + city);
        System.out.println("pick popular city is verified ");
    }

    @Test(priority = 3)
    /*
     * Test case to search for a popular city, pick it from the dropdown,
     * and verify the URL after selecting a city.
     */ public void searchAndPickPopularCity() throws InterruptedException {
        String city = "Goa";
        citypage.searchAndPick(city);
        webactionutil.verifyUrlAfterElementClick("https://dev.urbanaut.app/?city=" + city);
        System.out.println("search popular city and pick is verified");
    }

    @Test(priority = 4)
    /*
     * This test case searches for and picks non-popular cities from the list of destinations.
     * It verifies the URL after selecting a non-popular city.
     */ public void searchAndPickNonPopularCity() throws InterruptedException {
        String city = "Jodhpur";
        citypage.searchAndPick(city);
        webactionutil.verifyUrlAfterElementClick("https://dev.urbanaut.app/?city=" + city);
        System.out.println("search non popular city and pick is verified");
    }

    @Test(priority = 5)
    /*
     * This test case scrolls through the list of destinations and picks popular city.
     * It verifies the URL after selecting popular city.
     */ public void scrollAndPickPopularCity() throws InterruptedException {
        String city = "Mumbai";
        citypage.scrollAndPick(city);
        webactionutil.verifyUrlAfterElementClick("https://dev.urbanaut.app/?city=" + city);
        System.out.println("scroll and pick popular city is verified");
    }

    @Test(priority = 6)
    /*
     * This test case scrolls through the list of destinations and picks nonpopular city.
     * It verifies the URL after selecting nonpopular city.
     */ public void scrollAndPickNonPopularCity() throws InterruptedException {
        String city = "Sri Lanka South";
        citypage.scrollAndPick(city);
        webactionutil.verifyUrlAfterElementClick("https://dev.urbanaut.app/?city=" + city);
        System.out.println("scroll and pick nonpopular city is verified");
    }

    @Test(priority = 7)
    /*
     * This test performs the following actions:
     * 1. Taps on the search bar.
     * 2. Picks the city "GOA"(for eg) from the search options.
     * 3. Records the current URL before dismissing the search bar.
     * 4. Taps on the search bar to dismiss it.
     * 5. Refreshes the page.
     * 6. Verifies that the URL after refreshing is the same as the URL before refreshing.
     * 7. Prints a verification message.
     */ public void searchAndDismissAndRefresh() throws InterruptedException {
        webactionutil.clickAndClearElement(citypage.search);
        webactionutil.searchAndPickOption(citypage.search, "GOA", citypage.searchedOption);
        String beforeRefreshUrl = driver.getCurrentUrl();
        citypage.clickSendhAndDismiss();
        webactionutil.refreshPage();
        webactionutil.verifyUrlAfterElementClick(beforeRefreshUrl);
        System.out.println("autofill current city is verified");
    }

    /*********************** Below test cases apply for all the cities ***************************/
//    @Test
//    /*
//     * Test case to pick all popular cities from the dropdown,
//     * and verify the URL after selecting each city.
//     */ public void pickAllPopularCity() throws InterruptedException {
//        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        webactionutil.clickAndClearElement(citypage.search);
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        List<WebElement> popularCities = driver.findElements(By.xpath("//div[text()='Popular destinations']/../div[2]/div/span"));
//        int nopopularCities = popularCities.size();
//        for (int i = 1; i <= nopopularCities; i++) {
//            String citiesPath = "(//div[text()='Popular destinations']/../div[2]/div/span)[" + i + "]";
//            WebElement cities = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(citiesPath)));
//            String cityNmae = cities.getText();
//            System.out.println(cityNmae);
//            js.executeScript("arguments[0].click();", cities);
//            webactionutil.verifyUrlAfterElementClick("https://dev.urbanaut.app/?city=" + cityNmae);
//            webactionutil.clickAndClearElement(citypage.search);
//        }
//        System.out.println("pick popular city is verified ");
//    }
//
//    @Test
//    /*
//     * Test case to search for a popular city, pick it from the dropdown,
//     * and verify the URL after selecting each city.
//     */ public void searchAndPickAllPopularCity() throws InterruptedException {
//        webactionutil.clickAndClearElement(citypage.search);
//        List<WebElement> popularCities = driver.findElements(By.xpath("//div[text()='Popular destinations']/../div[2]/div/span"));
//        int nopopularCities = popularCities.size();
//        for (int i = 1; i <= nopopularCities; i++) {
//            String citiespath = "(//div[text()='Popular destinations']/../div[2]/div/span)[" + i + "]";
//            WebElement cities = driver.findElement(By.xpath(citiespath));
//            String cityNmae = cities.getText();
//            System.out.println(cityNmae);
//            webactionutil.searchAndPickOption(citypage.search, cityNmae, citypage.searchedOption);
//            webactionutil.verifyUrlAfterElementClick("https://dev.urbanaut.app/?city=" + cityNmae);
//            webactionutil.clickAndClearElement(citypage.search);
//        }
//        System.out.println("search popular city and pick is verified");
//    }
//
//    @Test
//    /*
//     * This test case searches for and picks non-popular cities from the list of destinations.
//     * It verifies the URL after selecting each non-popular city.
//     */ public void searchAndPickAllNonPopularCity() throws InterruptedException {
//        webactionutil.clickAndClearElement(citypage.search);
//        List<WebElement> allCities = driver.findElements(By.xpath("//div[text()=' Pick from our list of destinations ']/../div[4]/div/a"));
//        int noAllCities = allCities.size();
//        for (int i = 1; i <= noAllCities; i++) {
//            String citiespath = "(//div[text()=' Pick from our list of destinations ']/../div[4]/div/a)[" + i + "]";
//            WebElement cities = driver.findElement(By.xpath(citiespath));
//            String cityNmae = cities.getText();
//            if (!cityNmae.equalsIgnoreCase("BENGALURU") && !cityNmae.equalsIgnoreCase("DELHI") && !cityNmae.equalsIgnoreCase("GOA") && !cityNmae.equalsIgnoreCase("MUMBAI") && !cityNmae.equalsIgnoreCase("MYSORE")) {
//                System.out.println(cityNmae);
//                webactionutil.searchAndPickOption(citypage.search, cityNmae, citypage.searchedOption);
//                webactionutil.verifyUrlAfterElementClick("https://dev.urbanaut.app/?city=" + cityNmae);
//                webactionutil.clickAndClearElement(citypage.search);
//            } else {
//                System.out.println(cityNmae + " is popular city");
//            }
//        }
//        System.out.println("search non popular city and pick is verified");
//    }
//
//    @Test
//    /*
//     * This test case scrolls through the list of destinations and picks each city one by one.
//     * It verifies the URL after selecting each city.
//     */ public void scrollAndPickAllCity() throws InterruptedException {
//        webactionutil.clickElement(citypage.search);
//        List<WebElement> allCities = driver.findElements(By.xpath("//div[text()=' Pick from our list of destinations ']/../div[4]/div/a"));
//        int noAllCities = allCities.size();
//        for (int i = 1; i <= noAllCities; i++) {
//            String citiespath = "(//div[text()=' Pick from our list of destinations ']/../div[4]/div/a)[" + i + "]";
//            WebElement cities = driver.findElement(By.xpath(citiespath));
//            String cityName = cities.getText();
//            try {
//                webactionutil.moveToElementAndClick(cities);
//            } catch (Exception ignore) {
//                System.out.println("failed to click: " + cityName);
//                continue;
//            }
//            webactionutil.verifyUrlAfterElementClick("https://dev.urbanaut.app/?city=" + cityName);
//            System.out.println(cityName + " got clicked");
//            webactionutil.clickElement(citypage.search);
//        }
//        System.out.println("scroll and pick the city is verified");
//    }
}
