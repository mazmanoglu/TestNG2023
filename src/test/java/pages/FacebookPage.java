package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {

    public FacebookPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    // accept cookies on Facebook
    @FindBy(xpath = "//button[@title='Allow all cookies']")
    public WebElement facebookAcceptCookies;

    // username element on Facebook
    @FindBy(id="email")
    public WebElement facebookUsernameBoxElement;

    // password element on Facebook
    @FindBy(id = "pass")
    public WebElement facebookPasswordBoxElement;

    // log in button element on Facebook
    @FindBy(xpath = "//button[@name='login']")
    public WebElement facebookLoginButtonElement;

    // failed message on Facebook
    @FindBy(xpath = "//div[@class='_9ay7']")
    public WebElement facebookFailedMessage;
}
