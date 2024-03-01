package POMRepository;

import Utility.UtilityClasss.WebActionUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePOMClass {
    public WebDriver driver;
    public WebActionUtil webactionutil;
    public BasePOMClass(WebDriver driver, WebActionUtil webActionUtil)
    {
        this.driver = driver;
        this.webactionutil = webActionUtil;
        PageFactory.initElements(driver, this);
    }
}
