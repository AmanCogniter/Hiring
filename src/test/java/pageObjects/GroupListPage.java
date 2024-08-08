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

public class GroupListPage extends WebBasePage {
	WebDriver driver;
	String pattern = "yyMMddHHmmss";

	Date date = new Date();
	SimpleDateFormat dateformat = new SimpleDateFormat(pattern);

	String datevalue = dateformat.format(date);

	static String groupName;
	static String lastName;
	static String email;
	static String mobileNumber;

	String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\testfiles\\";
	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";
	private static Properties prop = new PropertiesLoader(FILE_NAME).load();

	public GroupListPage(WebDriver driver) {

		super(driver, "GroupListPage");
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

	public void clickOnGroupList() {
		click(By.xpath("(//div/ul/li/a[contains(text(),'Group List')])[2]"), "Group List", 30);
		staticWait(3000);
	}

	public void clickOnAddGroupList() {
		clickByJavascript(By.xpath("//a[@data-original-title='Add Group']"), "Add Group", 20);
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
			WebElement notifymessage = driver.findElement(
					By.xpath("//div/span[contains(text(),'Group successfully added')]"));
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
				By.xpath("//div[@class='form-group']//span[contains(@class,'invalid-feedback')]"), 45);
		String[] expectedValue = { "Group Name", "Recruiters"};
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
	public void enterGroupName() {
		staticWait(3000);
		groupName = prop.getProperty("groupname") + datevalue;
		System.out.println(groupName);
		enter(By.xpath("//div/input[@id='GroupName']"), groupName, "Group Name", 25);

	}
	public void selectRecruiters() {
		staticWait(3000);
		click(By.xpath("(//div/input[@type='search'])[2]"), "Recruiters DropDown", 20);
		click(By.xpath("(//ul/li/a/div)[2]"), "Recruiters", 20);

	}
	public void enterGroupNameIntoSearchField() {
		staticWait(3000);
		
		enter(By.xpath("//div/input[@id='GroupNameSearch']"), groupName, "Group Name", 25);

	}
	public void clickOnSearchButton() {
		staticWait(3000);
		
		click(By.xpath("//a[@data-original-title='Search']"), "Search Button", 20);

	}
	public void verifyGroupNameOnListingPage() {
		try {
			staticWait(3000);
			WebElement groupNAme = driver.findElement(
					By.xpath("//table[@id='tblRelatedInfoListing']/tbody/tr/td[contains(text(),'"+groupName+"')]"));
			if (groupNAme.isDisplayed()) {
				logger.info("Group name is Displayed on listing page");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Group name not Displayed on listing page");
		}
	}
	public void clickOnCheckBox() {
		staticWait(1000);
		
		click(By.xpath("//div[@class='custom-control custom-checkbox']"), "Check BoX", 20);

	}
	public void clickOnEdit() {
		staticWait(1000);
		
		click(By.xpath("//a/i[@class='fa fa-pencil text-success action-icon']"), "Edit", 20);

	}
	public void clickOnUpdate() {
		staticWait(1000);
		
		clickByJavascript(By.xpath("//a[@title='Update']"), "Update Button", 20);

	}
	public void captureUpdateNotifyMessage() {
		try {
			staticWait(2000);
			WebElement notifymessage = driver.findElement(
					By.xpath("//div/span[contains(text(),'Group has been successfully updated')]"));
			if (notifymessage.isDisplayed()) {
				logger.info(notifymessage.getText());
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Group hasn't been successfully updated");
		}
	}
	public void clickOnDelete() {
		staticWait(1000);
		
		clickByJavascript(By.xpath("//a[@id='DeleteMultiple']"), "Delete Button", 20);

	}
	public void clickOnConfirmationButton() {
		//staticWait(1000);
		
		clickByJavascript(By.xpath("//button[@title='OK']"), "Confirmation Button", 20);

	}
	public void captureDeleteNotifyMessage() {
		try {
			staticWait(2000);
			WebElement notifymessage = driver.findElement(
					By.xpath("//div/span[contains(text(),'Group has been successfully updated')]"));
			if (notifymessage.isDisplayed()) {
				logger.info(notifymessage.getText());
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Group hasn't been successfully deleted");
		}
	}


}
