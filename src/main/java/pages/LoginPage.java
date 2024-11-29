package pages;

import dto.UserDto;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage extends BasePage
{
    public LoginPage(WebDriver driver)
    {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,10), this);
    }

    @FindBy(xpath = "//a[text()=' Log in ']")
    WebElement btnLogIn;

    @FindBy(xpath = "//input[@id='email']")
    WebElement email;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnYalla;

    public void typeLoginForm(UserDto user)
    {
        btnLogIn.click();
        email.sendKeys(user.getEmail());
        password.sendKeys(user.getPassword());

        pause(2);
        btnYalla.click();
        pause(2);

    }

    @FindBy(xpath = "//button[text()='Ok']")
    WebElement btnOk;

    public void clickButtonOk()
    {
        btnOk.click();
        pause(2);
    }


}
