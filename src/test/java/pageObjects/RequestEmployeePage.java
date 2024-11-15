package pageObjects;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.PropertiesLoader;
import utils.WebBasePage;

public class RequestEmployeePage extends WebBasePage{
	WebDriver driver;
	String pattern = "yyMMddHHmmss";
	String patterns = "MM/dd/yyyy";

	Date date = new Date();
	SimpleDateFormat dateformat = new SimpleDateFormat(pattern);
	SimpleDateFormat dateformats = new SimpleDateFormat(patterns);
	String datevalue = dateformat.format(date);
	String datevalues = dateformats.format(date);
	static String linkedCompany;
	static String editedlinkedCompany;
	static String stagename;
	static String status;
	String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\testfiles\\";
	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";
	private static Properties prop = new PropertiesLoader(FILE_NAME).load();

	public RequestEmployeePage(WebDriver driver) {

		super(driver, "RequestEmployeePage");
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

	public void clickOnRequestEmployee() {
		staticWait(3000);

		// TODO: handle exception
		//JavascriptExecutor js = (JavascriptExecutor) driver;

		// Locating element by link text and store in variable "Element"
		//WebElement Element = driver.findElement(By.xpath("//a[@data-original-title='Offboard Employee List']"));
		/*
		 * WebElement Element = driver.findElement(By.xpath(
		 * "//ul[@data-p-name='Hiring']/div//li/a[@data-original-title='Stage']"));
		 * js.executeScript("arguments[0].scrollIntoView();", Element);
		 * staticWait(1000);
		 */

		click(By.xpath("//li/a[contains(text(),'Request Employee')]"), "Request Employee", 30);
		staticWait(3000);

	}

	public void clickOnAddRequestEmployee() {
		clickByJavascript(By.xpath("//a[@title='Add Request']"), "Add Request", 20);
		staticWait(2000);
	}
	public void selectLinkedCompanyName() {
		staticWait(3000);
		linkedCompany=prop.getProperty("linkedcompany");
		selectValueWithText(By.xpath("//select[@name='Linkedcompany']"), "Tycoon", "Linked Company Name", 25);

	}
	public void selectVendorLinkedCompanyName() {
		staticWait(3000);
		String vendorlinkedCompany = prop.getProperty("vendorlinkedcompany");
		selectValueWithText(By.xpath("//select[@name='Linkedcompany']"), vendorlinkedCompany, "Linked Company Name", 25);

	}
	public void clickOnResourceType() {
		staticWait(1000);
		click(By.xpath("//div/label[contains(text(),'Resource')]"), "Resource Type Radio Button", 20);
		//staticWait(2000);
	}
	public void selectProject() {
		staticWait(1000);

		selectValueWithIndex(By.xpath("//select[@name='Project']"), 3, "Project", 25);

	}
	public void enterDecription() {
		staticWait(1000);

		enter(By.xpath("//span/textarea[@class='form-control']"), "Test", "Description", 25);

	}
	public void clickOnCheckBox() {
		staticWait(1000);

		// Find all checkbox elements on the page
        List<WebElement> checkboxes = driver.findElements(By.xpath("//div[contains(@class,'custom-control custom-checkbox')]"));

        // Loop through each checkbox and click it if it's not already selected
        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }

	}
	public void clickOnSendRequest() {
		staticWait(1000);

		click(By.xpath("//button[@type='submit']"), "Send Request", 25);
		staticWait(3000);
	}
	public void selectRequest() {
		staticWait(3000);
		
		selectValueWithText(By.xpath("//select[contains(@id,'dropdown')]"), linkedCompany, "Linked Company Name", 25);

	}
	public void selectEditedRequest() {
		staticWait(3000);
		
		selectValueWithText(By.xpath("//select[contains(@id,'dropdown')]"), editedlinkedCompany, "Linked Company Name", 25);

	}
	public void clickOnSearchButton() {
		staticWait(1000);

		clickByJavascript(By.xpath("//div/a[@data-original-title='Search']"), "Search Button", 25);

	}
	public void verifyRequestOnListingPage() {
		try {
			staticWait(2000);
			WebElement request = driver.findElement(By.xpath("//span/span[contains(text(),'"+linkedCompany+"')]"));
			if (request.isDisplayed()) {
				logger.info("Request Displayed successfully on listing page");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Request not Displayed on listing page");
		}
	}
	public void verifyEditedRequestOnListingPage() {
		try {
			staticWait(2000);
			WebElement request = driver.findElement(By.xpath("//span/span[contains(text(),'"+editedlinkedCompany+"')]"));
			if (request.isDisplayed()) {
				logger.info("Request Displayed successfully on listing page");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Request not Displayed on listing page");
		}
	}
	public void clickOnCheckbox() {
		staticWait(1000);

		click(By.xpath("//div[@class='custom-control custom-checkbox custom-control-inline']"), "Check Box", 25);

	}
	public void clickOnDelete() {
		staticWait(1000);

		clickByJavascript(By.xpath("//a[@title='Delete']"), "Delete Button", 25);

	}
	public void clickOnConfirmationButton() {
		//staticWait(1000);

		click(By.xpath("//button[@title='OK']"), "Ok Button", 25);

	}
	public void captureDeleteNotifyMessage() {
		try {
			staticWait(2000);
			WebElement notifymessage = driver
					.findElement(By.xpath("//div/span[contains(text(),'Request Employee has been successfully deleted')]"));
			if (notifymessage.isDisplayed()) {
				logger.info(notifymessage.getText());
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Request Employee hasn't been successfully deleted");
		}
	}
	public void clickOnActionButton() {
		staticWait(1000);

		click(By.xpath("//span[@class='actions mobileaction']"), "Action Button", 25);

	}
	public void clickOnViewAssignedUsers() {
		//staticWait(1000);

		click(By.xpath("//a[@title='View Assigned Users']"), "View Assigned Users", 25);
		try {
			WebElement requestDetails = driver.findElement(By.xpath("//div/h4[contains(text(),'Request Details')]"));
			if (requestDetails.isDisplayed()) {
				logger.info("Request Details Page opened successfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Request Details Page not opened");
		}

	}
	public void clickOnCloseButton() {
		//staticWait(1000);

		click(By.xpath("(//button[@type='button'])[last()]"), "Close Button", 25);

	}
	public void clickOnVendorRadioButton() {
		staticWait(1000);
		click(By.xpath("//label[contains(text(),'Vendor')]"), "Vendor Radio Button", 20);
		
	}
	public void clickOnNoShareYourLicenseRadioButton() {
		staticWait(1000);
		click(By.xpath("//label[@for='ShareYourLicenseMessage_1']"), "No Share Your License Radio Button", 20);
		
	}
	public void enterNumberOfResources() {
		//staticWait(1000);

		enter(By.xpath("//span/input[@id='ResourceText']"), "999", "Number Of Resources", 25);

	}
	public void clickOnViewButton() {
		//staticWait(1000);

		click(By.xpath("//a[@title='View']"), "View Button", 25);
		try {
			WebElement view = driver.findElement(By.xpath("//div/span[contains(text(),'Request Employee')]"));
			if (view.isDisplayed()) {
				logger.info("View Page opened successfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("View Page not opened");
		}

	}
	public void clickOnEditButton() {
		//staticWait(1000);

		click(By.xpath("//a[@title='Edit']"), "Edit Button", 25);
		

	}
	public void selectEditedLinkedCompanyName() {
		staticWait(3000);
		 editedlinkedCompany = prop.getProperty("editedlinkedcompany");
		selectValueWithText(By.xpath("//select[@name='Linkedcompany']"), "QA Infotech", "Edited Linked Company Name", 25);

	}
	public void selectService() {
		staticWait(1000);

		selectValueWithIndex(By.xpath("//select[@name='SelectService']"), 3, "Service", 25);

	}
	
}
