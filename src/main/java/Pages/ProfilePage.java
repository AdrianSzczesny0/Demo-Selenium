package Pages;

import Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends TestBase
{

    public ProfilePage() {
        PageFactory.initElements(driver, this);
    }


    /* i could just directly name this check if user logged in. however the method below is quite generic, you can use
    it for different tests where its necessary to find text on page. normally id add such method to UTILITY  and reuse
    it in any test needed.
    */
    public boolean validate_text_On_Page(String validatedText)
    {
        boolean isPresent;

        try
        {
            driver.findElement(By.xpath("//*[contains(text(),'"+validatedText+"')]"));
            System.out.println("Text: "+validatedText +" is present on the page");
            isPresent=true;
        }
        catch (NoSuchElementException e)
        {
            isPresent=false;
            System.out.println("Text: "+validatedText +" is not present on the page");
        }

        return  isPresent;
    }

}
