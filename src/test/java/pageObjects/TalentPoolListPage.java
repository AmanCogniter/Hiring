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

public class TalentPoolListPage extends WebBasePage{
	WebDriver driver;
	String pattern = "yyMMddHHmmss";

	Date date = new Date();
	SimpleDateFormat dateformat = new SimpleDateFormat(pattern);

	String datevalue = dateformat.format(date);

	static String firstName;
	static String lastName;
	static String email;
	static String mobileNumber;

	String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\testfiles\\";
	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";
	private static Properties prop = new PropertiesLoader(FILE_NAME).load();

	public TalentPoolListPage(WebDriver driver) {

		super(driver, "TalentPoolListPage");
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

	public void clickOnTalentPoolList() {
		click(By.xpath("(//div/ul/li/a[@data-original-title='Talent Pool List'])[last()]"), "Talent Pool List", 30);
		staticWait(3000);
	}

	public void clickOnAddTalentPoolList() {
		clickByJavascript(By.xpath("//a[@data-original-title='Add to Talent Pool']"), "Add Talent Pool List", 20);
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

	public void captureErrorNotifyMessage() {
		try {
			staticWait(2000);
			WebElement notifymessage = driver
					.findElement(By.xpath("//div/span[contains(text(),'Please correct the highlighted errors shown')]"));
			if (notifymessage.isDisplayed()) {
				logger.info(notifymessage.getText());
				click(By.xpath("//button[@id='closenotifymessage']"), "Close Notify Message", 30);
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Error message not displayed");
		}
	}

	public void VerifyMandatoryFieldValidation() {
		staticWait(2000);
		int i = 0;
		String actualText;
		String expectedText;

		List<WebElement> errorMessageLocator = findMultipleElement(
				By.xpath("//div[contains(@class,'invalid-feedback')]"), 45);
		String[] expectedValue = { "First Name", "Last Name","Email","Mobile Number" };
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
	public void uploadDocument() {
		staticWait(3000);
//		findElementVisibility(
//				By.xpath("//span[@class='group-span-filestyle input-group-btn input-group-text bg-white']"), 20);
//		uploadDoc(By.xpath("//span[@class='group-span-filestyle input-group-btn input-group-text bg-white']"),
//				filePath + prop.getProperty("expenseFileDoc"), "uploaded document", 10);

//		String h = filePath + prop.getProperty("expenseFileDoc");
//		System.out.println("file path is :: " + h);
//		

		/*
		 * driver.findElement(By.
		 * xpath("//span[@class='group-span-filestyle input-group-btn input-group-text bg-white']"
		 * )) .click();
		 */
		driver.findElement(By.xpath(
				"//span[@class='group-span-filestyle input-group-btn input-group-text bg-white']/label[@for='flFile']"))
				.click();

		// put path to your image in a clipboard
		StringSelection ss = new StringSelection(
				"C:\\Users\\aanand\\eclipse-workspace\\Com.Talygen.Hiring.Automation\\src\\main\\resources\\testfiles\\pdf.pdf");
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

	public void enterFirstName() {
		staticWait(2000);
		firstName = prop.getProperty("talentpoolfirstname");
		System.out.println(firstName);
		enter(By.xpath("//div/input[@id='first_name']"), firstName, "First Name", 25);

	}

	public void enterLastName() {

		lastName = prop.getProperty("lastname") + datevalue;
		enter(By.xpath("//div/input[@id='last_name']"), lastName, "Last Name", 25);

	}

	public void enterEmail() {
		staticWait(3000);
		email = prop.getProperty("email") + datevalue + "@gmail.com";
		enter(By.xpath("//div/input[@id='email_id']"), email, "Email", 25);

	}

	public void enterMobileNumber() {

		mobileNumber = prop.getProperty("mobilenumber");
		click(By.xpath("//div/input[@name='mobile']"), "Mobile Number Textfield", 25);
		enter(By.xpath("//div/input[@name='mobile']"), mobileNumber, "Mobile Number", 25);
		click(By.xpath("//div/input[@name='phone_number']"), "Phone Textfield", 25);

	}
	public void captureNotifyMessage() {
		try {
			staticWait(5000);
			WebElement notifymessage = driver
					.findElement(By.xpath("//div/span[contains(text(),'Talent Pool successfully added')]"));
			if (notifymessage.isDisplayed()) {
				logger.info(notifymessage.getText());
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Talent Pool not added");
		}
	}
	public void clickOnTalentPoolNameSearchField() {

		staticWait(3000);
		click(By.xpath("//div/h5/a/span[contains(text(),'Talent Pool Name')]"), "Talent Pool Name Search Field", 25);

	}
	public void enterNameIntoSearchField() {

		
		enter(By.xpath("//div/input[@placeholder='Talent Pool Name  Search']"), firstName+" "+lastName, "Talent Pool Name", 25);

	}
	public void clickOnSearchButton() {

		staticWait(3000);
		clickByJavascript(By.xpath("//span/a[contains(@data-original-title,'Search')]"), "Search Button", 25);

	}
	public void verifyTalentPool() {
		try {
			staticWait(5000);
			WebElement notifymessage = driver
					.findElement(By.xpath("//td/span[contains(text(),'"+lastName+"')]"));
			if (notifymessage.isDisplayed()) {
				logger.info("Talent Pool displayed on listing page");
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Talent Pool not displayed on listing page");
		}
	}
	public void clickOnEmailSearchField() {

		staticWait(1000);
		click(By.xpath("//div/h5/a/span[contains(text(),'Email')]"), "Email Search Field", 25);

	}
	public void enterEMailIntoSearchField() {

		
		enter(By.xpath("//div/input[@placeholder='Email Search']"), email, "Email Name", 25);

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
					By.xpath("//div/span[contains(text(),'Talent Pool has been successfully deleted')]"));
			if (notifymessage.isDisplayed()) {
				logger.info(notifymessage.getText());
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Talent Pool hasn't been successfully deleted");
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
					.findElement(By.xpath("//div/span[contains(text(),'Talent Pool has been successfully updated')]"));
			if (updateNotifeMessage.isDisplayed()) {
				logger.info(updateNotifeMessage.getText());
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Talent Pool hasn't been successfully updated");
		}

	}
	public void clickOnViewButton() {
		waitForLoad(10);
		click(By.xpath("//a[@data-original-title='View']"), "View Button", 25);
		try {
			WebElement profile = driver.findElement(By.xpath("//div/span[contains(text(),'Talent Pool List Profile')]"));
			if (profile.isDisplayed()) {
				logger.info("View page opened successfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("View page not opened successfully");
		}

	}
	public void clickOnBackToList() {
		waitForLoad(10);
		click(By.xpath("//a[@data-original-title='Back to list']"), "Back To List", 25);

	}
	public void clickOnAddAsCandidate() {
		waitForLoad(10);
		click(By.xpath("//a[@data-original-title='Add As Candidate']"), "Add As Candidate", 25);

	}
	public void selectJob() {
		waitForLoad(10);
		selectValueWithIndex(By.xpath("//select[@name='Job']"), 2, "Job", 25);

	}
	public void enterDescription() {
		//waitForLoad(10);
		switchToFrame();
		enter(By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_theme_Default cke_show_borders']"), "Test", "Description", 25);
driver.switchTo().parentFrame();
	}
	public void saveButton() {

		staticWait(3000);
		scrollDown();
		WebElement savebutton = driver.findElement(By.xpath("(//span[contains(text(),'Save')])[2]"));
		Actions action = new Actions(driver);
		action.moveToElement(savebutton).click().perform();
		// click(By.xpath("//div/a[contains(text(),'Save')]"), "Save Button", 20);
		// waitForLoad(20);
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
		 waitForLoad(10);
		clickByJavascript(By.xpath("(//a[contains(text(),'Next')])[2]"), "Next Button", 25);

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

		enter(By.xpath("//div/input[contains(@placeholder,'Enter')]"), firstName, "Value", 25);

	}

	public void clickOnDeleteManageView() {
		waitForLoad(10);
		clickByJavascript(By.xpath("(//a[@data-original-title='Delete'])[last()]"), "Delete Button", 25);

	}
	public void saveManageView() {

		staticWait(3000);
		//scrollDown();
		WebElement savebutton = driver.findElement(By.xpath("//div/a[@data-original-title='Save']"));
		Actions action = new Actions(driver);
		action.moveToElement(savebutton).click().perform();
		// click(By.xpath("//div/a[contains(text(),'Save')]"), "Save Button", 20);
		// waitForLoad(20);
	}

}
