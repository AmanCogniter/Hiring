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

public class JobRequisitionPage extends WebBasePage {
	WebDriver driver;
	String pattern = "yyMMddHHmmss";

	Date date = new Date();
	SimpleDateFormat dateformat = new SimpleDateFormat(pattern);

	String datevalue = dateformat.format(date);

	static String designation;
	static String position;
	static String department;
	static String designationName;

	String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\testfiles\\";
	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";
	private static Properties prop = new PropertiesLoader(FILE_NAME).load();

	public JobRequisitionPage(WebDriver driver) {

		super(driver, "JobRequisitionPage");
		this.driver = driver;
	}

	public void clickFullMenuDropDown() {
		staticWait(25000);
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

	public void clickOnJobRequisition() {
		click(By.xpath("//a[contains(text(),'Job Requisition')]"), "Job Requisition", 30);
		staticWait(3000);
	}

	public void clickOnAddJobRequisition() {
		clickByJavascript(By.xpath("//a[@title='Add New']"), "Add Job Requisition", 20);
		staticWait(2000);
	}

	public void save() {

		staticWait(1000);
		WebElement savebutton = driver.findElement(By.xpath("//div/button[contains(text(),'Save')]"));
		Actions action = new Actions(driver);
		action.moveToElement(savebutton).click().perform();
		// click(By.xpath("//div/a[contains(text(),'Save')]"), "Save Button", 20);
		// waitForLoad(20);
		staticWait(3000);
	}

	public void captureNotifyMessage() {
		try {
			staticWait(2000);
			WebElement notifymessage = driver
					.findElement(By.xpath("//div/span[contains(text(),'Group successfully added')]"));
			if (notifymessage.isDisplayed()) {
				logger.info(notifymessage.getText());
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Group not successfully added");
		}
	}

	public void VerifyMandatoryFieldValidation() {
		int i = 0;
		String actualText;
		String expectedText;

		List<WebElement> errorMessageLocator = findMultipleElement(
				By.xpath("//div[@class='form-group']//span[contains(@class,'invalid-feedback d-block')]"), 45);
		String[] expectedValue = { "Designation", "Positions", "Department", "Location" };
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

	public void selectdesignation() {
		staticWait(3000);
		designation = prop.getProperty("designition");

		selectValueWithText(By.xpath("//select[@name='Designation']"), designation, "Designation", 25);

	}

	public void enterPosition() {
		// staticWait(3000);
		position = prop.getProperty("numberofposition");

		enter(By.xpath("//span/input[@type='text']"), position, "Position", 25);

	}

	public void selectdepartment() {
		// staticWait(3000);
		// department = prop.getProperty("department");

		selectValueWithIndex(By.xpath("//select[@name='Department']"), 2, "Department", 25);

	}

	public void selectLocation() {
		// staticWait(3000);

		click(By.xpath("//span[@class='multiselect__placeholder']"), "Location DropDown", 25);
		// enter(By.xpath("//div/input[@placeholder='Select option']"), "Dallas",
		// "Location", 25);
		click(By.xpath("(//ul/li/span[@data-select='Press enter to select'])[2]/span"), "Location", 25);

	}

	public void enterStartSallry() {
		// staticWait(3000);

		enter(By.xpath("//span/input[@id='AnnualSalary']"), "60000", "Salary From", 25);

	}

	public void enterSallryTo() {
		// staticWait(3000);

		enter(By.xpath("//span/input[@id='Salary']"), "80000", "Salary To", 25);

	}

	public void selectExperienceFrom() {
		// staticWait(3000);
		// designation = prop.getProperty("designition");

		selectValueWithText(By.xpath("//select[@name='ExpForm']"), "4", "Experience from", 25);

	}

	public void selectExperienceTo() {
		// staticWait(3000);
		// designation = prop.getProperty("designition");

		selectValueWithText(By.xpath("//select[@name='ExpTo']"), "7", "Experience To", 25);

	}

	public void enterReason() {
		// staticWait(3000);

		enter(By.xpath("//textarea[@class='form-control']"), "Test", "Reason", 25);

	}

	public void enterDesignitionIntoSearchField() {
		staticWait(5000);

		enter(By.xpath("//div/input[@placeholder='Search By Designation Name ']"), designation, "Designition", 25);

	}
	public void enterDesignitionIntoSearchFieldForrejectFunctionality() {
		staticWait(5000);

		enter(By.xpath("//div/input[@placeholder='Search By Designation Name ']"), designationName, "Designition", 25);

	}

	public void clickOnSearchButton() {
		// staticWait(3000);

		clickByJavascript(By.xpath("//a[@id='Go']"), designation, 25);

	}

	public void verifyDesignationOnListingPage() {
		staticWait(3000);

		try {
			WebElement verify = driver
					.findElement(By.xpath("//table/tbody/tr/td/span/span[contains(text(),'" + designation + "')]"));
			if (verify.isDisplayed()) {
				logger.info("designation is available on listing page");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("designation is not available on listing page");
		}

	}

	public void clickOnCheckBox() {
		// staticWait(3000);

		click(By.xpath("//div[@class='custom-control custom-checkbox custom-control-inline']"), "CheckBox", 25);

	}

	public void clickOndelete() {
		// staticWait(3000);

		clickByJavascript(By.xpath("//a[@id='DeleteMultiple']"), "Delete Button", 25);

	}

	public void clickOnConfirmationButton() {
		// staticWait(1000);

		click(By.xpath("//button[@title='OK']"), "Confirmation Button", 20);

	}

	public void captureDeleteNotifyMessage() {
		try {
			staticWait(2000);
			WebElement notifymessage = driver
					.findElement(By.xpath("//div/span[contains(text(),'Requisition has been successfully deleted')]"));
			if (notifymessage.isDisplayed()) {
				logger.info(notifymessage.getText());
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Requisition hasn't been successfully deleted");
		}
	}

	public void clickOnView() {
		staticWait(1000);

		click(By.xpath("//a[@title='View']"), "View Button", 25);
		try {
			staticWait(1000);
			WebElement requisitiondetails = driver
					.findElement(By.xpath("//div/h2[contains(text(),'Requisition Details')]"));
			if (requisitiondetails.isDisplayed()) {
				logger.info("Requisition Details Page openend");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Requisition Details Page not openend");
		}

	}

	public void clickOnActionButton() {
		staticWait(1000);

		click(By.xpath("//span[@class='actions mobileaction']"), "Action Button", 20);

	}

	public void clickOnBackToList() {
		// staticWait(1000);

		click(By.xpath("//a[@title='Back to List']"), "Back To List", 20);

	}

	public void clickOnEdit() {
		// staticWait(1000);

		click(By.xpath("//a[@title='Edit']"), "Edit Button", 20);
		try {
			WebElement updateRequisition = driver
					.findElement(By.xpath("//div/span[contains(text(),'Add Requisition')]"));
			if (updateRequisition.isDisplayed()) {
				logger.info("Edit page openend");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Edit page not openend");

		}

	}

	public void clickOnApprove() {
		// staticWait(1000);

		clickByJavascript(By.xpath("//a[@data-original-title='Approve']"), "Approve", 20);

	}

	public void clickOnReject() {
		staticWait(3000);

		clickByJavascript(By.xpath("//a[@title='Reject']"), "Reject", 20);

	}

	public void enterComment() {
		staticWait(1000);

		enter(By.xpath("//textarea[@placeholder='Enter Comment']"), "Test", "Comment", 25);

	}

	public void clickOnSaveComment() {
		// staticWait(1000);

		click(By.xpath("//button[contains(text(),'Save')]"), "Save", 20);
		logger.info("Rejected successfully");
	}

	public void clickOnAddDesignation() {
		staticWait(3000);

		click(By.xpath("//a[@class='round-icon-small btn-dark theme-primary']"), "Add Designation", 20);

	}

	public void enterDesignationName() {
		staticWait(1000);
		designationName = "Designation Name " + datevalue;
		enter(By.xpath("//input[@id='Designation']"), designationName, "Designation name", 25);

	}

	public void clickOnSaveDesignation() {
		// staticWait(1000);

		click(By.xpath("(//button[@type='submit'])[2]"), "Save", 20);

	}

	public void clickOnClose() {
		staticWait(3000);

		click(By.xpath("(//button[@type='button'])[4]"), "Close", 20);

	}

	public void selectStatus() {
		staticWait(1000);

		selectValueWithText(By.xpath("//div/select[@name='Status']"), "Active", "Status", 25);

	}

	public void selectdesignationForReject() {
		driver.navigate().refresh();
		staticWait(5000);

		click(By.xpath("//select[@name='Designation']"), "Designation DropDown", 30);
		staticWait(1000);
		selectValueWithText(By.xpath("//select[@name='Designation']"), designationName, "Designation", 25);

	}

	public void enterDesignitionIntoSearchFieldForReject() {
		staticWait(5000);

		enter(By.xpath("//div/input[@placeholder='Search By Designation Name ']"), designationName, "Designition", 25);

	}

	public void verifyDesignationOnListingPageForReject() {
		staticWait(3000);

		try {
			WebElement verify = driver.findElement(By.xpath(
					"//table/tbody/tr/td/span/span[contains(text(),'" + designationName + "')]"));
			if (verify.isDisplayed()) {
				logger.info("designation is available on listing page");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("designation is not available on listing page");
		}

	}
}
