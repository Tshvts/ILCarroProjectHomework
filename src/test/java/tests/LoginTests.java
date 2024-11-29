package tests;

import dto.UserDto;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;
import pages.SearchPage;

import java.util.Random;

public class LoginTests extends AppManager
{
    private String email, password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @BeforeMethod
    public void registraton()
    {
        int i = new Random().nextInt(1000);
        email = "testhw_"+i+"@gmail.com";
        password = "Password123!";
        UserDto user = new UserDto("Tanya", "Fidelman",email, password);
        new HomePage(getDriver()).clickBtnSignUpHeader();
        new RegistrationPage(getDriver()).typeRegistrationForm(user);
        new RegistrationPage(getDriver()).clickChbxAndBtn();
        new RegistrationPage(getDriver()).clickButtonOk();
        new SearchPage(getDriver()).clickBtnLogOut();
    }

    @Test
    public void loginPositiveTest()
    {
        UserDto user = new UserDto("Tanya", "Fidelman",email, password);
        new LoginPage(getDriver()).typeLoginForm(user);
        new LoginPage(getDriver()).clickButtonOk();
        Assert.assertTrue(new SearchPage(getDriver()).isLogOutPresent());
    }


}
