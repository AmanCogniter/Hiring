package utils;

import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.Log;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import static reporting.ComplexReportFactory.getTest;

public class WebBasePage extends WaitStatement {

    private WebDriver driver;
    public static Logger logger;
    private String pageName;
    
  

    public WebBasePage(WebDriver driver, String pageName) {
        super(driver);
        this.driver = driver;
        this.pageName = pageName;
        logger = Logger.getLogger(pageName);
    }

    public void open(String url) {

        driver.get(url);
        getTest().log(LogStatus.PASS, "Url opened - " + url);
    }

    public List<WebElement> findMultipleElement(By by, int time) {
        List<WebElement> elements = new ArrayList<>();
        try {
            staticWait(2000);
            WebElement element = findElementVisibility(by, time);
            waitForVisibilityOfElement(by, time);
            elements = driver.findElements(by);
            return elements;
        } catch (Exception e) {
            getTest().log(LogStatus.FAIL, "Element not found : " + by + ". Error occurred. " + e);
            logger.info("Element not found : " + by + ". Error occurred. " + e);
            takeScreenshot(new Object() {
            }.getClass().getEnclosingMethod().getName());
            Assert.fail("" + e);
            return elements;
        }
    }

    public void waitForLoader(int time) {
        try {
            waitForElementInVisibility(By.cssSelector(".lds-ring"), time);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enter(By by, String value, String name, int time) {
        try {
            WebElement element = findElementVisibility(by, time);
            staticWait(200);
            element.clear();
            element.sendKeys(value);
            getTest().log(LogStatus.PASS, name + " entered with value - " + value);
            logger.info(name + " entered with value - " + value);
        } catch (Exception e) {
            getTest().log(LogStatus.FAIL, pageName + name + " not entered with value - " + value + ", error exist - " + e);
            logger.info(name + " not entered with value - " + value + ", error exist - " + e);
            takeScreenshot(new Object() {
            }.getClass().getEnclosingMethod().getName());
            Assert.fail("" + e);
        }
    }
    
    
    public void clear(By by, String name , int time)

    {
    	try {
    		WebElement element = findElementVisibility(by, time);
    		 staticWait(200);
             element.clear();
             getTest().log(LogStatus.PASS,"Cleared the value entered in the field");
             logger.info("Cleared the value entered in the field");
    	}
    	catch(Exception e)
    	{
    		getTest().log(LogStatus.FAIL, " Did not Cleared the value which was entered in the field");
            logger.info("Did not Cleared the value which was entered in the field");
            takeScreenshot(new Object() {
            }.getClass().getEnclosingMethod().getName());
            Assert.fail("" + e);
    	}
    }
    public void click(By by, String name, int time) {

        WebElement element = findElementVisibility(by, time);
        staticWait(200);
        if (element != null) {
            try {
                element.click();
                getTest().log(LogStatus.PASS, name + " clicked");
                logger.info(name + " clicked ");
            } catch (Exception e) {
                getTest().log(LogStatus.FAIL, pageName + name + " not clicked ");
                logger.info(name + " not clicked");
                takeScreenshot(new Object() {
                }.getClass().getEnclosingMethod().getName());
                Assert.fail(name + " -  element not clickable");
            }
        } else {
            getTest().log(LogStatus.FAIL, pageName + name + " not clicked ");
            logger.info(name + " not clicked");
            takeScreenshot(new Object() {
            }.getClass().getEnclosingMethod().getName());
            Assert.fail(name + " -  element not present");
        }

    }

    public void selectValueWithIndex(By by, int count, String name, int time) {
        try {
            WebElement element = findElementVisibility(by, time);
            boolean elementEnabled = findElementVisibility(by, time).isEnabled();
            Select se = new Select(element);
            se.selectByIndex(count);
            getTest().log(LogStatus.PASS, name + " selected with index - " + count);
            logger.info(name + " selected with value - " + count);
        } catch (Exception e) {
            getTest().log(LogStatus.FAIL, name + " not selected with index - " + count + " and Error occurred. " + e);
            logger.info(name + " not selected with value - " + count + " and Error occurred. " + e);
            takeScreenshot(new Object() {
            }.getClass().getEnclosingMethod().getName());
            Assert.fail("" + e);
        }
    }

    public void selectValueWithValue(By by, String string, String name, int time) {
        try {
            WebElement element = findElementVisibility(by, time);
            Select se = new Select(element);
            se.selectByValue(string);
            getTest().log(LogStatus.PASS, name + " selected with value - " + string);
            logger.info(name + " selected with value - " + string);
        } catch (Exception e) {
            getTest().log(LogStatus.FAIL, name + " not selected with value - " + string + ". And Error Occurred. " + e);
            logger.info(name + " not selected with value - " + string + ". And Error Occurred. " + e);
            takeScreenshot(new Object() {
            }.getClass().getEnclosingMethod().getName());
            Assert.fail("" + e);
        }
    }

    public void selectValueWithText(By by, String value, String name, int time) {
        try {
            staticWait(200);
            WebElement element = findElementVisibility(by, time);
            Select se = new Select(element);
            se.selectByVisibleText(value);
            getTest().log(LogStatus.PASS, name + " selected with value - " + value);
            logger.info(name + " selected with value - " + value);
        } catch (Exception e) {
            getTest().log(LogStatus.FAIL, name + " not selected with value - " + value + ". And Error Occurred. " + e);
            logger.info(name + " not selected with value - " + value + ". And Error Occurred. " + e);
            takeScreenshot(new Object() {
            }.getClass().getEnclosingMethod().getName());
            Assert.fail("" + e);
        }
    }
    
    public void  verifySelectedValue(By by,String name,String categoryStatus ,int time)
    {
    	String selectedValue  =" ";
    	try {
    		staticWait(200);
            WebElement element = findElementVisibility(by, time);
            Select  select = new Select(element);
             selectedValue=  select.getFirstSelectedOption().getText();
             if (selectedValue.equals(categoryStatus))
             {
            	 getTest().log(LogStatus.PASS, name + " selected with value - " + selectedValue);
                 logger.info(name + " selected with value - " + selectedValue);	
                // System.out.println(name + " selected with value - " + selectedValue);
             }
             else
             {
            	 getTest().log(LogStatus.FAIL, name + " not selected with value - " + selectedValue + ". And Error Occurred. " );
                 logger.info(name + " not selected with value - " + selectedValue + ". And Error Occurred. " );
                 takeScreenshot(new Object() {
                 }.getClass().getEnclosingMethod().getName());
             }
            
          
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    	}
    	
    }
    

    public void scrollDown() {
        try {
            staticWait(2000);
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            getTest().log(LogStatus.PASS,"Page scroll down");
            logger.info("Page scroll down");
            staticWait(2000);
        } catch (Exception e) {
            getTest().log(LogStatus.FAIL, "Error Occurred " + e);
            logger.info("Error Occurred " + e);
            takeScreenshot(new Object() {
            }.getClass().getEnclosingMethod().getName());
            Assert.fail("" + e);
        }
    }

    public void staticWait(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void scrollToWebelement(By by, String name) {
        try {
            staticWait(500);
            WebElement element = findElementPresence(by, 20);
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].scrollIntoView();", element);
            getTest().log(LogStatus.PASS, "Scroll to this element - " + name);
            logger.info("Scroll to this element - " + name);
            staticWait(500);
        } catch (Exception e) {
            getTest().log(LogStatus.FAIL, "Error occurred. " + e);
            logger.info("Error occurred. " + e);
            takeScreenshot(new Object() {
            }.getClass().getEnclosingMethod().getName());
            Assert.fail("" + e);
        }
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public void clickByJavascript(By by, String name, int time) {

        try {
            staticWait(2000);
            WebElement element = findElementPresence(by, time);
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);
            getTest().log(LogStatus.PASS, name + " click by JS");
            logger.info(name + " click by JS");
        } catch (Exception e) {
            getTest().log(LogStatus.FAIL, "Error Occurred. " + e);
            logger.info("Error Occurred. " + e);
            takeScreenshot("NotClickByJS");
            Assert.fail("" + e);
        }

    }


    public String getText(By by, int time) {
        try {
            WebElement ele = findElementVisibility(by, time);
            String getText = ele.getText();
            logger.info(" Text displayed is  - " + getText);
            return getText;
        } catch (Exception e) {
            getTest().log(LogStatus.FAIL, "Error Occured. " + e);
            logger.info("Error Occured. " + e);
            Assert.fail("" + e);
            return null;
        }
    }

    public String getAtribute(By by, String tag, int time) {
        try {
            WebElement ele = findElementVisibility(by, time);
            String getText;
            getText = ele.getAttribute(tag);
            logger.info(" get attribute value is  - " + getText);
            return getText;
        } catch (Exception e) {
            getTest().log(LogStatus.FAIL, "Error Occurred. " + e);
            logger.info("Error Occurred. " + e);
            Assert.fail("" + e);
            return null;
        }
    }

    public void waitForLoad(int timeoutSec) {
        try {
            new WebDriverWait(driver, timeoutSec).until((ExpectedCondition<Boolean>) wd ->
                    ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void scrollUpDown(String scroll) {
        Actions actions = new Actions(driver);
        try {
            if (scroll.equalsIgnoreCase("down")) {
                actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
            } else if (scroll.equalsIgnoreCase("up")) {
                actions.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();
            }
        } catch (Exception e) {
            e.printStackTrace();
            takeScreenshot("ScrollUpDown");
            Assert.fail("" + e);
        }
    }
    public void switchToFrame() {
		WebElement iframe = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(iframe);
	}

    public boolean switchToTab(int tabPosition) {
        boolean tabFound = false;
        Set<String> allWindowHandles = driver.getWindowHandles();
        ArrayList<String> tabs = new ArrayList<String>(allWindowHandles);
        if (tabs.size() > 0) {
            try {
                driver.switchTo().window(tabs.get(tabPosition));
            } catch (Exception e) {
                getTest().log(LogStatus.FAIL, "Error in opening new tab");
                takeScreenshot("ErrorInOpenWindow");
                return false;
            }
            tabFound = true;
        }
        if (!tabFound) {
            getTest().log(LogStatus.FAIL, " There are no new tabs");
            takeScreenshot(new Object() {
            }.getClass().getEnclosingMethod().getName());
        }

        return tabFound;

    }

    public void closeCurrentTab(int currentTabIndex) {
        try {
            Set<String> allWindowHandles = driver.getWindowHandles();
            ArrayList<String> tabs = new ArrayList<String>(allWindowHandles);
            driver.switchTo().window(tabs.get(currentTabIndex));
            driver.close();
        } catch (Exception e) {
            getTest().log(LogStatus.FAIL, "Not able to close current tab");
            logger.info("Not able to close  current tab");
            takeScreenshot(new Object() {
            }.getClass().getEnclosingMethod().getName());
            Assert.fail("Not able to close current tab");
        }
    }

    public void switchToParentTab() {
        try {
            Set<String> allWindowHandles = driver.getWindowHandles();
            ArrayList<String> tabs = new ArrayList<String>(allWindowHandles);
            driver.switchTo().window(tabs.get(0));
        } catch (Exception e) {
            getTest().log(LogStatus.FAIL, "Not able to switch to parent tab");
            logger.info("Not able to switch to parent tab");
            takeScreenshot(new Object() {
            }.getClass().getEnclosingMethod().getName());
            Assert.fail("Not able to switch to parent tab");
        }
    }

    public void takeScreenshot(String name) {
        String imagePath = System.getProperty("user.dir") + "\\reports\\" + name + "_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            org.apache.commons.io.FileUtils.copyFile(scrFile, new File(imagePath + ".png"));
            System.out.println(imagePath + ".png");
        } catch (Exception e) {
            Assert.fail("Error while taking screenshot - " + e);
        }
        getTest().log(LogStatus.INFO, getTest().addScreenCapture(imagePath + ".png"));
    }

    public int countNumberOfFilesInFolder(String path) {
        try {
            return Objects.requireNonNull(new File(path).list()).length;
        }
        catch (NullPointerException e)
        {
            getTest().log(LogStatus.FAIL,"File directory not found. "+path);
            logger.info("File directory not found. "+path);
            takeScreenshot("DirectoryNotFound");
            Assert.fail("" + e);
            return 0;
        }
    }

    public void waitTillNewFile(String path, int previousFileCount) {
        try {
            staticWait(5000);
            int timeCount = 1;
            for (timeCount = 1; timeCount < 80; timeCount++) {
                if (countNumberOfFilesInFolder(path) > previousFileCount) {
                    getTest().log(LogStatus.PASS, "PDF downloaded...");
                    break;
                }
                staticWait(500);
                System.out.println("countNumberOfFilesInFolder(path) - " + countNumberOfFilesInFolder(path) + " previousFileCount - " + previousFileCount);
                logger.info("countNumberOfFilesInFolder(path) - " + countNumberOfFilesInFolder(path) + " previousFileCount - " + previousFileCount);
            }
        } catch (Exception e) {
            takeScreenshot("WaitTillNewFile");
            Assert.fail("" + e);
        }

    }

    public void uploadDoc(By by, String value, String name, int time) {
        try {
            WebElement element = findElementVisibility(by, time);
            staticWait(500);
            element.sendKeys(value);
            getTest().log(LogStatus.PASS, name + " uploaded with value - " + value);
            logger.info(name + " uploaded with value - " + value);
        } catch (Exception e) {
            getTest().log(LogStatus.FAIL, "Error occurred. " + e);
            logger.info("Error occurred. " + e);
            takeScreenshot(new Object() {
            }.getClass().getEnclosingMethod().getName());
            Assert.fail("" + e);
        }
    }

    public void clickMultipleTimes(By by, String name, int time) {

        WebElement element = findElementVisibility(by, time);
        staticWait(200);
        if (element != null) {
            if (multipleClick(element, time)) {
                getTest().log(LogStatus.PASS, name + " clicked");
                logger.info(name + " clicked ");
            } else {
                getTest().log(LogStatus.FAIL, pageName + name + " not clicked ");
                logger.info(name + " not clicked");
                takeScreenshot(new Object() {
                }.getClass().getEnclosingMethod().getName());
                Assert.fail(name + " -  element not clickable");
            }

        } else {
            getTest().log(LogStatus.FAIL, pageName + name + " not clicked ");
            logger.info(name + " not clicked");
            takeScreenshot(new Object() {
            }.getClass().getEnclosingMethod().getName());
            Assert.fail(name + " -  element not present");
        }

    }
    
     public void  isDisplayed(By by, String name, int time)
     {
    	 try {
    	 WebElement element = findElementClickable(by, time);
         staticWait(200);
        	 getTest().log(LogStatus.PASS , name + "Displayed");
        	 logger.info(name + "Displayed");
         }
         catch(Exception e)
         {
        	 getTest().log(LogStatus.FAIL, pageName+ name+ "not displayed");
        	 logger.info(name + " not displayed");
             takeScreenshot(new Object() {
             }.getClass().getEnclosingMethod().getName());
             Assert.fail(name + " -  element not displayed");
         }
    
     }
     
     public void  isNotDisplayed(By by, String name, int time)
     {
    	 WebElement element = findElementVisibility(by, time);
         staticWait(200);
         if (element.isDisplayed())
         {
        	 getTest().log(LogStatus.PASS , name + "not Displayed");
        	 logger.info(name + "not Displayed");
         }
         else
         {
        	 getTest().log(LogStatus.FAIL, pageName+ name+ "displayed");
        	 logger.info(name + "displayed");
             takeScreenshot(new Object() {
             }.getClass().getEnclosingMethod().getName());
             Assert.fail(name + " -  element displayed");
         }
    
     }
     
     

    public boolean multipleClick(WebElement element, int count) {
        for (int cl = 1; cl <= count; cl++) {
            try {
                staticWait(300);
                element.click();
                return true;
            } catch (StaleElementReferenceException e) {

            }
        }
        return false;
    }
    
    public void verifySearchRecord(By by, String actualrecord , String name, int time )
    {
    	driver.navigate().refresh();
    	try
    	{
    	WebElement element = findElementVisibility(by, time);
        staticWait(4000);
        String searchedRecord= element.getText().trim();
        
        if (searchedRecord.equalsIgnoreCase(actualrecord))
        {
        	getTest().log(LogStatus.PASS,"Search record for "+name +" is displayed as expected");
			logger.info("Search record for "+name +" is displayed as expected");
    	}
    	else
    	{
    		getTest().log(LogStatus.FAIL, "Search record for "+name +" is not displayed as expected");
			logger.info("Search record for "+name +" is not displayed as expected");
			Assert.fail("verifySearchRecord");
			takeScreenshot(name);
    	}
    	}
    	catch (Exception e) {
			logger.error("Exception from Verify search record Method " + e);
			
		}
    	
    }
    
    public void verifyValidationMessage(By by ,String expectedMessage , int time)
    {
    	try {
    		
    	WebElement element = findElementVisibility(by, time);
        staticWait(200);
        String actualmessage= element.getText().trim();
        if (actualmessage.equalsIgnoreCase(expectedMessage))
        {
        	getTest().log(LogStatus.PASS,"Validation Message is displayed as expected");
			logger.info("Validation Message is displayed as expected");
    	}
    	else
    	{
    		getTest().log(LogStatus.FAIL, "Validation Message is not displayed as expected");
			logger.info("Validation Message is displayed as expected");
			Assert.fail("verifyValidationMessage");
			takeScreenshot("verifyValidationMessage");
    	}
    	}
    	catch (Exception e) {
			logger.error("Exception from Verify validation messaage Method " + e);
			
		}  
    }
    
    public void verifySuccessMessage(By by ,String expectedMessage , int time)
    {
    	try {
    		
    	WebElement element = findElementVisibility(by, time);
        staticWait(200);
        String actualmessage= element.getText().trim();
        if (actualmessage.equalsIgnoreCase(expectedMessage))
        {
        	getTest().log(LogStatus.PASS,"Success Message is displayed as expected");
			logger.info("Success Message is displayed as expected");
    	}
    	else
    	{
    		getTest().log(LogStatus.FAIL, "Success Message is not displayed as expected");
			logger.info("Success Message is displayed as expected");
			Assert.fail("verifySuccessMessage");
			takeScreenshot("verifySuccessMessage");
    	}
    	}
    	catch (Exception e) {
			logger.error("Exception from Verify Success messaage Method " + e);
			
		}  
    }
    
    
    
    public boolean isAttribtuePresent(WebElement element, String attribute) {
        Boolean result = false;
        try {
            String value = element.getAttribute(attribute);
            if (value != null){
                result = true;
            }
        } catch (Exception e) {}

        return result;
    } 
    
    
    
    
   
   
    
    

}

