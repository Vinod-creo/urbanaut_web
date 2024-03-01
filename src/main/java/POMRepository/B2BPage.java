package POMRepository;

import Utility.UtilityClasss.WebActionUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class B2BPage extends BasePOMClass
{
    public B2BPage(WebDriver driver, WebActionUtil webActionUtil)
    {
        super(driver, webActionUtil);
    }
    @FindBy(xpath = "//a[text()='BOOK A DEMO']")
    public WebElement BookADemoLink;
}
