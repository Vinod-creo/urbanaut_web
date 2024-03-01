package CityPageTest;

import Utility.UtilityClasss.BaseClass;
import org.testng.annotations.Test;

public class TestListwithus extends BaseClass {
    /*
     * Clicks on the "Host With Us" button, verifies navigation to the B2B page,
     * and checks the URL and the presence of the "Book a Demo" link on the page.
     */
    @Test(priority = 1)
    public void testListstwithusNavigation() throws InterruptedException {
        citypage.clickHostWithUSButton();
        webactionutil.verifyUrlAfterElementClick("https://dev.urbanaut.app/hosting");
        if (citypage.BookADemoLink.isDisplayed()) {
            System.out.println("B2B page is displayed");
        } else {
            System.out.println("B2B page is not displayed");
        }
        citypage.clickUrbanautLogo();
        System.out.println("Navigation to B2B page after clicking 'Host With Us' button is verified");
    }
}
