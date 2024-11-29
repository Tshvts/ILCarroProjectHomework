package tests;

import dto.UserDto;
import manager.AppManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegistrationPage;
import pages.SearchPage;

import java.util.Random;

public class RegistrationTests extends AppManager
{
    private String email, password;

    @Test
    public void RegistratonPositiveTest()
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
}
