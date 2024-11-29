package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class SearchPage extends BasePage
{
    public SearchPage(WebDriver driver)
    {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,
                10), this);
    }

    @FindBy(xpath = "//a[text()=' Logout ']")
    WebElement btnLogOut;

    public boolean isLogOutPresent()
    {
        pause(2);
        return btnLogOut.isDisplayed();
    }

    public void clickBtnLogOut()
    {
        btnLogOut.click();
        pause(2);
    }
}
