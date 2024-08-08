package pageObjects;

import static reporting.ComplexReportFactory.getTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
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

public class CandidateListPage extends WebBasePage {
	WebDriver driver;
	String pattern = "yyMMddHHmmss";
	String patterns = "MM/dd/yy";
	Date date = new Date();
	SimpleDateFormat dateformat = new SimpleDateFormat(pattern);
	SimpleDateFormat dateformats = new SimpleDateFormat(patterns);

	String datevalue = dateformat.format(date);
	String datevalues = dateformats.format(date);

	static String firstName;
	static String lastName;
	static String email;
	static String mobileNumber;

	String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\testfiles\\";
	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";
	private static Properties prop = new PropertiesLoader(FILE_NAME).load();

	public CandidateListPage(WebDriver driver) {

		super(driver, "CandidateListPage");
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

	public void clickOnCandidateList() {
		click(By.xpath("(//a[contains(text(),'Candidate List')])[2]"), "Candidate List", 30);
		staticWait(3000);
	}

	public void clickOnAddCandidateList() {
		clickByJavascript(By.xpath("//a[@data-original-title='Add Candidate']"), "Add Candidate", 20);
		staticWait(2000);
	}

	public void save() {
		scrollDown();
		staticWait(1000);
		WebElement savebutton = driver.findElement(By.xpath("//div/a[contains(text(),'Save')]"));
		Actions action=new Actions(driver);
		action.moveToElement(savebutton).click().perform();
		//click(By.xpath("//div/a[contains(text(),'Save')]"), "Save Button", 20);
		// waitForLoad(20);
	}

	public void closeNotifyMessage() {
		try {
			WebElement notifymessage = driver.findElement(
					By.xpath("//div/span[contains(text(),'Please correct the highlighted errors shown')]"));
			if (notifymessage.isDisplayed()) {
				logger.info(notifymessage.getText());
				staticWait(2000);
				click(By.xpath("//button[@id='closenotifymessage']"), "Close Button", 30);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void VerifyMandatoryFieldValidation() {
		int i = 0;
		String actualText;
		String expectedText;

		List<WebElement> errorMessageLocator = findMultipleElement(
				By.xpath("//div[@class='form-group']//span[contains(@class,'invalid-feedback')]"), 45);
		String[] expectedValue = { "Select Job", "First Name", "Last Name", "Email", "Mobile Number" };
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

	public void selectJob() {
		staticWait(5000);
		click(By.xpath("//select[@name='Job']"), "Job DropDown", 20);
		selectValueWithText(By.xpath("//select[@name='Job']"), "Quality Analyst", "Job", 20);

	}

	public void enterFirstName() {

		firstName = prop.getProperty("firstname") + datevalue;
		System.out.println(firstName);
		enter(By.xpath("//div/input[@id='first_name']"), firstName, "First Name", 25);

	}

	public void enterLastName() {

		lastName = prop.getProperty("lastname");
		enter(By.xpath("//div/input[@id='last_name']"), lastName, "Last Name", 25);

	}

	public void enterEmail() {

		email = prop.getProperty("email") + datevalue + "@gmail.com";
		enter(By.xpath("//div/input[@id='email_id']"), email, "Email", 25);

	}

	public void enterMobileNumber() {

		mobileNumber = prop.getProperty("mobilenumber");
		enter(By.xpath("//div/input[@name='mobile']"), mobileNumber, "Mobile Number", 25);

	}

	public void clickOnCandidteNameSearchField() {
		waitForLoad(50);
		click(By.xpath("//div/h5/a/span[contains(text(),'Candidate  Name')]"), "Candidate Name Search Field", 25);

	}

	public void enterCandidateNameIntoSearchField() {

		enter(By.xpath("//div/input[@placeholder='Search by Candidate  Name']"), firstName, "Candaidate Name", 25);

	}

	public void captureNotifyMessageOfAddCandidate() {
		staticWait(3000);
		try {
			WebElement candidateNAme = driver
					.findElement(By.xpath("//div/span[contains(text(),'Candidate successfully added')]"));
			if (candidateNAme.isDisplayed()) {
				logger.info(candidateNAme.getText());
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Candidate not added successfully");
		}

	}

	public void clickOnSearchButton() {
		waitForLoad(10);
		click(By.xpath("//span[@id='searchDataButton']"), "Search Button", 25);

	}

	public void verifyCandidateOnListingPage() {
		waitForLoad(30);
		try {
			WebElement candidateNAme = driver.findElement(By.xpath("//tr/td/a[contains(text(),'" + firstName + "')]"));
			if (candidateNAme.isDisplayed()) {
				logger.info("Candidate name displayed successfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Candidate name not displayed ");
		}

	}

	public void clickOncheckbox() {
		waitForLoad(10);
		click(By.xpath("//th/div[@class='custom-control custom-checkbox']"), "CheckBox", 25);

	}

	public void clickOnDelete() {
		// waitForLoad(10);
		clickByJavascript(By.xpath("//span[contains(text(),'Delete')]"), "Delete Button", 25);

	}

	public void clickOnConfirmationButton() {
		// waitForLoad(10);
		click(By.xpath("//button[contains(text(),'OK')]"), "Ok Button", 25);

	}

	public void captureNotifyMessage() {
		waitForLoad(30);
		try {
			WebElement notifeMessage = driver
					.findElement(By.xpath("//div/span[contains(text(),'Candidate has been successfully deleted')]"));
			if (notifeMessage.isDisplayed()) {
				logger.info(notifeMessage.getText());
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("'Candidate hasn't been successfully deleted ");
		}

	}

	public void verifyGridViewFunctionality() {
		waitForLoad(30);
		click(By.xpath("//a[@data-original-title='List View']"), "grid", 25);
		try {
			String gridView = driver.findElement(By.xpath("//a[@data-original-title='List View']"))
					.getAttribute("title");
			if (gridView.contains("Grid View")) {
				logger.info("Grid View Button Working successfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Grid View Button not Working");
		}

	}

	public void verifyListViewFunctionality() {
		waitForLoad(30);
		click(By.xpath("//a[@data-original-title='List View']"), "grid", 25);
		try {
			String listView = driver.findElement(By.xpath("//a[@data-original-title='List View']"))
					.getAttribute("title");
			if (listView.contains("List View")) {
				logger.info("List View Button Working successfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("List View Button not Working");
		}

	}

	public void clickOnManageView() {
		waitForLoad(10);
		clickByJavascript(By.xpath("//a[@data-original-title='Manage View']"), "Manage View", 25);

	}

	public void clickOnAddManageView() {
		waitForLoad(10);
		clickByJavascript(By.xpath("(//a[contains(text(),'Add New')])[last()]"), "Add Manage View", 25);

	}

	public void enterViewName() {
		waitForLoad(10);
		String viewName = prop.getProperty("viewname") + datevalue;
		enter(By.xpath("//label[contains(text(),'View Name')]/parent::div/descendant::input[@class='form-control']"),
				viewName, "View Name", 25);

	}

	public void clickOnNext() {
		// waitForLoad(10);
		clickByJavascript(By.xpath("//a[contains(text(),'Next')]"), "Next Button", 25);

	}

	public void clickOnMoveAllRight() {
		// waitForLoad(10);
		click(By.xpath("(//button[@data-original-title='Move All Right'])[last()]"), "Move All Right", 25);

	}

	public void clickOnNextButton() {
		// waitForLoad(10);
		clickByJavascript(By.xpath("(//a[contains(text(),'Next')])[last()]"), "Next Button", 25);

	}

	public void selectFieldName() {
		waitForLoad(30);
		selectValueWithText(By.xpath("//select[contains(@name,'fieldName')]"), "First Name", "Field Name", 25);

	}

	public void selectConditionalOperator() {
		waitForLoad(30);
		selectValueWithText(By.xpath("//select[contains(@name,'operator')]"), "Contains", "Conditional Operator", 25);

	}

	public void enterValue() {
		waitForLoad(10);

		enter(By.xpath("//div/input[contains(@id,'first_name')]"), firstName, "Value", 25);

	}

	public void clickOnDeleteManageView() {
		waitForLoad(10);
		clickByJavascript(By.xpath("(//a[@data-original-title='Delete'])[last()]"), "Delete Button", 25);

	}

	public void clickOnForwardCandidateCV() {
		waitForLoad(10);
		click(By.xpath("//a/span[contains(text(),'Forward candidates CV')]"), "Forward candidates CV", 25);

	}

	public void selectTemplate() {
		waitForLoad(50);
		click(By.xpath("//select[@name='Template']"), "Template Dropdown", 25);
		// selectValueWithIndex(By.xpath("//select[@name='Template']"), 2, "Template",
		// 25);
		click(By.xpath("//select[@name='Template']/option[2]"), "Template ", 25);

	}

	public void selectPrefillFromTemplate() {
		// waitForLoad(10);
		click(By.xpath("//select[@name='PrefillTemplate']"), "Prefill from Template Dropdown", 25);
		// selectValueWithIndex(By.xpath("//select[@name='PrefillTemplate']"), 2,
		// "Prefill from Template", 25);
		click(By.xpath("//select[@name='PrefillTemplate']/option[2]"), "Prefill from Template", 25);

	}

	public void selectResumeTemplate() {
		// waitForLoad(10);
		click(By.xpath("//select[@name='TemplateResume']"), "Resume Template Dropdown", 25);
		// selectValueWithIndex(By.xpath("//select[@name='TemplateResume']"), 2, "Resume
		// Template", 25);
		click(By.xpath("//select[@name='TemplateResume']/option[2]"), "Resume Template", 25);

	}

	public void enterToEmail() {
		waitForLoad(10);

		enter(By.xpath("//input[@name='ToEmail']"), "sql@yopmail.com", "To email", 25);

	}

	public void clickOnSend() {
		staticWait(3000);
		clickByJavascript(By.xpath("//a/span[contains(text(),'Send')]"), "Send Button", 25);

	}

	public void VerifyMandatoryFieldOfForwardCandidateCV() {
		int i = 0;
		String actualText;
		String expectedText;

		List<WebElement> errorMessageLocator = findMultipleElement(
				By.xpath("//div[@class='form-group']//span[contains(@class,'invalid-feedback')]"), 45);
		String[] expectedValue = { "Choose Template", "Receive Reply on", "Prefill from template", "Resume Template" };
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

	public void clickOnActionButton() {
		waitForLoad(10);
		click(By.xpath("//span[@class='actions mobileaction']/i"), "Action Button", 25);

	}

	public void clickOnEditButton() {
		waitForLoad(10);
		click(By.xpath("//a[@data-original-title='Edit']"), "Edit Button", 25);

	}

	public void captureUpdateNotifyMessage() {
		waitForLoad(30);
		try {
			WebElement updateNotifeMessage = driver
					.findElement(By.xpath("//div/span[contains(text(),'Candidate has been successfully updated')]"));
			if (updateNotifeMessage.isDisplayed()) {
				logger.info(updateNotifeMessage.getText());
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Candidate hasn't been successfully updated");
		}

	}

	public void clickOnMakeOfferButton() {
		waitForLoad(10);
		click(By.xpath("//a[@data-original-title='Make Offer']"), "Make Offer", 25);

	}

	public void enterToPhoneNumber() {
		staticWait(5000);
		click(By.xpath("//div/input[@placeholder='Phone number']"), "Phone Number textfield", 25);
		enter(By.xpath("//div/input[@placeholder='Phone number']"), mobileNumber, "Phone Number", 25);

	}

	public void enterDateOfBirth() {
		// waitForLoad(10);

		enter(By.xpath("//div/input[@id='dateofbirth']"), prop.getProperty("dateofbirth"), "Date Of Birth", 25);

	}

	public void enterStreet() {
		// waitForLoad(10);

		enter(By.xpath("//div/input[@id='street']"), prop.getProperty("street"), "Street", 25);

	}

	public void enterCity() {
		// waitForLoad(10);

		enter(By.xpath("//div/input[@id='city']"), prop.getProperty("city"), "City", 25);

	}

	public void enterState() {
		// waitForLoad(10);

		enter(By.xpath("//div/input[@id='state']"), prop.getProperty("city"), "State", 25);

	}

	public void selectCountry() {
		// waitForLoad(10);

		selectValueWithText(By.xpath("//div/select[@name='country']"), prop.getProperty("country"), "Country", 25);

	}

	public void enterZipCode() {
		// waitForLoad(10);

		enter(By.xpath("//div/input[@id='zipcode']"), prop.getProperty("zipcode"), "Zipcode", 25);

	}

	public void clickOnContinue() {
		// waitForLoad(10);

		click(By.xpath("//div/a[contains(text(),'Continue')]"), "Continue", 25);

	}

	public void enterAmountPayable() {
		staticWait(3000);

		enter(By.xpath("//div/input[@id='amount']"), prop.getProperty("amount"), "Payable Amount", 25);

	}

	public void selectCurrency() {
		// staticWait(3000);

		selectValueWithText(By.xpath("//div/select[@name='currency']"), "USD(US$)", "Currency", 25);

	}

	public void selectPeriod() {
		// staticWait(3000);

		selectValueWithText(By.xpath("//div/select[@name='period']"), "Annually", "Period", 25);

	}

	public void selectPaidAs() {
		// staticWait(3000);

		selectValueWithText(By.xpath("//div/select[@name='paidas']"), "Monthly", "Paid As", 25);

	}

	public void clickOnContinueOfCompensation() {
		// waitForLoad(10);

		click(By.xpath("//span[contains(text(),'Continue')]"), "Continue", 25);

	}

	public void captureUpdateNotifyMessageOfCompensation() {
		waitForLoad(30);
		try {
			WebElement updateNotifeMessage = driver
					.findElement(By.xpath("//div/span[contains(text(),'Information successfully added')]"));
			if (updateNotifeMessage.isDisplayed()) {
				logger.info(updateNotifeMessage.getText());
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Information not added");
		}

	}

	public void selectDepartment() {
		staticWait(3000);

		selectValueWithText(By.xpath("//div/select[@name='department']"), "Quality Analyst", "Department", 25);

	}

	public void selectJObLocation() {
		// staticWait(3000);
		click(By.xpath("//div/input[@placeholder='Select Location']"), "Job textField", 25);
		enter(By.xpath("//div/input[@placeholder='Select Location']"), prop.getProperty("location"), "Job location",
				25);
		click(By.xpath("//div/ul/li/span[@data-select='Press enter to select']"), "Job Location", 25);
	}

	public void selectReportingManager() {
		// staticWait(3000);
		// click(By.xpath("//div/select[@id='reportingmanager']"), "Reporting Manager
		// Dropdown", 25);
		selectValueWithIndex(By.xpath("//div/select[@id='reportingmanager']"), 2, "Reporting Manager", 25);
		// click(By.xpath("//div/select[@id='reportingmanager']/option[2]"), "Reporting
		// Manager", 25);

	}

	public void enterJoiningDAte() {
		// staticWait(3000);

		click(By.xpath("(//span[@title='Select Date'])[2]"), "Date Picker", 25);
		click(By.xpath("(//span[@title='Select Date'])[2]"), "Date Picker Closed", 25);

	}

	public void enterDAte() {
		// staticWait(3000);

		click(By.xpath("//div/input[@name='enddate']"), "Date ", 25);
		enter(By.xpath("//div/input[@name='enddate']"), datevalues, "Date", 25);

	}

	public void selectOfferTemplate() {
		// staticWait(3000);

		// selectValueWithIndex(By.xpath("//div/select[@name='offertemplate']"), 2,
		// "Offer Template", 25);
		click(By.xpath("//div/select[@name='offertemplate']"), "Offer Template Doprdown ", 25);
		click(By.xpath("//div/select[@name='offertemplate']/option[2]"), "Offer Template ", 25);
	}

	public void clickOnSave() {
		// staticWait(3000);

		click(By.xpath("//a/span[contains(text(),'Save')]"), "Save ", 25);

	}

	public void clickOnEmailOffer() {
		staticWait(3000);

		click(By.xpath("//span[contains(text(),'Email Offer')]"), "Email Offer ", 25);

	}

	public void captureNotifyMessageOfSendMail() {
		waitForLoad(30);
		try {
			WebElement notifeMessage = driver
					.findElement(By.xpath("//div/span[contains(text(),'Email has been sent successfully')]"));
			if (notifeMessage.isDisplayed()) {
				logger.info(notifeMessage.getText());
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Email hasn't been sent successfully ");
		}

	}

	public void clickOnViewButton() {
		staticWait(1000);
		click(By.xpath("//span/a[@data-original-title='View']"), "View", 25);

	}

	public void clickOnEdit() {
		staticWait(1000);
		click(By.xpath("//a[@data-original-title='Edit']"), "Edit", 25);

	}

	public void captureNotifyMessageOfUpdateCandidate() {
		waitForLoad(30);
		try {
			WebElement notifeMessage = driver
					.findElement(By.xpath("//div/span[contains(text(),'Candidate has been successfully updated')]"));
			if (notifeMessage.isDisplayed()) {
				logger.info(notifeMessage.getText());
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Candidate hasn't been successfully updated");
		}

	}

	public void clickOnRequestDocument() {
		staticWait(1000);
		click(By.xpath("//span/a[contains(text(),'Request Documents')]"), "'Request Documents", 25);

	}

	public void selectRequestTemplate() {
		staticWait(1000);
		selectValueWithIndex(By.xpath("//select[@id='SelectTemplate']"), 2, "'Request Template", 25);

	}

	public void clickOnSendEmail() {
		staticWait(3000);
		click(By.xpath("//a/span[contains(text(),'Send Email')]"), "Send Email", 25);

	}

	public void captureNotifyMessageOfRequestDocuments() {
		waitForLoad(30);
		try {
			WebElement notifeMessage = driver
					.findElement(By.xpath("//div/span[contains(text(),'Email has been sent successfully')]"));
			if (notifeMessage.isDisplayed()) {
				logger.info(notifeMessage.getText());
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Candidate hasn't been successfully updated");
		}

	}

	public void clickOnHire() {
		staticWait(1000);
		click(By.xpath("//span/a[contains(text(),'Hire')]"), "Hire", 25);

	}

	public void clickOnCancelButton() {
		staticWait(1000);
		click(By.xpath("//button[contains(text(),'Cancel')]"), "Cancel", 25);

	}

	public void clickOnHold() {
		staticWait(1000);
		click(By.xpath("//a[contains(text(),'On Hold')]"), "On Hold", 25);

	}

	public void selectOnHoldReason() {
		staticWait(1000);
		selectValueWithIndex(By.xpath("//select[@id='holdReason']"), 2, "Hold Reason", 25);

	}

	public void clickOnCandidateCheckBox() {
		staticWait(1000);
		click(By.xpath("//div/label[contains(text(),'Candidate')]"), "Candidate CheckBox", 25);

	}

	public void clickOnHiringTeamCheckBox() {
		staticWait(1000);
		click(By.xpath("//div/label[contains(text(),'Hiring Team')]"), "Hiring team CheckBox", 25);

	}

	public void enterComment() {
		staticWait(1000);
		enter(By.xpath("//div/textarea[@id='holdLeaveComment']"), prop.getProperty("comment"), "Hold", 25);

	}

	public void enterDescription() {
		staticWait(1000);
		switchToFrame();
		enter(By.xpath(
				"//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_theme_Default cke_show_borders']"),
				prop.getProperty("description"), "Description", 25);
		driver.switchTo().parentFrame();
	}

	public void clickOnUpdate() {
		// staticWait(1000);
		click(By.xpath("(//a/span[contains(text(),'Update')])[last()]"), "Update", 25);

	}

	public void captureNotifyMessageOfOnHold() {
		waitForLoad(30);
		try {
			WebElement notifeMessage = driver.findElement(
					By.xpath("//div/span[contains(text(),'Candidate Profile has been successfully updated')]"));
			if (notifeMessage.isDisplayed()) {
				logger.info(notifeMessage.getText());
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Candidate hasn't been successfully updated");
		}

	}

	public void clickOnInterview() {
		staticWait(3000);
		click(By.xpath("//span[contains(text(),'Interview')]"), "Interview", 25);

	}

	public void clickOnNote() {
		staticWait(3000);
		click(By.xpath("//span[contains(text(),'Notes')]"), "Note", 25);

	}

	public void clickOnAddNote() {
		// staticWait(1000);
		clickByJavascript(By.xpath("//small/a[contains(text(),'Add Note')]"), "Add Note", 25);

	}

	public void enterNotesDescription() {
		staticWait(1000);
		switchToFrame();
		enter(By.xpath(
				"//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_theme_Default cke_show_borders']"),
				"Test", "Notes Detail", 25);
		driver.switchTo().parentFrame();
	}

	public void clickOnSAve() {
		// staticWait(1000);
		clickByJavascript(By.xpath("//a[@title='Save']"), "Save", 25);

	}

	public void captureNotifyMessageOfNotes() {
		waitForLoad(30);
		try {
			WebElement notifeMessage = driver
					.findElement(By.xpath("//div/span[contains(text()'note has been added successfully')]"));
			if (notifeMessage.isDisplayed()) {
				logger.info(notifeMessage.getText());
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Note hasn't been added successfully");
		}

	}

	public void clickOnDeleteActionButton() {
		staticWait(3000);
		click(By.xpath("//div[@class='verticle-action']"), "Delete Action Button", 25);

	}

	public void clickOnDeleteButton() {
		staticWait(3000);
		click(By.xpath("//a[contains(text(),'Delete')]"), "Delete Button", 25);

	}

	public void clickOnEditNotesButton() {
		staticWait(3000);
		click(By.xpath("//a[contains(text(),'Edit')]"), "Edit Button", 25);

	}

	public void captureNotifyDeleteMessageOfNotes() {
		waitForLoad(30);
		try {
			WebElement notifeMessage = driver
					.findElement(By.xpath("//div/span[contains(text(),'Note Deleted Successfully')]"));
			if (notifeMessage.isDisplayed()) {
				logger.info(notifeMessage.getText());
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Note hasn't been added successfully");
		}

	}

	public void captureNotifyEditMessageOfNotes() {
		waitForLoad(30);
		try {
			WebElement notifeMessage = driver
					.findElement(By.xpath("//div/span[contains(text(),'Note Updated Successfully')]"));
			if (notifeMessage.isDisplayed()) {
				logger.info(notifeMessage.getText());
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Note hasn't been added successfully");
		}

	}

	public void clickOnDocuments() {
		staticWait(3000);
		click(By.xpath("//span[contains(text(),'Documents')]"), "Documents", 25);

	}
	public void selectDocumentType() {
		staticWait(1000);
		selectValueWithIndex(By.xpath("//select[@id='ddldoctypes']"), 1, "Document Type", 25);

	}
	// upload file
		public void uploadDocument() {
			staticWait(3000);
//			findElementVisibility(
//					By.xpath("//span[@class='group-span-filestyle input-group-btn input-group-text bg-white']"), 20);
//			uploadDoc(By.xpath("//span[@class='group-span-filestyle input-group-btn input-group-text bg-white']"),
//					filePath + prop.getProperty("expenseFileDoc"), "uploaded document", 10);

//			String h = filePath + prop.getProperty("expenseFileDoc");
//			System.out.println("file path is :: " + h);
//			

			/*
			 * driver.findElement(By.
			 * xpath("//span[@class='group-span-filestyle input-group-btn input-group-text bg-white']"
			 * )) .click();
			 */
			driver.findElement(By.xpath(
					"//span[@class='group-span-filestyle input-group-btn input-group-text bg-white']/label[@for='item_image']"))
					.click();

			// put path to your image in a clipboard
			StringSelection ss = new StringSelection(
					"C:\\Users\\aanand\\eclipse-workspace\\Com.Talygen.Hiring.Automation\\src\\main\\resources\\testfiles\\55565.jpg");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

			// imitate mouse events like ENTER, CTRL+C, CTRL+V
			Robot robot;
			try {
				robot = new Robot();

				robot.delay(250);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.delay(90);
				robot.keyRelease(KeyEvent.VK_ENTER);
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void captureNotifyMessageOfManageDocumentType() {
			staticWait(3000);
			try {
				WebElement manageDocumentType = driver
						.findElement(By.xpath("//div/span[contains(text(),'Document successfully added')]"));
				if (manageDocumentType.isDisplayed()) {
					logger.info(manageDocumentType.getText());
				}
			} catch (Exception e) {
				// TODO: handle exception
				logger.info("Document not added successfully");
			}

		}

		public void clickOnManageDocumentType() {
			staticWait(1000);
			click(By.xpath("//a[contains(text(),'Manage Document Type')]"), "Manage Document Type", 25);

		}


	public void clickOnApplyForMore() {
		staticWait(1000);
		click(By.xpath("//a/span[contains(text(),'Apply For More')]"), "Apply For More", 25);

	}

	public void selectJobForApplyMore() {
		staticWait(1000);
		selectValueWithIndex(By.xpath("//select[@name='Job']"), 1, "Job", 25);

	}

	public void clickOnSaveAndSkipEmail() {
		staticWait(1000);
		clickByJavascript(By.xpath("//a[@data-original-title='Save and Skip Email']"), "Save and Skip Email", 25);

	}

}
