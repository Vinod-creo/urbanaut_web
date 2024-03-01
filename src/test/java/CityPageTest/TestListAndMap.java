package CityPageTest;

import POMRepository.Map;
import Utility.UtilityClasss.BaseClass;
import org.testng.annotations.Test;

public class TestListAndMap extends BaseClass {
    Map map;

    /*
     * Test case to verify the default state of the list and map toggles, and navigation upon clicking on them.
     */
    @Test(priority = 1)
    public void testListAndMapToggle() {
        String listStatus = citypage.list.isEnabled() ? "enabled" : "disabled";
        System.out.println("By default list is " + listStatus);
        map = citypage.clickMapToggle();
        String mapStatus = map.zoomin.isDisplayed() ? "displayed" : "not displayed";
        System.out.println("Map is " + mapStatus);
        citypage.clickListToggle();
        System.out.println("List and map are verified");
    }
}
