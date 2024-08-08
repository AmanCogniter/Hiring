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

public class PolicyPage extends WebBasePage {
	WebDriver driver;
	String pattern = "yyMMddHHmmss";

	Date date = new Date();
	SimpleDateFormat dateformat = new SimpleDateFormat(pattern);

	String datevalue = dateformat.format(date);

	static String policyname;
	static String department;
	static String email;
	static String mobileNumber;

	String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\testfiles\\";
	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";
	private static Properties prop = new PropertiesLoader(FILE_NAME).load();

	public PolicyPage(WebDriver driver) {

		super(driver, "PolicyPage");
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

	public void clickOnPolicy() {
		click(By.xpath("//div/ul/li/a[@data-original-title='Policy']"), "Policy", 30);
		staticWait(3000);
	}

	public void clickOnAddPolicy() {
		clickByJavascript(By.xpath("//a[@data-original-title='Add Policy']"), "Add Policy", 20);
		staticWait(2000);
	}

	public void save() {

		staticWait(1000);
		WebElement savebutton = driver.findElement(By.xpath("//div/a[contains(text(),'Save')]"));
		Actions action = new Actions(driver);
		action.moveToElement(savebutton).click().perform();
		// click(By.xpath("//div/a[contains(text(),'Save')]"), "Save Button", 20);
		// waitForLoad(20);
	}

	public void captureNotifyMessage() {
		try {
			staticWait(2000);
			WebElement notifymessage = driver
					.findElement(By.xpath("//div/span[contains(text(),'Policy successfully added')]"));
			if (notifymessage.isDisplayed()) {
				logger.info(notifymessage.getText());
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Policy not successfully added");
		}
	}

	public void VerifyMandatoryFieldValidation() {
		int i = 0;
		String actualText;
		String expectedText;

		List<WebElement> errorMessageLocator = findMultipleElement(
				By.xpath("//span[contains(@class,'field-validation-valid')]"), 45);
		String[] expectedValue = { "Policy Name", "Start Date" };
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

	public void enterPolicyName() {
		// staticWait(3000);
		policyname = prop.getProperty("plicyname") + datevalue;

		enter(By.xpath("//input[@id='PolicyName']"), policyname, "Policy Name", 25);

	}

	public void enterDescription() {

		enter(By.xpath("//textarea[@id='description']"), "Test", "Description", 25);

	}

	public void selectdepartment() {
		// staticWait(3000);
		department = prop.getProperty("department");

		selectValueWithText(By.xpath("//select[@id='ddlProbationPeriodList']"), department,
				"Department Of Probation Period", 25);

	}

	public void enterDurationOfProbationPeriod() {

		enter(By.xpath("//tg-input/input[@id='ProbationDuration1']"), "6", "Duration of Probation Period", 25);

	}

	public void selectdepartmentOfNoticePeriod() {
		// staticWait(3000);
		department = prop.getProperty("department");

		selectValueWithText(By.xpath("//select[@id='ddlNoticePeriodList']"), department, "Department Of Notice Period",
				25);

	}

	public void enterDurationOfNoticeonPeriod() {

		enter(By.xpath("//tg-input/input[contains(@id,'NoticeDuration')]"), "1", "Duration of Notice Period", 25);

	}

	public void clickOnPolicyNameSearchFilter() {

		click(By.xpath("//h5/span[contains(text(),'Policy Name')]"), "Policy name search field", 25);

	}

	public void enterPolicyNameIntoSearchField() {

		enter(By.xpath("//div/input[@placeholder='Policy Name']"), policyname, "Policy name", 25);

	}

	public void clickOnSearchButton() {

		click(By.xpath("//span[@data-original-title='Search']"), "Search Button", 25);

	}
	public void verifyPolcyName() {
staticWait(2000);
		try {
			WebElement verifypolicyname = driver.findElement(By.xpath("//td/a[contains(text(),'"+policyname+"')]"));
			if (verifypolicyname.isDisplayed()) {
				logger.info("Policy name displayed on listing page");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Policy name not displayed on listing page");
		}
	}
	public void clickOnPolicyName() {
		staticWait(2000);
		click(By.xpath("//td/a[contains(text(),'"+policyname+"')]"), "Policy Name", 25);

	}
	public void captureupdateNotifyMessage() {
		try {
			staticWait(2000);
			WebElement notifymessage = driver
					.findElement(By.xpath("//div/span[contains(text(),'Policy updated successfully')]"));
			if (notifymessage.isDisplayed()) {
				logger.info(notifymessage.getText());
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Policy not updated successfully");
		}
	}
	public void clickOnCheckBox() {
		// staticWait(3000);

		click(By.xpath("//div[@class='custom-control custom-checkbox']"), "CheckBox", 25);

	}
	public void clickOndelete() {
		// staticWait(3000);

		clickByJavascript(By.xpath("//a[@id='DeleteMultiple']"), "Delete Button", 25);

	}
	public void clickOnConfirmationButton() {
		staticWait(1000);
		
		click(By.xpath("//button[@title='OK']"), "Confirmation Button", 20);

	}
	public void captureDeleteNotifyMessage() {
		try {
			staticWait(2000);
			WebElement notifymessage = driver.findElement(
					By.xpath("//div/span[contains(text(),'Policies has been successfully deleted')]"));
			if (notifymessage.isDisplayed()) {
				logger.info(notifymessage.getText());
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Policies hasn't been successfully deleted");
		}
	}
	public void selectInActiveStatus() {
		 staticWait(1000);
		

		selectValueWithText(By.xpath("//select[contains(@onchange,'DrpdownUpdataStatus')]"), "Inactive",
				"InActive Status", 25);

	}
	public void selectActiveStatus() {
		 staticWait(1000);
		

		selectValueWithText(By.xpath("//select[contains(@onchange,'DrpdownUpdataStatus')]"), "Active",
				"Active Status", 25);

	}
	public void clickOnProbationPeriod() {
		staticWait(3000);
		
		clickByJavascript(By.xpath("//td/a[@data-original-title='Probation Period View']"), "Probation Period", 20);
		try {
			staticWait(1000);
			WebElement probationperiod = driver.findElement(By.xpath("//div/h4[contains(text(),'Probation Period Detail')]"));
			if (probationperiod.isDisplayed()) {
				logger.info("Probation Period page opened successfully");
				click(By.xpath("//button[contains(text(),'Close')]"), "Close Button", 20);
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Probation Period page not opened successfully");
		}

	}
	public void clickOnNoticePeriod() {
		staticWait(3000);
		
		clickByJavascript(By.xpath("//a[@data-original-title='Notice Period View']"), "Notice Period", 20);
		try {
			staticWait(1000);
			WebElement probationperiod = driver.findElement(By.xpath("//div/h4[contains(text(),'Notice Period Detail')]"));
			if (probationperiod.isDisplayed()) {
				logger.info("Notice Period page opened successfully");
				click(By.xpath("//button[contains(text(),'Close')]"), "Close Button", 20);

			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Notice Period page not opened successfully");
		}

	}
}
