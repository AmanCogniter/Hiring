package pageObjects;

import static reporting.ComplexReportFactory.getTest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
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

public class StagePage extends WebBasePage {
	WebDriver driver;
	String pattern = "yyMMddHHmmss";
	String patterns = "MM/dd/yyyy";

	Date date = new Date();
	SimpleDateFormat dateformat = new SimpleDateFormat(pattern);
	SimpleDateFormat dateformats = new SimpleDateFormat(patterns);
	String datevalue = dateformat.format(date);
	String datevalues = dateformats.format(date);

	static String stagename;
	static String status;
	String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\testfiles\\";
	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";
	private static Properties prop = new PropertiesLoader(FILE_NAME).load();

	public StagePage(WebDriver driver) {

		super(driver, "StagePage");
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

	public void clickOnStage() {
		staticWait(3000);

		// TODO: handle exception
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Locating element by link text and store in variable "Element"
		//WebElement Element = driver.findElement(By.xpath("//a[@data-original-title='Offboard Employee List']"));
		 WebElement Element =
		 driver.findElement(By.xpath("//ul[@data-p-name='Hiring']/div//li/a[@data-original-title='Stage']"));
		js.executeScript("arguments[0].scrollIntoView();", Element);
		staticWait(1000);

		click(By.xpath("//ul[@data-p-name='Hiring']/div//li/a[@data-original-title='Stage']"), "Stage", 30);
		staticWait(3000);

	}

	public void clickonStage() {
		staticWait(1000);

		/*
		 * // TODO: handle exception JavascriptExecutor js = (JavascriptExecutor)
		 * driver;
		 * 
		 * // Locating element by link text and store in variable "Element" WebElement
		 * Element = driver.findElement(By.
		 * xpath("//a[@data-original-title='Offboard Employee List']"));
		 * js.executeScript("arguments[0].scrollIntoView();", Element);
		 * staticWait(1000);
		 */
		click(By.xpath("//ul[@data-p-name='Hiring']/li/a[contains(text(),'Stage')]"), "Stage", 30);
		staticWait(3000);

	}

	public void clickOnAddStage() {
		clickByJavascript(By.xpath("//a[@title='Add']"), "Add Stage", 20);
		staticWait(2000);
	}

	public void save() {

		staticWait(1000);
		/*
		 * WebElement savebutton =
		 * driver.findElement(By.xpath("//button[contains(text(),'Save')]")); Actions
		 * action = new Actions(driver);
		 * action.moveToElement(savebutton).click().perform();
		 * Reporter.log("save button Clicked", true);
		 */
		click(By.xpath("//button[contains(text(),'Save')]"), "Save Button", 20);
		// waitForLoad(20);
	}

	public void VerifyMandatoryFieldValidation() {
		int i = 0;
		String actualText;
		String expectedText;

		List<WebElement> errorMessageLocator = findMultipleElement(
				By.xpath("//span[contains(@class,'invalid-feedback')]"), 45);
		String[] expectedValue = { "Stage", "Phase Name", "Type", "Description", "Status" };
		for (Object expected : expectedValue) {

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

	public void clickOnUserGuide() {
		clickByJavascript(By.xpath("//span/a[contains(text(),'User Guide')]"), "User Guide", 20);
		staticWait(2000);
		try {
			String userGuide = driver.findElement(By.xpath("//div[@id='scrollbarreplyuserguideMangeView']/div"))
					.getText();
			if (userGuide.contains(prop.getProperty("stageUserGuide"))) {
				logger.info("User Guide opened succcessfully");
				staticWait(1000);
				clickByJavascript(By.xpath("//span/a[contains(text(),'User Guide')]"), "Close User Guide", 20);
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("User Guide not opened");
		}
	}

	public void enterStageName() {
		staticWait(1000);
		stagename = prop.getProperty("stagename") + datevalue;

		enter(By.xpath("//span/input[@id='stage_name']"), stagename, "Stage Name", 25);

	}

	public void selectPhaseName() {
		staticWait(1000);

		selectValueWithIndex(By.xpath("//select[@name='phase_id']"), 1, "Phase Name", 25);

	}

	public void selectType() {
		staticWait(1000);

		selectValueWithIndex(By.xpath("//select[@name='stage_type']"), 1, "Type", 25);

	}

	public void enterDescription() {
		staticWait(1000);

		enter(By.xpath("//span/textarea[@placeholder='Enter Description']"), "Enter Description", "Description", 25);

	}

	public void selectStatus() {
		staticWait(1000);
		 status = prop.getProperty("status");

		selectValueWithText(By.xpath("//select[@name='status_id']"), status, "Status", 25);

	}

	public void captureNotifyMessage() {
		try {
			staticWait(2000);
			WebElement notifymessage = driver
					.findElement(By.xpath("//div/span[contains(text(),'Stage has been successfully added')]"));
			if (notifymessage.isDisplayed()) {
				logger.info(notifymessage.getText());
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Stage hasn't been successfully added");
		}
	}

	public void enterStageNameIntoSearchField() {
		staticWait(1000);

		enter(By.xpath("(//div/input[contains(@placeholder,'Search')])[last()]"), stagename, "Stage Name", 25);

	}

	public void clickOnSearchButton() {
		staticWait(1000);

		clickByJavascript(By.xpath("//a[@id='Go']"), "Search Button", 25);

	}

	public void verifyStageNameOnListingPage() {
		try {
			staticWait(2000);
			WebElement stageName = driver.findElement(By.xpath("//span/a[contains(text(),'" + stagename + "')]"));
			if (stageName.isDisplayed()) {
				logger.info("Stage name Displayed successfully on listing page");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Stage Name not Displayed on listing page");
		}
	}

	public void clickOnStageName() {
		staticWait(1000);

		click(By.xpath("//span/a[contains(text(),'" + stagename + "')]"), "Satge Name", 25);

	}
	public void captureUpdateNotifyMessage() {
		try {
			staticWait(2000);
			WebElement notifymessage = driver
					.findElement(By.xpath("//div/span[contains(text(),'Stage has been successfully updated')]"));
			if (notifymessage.isDisplayed()) {
				logger.info(notifymessage.getText());
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Stage hasn't been successfully updated");
		}
	}
	public void clickOnCheckBox() {
		staticWait(1000);

		click(By.xpath("(//div[@class='custom-control custom-checkbox custom-control-inline'])[2]"), "Check Box", 25);

	}
	public void clickOnInActiveStatus() {
		//staticWait(1000);

		click(By.xpath("//a[@title='Inactive']"), "Inactive Status Button", 25);

	}
	public void clickOnActiveStatus() {
		//staticWait(1000);

		click(By.xpath("//a[@title='Active']"), "Active Status Button", 25);

	}
	public void clickOnConfirmationButton() {
		//staticWait(1000);

		click(By.xpath("//button[@title='OK']"), "OK Button", 25);

	}
	public void clickOnDeleteButton() {
		//staticWait(1000);

		click(By.xpath("//a[@title='Delete']"), "Delete Button", 25);

	}
	public void captureDeleteNotifyMessage() {
		try {
			staticWait(2000);
			WebElement notifymessage = driver
					.findElement(By.xpath("//div/span[contains(text(),'Stage has been successfully deleted')]"));
			if (notifymessage.isDisplayed()) {
				logger.info(notifymessage.getText());
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Stage hasn't been successfully deleted");
		}
	}
	public void selectStatusFromDropDown() {
		//staticWait(1000);

		selectValueWithText(By.xpath("//select[@id='crmlistingStatus_span']"), status, "Status", 25);

	}
	public void selectInActiveStatusFromDropDown() {
		//staticWait(1000);

		selectValueWithText(By.xpath("//select[@id='crmlistingStatus_span']"), "Inactive", "Status", 25);

	}
	public void stageAscending() {
        titleSorting("ascending");
    }

    public void stageDescending() {
        titleSorting("descending");
    }
 public void titleSorting(String order) {
        List<String> actualSortedArray = new ArrayList<>();

        click(By.xpath("//table/thead/tr/th[@id='stage_name']"), "Stage", 20);

        List<WebElement> stageocators = findMultipleElement(By.xpath("//table[contains(@id,'tablelistingdata')]/tbody/tr/td[2]/span/a[contains(@class,'router-link-active')]"), 30);
        for (WebElement stageName : stageocators) {
            actualSortedArray.add(stageName.getText().trim());
        }

        if (order.equalsIgnoreCase("ascending")) {
            verifyAscendingOrder(actualSortedArray, "stageName");
        } else if (order.equalsIgnoreCase("descending")) {
            verifyDescendingOrder(actualSortedArray, "stageName");
        }
    }
 public void verifyAscendingOrder(List<String> actualSortedArray, String fieldName) {
     List<String> result = new ArrayList<>();
     List<String> expectedSortedList = new ArrayList<>(actualSortedArray);
     expectedSortedList.sort(String.CASE_INSENSITIVE_ORDER);
     for(int i =0; i<expectedSortedList.size();i++)
     {
         if (expectedSortedList.get(i).equalsIgnoreCase(actualSortedArray.get(i)))
         {
             result.add("true");
         }
         else
         {
             result.add("false");
         }
     }
     if (!result.contains("false")) {
         getTest().log(LogStatus.PASS, fieldName + "s are sorted in ascending Order when click the " + fieldName + " header for one time");
         logger.info(fieldName + "s are sorted in ascending Order when click the " + fieldName + " header for one time");
     } else {
         getTest().log(LogStatus.FAIL, fieldName + "s are not sorted in ascending Order when click the " + fieldName + " header for one time");
         logger.info(fieldName + "s are not sorted in ascending Order when click the " + fieldName + " header for one time");
         takeScreenshot(fieldName + "Ascending");
     }
 }
public void verifyDescendingOrder(List<String> actualSortedArray, String fieldName) {
     List<String> result = new ArrayList<>();
     List<String> expectedSortedList = new ArrayList<>(actualSortedArray);
     expectedSortedList.sort(String.CASE_INSENSITIVE_ORDER);
     Collections.reverse(expectedSortedList);
     for(int i =0; i<expectedSortedList.size();i++)
     {
         if (expectedSortedList.get(i).equalsIgnoreCase(actualSortedArray.get(i)))
         {
             result.add("true");
         }
         else
         {
             result.add("false");
         }
     }
     if (!result.contains("false")) {
         getTest().log(LogStatus.PASS, fieldName + "s are sorted in descending Order when click the " + fieldName + " header for two times");
         logger.info(fieldName + "s are sorted in descending Order when click the " + fieldName + " header for two times");
     } else {
         getTest().log(LogStatus.FAIL, fieldName + "s are not sorted in descending Order when click the " + fieldName + " header for two times");
         logger.info(fieldName + "s are not sorted in descending Order when click the " + fieldName + " header for two times");
         takeScreenshot(fieldName + "Descending");
     }
 }
	
	

}
