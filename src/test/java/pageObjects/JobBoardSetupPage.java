package pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.PropertiesLoader;
import utils.WebBasePage;

public class JobBoardSetupPage extends WebBasePage {
	WebDriver driver;
	String pattern = "yyMMddHHmmss";

	Date date = new Date();
	SimpleDateFormat dateformat = new SimpleDateFormat(pattern);

	String datevalue = dateformat.format(date);

	String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\testfiles\\";
	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";
	private static Properties prop = new PropertiesLoader(FILE_NAME).load();

	public JobBoardSetupPage(WebDriver driver) {

		super(driver, "JobBoardSetupPage");
		this.driver = driver;
	}

	public void clickFullMenuDropDown() {
		staticWait(5000);
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

	public void clickOnJobBoardSetup() {
		click(By.xpath("//a[contains(text(),'Job Board Setup')]"), "Job Board Setup", 30);
		staticWait(3000);
	}

	public void verifyLayoutPage() {
		staticWait(5000);

		try {
			WebElement designation = driver.findElement(By.xpath("//div/span[contains(text(),'Layout')]"));
			if (designation.isDisplayed()) {
				logger.info("Layout page opened successfully");

			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Layout page not opened");
		}

	}

	public void clickOnSaveButton() {
		scrollDown();
		staticWait(1000);
		clickByJavascript(By.xpath("//a[@data-original-title='Save']"), "Save Button", 30);

	}
	public void clickOnGeneralSaveButton() {
		scrollDown();
		staticWait(1000);
		clickByJavascript(By.xpath("(//a[@data-original-title='Save'])[2]"), "Save Button", 30);

	}

	public void captureNotifyMessage() {
		staticWait(2000);

		try {
			WebElement notifymessage = driver.findElement(
					By.xpath("//div/span[contains(text(),'Job Board Setup has been successfully saved')]"));
			if (notifymessage.isDisplayed()) {
				logger.info(notifymessage.getText());

			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Job Board Setup hasn't been successfully saved");
		}

	}

	public void clickOnGeneral() {
		staticWait(2000);
		click(By.xpath("(//div/ul/li/a[contains(text(),'General')])[last()]"), "General", 30);

	}

	public void verifyGeneralPage() {
		staticWait(5000);

		try {
			WebElement designation = driver.findElement(By.xpath("//div/span[contains(text(),'General')]"));
			if (designation.isDisplayed()) {
				logger.info("General page opened successfully");

			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("General page not opened");
		}

	}

	public void clickOnAppearance() {
		staticWait(2000);
		click(By.xpath("//div/ul/li/a[contains(text(),'Appearance')]"), "Appearance", 30);

	}

	public void verifyAppearancePage() {
		staticWait(5000);

		try {
			WebElement appearance = driver.findElement(By.xpath("//div/span[contains(text(),'Appearance')]"));
			if (appearance.isDisplayed()) {
				logger.info("Appearance page opened successfully");

			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Appearance page not opened");
		}

	}

	public void clickOnWebsiteAndSocial() {
		staticWait(2000);
		click(By.xpath("//div/ul/li/a[contains(text(),'Website & Social')]"), "Website & Social", 30);

	}

	public void verifyWebsiteAndSocialPage() {
		staticWait(5000);

		try {
			WebElement websiteAndSocial = driver
					.findElement(By.xpath("//div/span[contains(text(),'Website & Social')]"));
			if (websiteAndSocial.isDisplayed()) {
				logger.info("Website & Social page opened successfully");

			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Website & Social page not opened");
		}

	}

	public void clickOnDetailsRadioButton() {
		staticWait(2000);
		click(By.xpath("//label[contains(text(),'Details(Recommended)')]"), "Details Radio Button", 30);

	}

	public void clickOnSimpleRadioButton() {
		staticWait(2000);
		click(By.xpath("//label[contains(text(),'Simple')]"), "Simple Radio Button", 30);

	}

	public void clickOnManageContent() {
		staticWait(2000);
		click(By.xpath("//li/a[contains(text(),'Manage Content')]"), "Manage Content", 30);

	}

	public void verifyManageContent() {
		staticWait(5000);

		try {
			WebElement manageContent = driver.findElement(By.xpath("//div/span[contains(text(),'Managing Content')]"));
			if (manageContent.isDisplayed()) {
				logger.info("Managing Content page opened successfully");

			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Managing Content page not opened");
		}

	}

	public void enterHeader() {
		// staticWait(2000);
		enter(By.xpath("//div/input[@name='manage_content_header']"), "Enter Header name", "Header name", 30);

	}

	public void enterSubHeader() {
		// staticWait(2000);
		enter(By.xpath("//div/input[@name='manage_content_sub_header']"), "Enter SubHeader name", "Sub Header name",
				30);

	}

	public void enterDescription() {
		// staticWait(2000);
		switchToFrame();
		enter(By.xpath(
				"//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_theme_Colored cke_show_borders']"),
				"Description", "Description", 30);
		driver.switchTo().defaultContent();
	}

	public void selectLanguage() {
		// staticWait(2000);
		selectValueWithText(By.xpath("//span[contains(text(),'Language')]/parent::h5/../../descendant::div[2]/select"),
				"English", "Language", 30);

	}

	public void clickOnTestimonials() {
		staticWait(2000);
		click(By.xpath("//li/a[contains(text(),'Testimonials')]"), "Testimonials ", 30);

	}

	public void verifyTestimonials() {
		staticWait(5000);

		try {
			WebElement testimonials = driver.findElement(By.xpath("//div/span[contains(text(),'Testimonials')]"));
			if (testimonials.isDisplayed()) {
				logger.info("Testimonials page opened successfully");

			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Testimonials page not opened");
		}

	}

	public void enterEmployeeFullName() {
		// staticWait(2000);
		enter(By.xpath("//div/input[@name='empolyee_name']"), "Enter Employee Full name", "Employee Full name", 30);

	}

	public void enterJobTitle() {
		// staticWait(2000);
		enter(By.xpath("//div/input[@name='job_title']"), "Enter Job Title", "Job Title", 30);

	}

	public void enterComment() {
		// staticWait(2000);
		enter(By.xpath("//div/input[@name='testimonial_comment']"), " Enter testimonial comment", "Comment", 30);

	}

	public void uploadFile() throws AWTException {
		staticWait(1000);
		/*
		 * WebElement UploadImg = driver.findElement(By.xpath("//a[@type='file']"));
		 * UploadImg.sendKeys(
		 * "C:\\Users\\aanand\\eclipse-workspace\\Com.Talygen.Hiring.Automation\\src\\main\\resources\\testfiles\\cogniter-logo.png"
		 * );
		 */

		// file path passed as parameter to StringSelection
		StringSelection s = new StringSelection(
				"C:\\Users\\aanand\\eclipse-workspace\\Com.Talygen.Hiring.Automation\\src\\main\\resources\\testfiles\\cogniter-logo.png");
		// Clipboard copy
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
		// identify element and click
		staticWait(1000);
		driver.findElement(By.xpath("//a[@type='file']")).click();
		// Robot object creation
		staticWait(2000);
		Robot r = new Robot();
		// pressing enter
		r.keyPress(KeyEvent.VK_ENTER);
		// releasing enter
		r.keyRelease(KeyEvent.VK_ENTER);
		// pressing ctrl+v
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		// releasing ctrl+v
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		// pressing enter
		r.keyPress(KeyEvent.VK_ENTER);
		// releasing enter
		r.keyRelease(KeyEvent.VK_ENTER);

		logger.info("File Uploaded successfully");

	}

	public void clickOnAddTestimonials() {
		staticWait(2000);
		click(By.xpath("//a[contains(text(),'Add a Testimonials')]"), "Add a Testimonials ", 30);

	}

	public void clickOnEmployees() {
		staticWait(2000);
		click(By.xpath("//li/a[contains(text(),'Employees')]"), "Employees ", 30);

	}

	public void verifyEmployees() {
		staticWait(5000);

		try {
			WebElement employees = driver.findElement(By.xpath("//div/span[contains(text(),'Employees')]"));
			if (employees.isDisplayed()) {
				logger.info("Employees page opened successfully");

			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Employees page not opened");
		}

	}

	public void clickOnPhotosAndVideos() {
		staticWait(2000);
		click(By.xpath("//li/a[contains(text(),'Photos & Videos')]"), "Photos & Videos ", 30);

	}

	public void verifyPhotosAndVideos() {
		staticWait(5000);

		try {
			WebElement photosAndVideos = driver.findElement(By.xpath("//div/span[contains(text(),'Photos & Videos')]"));
			if (photosAndVideos.isDisplayed()) {
				logger.info("Photos & Videos page opened successfully");

			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Photos & Videos page not opened");
		}

	}

	public void clickOnContent() {
		staticWait(2000);
		click(By.xpath("//li/a[text()='Content']"), "Content", 30);

	}

	public void verifyContent() {
		staticWait(5000);

		try {
			WebElement content = driver.findElement(By.xpath("//div/span[contains(text(),'Conclusion Layout')]"));
			if (content.isDisplayed()) {
				logger.info("Content page opened successfully");

			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Content page not opened");
		}

	}
}
