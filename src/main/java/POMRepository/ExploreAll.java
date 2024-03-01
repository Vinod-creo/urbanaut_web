package POMRepository;

import Utility.UtilityClasss.WebActionUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ExploreAll extends BasePOMClass {
    public ExploreAll(WebDriver driver, WebActionUtil webactionutil) {
        super(driver, webactionutil);
    }

    @FindBy(xpath = "(//button[text()=' Events '])")
    public WebElement eventsFilter;
    @FindBy(xpath = "(//button[text()=' Experiences '])")
    public WebElement expirenceFilter;
    @FindBy(xpath = "//button[text()=' Eat / Drink ']")
    public WebElement eatdrinkFilter;
    @FindBy(xpath = "//button[text()=' Stay ']")
    public WebElement stayFilter;
    @FindBy(xpath = "//button[text()=' Do ']")
    public WebElement doFilter;
    @FindBy(xpath = "//button[text()=' Real local ']")
    public WebElement reallocalFilter;
    @FindBy(xpath = "//button[text()=' Buy ']")
    public WebElement buyFilter;

    public void verifyEventExploreAll() throws InterruptedException {
        webactionutil.waitUntilElementVisible(eventsFilter);
        if (eventsFilter.isEnabled()) {
            System.out.println("event is enabled");
        } else {
            System.out.println("event is disabled");
        }
        webactionutil.verifyUrlAfterElementCLickCheckitcontains("id=12");
    }

    public void verifyExpirenceExploreAll() throws InterruptedException {
        webactionutil.waitUntilElementVisible(expirenceFilter);
        if (expirenceFilter.isEnabled()) {
            System.out.println("Expirence is enabled");
        } else {
            System.out.println("Expirence is disabled");
        }
        webactionutil.verifyUrlAfterElementCLickCheckitcontains("id=11");
    }

    public void verifyEatDrinkExploreAll() throws InterruptedException {
        webactionutil.waitUntilElementVisible(eatdrinkFilter);
        if (eatdrinkFilter.isEnabled()) {
            System.out.println("Eat/Drink is enabled");
        } else {
            System.out.println("Eat/DRINK is disabled");
        }
        webactionutil.verifyUrlAfterElementCLickCheckitcontains("id=1");
    }

    public void verifyRealLocalExploreAll() throws InterruptedException {
        webactionutil.waitUntilElementVisible(reallocalFilter);

        if (reallocalFilter.isEnabled()) {
            System.out.println("Real Local is enabled");
        } else {
            System.out.println("Real Local is disabled");
        }
        webactionutil.verifyUrlAfterElementCLickCheckitcontains("id=9");
    }

    public void verifyDoExploreAll() throws InterruptedException {
        webactionutil.waitUntilElementVisible(doFilter);
        if (doFilter.isEnabled()) {
            System.out.println("Do is enabled");
        } else {
            System.out.println("Do is disabled");
        }
        webactionutil.verifyUrlAfterElementCLickCheckitcontains("id=4");
    }

    public void verifyStayExploreAll() throws InterruptedException {
        webactionutil.waitUntilElementVisible(stayFilter);
        if (stayFilter.isEnabled()) {
            System.out.println("Stay is enabled");
        } else {
            System.out.println("Stay is disabled");
        }
        webactionutil.verifyUrlAfterElementCLickCheckitcontains("id=6");
    }

    public void verifyBuyExploreAll() throws InterruptedException {
        webactionutil.waitUntilElementVisible(buyFilter);
        if (buyFilter.isEnabled()) {
            System.out.println("Buy is enabled");
        } else {
            System.out.println("Buy is disabled");
        }
        webactionutil.verifyUrlAfterElementCLickCheckitcontains("id=5");
    }

}
