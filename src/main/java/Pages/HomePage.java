package Pages;

import Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase
{

    @FindBy(xpath = "//span[contains(text(),'Sign in')]/..")
    WebElement  SIGN_IN_BUTTON;
    @FindBy(xpath = "//div[@role='tooltip']/div/a" )
    WebElement  SIGN_IN_AS_DEVELOPER_BUTTON;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public LoginPage go_to_Login_Page()
    {
        SIGN_IN_BUTTON.click();
        SIGN_IN_AS_DEVELOPER_BUTTON.click();
        return new LoginPage();
    }
    public boolean verify_user_Logged_in()
    {
        boolean isPresent;
        try
        {
            driver.findElement(By.cssSelector(".userAvatar__body"));
        isPresent=true;
        }
        catch (NoSuchElementException e)
        {
            isPresent=false;
        }
        return isPresent;
    }
}
