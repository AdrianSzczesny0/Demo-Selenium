package Pages;

import Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase
{
    @FindBy(xpath = "//input[@type='email']")
    WebElement EMAIL_INPUT;
    @FindBy(xpath = "//input[@type='password']")
    WebElement PASSWORD_INPUT;
    @FindBy(xpath = "//form/button")
    WebElement SIGN_IN_BUTTON;





    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void fill_Login_form(String email, String password)
    {
        EMAIL_INPUT.sendKeys(email);
        PASSWORD_INPUT.sendKeys(password);
    }
    public ProfilePage log_in()
    {
        SIGN_IN_BUTTON.click();
        return new ProfilePage();
    }



}
