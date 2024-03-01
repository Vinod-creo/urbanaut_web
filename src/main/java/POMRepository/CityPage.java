package POMRepository;

import Utility.UtilityClasss.WebActionUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class CityPage<B2B> extends BasePOMClass {
    WebDriverWait wait;
    Instagram instagram;

    public CityPage(WebDriver driver, WebActionUtil webActionutil) {
        super(driver, webActionutil);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(xpath = "//img[@src='assets/svg/urbanaut_icon.svg']")
    public WebElement urbanautLogo;
    @FindBy(xpath = "//a[text()='List with us']")
    public WebElement ListWithUs;
    @FindBy(xpath = "//a[text()='BOOK A DEMO']")
    public WebElement BookADemoLink;

    @FindBy(xpath = "//label[text()='List']")
    public WebElement list;
    @FindBy(xpath = "//label[text()='Map ']")
    public WebElement map;
    @FindBy(xpath = "//img[@src='assets/png/search_icon.svg']")
    public WebElement searchicon;
    @FindBy(xpath = "//div[@class='cdk-overlay-pane']")
    public WebElement dropdown;

    @FindBy(xpath = "//input[@type='text']")
    public WebElement search;
    @FindBy(xpath = "//div[text()='Events']/../div[2]/a")
    public WebElement eventExploreAll;
    @FindBy(xpath = "//div[text()='Experiences']/../div[2]/a")
    public WebElement expirenceExploreAll;
    @FindBy(xpath = "//div[text()='Eat / Drink']/../div[2]/a")
    public WebElement eatdrinkExploreAll;
    @FindBy(xpath = "//div[text()='Real local']/../div[2]/a")
    public WebElement reallocalExploreAll;
    @FindBy(xpath = "//div[text()='Do']/../div[2]/a")
    public WebElement doExploreAll;
    @FindBy(xpath = "//div[text()='Stay']/../div[2]/a")
    public WebElement stayExploreAll;
    @FindBy(xpath = "//div[text()='Buy']/../div[2]/a")
    public WebElement buyExploreAll;
    @FindBy(xpath = "(//div[contains(text(),' list of destinations ')]/../div[2]/div/a)[1]")
    public WebElement searchedOption;
    @FindBy(xpath = "//button[@class='rightRs']")
    public WebElement rightScroll;
    @FindBy(xpath = "//img[@src='assets/png/insta.png']")
    public WebElement instaLogo;
    @FindBy(xpath = "//img[contains(@alt, 'urbanaut_')]")
    public WebElement urbanautLogoInsta;
    @FindBy(xpath = "//a[@ href='https://www.instagram.com/urbanaut_/']/span[1]")
    public WebElement joinourgramLink;
    @FindBy(xpath = "//app-footer//a[3]/span[text()='Home']")
    public WebElement homeLink;
    @FindBy(xpath = "//app-footer//a[4]/span[text()='T&C']")
    public WebElement termsAndConditionLink;
    @FindBy(xpath = ("//app-footer//a[5]/span[text()='Privacy Policy']"))
    public WebElement privacyPolicyLink;
    @FindBy(xpath = ("//app-footer//a[6]/span[text()='EULA']"))
    public WebElement eulaLink;
    @FindBy(xpath = ("//app-footer//a[7]/span[text()='About Us']"))
    public WebElement aboutUsLink;
    @FindBy(xpath = ("(//app-footer//a)[8]"))
    public WebElement downloadTheAppLink;
    @FindBy(xpath = ("(//app-footer//a)[9]"))
    public WebElement subscribeToNewsletterLink;
    @FindBy(xpath = "(//app-footer//img)[2]")
    public WebElement certificateImage;


    //************************************Action Methods********************************//
    public void clickUrbanautLogo() throws InterruptedException {
        // Click on the Urbanaut logo
        urbanautLogo.click();
        // Verify that the URL changes to the expected URL after clicking the logo
    }

    public void clickHostWithUSButton() {
        // Wait until the "Host With US" button is clickable
        wait.until(ExpectedConditions.elementToBeClickable(ListWithUs)).click();
    }

    public void clickListToggle() {
        // Wait until the list toggle element is clickable
        wait.until(ExpectedConditions.elementToBeClickable(list)).click();
    }

    public Map clickMapToggle() {
        // Wait until the map toggle element is clickable
        wait.until(ExpectedConditions.elementToBeClickable(map)).click();
        // Return a new instance of the Map class
        return new Map(driver, webactionutil);
    }

    public void clickSearchIcon() throws InterruptedException {
        String message = searchicon.isDisplayed() ? "search icon is displayed" : "search icon is not displayed";
        System.out.println(message);
        webactionutil.clickElement(searchicon);
    }

    public void clickSearch() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(search));
        element.click();
    }

    public void clickSendhAndDismiss() throws InterruptedException {
        clickSearch();
        search.sendKeys("abcd");
        search.clear();
    }

    public void pickPopularCity(String cityname) throws InterruptedException {
        webactionutil.clickAndClearElement(search);
        String elementpath = "//div[text()='Popular destinations']/../div[2]//span[text()='" + cityname + "']";
        WebElement element = driver.findElement(By.xpath(elementpath));
        element.click();
        webactionutil.verifyUrlAfterElementClick("https://dev.urbanaut.app/?city=" + cityname);
    }

    public void searchAndPick(String cityname) {
        webactionutil.clickClearAndSendkeysToElement(search, cityname);
        searchedOption.click();
    }

    public void scrollAndPick(String cityname) throws InterruptedException {
        search.click();
        String elementpath = "//div[contains(text(),' list of destinations ')]/../div[4]//a[text()='" + cityname + "']";
        WebElement element = driver.findElement(By.xpath(elementpath));
        webactionutil.moveToElementAndClick(element);
    }

    public void listOfPopularCities() throws InterruptedException {
        webactionutil.clickAndClearElement(search);
        List<WebElement> popularCities = driver.findElements(By.xpath("//div[text()='Popular destinations']/../div[2]/div/span"));
        int nopopularCities = popularCities.size();

        for (int i = 1; i <= nopopularCities; i++) {
            String popularcitiespath = "(//div[text()='Popular destinations']/../div[2]/div/span)[" + i + "]";
            WebElement popularcities = driver.findElement(By.xpath(popularcitiespath));
            String popularcityNmae = popularcities.getText();
            System.out.println(popularcityNmae);
        }
    }

    public ExploreAll clickEventExploreall() throws InterruptedException {
        webactionutil.waitUntilElementVisible(eventExploreAll);
        eventExploreAll.click();
        return new ExploreAll(driver, webactionutil);
    }

    public ExploreAll clickExpirenceExploreall() throws InterruptedException {
        webactionutil.waitUntilElementVisible(expirenceExploreAll);
        expirenceExploreAll.click();
        return new ExploreAll(driver, webactionutil);
    }

    public ExploreAll clickEattDrinkExploreall() throws InterruptedException {
        webactionutil.waitUntilElementVisible(eatdrinkExploreAll);
        eatdrinkExploreAll.click();
        return new ExploreAll(driver, webactionutil);
    }

    public ExploreAll clickRealLocalExploreall() throws InterruptedException {
        webactionutil.waitUntilElementVisible(reallocalExploreAll);
        reallocalExploreAll.click();
        return new ExploreAll(driver, webactionutil);
    }

    public ExploreAll clickDoExploreAll() throws InterruptedException {
        webactionutil.waitUntilElementVisible(doExploreAll);
        doExploreAll.click();
        return new ExploreAll(driver, webactionutil);
    }

    public ExploreAll clickStayExploreAll() throws InterruptedException {
        webactionutil.waitUntilElementVisible(stayExploreAll);
        stayExploreAll.click();
        return new ExploreAll(driver, webactionutil);
    }

    public ExploreAll clickBuyExploreAll() throws InterruptedException {
        webactionutil.waitUntilElementVisible(buyExploreAll);
        buyExploreAll.click();
        return new ExploreAll(driver, webactionutil);
    }

    public void clickRightScroll(int k) throws InterruptedException {
        String rigtScroll = "(//button[@class='rightRs'])[" + k + "]";
        WebElement rightScroll = driver.findElement(By.xpath(rigtScroll));
        webactionutil.waitUntilElementVisible(rightScroll);
        webactionutil.moveToElementAndClick(rightScroll);
    }

    public void clickLeftScroll(int k) throws InterruptedException {
        String leftScroll = "(//button[@class='leftRs'])[" + k + "]";
        WebElement lefttScroll = driver.findElement(By.xpath(leftScroll));
        webactionutil.waitUntilElementVisible(lefttScroll);
        webactionutil.moveToElementAndClick(lefttScroll);
    }

    public void verifyExpirenceSpotImage() {
        List<WebElement> spotTiles = driver.findElements(By.xpath("//div[text()='Experiences']/../../div[2]//div[@class='tile']"));
    }

    public Instagram clickInstaLogo() throws InterruptedException {
        if (instaLogo.isDisplayed()) {
            System.out.println("insta logo is displayed on city page");
            webactionutil.moveToElementAndClick(instaLogo);
            return new Instagram(driver, webactionutil);
        }
        System.out.println(" insta logo is not displayed on citypage");
        return null;
    }

    public Instagram clickInstaLink() throws InterruptedException {
        if (joinourgramLink.isDisplayed()) {
            System.out.println("join our gram link is displayed on city page");
            webactionutil.moveToElementAndClick(joinourgramLink);
            return new Instagram(driver, webactionutil);
        } else {
            System.out.println("join our gram link is not displayed on city page");
        }
        return null;
    }

    public void clickHomeLink() throws InterruptedException {
        if (homeLink.isDisplayed()) {
            System.out.println("Home link is displayed on city page");
            webactionutil.moveToElementAndClick(homeLink);
        } else {
            System.out.println("Home link is not displayed on city page");
        }
    }

    public void clickTermsAndCondtionLink() throws InterruptedException {
        if (termsAndConditionLink.isDisplayed()) {
            System.out.println("T&C link is displayed on city page");
            webactionutil.moveToElementAndClick(termsAndConditionLink);
        } else {
            System.out.println("T&C link is not displayed on city page");
        }
    }

    public void clickPrivacyPolicyLink() throws InterruptedException {
        if (privacyPolicyLink.isDisplayed()) {
            System.out.println("Privacy Policy Link link is displayed on city page");
            webactionutil.moveToElementAndClick(privacyPolicyLink);
        } else {
            System.out.println("Privacy Policy link is not displayed on city page");
        }
    }

    public void clickEULALink() throws InterruptedException {
        if (eulaLink.isDisplayed()) {
            System.out.println("EULA Link link is displayed on city page");
            webactionutil.moveToElementAndClick(eulaLink);
        } else {
            System.out.println("EULA link is not displayed on city page");
        }
    }

    public void clickAboutUsLink() throws InterruptedException {
        if (aboutUsLink.isDisplayed()) {
            System.out.println("About Us Link link is displayed on city page");
            webactionutil.moveToElementAndClick(aboutUsLink);
        } else {
            System.out.println("AboutUS link is not displayed on city page");
        }
    }

    public void clickDownloadTheAppLink() throws InterruptedException {
        if (downloadTheAppLink.isDisplayed()) {
            System.out.println("Download The App Link link is displayed on city page");
            webactionutil.moveToElementAndClick(downloadTheAppLink);
        } else {
            System.out.println("Download The App link is not displayed on city page");
        }
    }

    public void clickSubscribetoNewsletter() throws InterruptedException {
        if (subscribeToNewsletterLink.isDisplayed()) {
            System.out.println("subcribe to newsletter Link link is displayed on city page");
            webactionutil.moveToElementAndClick(subscribeToNewsletterLink);
        } else {
            System.out.println("subcribe to newsletter link is not displayed on city page");
        }
    }

    public void verifyCertificateImage() {
        if (certificateImage.isDisplayed()) {
            System.out.println(" certificate image is displayed on city page");

        } else {
            System.out.println(" certificate image is not displayed on city page");
        }

    }

    public void verifyTileImage(String tilepath, String category) {
        String imagepath = tilepath + "//a[@class='card-img-link']/img";
        try {
            WebElement element = driver.findElement(By.xpath(imagepath));
            while (true) {
                if (!element.isDisplayed()) {
                    String rightScrollPath = "//div[text()='" + category + "']/../following-sibling::div[1]//button[@class='rightRs']";
                    WebElement rightScroll = driver.findElement(By.xpath(rightScrollPath));
                    webactionutil.moveToElementAndClick(rightScroll);
                } else if (element.isDisplayed()) {
                    break;
                }
            }
            String imagevalue = element.getAttribute("src");
            System.out.println("Image is present : " + imagevalue);
        } catch (Exception e) {
            System.out.println("Image is not Found in this tile");
        }
    }

    public void verifySaveIcon(String tilepath, String category) throws InterruptedException {
        String saveiconpath = tilepath + "//a[@ mattooltip ='Added to MY SPOT. DOWNLOAD THE APP to access your saved spots.']/img";
        WebElement element = driver.findElement(By.xpath(saveiconpath));
        while (true) {
            if (!element.isDisplayed()) {
                String rightScrollPath = "//div[text()='" + category + "']/../following-sibling::div[1]//button[@class='rightRs']";
                WebElement rightScroll = driver.findElement(By.xpath(rightScrollPath));
                webactionutil.moveToElementAndClick(rightScroll);
            } else if (element.isDisplayed()) {
                break;
            }
        }
        String saveiconvalue = element.getAttribute("src");
        if (saveiconvalue != null) {
            System.out.println("save icon is present: " + saveiconvalue);
        } else {
            System.out.println("save icon is not found on this tile");
        }
    }

    public void verifySpotName(String tilepath, String category) throws InterruptedException {
        String spotnamepath = tilepath + "//div//span[@class='pre-wrap']";
        WebElement element = driver.findElement(By.xpath(spotnamepath));
        while (true) {
            if (!element.isDisplayed()) {
                String rightScrollPath = "//div[text()='" + category + "']/../following-sibling::div[1]//button[@class='rightRs']";
                WebElement rightScroll = driver.findElement(By.xpath(rightScrollPath));
                webactionutil.moveToElementAndClick(rightScroll);
            } else if (element.isDisplayed()) {
                break;
            }
        }
        String spotname = element.getText();
        System.out.println("spotname name is: " + spotname);

    }

    public void verifyPartnerName(String tilepath, String category) throws InterruptedException {
        String partnernamepath = tilepath + "//div//span[@class='company']";
        WebElement element = driver.findElement(By.xpath(partnernamepath));
        while (true) {
            if (!element.isDisplayed()) {
                String rightScrollPath = "//div[text()='" + category + "']/../following-sibling::div[1]//button[@class='rightRs']";
                WebElement rightScroll = driver.findElement(By.xpath(rightScrollPath));
                webactionutil.moveToElementAndClick(rightScroll);
            } else if (element.isDisplayed()) {
                break;
            }
        }
        String partnername = element.getText();
        System.out.println("partnername is: " + partnername);
    }

    public void verifySlot(String tilepath, String category) throws InterruptedException {
        String slotpath = tilepath + "//div//a[@class='card-text']/div[1]";
        WebElement element = driver.findElement(By.xpath(slotpath));
        while (true) {
            if (!element.isDisplayed()) {
                String rightScrollPath = "//div[text()='" + category + "']/../following-sibling::div[1]//button[@class='rightRs']";
                WebElement rightScroll = driver.findElement(By.xpath(rightScrollPath));
                webactionutil.moveToElementAndClick(rightScroll);
            } else if (element.isDisplayed()) {
                break;
            }
        }
        String slotname = element.getText();
        System.out.println("slot name is: " + slotname);
    }

    public void verifyAvailability(String tilepath, String category) throws InterruptedException {
        String slotpath = tilepath + "//div//button[@class='btn btn-primary']";
        try {
            WebElement element = driver.findElement(By.xpath(slotpath));
            while (true) {
                if (!element.isDisplayed()) {
                    String rightScrollPath = "//div[text()='" + category + "']/../following-sibling::div[1]//button[@class='rightRs']";
                    WebElement rightScroll = driver.findElement(By.xpath(rightScrollPath));
                    webactionutil.moveToElementAndClick(rightScroll);
                } else if (element.isDisplayed()) {
                    break;
                }
            }
            String Availability = element.getText();
            System.out.println("Availability is: " + Availability);
        } catch (Exception e) {
            System.out.println("Availability is not found");
        }
    }

    public void verifyAllSpotTiles(String category) throws InterruptedException {
        String spotsTilesPath = "//div[text()='" + category + "']/../following-sibling::div[1]//ngu-tile/div";
        List<WebElement> spotTiles = driver.findElements(By.xpath(spotsTilesPath));
        int noSpottiles = spotTiles.size();
        System.out.println(noSpottiles);
        for (int i = 1; i <= noSpottiles; i++) {
            String tilespath = "(" + spotsTilesPath + ")[" + i + "]";
            verifySpotTile(tilespath, category);
        }
    }

    public void verifySpotTile(String tilespath, String category) throws InterruptedException {
        verifyTileImage(tilespath, category);
        verifySaveIcon(tilespath, category);
        verifySpotName(tilespath, category);
        verifyPartnerName(tilespath, category);
        verifyAvailability(tilespath, category);
        verifySlot(tilespath, category);
    }
}

