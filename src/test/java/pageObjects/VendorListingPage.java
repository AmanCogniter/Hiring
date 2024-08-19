package pageObjects;

import static reporting.ComplexReportFactory.getTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.LogStatus;

import utils.PropertiesLoader;
import utils.WebBasePage;

public class VendorListingPage extends WebBasePage{
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
		staticWait(5000);
		click(By.xpath("//div/ul/li/a/span[contains(text(),'Full Menu')]"), "Full Menu", 30);
		staticWait(2000);
	}

	public void clickOnHiring() {
		click(By.xpath("//li[@data-name='Hiring']//a//i//following::text()[1]//following::span"), "Hiring", 30);
		staticWait(2000);
	}

	public void clickOnVendorList() {
		click(By.xpath("(//div/ul/li/a[@data-original-title='Vendor Listing'])[last()]"), "Vendor List", 30);
		staticWait(3000);
	}

	public void clickOnAddVendorList() {
		clickByJavascript(By.xpath("//a[@data-original-title='Add vendor']"), "Add Vendor", 20);
		staticWait(2000);
	}

	public void save() {

		staticWait(3000);
		scrollDown();
		WebElement savebutton = driver.findElement(By.xpath("//div/button[contains(text(),'Save')]"));
		Actions action = new Actions(driver);
		action.moveToElement(savebutton).click().perform();
		// click(By.xpath("//div/a[contains(text(),'Save')]"), "Save Button", 20);
		// waitForLoad(20);
	}

	public void captureNotifyMessage() {
		try {
			staticWait(5000);
			WebElement notifymessage = driver
					.findElement(By.xpath("//div/span[contains(text(),'Vendor has been created successfully')]"));
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
				By.xpath("//span[contains(@class,'field-validation-valid invalid-feedback')]"), 45);
		String[] expectedValue = { "Company Name", "First Name","Last Name","Email","Password","Confirm Password","Country","State","City","Phone Number","Address 1","Zip Code"};
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
		companyName = prop.getProperty("companyName")+datevalue;
		
		enter(By.xpath("//tg-input/input[@name='CompanyName']"), companyName, "Company Name", 25);

	}
	public void enterFirstName() {
		staticWait(2000);
		firstName = prop.getProperty("vendor");
		
		enter(By.xpath("//tg-input/input[@name='FirstName']"), firstName, "First Name", 25);

	}

	public void enterLastName() {

		lastName = prop.getProperty("vendorlastname") + datevalue;
		enter(By.xpath("//tg-input/input[@name='LastName']"), lastName, "Last Name", 25);

	}

	public void enterEmail() {
		//staticWait(3000);
		email = prop.getProperty("email") + datevalue + "@gmail.com";
		enter(By.xpath("//tg-input/input[@name='Email']"), email, "Email", 25);

	}
	public void enterPassword() {
		//staticWait(3000);
		String password = prop.getProperty("passwords");
		enter(By.xpath("//tg-input/input[@name='Password']"), password, "Password", 25);

	}
	public void enterConfirmPassword() {
		//staticWait(3000);
		String password = prop.getProperty("passwords");
		enter(By.xpath("//tg-input/input[@name='ConfirmPassword']"), password, "Confirm Password", 25);

	}
	public void selectCountry() {
		//staticWait(3000);
		String country = prop.getProperty("country");
		selectValueWithText(By.xpath("//tg-select/select[@name='CountryId']"), country, "Country", 25);

	}
	public void enterState() {
		//staticWait(3000);
		String state = prop.getProperty("state");
		enter(By.xpath("//tg-input/input[@name='State']"), state, "State", 25);

	}
	public void enterCity() {
		//staticWait(3000);
		String state = prop.getProperty("state");
		enter(By.xpath("//tg-input/input[@name='City']"), state, "City", 25);

	}
	public void enterAddress() {
		//staticWait(3000);
		String address = prop.getProperty("address1");
		enter(By.xpath("//tg-input/input[@name='Address1']"), address, "Address1", 25);

	}
	public void enterAddress2() {
		//staticWait(3000);
		//String address = prop.getProperty("address1");
		enter(By.xpath("//tg-input/input[@name='Address2']"), "NA", "Address2", 25);

	}
	public void enterZipCode() {
		//staticWait(3000);
		String zipcode = prop.getProperty("zipcode");
		enter(By.xpath("//tg-input/input[@name='ZipCode']"), zipcode, "Zip Code", 25);

	}


	public void enterMobileNumber() {

		mobileNumber = prop.getProperty("mobilenumber");
		
		enter(By.xpath("//tg-input/input[@name='Phone']"), mobileNumber, "Mobile Number", 25);
		

	}
	public void enterVendorNameIntoSearchField() {
		//staticWait(3000);
		
		enter(By.xpath("//div/input[@placeholder='Search by Vendor name']"),companyName, "Vendor Name", 25);

	}
	public void clickOnSearchButton() {
		//staticWait(3000);
		
		clickByJavascript(By.xpath("//a[@id='Search']"),"Search Button", 25);

	}
	public void verifyVendor() {
		try {
			staticWait(5000);
			WebElement notifymessage = driver
					.findElement(By.xpath("//table/tbody/tr/td/span[contains(text(),'"+companyName+"')]"));
			if (notifymessage.isDisplayed()) {
				logger.info("Vendor displayed on listing page");
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Vendor not displayed on listing page");
		}
	}

}
