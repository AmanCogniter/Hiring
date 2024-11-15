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
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;

import utils.PropertiesLoader;
import utils.WebBasePage;

public class ServicePage extends WebBasePage {
	WebDriver driver;
	String pattern = "yyMMddHHmmss";
	String patterns = "MM/dd/yyyy";

	Date date = new Date();
	SimpleDateFormat dateformat = new SimpleDateFormat(pattern);
	SimpleDateFormat dateformats = new SimpleDateFormat(patterns);
	String datevalue = dateformat.format(date);
	String datevalues = dateformats.format(date);

	static String servicename;

	String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\testfiles\\";
	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";
	private static Properties prop = new PropertiesLoader(FILE_NAME).load();

	public ServicePage(WebDriver driver) {

		super(driver, "ServicePage");
		this.driver = driver;
	}

	public void clickFullMenuDropDown() {
		staticWait(25000);
		click(By.xpath("//div/ul/li/a/span[contains(text(),'Full Menu')]"), "Full Menu", 30);
		staticWait(2000);
	}

	public void clickOnHiring() {
		staticWait(1000);
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

	public void clickOnService() {
		staticWait(1000);
		
		// TODO: handle exception
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Locating element by link text and store in variable "Element"
		WebElement Element = driver.findElement(By.xpath("//a[@data-original-title='Offboard Employee List']"));
		js.executeScript("arguments[0].scrollIntoView();", Element);
		staticWait(1000);

		click(By.xpath("//a[@data-original-title='Service']"), "Service", 30);
		staticWait(3000);

	

	}
	public void clickonService() {
		staticWait(1000);
		
		

		click(By.xpath("//ul[@data-p-name='Hiring']/li/a[contains(text(),'Service')]"), "Service", 30);
		staticWait(3000);

	

	}

	public void clickOnAddService() {
		clickByJavascript(By.xpath("//a[@title='Add New Service']"), "Add Service", 20);
		staticWait(2000);
	}

	public void save() {

		staticWait(1000);
		WebElement savebutton = driver.findElement(By.xpath("//button[contains(text(),'Save')]"));
		Actions action = new Actions(driver);
		action.moveToElement(savebutton).click().perform();
		Reporter.log("save button Clicked", true);
		// click(By.xpath("//div/a[contains(text(),'Save')]"), "Save Button", 20);
		// waitForLoad(20);
	}

	public void VerifyMandatoryFieldValidation() {
		int i = 0;
		String actualText;
		String expectedText;

		List<WebElement> errorMessageLocator = findMultipleElement(
				By.xpath("//span[contains(@class,'invalid-feedback')]"), 45);
		String[] expectedValue = { "Service Name", "Status", };
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

	public void enterServiceName() {
		staticWait(1000);
		servicename = prop.getProperty("servicename") + datevalue;

		enter(By.xpath("//span/input[@id='ServiceName']"), servicename, "Service Name", 25);

	}

	public void selectStatus() {
		staticWait(1000);

		selectValueWithText(By.xpath("//select[@name='Status']"), "Active", "Service Name", 25);

	}

	public void enterDescription() {
		staticWait(1000);

		enter(By.xpath("//span/textarea[@placeholder='Enter Description']"), "Test", "Description", 25);

	}

	public void captureNotifyMessage() {
		try {
			staticWait(2000);
			WebElement notifymessage = driver
					.findElement(By.xpath("//div/span[contains(text(),'Service has been successfully added')]"));
			if (notifymessage.isDisplayed()) {
				logger.info(notifymessage.getText());
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Service hasn't been successfully added");
		}
	}

	public void enterServiceNameIntoSearchField() {
		staticWait(1000);

		enter(By.xpath("(//div/input[contains(@placeholder,'Search')])[last()]"), servicename, "Service Name", 25);

	}

	public void clickOnsearchButton() {
		// staticWait(1000);

		clickByJavascript(By.xpath("//a[@data-original-title='Search']"), "Search Button", 25);

	}

	public void verifyServiceNameOnListingPage() {
		try {
			staticWait(2000);
			WebElement serviceName = driver.findElement(By.xpath("//span[contains(text(),'" + servicename + "')]"));
			if (serviceName.isDisplayed()) {
				logger.info("Service name Displayed successfully on listing page");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Service Name not Displayed on listing page");
		}
	}
	public void clickOnCheckBox() {
		 staticWait(1000);

		click(By.xpath("(//div[@class='custom-control custom-checkbox custom-control-inline'])[2]"), "CheckBox", 25);

	}
	public void clickOnDelete() {
		// staticWait(1000);

		click(By.xpath("//a[@title='Delete']"), "Delete", 25);

	}
	public void clickOnConfirmationButton() {
		// staticWait(1000);

		click(By.xpath("//button[@title='OK']"), "Confirmation Button", 20);

	}

	public void captureDeleteNotifyMessage() {
		try {
			staticWait(2000);
			WebElement notifymessage = driver
					.findElement(By.xpath("//div/span[contains(text(),'Service has been successfully deleted')]"));
			if (notifymessage.isDisplayed()) {
				logger.info(notifymessage.getText());
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Service successfully not added");
		}
	}
	public void selectInActiveStatus() {
		staticWait(1000);

		selectValueWithText(By.xpath("//select[@id='crmlistingStatus_span']"), "Inactive", "InActive Status", 25);

	}
	public void selectActiveStatus() {
		staticWait(2000);

		selectValueWithText(By.xpath("//select[@id='crmlistingStatus_span']"), "Active", "Active Status", 25);

	}
	public void clickOnAssignService() {
		staticWait(3000);
		clickByJavascript(By.xpath("//a[@title='Assign Service']"), "Assign Service", 20);
		
	}
	public void selectService() {
		staticWait(2000);
		click(By.xpath("//div/span[contains(text(),'Select Service')]"), "Select Service DropDown", 20);
		//enter(By.xpath("//div/input[@placeholder='Select Service']"), servicename, "Service Name", 25);
		staticWait(1000);
		click(By.xpath("//span/span[contains(text(),'"+servicename+"')]"), " Service Name", 20);
		

	}
	public void captureAssignServiceNotifyMessage() {
		try {
			staticWait(2000);
			WebElement notifymessage = driver
					.findElement(By.xpath("//div/span[contains(text(),'Service Assigned Successfully')]"));
			if (notifymessage.isDisplayed()) {
				logger.info(notifymessage.getText());
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Service hasn't been Assign successfully ");
		}
	}

}
