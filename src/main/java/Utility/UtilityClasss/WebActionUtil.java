package Utility.UtilityClasss;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class WebActionUtil extends BaseClass {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;


    public WebActionUtil(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void verifyUrlAfterElementClick(String url) throws InterruptedException {
        // Wait until the URL becomes the expected URL or until timeout
        Thread.sleep(2000);
        // Get the current URL
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        // Check if the current URL matches the expected URL
        String message = currentUrl.equalsIgnoreCase(url) ? "Current URL matches the expected URL: " + url : "Current URL does not match the expected URL: " + url;
        // Print the message
        System.out.println(message);
    }


    public void clickElement(WebElement element) throws InterruptedException {
        // Wait for the element to be clickable
        waitUntilElementVisible(element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        // Click on the element
//        element.click();
        try {
            element.click();
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            element.click();
        } catch (Exception e) {
            System.out.println("Failed: Could not Click");
        }
    }

    public WebElement waitUntilElementVisible(WebElement element) throws InterruptedException {
        // Wait for the element to be clickable
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return element;
        } catch (Exception ignored) {
            Thread.sleep(1000);
            wait.until(ExpectedConditions.visibilityOf(element));
            return element;
        }
    }

    public void clearElemnt(WebElement element) {
        // Wait for the element to be visible
        WebElement clearableElement = wait.until(ExpectedConditions.visibilityOf(element));
        // Clear the text input of the element
        clearableElement.clear();

    }

    public void SendkeysToElement(WebElement element, String text) {
        // Wait for the element to be visible
        WebElement targetElement = wait.until(ExpectedConditions.visibilityOf(element));
        // Send the specified text to the target element
        targetElement.sendKeys(text);
    }

    public void clickAndClearElement(WebElement element) {
        // Wait for the element to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(element));

        // Click on the element
        element.click();

        // Clear the content of the element
        element.clear();
    }

    public void clickClearAndSendkeysToElement(WebElement element, String text) {
        // Wait for the element to be clickable
        WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(element));

        // Click on the element
        clickableElement.click();

        // Clear the content of the element
        clickableElement.clear();

        // Send the specified text to the element
        clickableElement.sendKeys(text);
    }


    public void clickElement1AndClearElement2(WebElement element1, WebElement element2) {
        clickElementOnceVisible(element1);
        clearElementOnceVisible(element2);
    }

    public void searchAndPickOption(WebElement elementToSearch, String textToSearch, WebElement elementToPick) {
        elementToSearch.sendKeys(textToSearch);
        elementToPick.click();
    }

    public void clickElementOnceVisible(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void clearElementOnceVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element)).clear();
    }

    public void clickElementOnceVisibleJavaExecutor(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        js.executeScript("arguments[0].click();", element);
    }

    public boolean verifyStringInArray(String[] allText, String target) {
        for (String text : allText) {
            if (text.equals(target)) {
                return true;
            }
        }
        return false;
    }

    public void checkListcontains(String[] myArray, String searchString) {
        if (verifyStringInArray(myArray, searchString)) {
            System.out.println(searchString + ":  is found in the List.");
        } else {
            System.out.println(searchString + ":  is not found in the List.");
        }
    }

    public void verifyUrlAfterElementCLickCheckitcontains(String url) throws InterruptedException {
        Thread.sleep(2000);
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        String message = currentUrl.contains(url) ? url + ": URL is matched" : url + ": URL is not matched";
        System.out.println(message);
    }

    Actions actions;

    public void moveToElementAndClick(WebElement element) throws InterruptedException {
        Actions actions = new Actions(driver);
        waitUntilElementVisible(element);
//        wait.until(ExpectedConditions.elementToBeClickable(element));
//        actions.moveToElement(element).click().perform();
        try {
            //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
//            actions.moveToElement(element).pause(Duration.ofSeconds(1)).click().perform();
        } catch (org.openqa.selenium.StaleElementReferenceException e) {
//            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        }
    }


    public void refreshPage() {
        driver.navigate().refresh();

    }

    public void switchToNewTab(WebDriver driver, String expectedUrl) {
        Set<String> windowHandles = driver.getWindowHandles();
        String newTabHandle = windowHandles.toArray(new String[0])[windowHandles.size() - 1]; // Switch to the new tab (assuming it's the last one opened)
        driver.switchTo().window(newTabHandle);
        if (driver.getCurrentUrl().equals(expectedUrl)) {  // Verify the URL of the new tab
            System.out.println("Verification successful! New tab has the expected URL: " + expectedUrl);
        } else {
            System.out.println("Verification failed! New tab does not have the expected URL: " + expectedUrl);
        }
        driver.close();
        driver.switchTo().window(windowHandles.toArray(new String[0])[0]); // Switch back to the first tab
    }


}
