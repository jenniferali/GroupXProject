package pages;
// Locators go on in pages classes
// AKA OBJECT REPOSITORY
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class LoginPage {

    @FindBy(id="txtUsername")
    public WebElement usernameTextField;

    @FindBy(id="txtPassword")
    public WebElement passwordTextField;

    @FindBy(id="btnLogin")
    public WebElement loginButton;

    @FindBy(id="spanMessage")
    public WebElement errorMessage;

    // CONSTRUCTOR USED TO INITIALIZE ELEMENTS
    // A "constructor" is a block of code--has same name as class name--looks like a method
    // Using access modifier "public" to be able to use it throughout the project
    // Inside constructor, all elements are initialized using Selenium PageFactory
    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

}