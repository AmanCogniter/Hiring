package pageObjects;

import static reporting.ComplexReportFactory.getTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

public class JobListPage extends WebBasePage {
	WebDriver driver;
	String pattern = "yyMMddHHmmss";
	String patterns = "MM/dd/yyyy";

	Date date = new Date();
	SimpleDateFormat dateformat = new SimpleDateFormat(pattern);
	SimpleDateFormat dateformats = new SimpleDateFormat(patterns);
	String datevalue = dateformat.format(date);
	String datevalues = dateformats.format(date);

	static String titleName;
	static String jobtitle;
	static String designation;
	static String department;

	String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\testfiles\\";
	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";
	private static Properties prop = new PropertiesLoader(FILE_NAME).load();

	public JobListPage(WebDriver driver) {

		super(driver, "JobListPage");
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

	public void clickOnJobList() {
		click(By.xpath("//div/ul/li/a[contains(text(),'Job List')]"), "Group List", 30);
		staticWait(3000);
	}

	public void clickOnAddJobList() {
		clickByJavascript(By.xpath("//a[@data-original-title='Add a Job']"), "Add Group", 20);
		staticWait(2000);
	}

	public void save() {

		staticWait(1000);
		WebElement savebutton = driver.findElement(By.xpath("//a[@data-original-title='Save and continue']"));
		Actions action = new Actions(driver);
		action.moveToElement(savebutton).click().perform();
		// click(By.xpath("//div/a[contains(text(),'Save')]"), "Save Button", 20);
		// waitForLoad(20);
	}

	
	public void VerifyMandatoryFieldValidation() {
		int i = 0;
		String actualText;
		String expectedText;

		List<WebElement> errorMessageLocator = findMultipleElement(By.xpath("//div[@class='invalid-feedback']"), 45);
		String[] expectedValue = { "Title", "Job Title(Internal)", "Designation", "Enter number of positions",
				"Department", "Start Date", "Close Date", "Location", "Currency", "Skill", "Short Description",
				"Description", "Graduation", "Post Graduation", "Doctorate" };
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

	public void enterTitle() {
		staticWait(3000);
		titleName = prop.getProperty("titlename");

		enter(By.xpath("//div/input[@id='post_title']"), titleName, "Title", 25);

	}

	public void enterJobTitle() {
		staticWait(1000);
		jobtitle = prop.getProperty("jobtitle");

		enter(By.xpath("//div/input[@id='job_title']"), jobtitle, "Job Title", 25);

	}

	public void selectDesignation() {
		staticWait(1000);
		designation = prop.getProperty("designation");

		selectValueWithText(By.xpath("//select[@name='designation_id']"), designation, "Designation", 25);

	}

	public void enterPosition() {
		staticWait(1000);
		String position = prop.getProperty("numberofposition");

		enter(By.xpath("//input[@id='positions']"), position, "Number of position", 25);

	}

	public void selectDepartment() {
		staticWait(1000);
		department = prop.getProperty("department");

		selectValueWithText(By.xpath("//select[@name='department_id']"), department, "Department", 25);

	}

	public void enterStartdate() {
		staticWait(1000);

		enter(By.xpath("//input[@name='start_date']"), datevalues, "Start date", 25);

	}

	public void enterClosedate() {
		staticWait(1000);
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		Date tomorrow = calendar.getTime();
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

		String tomorrowAsString = dateFormat.format(tomorrow);
		enter(By.xpath("//input[@name='close_date']"), tomorrowAsString, "Close date", 25);

	}

	public void selectLocation() {
		staticWait(1000);
		click(By.xpath("//div[@class='multiselect__tags']/input"), "Location Dropdown", 25);
		staticWait(1000);
		click(By.xpath("//span[@data-select='Press enter to select']/span"), "Location", 25);

	}

	public void selectCurrency() {
		staticWait(1000);
		String currency = prop.getProperty("currency");

		selectValueWithText(By.xpath("//select[@name='currency']"), currency, "Currency", 25);

	}

	public void selectSalleryFrequency() {
		staticWait(1000);
		String salleryfrequency = prop.getProperty("salleryfrequency");

		selectValueWithText(By.xpath("//select[@name='salary_frequency']"), salleryfrequency, "Sallery Frequency", 25);

	}

	public void selectJobType() {
		staticWait(1000);

		selectValueWithIndex(By.xpath("//select[@name='job_type_id']"), 1, "Job Type", 25);

	}

	public void selectSkill() {
		staticWait(1000);
		click(By.xpath("(//div[@class='multiselect__tags']/input)[2]"), "Skill Dropdown", 25);
		staticWait(1000);
		click(By.xpath(
				"(//div[@class='multiselect__content-wrapper'])[2]/ul/li/span[@data-select='Press enter to select']/span"),
				"Skill", 25);

	}

	public void enterShortDescription() {
		staticWait(1000);

		enter(By.xpath("//textarea[@placeholder='Enter Short Description']"), "Enter Short description",
				"Short description", 25);

	}

	public void enterDescription() {
		staticWait(2000);
		switchToFrame();
		WebElement descrition = driver.findElement(By.xpath(
				"//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_theme_Default cke_show_borders']"));
		Actions action = new Actions(driver);
		action.moveToElement(descrition).click().perform();
		enter(By.xpath(
				"//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_theme_Default cke_show_borders']"),
				"Enter description", "Description", 25);
		driver.switchTo().parentFrame();

	}

	public void selectGraduation() {
		staticWait(1000);

		selectValueWithText(By.xpath("//select[@name='graduation']"), "Any Graduation", "Graduation", 25);

	}

	public void selectPostGraduation() {
		staticWait(1000);

		selectValueWithText(By.xpath("//select[@name='post_graduation']"), "Any Post Graduation", "Post Graduation",
				25);

	}

	public void selectDoctorate() {
		staticWait(1000);

		selectValueWithText(By.xpath("//select[@name='doctorate']"), "Any Doctorate", "Doctorate", 25);

	}

	public void selectStatus() {
		staticWait(1000);

		selectValueWithText(By.xpath("//select[@id='saveOptions']"), "Publish", "Status", 25);

	}
	public void clickOnConfirmationButton() {
		//staticWait(1000);
		
		clickByJavascript(By.xpath("//button[@title='OK']"), "Confirmation Button", 20);

	}
	public void captureNotifyMessage() {
		try {
			staticWait(2000);
			WebElement notifymessage = driver.findElement(
					By.xpath("//div/span[contains(text(),'Job successfully added')]"));
			if (notifymessage.isDisplayed()) {
				logger.info(notifymessage.getText());
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Job successfully not added");
		}
	}


}
