package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.PropertiesLoader;
import utils.WebBasePage;

import java.util.Properties;

public class UserLoginPage extends WebBasePage {
    WebDriver driver;
    By locUserName = By.cssSelector("input#username");
    private final static String FILE_NAME = System.getProperty("user.dir") + "\\src\\main\\resources\\testdata.properties";
    private static Properties prop = new PropertiesLoader(FILE_NAME).load();

    public UserLoginPage(WebDriver driver) {
        super(driver, "User Login Page");
        this.driver = driver;
    }

    public static String userName;
    public static String password;

    public void enterUserName() {
    	//driver.navigate().refresh();
    	//staticWait(5000);
        if (System.getProperty("username") == null) {
            userName = prop.getProperty("username");
        } else {
            userName = System.getProperty("username");
        }
        waitForVisibilityOfElement(By.xpath("//div/input[@name='Username']"), 20);
        enter(By.xpath("//div/input[@name='Username']"), userName, "User Name", 15);
    }

    public void enterPassword() {
        if (System.getProperty("password") == null) {
            password = prop.getProperty("password");
        } else {
            password = System.getProperty("password");
        }
        enter(By.xpath("//div/input[@name='Password']"), password, "Password", 10);
        click(By.xpath("//span[@title='Show']"), "Visible Button", 10);
    }

    public void acceptPrivacyPolicy() {
        click(By.xpath("//input[@name='AcceptPrivacyPolicy']//parent::div[contains(@class,'custom')]"), "Privacy Policy", 10);
    }

    public void clickLogin() {
    	//staticWait(2000);
		/*
		 * String actualUserName = getAtribute(By.xpath("//input[@id='username']"),
		 * "value", 20); String actualPassword =
		 * getAtribute(By.xpath("//input[@id='password']"), "value", 20); if
		 * (actualUserName.equals(userName) && actualPassword.equals(password)) {
		 * click(By.cssSelector("input#btnLogin"), "Login", 10); } else {
		 * enterUserName(); enterPassword(); acceptPrivacyPolicy(); clickLogin(); }
		 */
    	 WebElement  privacypolicy = driver.findElement(By.xpath("//input[@name='AcceptPrivacyPolicy']"));
     	String value = privacypolicy.getAttribute("Checked");
     	 
     	 if(value == null)
     	 {
     		 
     	 acceptPrivacyPolicy();
     	 	click(By.cssSelector("input#btnLogin"),"Login",10);
     	 }
     	 else
     	 {
     		 click(By.cssSelector("input#btnLogin"),"Login",10);
     	 }
    }

    public void forcefulLogOutLogin() {
    	staticWait(5000);
        if (findElementVisibility(locUserName, 10) != null) {
            enterUserName();
            enterPassword();
            acceptPrivacyPolicy();
            clickLogin();
        } else {
            clickByJavascript(By.id("navbarDropdownMenuLink"), "Logout menu", 30);
            clickByJavascript(By.xpath("//a[contains(text(),'Logout')]"), "Logout", 30);
            //click(By.xpath("//div/a[contains(text(),'Click Here')]"), "Click Here", 10);
            enterUserName();
            enterPassword();
            acceptPrivacyPolicy();
            clickLogin();
        }
    }
}
