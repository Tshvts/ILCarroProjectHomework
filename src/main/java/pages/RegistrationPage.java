package pages;

import dto.UserDto;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class RegistrationPage extends BasePage
{
    public RegistrationPage(WebDriver driver)
    {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,10), this);
    }

    @FindBy(xpath = "//input[@id='name']")
    WebElement name;

    @FindBy(xpath = "//input[@id='lastName']")
    WebElement lastName;

    @FindBy(xpath = "//input[@id='email']")
    WebElement email;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(xpath = "//div[@class='checkbox-container']")
    WebElement CheckBox;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnYalla;

    public void typeRegistrationForm(UserDto user)
    {
        name.sendKeys(user.getName());
        lastName.sendKeys(user.getLastName());
        email.sendKeys(user.getEmail());
        password.sendKeys(user.getPassword());
        pause(2);
    }

    public void clickChbxAndBtn()
    {
        CheckBox.click();
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
