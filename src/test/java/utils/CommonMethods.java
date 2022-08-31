package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.PageInitializer;

import java.util.concurrent.TimeUnit;

// ** Remember that CommonMethods is extended everywhere! ** ... and only extended by PageInitializer
public class CommonMethods {

    public static WebDriver driver;

    public static void openBrowserAndLaunchApplication(){
        //grabs info from "config.properties"... via "ConfigReader" class which reads "config.properties"
        // "Constants" class has the exact file path
        ConfigReader.readProperties(Constants.CONFIGURATION_FILEPATH);

        //CROSS BROWSER TESTING
        //browser name is passed from "config.properties"... via "ConfigReader" class which reads "config.properties"
        switch (ConfigReader.getPropertyValue("browser")){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Invalid browser name");
        }

        driver.manage().window().maximize();
        driver.get(ConfigReader.getPropertyValue("url"));
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);

        //this method is used to initialize all the objects of the pages at the very beginning

        //***Method to initialize pageInitializer needs to be called here**
    }

    public static void closeBrowser(){
        driver.quit();
    }

    //this method will automatically clear the data when we need to send text
    public static void sendText(WebElement element, String textToSend){
        element.clear();
        element.sendKeys(textToSend);
    }

    //implicit wait relies on TIME
    //explicit wait relies on a CONDITION
    //this method will return 20 sec wait using EXPLICIT_WAIT
    public static WebDriverWait getWait(){
        WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT);
        return wait;
    }

    //this method will wait until the element becomes clickable
    public static void waitForClickability(WebElement element){
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    //to perform click operation
    public static void click(WebElement element){
        waitForClickability(element);
        element.click();
    }

    //select class for dropdown
    public static void selectDropdown(WebElement element, String text){
        Select s = new Select(element);
        s.selectByVisibleText(text);
    }
    //sometimes the normal click method may not work, so we use:
    //js click (javascript executor click)
    public static JavascriptExecutor getJSExecutor(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js;
    }

    //to perform click via javascript executor
    public static void jsClick(WebElement element){
        getJSExecutor().executeScript("arguments[0].click();", element);
    }

}