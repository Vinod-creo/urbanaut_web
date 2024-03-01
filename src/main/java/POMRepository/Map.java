package POMRepository;

import Utility.UtilityClasss.WebActionUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Map extends BasePOMClass
{
    public Map(WebDriver driver, WebActionUtil webActionUtil)
    {
        super(driver, webActionUtil);
    }

    @FindBy(xpath = "//button[@aria-label='Zoom in']")
    public WebElement zoomin;
    @FindBy(xpath = "//button[@aria-label='Zoom out']")
    public WebElement zoomout;



}
