package pageObjects;

import static reporting.ComplexReportFactory.getTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.LogStatus;

import utils.PropertiesLoader;
import utils.WebBasePage;

public class VendorListingPage extends WebBasePage {
	WebDriver driver;
	String pattern = "yyMMddHHmmss";

	Date date = new Date();
	SimpleDateFormat dateformat = new SimpleDateFormat(pattern);

	String datevalue = dateformat.format(date);
	static String companyName;
	static String firstName;
	static String lastName;
	static String email;
	static String mobileNumber;

	String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\testfiles\\";
	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";
	private static Properties prop = new PropertiesLoader(FILE_NAME).load();

	public VendorListingPage(WebDriver driver) {

		super(driver, "VendorListingPage");
		this.driver = driver;
	}

	public void clickFullMenuDropDown() {
		staticWait(15000);
		click(By.xpath("//div/ul/li/a/span[contains(text(),'Full Menu')]"), "Full Menu", 30);
		staticWait(2000);
	}

	public void clickOnHiring() {

		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;

			// Locating element by link text and store in variable "Element"
			WebElement Element = driver.findElement(By.xpath("//li/a[contains(text(),'Expense')]"));

			// Scrolling down the page till the element is found
			js.executeScript("arguments[0].scrollIntoView();", Element);
			staticWait(1000);
			WebElement hiring = driver.findElement(By.xpath("//li/a[contains(text(),'Hiring')]"));
			if (hiring.isDisplayed()) {
				click(By.xpath("//li/a[contains(text(),'Hiring')]"), "Hiring", 30);
				staticWait(2000);
			}
		} catch (Exception e) {
			// TODO: handle exception
			click(By.xpath("//li[@data-name='Hiring']/a//following::span"), "Hiring", 30);
		}
	}

	public void clickOnVendorList() {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Locating element by link text and store in variable "Element"
		WebElement Element = driver.findElement(By.xpath("//a[contains(text(),'Offboard Employee List')]"));

		// Scrolling down the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();", Element);
		staticWait(1000);

		click(By.xpath("//a[contains(text(),'Vendor Listing')]"), "Vendor List", 30);
		staticWait(3000);
	}

	public void clickOnAddVendorList() {
		clickByJavascript(By.xpath("//a[@title='Add Vendor']"), "Add Vendor", 20);
		staticWait(2000);
	}

	public void save() {

		staticWait(3000);
		scrollDown();
		WebElement savebutton = driver.findElement(By.xpath("//div/a[contains(text(),'Save')]"));
		Actions action = new Actions(driver);
		action.moveToElement(savebutton).click().perform();
		// click(By.xpath("//div/a[contains(text(),'Save')]"), "Save Button", 20);
		// waitForLoad(20);
	}

	public void captureNotifyMessage() {
		try {
			staticWait(15000);
			WebElement notifymessage = driver
					.findElement(By.xpath("//span[contains(text(),'Vendor has been successfully added')]"));
			if (notifymessage.isDisplayed()) {
				logger.info(notifymessage.getText());
				click(By.xpath("//button[@id='closenotifymessage']"), "Close Notify Message", 30);
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Vendor hasn't been created successfully");
		}
	}

	public void VerifyMandatoryFieldValidation() {
		staticWait(2000);
		int i = 0;
		String actualText;
		String expectedText;

		List<WebElement> errorMessageLocator = findMultipleElement(
				By.xpath("//span[contains(@class,'invalid-feedback')]"), 45);
		String[] expectedValue = { "Company Name", "First Name", "Last Name", "Email", "Password", "Confirm Password",
				"Country", "State", "City", "Phone Number", "Address 1", "Zip Code" };
		for (Object expected : expectedValue) {
			/*
			 * WebElement AsteriskField = findElementVisibility(By.xpath("//label[text()='"+
			 * expected + ":']"), 45);
			 */
			WebElement AsteriskField = findElementVisibility(By.xpath("//label[contains(text(),'" + expected
					+ "')]/ancestor::div[@class='form-group']/descendant::span[contains(text(),'*')]"), 45);
			if (AsteriskField != null) {
				getTest().log(LogStatus.PASS, "The Asterisk symbol is displayed for " + expected + " field");
				logger.info("The Asterisk symbol is displayed for " + expected + " field");
			} else {
				getTest().log(LogStatus.FAIL, "The Asterisk symbol is not displayed for " + expected + " field");
				logger.info("The Asterisk symbol is not displayed for " + expected + " field");
				takeScreenshot(expected.toString());
			}

			List<WebElement> expectedElements = errorMessageLocator;
			for (WebElement element : expectedElements) {
				i++;
				actualText = element.getText();
				expectedText = expected.toString();

				if (actualText.indexOf(expectedText) != -1) {
					getTest().log(LogStatus.PASS,
							"Error message for \"" + expected + "\" field is displayed as expected");
					logger.info("Error message for \"" + expected + "\" field is displayed as expected");
					i = 0;
					break;
				} else if (i == expectedValue.length && !element.getText().contains(expectedText)) {
					getTest().log(LogStatus.FAIL, "Error message for \"" + expected + "\" field is not displayed");
					logger.info("Error message for \"" + expected + "\" field is displayed as expected");
					takeScreenshot(expectedText);
				}
			}

		}
	}

	public void enterCompanyName() {
		staticWait(2000);
		companyName = prop.getProperty("companyName") + datevalue;

		enter(By.xpath("//span/input[@name='CompanyName']"), companyName, "Company Name", 25);

	}

	public void enterFirstName() {
		staticWait(2000);
		firstName = prop.getProperty("vendor");

		enter(By.xpath("//span/input[@name='FirstName']"), firstName, "First Name", 25);

	}

	public void enterLastName() {

		lastName = prop.getProperty("vendorlastname") + datevalue;
		enter(By.xpath("//span/input[@name='LastName']"), lastName, "Last Name", 25);

	}

	public void enterEmail() {
		// staticWait(3000);
		email = prop.getProperty("email") + datevalue + "@gmail.com";
		enter(By.xpath("//span/input[@name='Email']"), email, "Email", 25);

	}

	public void enterPassword() {
		// staticWait(3000);
		String password = prop.getProperty("passwords");
		enter(By.xpath("//span/input[@name='Password']"), password, "Password", 25);

	}

	public void enterConfirmPassword() {
		// staticWait(3000);
		String password = prop.getProperty("passwords");
		enter(By.xpath("//span/input[@name='ConfirmPassword']"), password, "Confirm Password", 25);

	}

	public void selectCountry() {
		// staticWait(3000);
		String country = prop.getProperty("country");
		selectValueWithText(By.xpath("//select[@name='Country']"), country, "Country", 25);

	}

	public void enterState() {
		// staticWait(3000);
		String state = prop.getProperty("state");
		click(By.xpath("//div/select[@name='State']"), "State Dropdown", 25);
		 staticWait(1000);
		selectValueWithText(By.xpath("//div/select[@name='State']"), state, "State", 25);

	}

	public void enterCity() {
		// staticWait(3000);
		String state = prop.getProperty("state");
		enter(By.xpath("//span/input[@name='City']"), state, "City", 25);

	}

	public void enterAddress() {
		// staticWait(3000);
		String address = prop.getProperty("address1");
		enter(By.xpath("//span/input[@name='Address1']"), address, "Address1", 25);

	}

	public void enterAddress2() {
		// staticWait(3000);
		// String address = prop.getProperty("address1");
		enter(By.xpath("//span/input[@name='Address2']"), "NA", "Address2", 25);

	}

	public void enterZipCode() {
		// staticWait(3000);
		String zipcode = prop.getProperty("zipcode");
		enter(By.xpath("(//span/input[@type='text'])[last()-1]"), zipcode, "Zip Code", 25);

	}

	public void enterMobileNumber() {

		mobileNumber = prop.getProperty("mobilenumber");

		enter(By.xpath("(//span/input[@type='text'])[last()]"), mobileNumber, "Mobile Number", 25);

	}

	public void enterVendorNameIntoSearchField() {
		// staticWait(3000);

		enter(By.xpath("//div/input[@placeholder='Search ']"), companyName, "Vendor Name", 25);

	}

	public void clickOnSearchButton() {
		// staticWait(3000);

		clickByJavascript(By.xpath("//a[@id='Go']"), "Search Button", 25);

	}

	public void verifyVendor() {
		try {
			staticWait(5000);
			WebElement notifymessage = driver
					.findElement(By.xpath("//span[contains(text(),'" + companyName + "')]"));
			if (notifymessage.isDisplayed()) {
				logger.info("Vendor displayed on listing page");

			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Vendor not displayed on listing page");
		}
	}

}
