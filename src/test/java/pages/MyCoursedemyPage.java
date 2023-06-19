package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MyCoursedemyPage {
    public MyCoursedemyPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    // login link
    @FindBy(xpath = "//a[text()='Log in']")
    public WebElement loginLinkElement;

    // email
    @FindBy(xpath = "//input[@id='login-email']")
    public WebElement emailBoxElement;

    // password
    @FindBy(xpath = "//input[@id='login-password']")
    public WebElement passwordBoxElement;

    // login button
    @FindBy(xpath = "//button[text()='Login']")
    public WebElement loginButtonElement;

    // accept cookies
    @FindBy(xpath = "//a[text()='Accept']")
    public WebElement acceptCookies;

    @FindBy(linkText = "My courses")
    public WebElement myCoursesLink;
}
