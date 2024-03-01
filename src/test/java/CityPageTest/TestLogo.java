package CityPageTest;

import Utility.UtilityClasss.BaseClass;
import org.testng.annotations.Test;

public class TestLogo extends BaseClass {
    /*
     * Test case to verify navigation upon clicking the Urbanaut logo.
     */
    @Test(priority = 1)
    public void testUrbanautLogoNavigation() throws InterruptedException {
        citypage.urbanautLogo.click();
        webactionutil.verifyUrlAfterElementClick("https://dev.urbanaut.app/");
        System.out.println("Urbanaut logo navigation to the city page verified");
    }
}