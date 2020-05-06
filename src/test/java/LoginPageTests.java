import Base.TestBase;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTests extends TestBase
{
    LoginPage loginPage;
    HomePage homePage;
    ProfilePage profilePage;
    public LoginPageTests()
    {
        super();
    }

    @BeforeMethod
    public void SetUp()
    {
        Initialization();
        homePage = new HomePage();
    }
    /*
    Below is the test case to login to JustJoinIT Site using email account.
    all steps in the test below could be executed from 1 function in the LoginPage
    However i prefered to handle this this way so i can reuse the separate actions for different cases.
    Example: the fill login page could be used for many cases since i used parametrization.
     */

    @Test
    public void verify_existing_user_can_successfully_login()
    {
        boolean isPresent;
        //go to login page and successfully log in using credentials from properties file.
        loginPage = homePage.go_to_Login_Page();
        loginPage.fill_Login_form(prop.getProperty("username"),prop.getProperty("password"));
        profilePage = loginPage.log_in();

        /*
            validate user successfully logged in by checking that there is My Profile text on page.
            NOTE * that the action can be so fast that its possible you wont see the profile page at all.
        */
        isPresent = profilePage.validate_text_On_Page("My profile");
        Assert.assertTrue(isPresent);
    }

    @AfterMethod
    public void TearDown()
    {
        driver.quit();
    }
}
