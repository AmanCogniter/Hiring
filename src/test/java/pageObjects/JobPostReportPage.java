package pageObjects;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.PropertiesLoader;
import utils.WebBasePage;

public class JobPostReportPage extends WebBasePage{
	WebDriver driver;
	String pattern = "yyMMddHHmmss";

	Date date = new Date();
	SimpleDateFormat dateformat = new SimpleDateFormat(pattern);

	String datevalue = dateformat.format(date);
	
	

	String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\testfiles\\";
	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";
	private static Properties prop = new PropertiesLoader(FILE_NAME).load();

	public JobPostReportPage(WebDriver driver) {

		super(driver, "JobPostReportPage");
		this.driver = driver;
	}

	public void clickFullMenuDropDown() {
		staticWait(15000);
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

	public void clickOnJobPostReport() {
		click(By.xpath("//a[contains(text(),'Job Post Report')]"), "Job Post Report", 30);
		staticWait(3000);
	}
	public void selectDesignation() {
		click(By.xpath("//button[@title='Select']"), "Designation Dropdown", 30);
		click(By.xpath("//div/ul/li[@class='multiselect-item multiselect-all']"), "Designation ", 30);
		
	}
	public void clickOnSearchButton() {
		clickByJavascript(By.xpath("//div/a[@id='aSearch']"), "Search Button", 30);
		
		
	}
	public void verifyHiringReportWithDesignation() {
		staticWait(25000);
		scrollDown();
		switchToFrame();
		try {
			WebElement designation = driver.findElement(By.xpath("//div/div[contains(text(),'Designation Name')]"));
			if (designation.isDisplayed()) {
				logger.info("Hiring report with designation displayed successfully");
				driver.switchTo().defaultContent();
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Hiring report not displayed ");
		}
		
		
	}
	public void selectStatus() {
		click(By.xpath("(//button[@title='Select'])[2]"), "Status Dropdown", 30);
		click(By.xpath("(//div/ul/li[@class='multiselect-item multiselect-all'])[2]"), "Status ", 30);
		
	}
	public void verifyHiringReportWithStatus() {
		staticWait(25000);
		scrollDown();
		switchToFrame();
		try {
			WebElement designation = driver.findElement(By.xpath("//div/div[contains(text(),'Status Name')]"));
			if (designation.isDisplayed()) {
				logger.info("Hiring report with Status displayed successfully");
				driver.switchTo().defaultContent();
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Hiring report not displayed ");
		}
		
		
	}
	public void clickOnStatusRadioButton() {
		staticWait(5000);
		click(By.xpath("//div/input[@id='Status']"), "Status Radio Button", 30);
		
		
	}
	
}
