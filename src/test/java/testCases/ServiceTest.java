package testCases;

import static reporting.ComplexReportFactory.getTest;

import org.testng.annotations.Test;

import action.LoginAction;
import action.ServiceAction;
import utils.WebTestBase;

public class ServiceTest extends WebTestBase{
	static String Screenname ="<b> Hiring/b>";
	  
	@Test(priority=1)
	public void validationCheck()
	{
		test=getTest(Screenname + ": Validation message on Add Service");
		ServiceAction serviceAction = new ServiceAction(driver);
		new LoginAction(driver).logoutLogin();
		serviceAction.goToHiringTab();
		serviceAction.validationCheck();
	}
	@Test(priority=2)
	public void addService()
	{
		test=getTest(Screenname + ": Validate Add Service Functionality");
		ServiceAction serviceAction = new ServiceAction(driver);
		new LoginAction(driver).logoutLogin();
		serviceAction.goTOHiringTab();
		serviceAction.addService();
	}
	@Test(priority=3)
	public void ValidateServiceNameOnListingPage()
	{
		test=getTest(Screenname + ":Validate Service Name On Listing Page");
		ServiceAction serviceAction = new ServiceAction(driver);
		new LoginAction(driver).logoutLogin();
		serviceAction.goTOHiringTab();
		serviceAction.verifyServiceNameOnListingPAge();
	}
	@Test(priority=4)
	public void ValidateStatusFunctionalityOfService()
	{
		test=getTest(Screenname + ":Validate Status functionality Of Service");
		ServiceAction serviceAction = new ServiceAction(driver);
		new LoginAction(driver).logoutLogin();
		serviceAction.goTOHiringTab();
		serviceAction.verifyServiceStatusFunctionalityOnListingPAge();
	}
	
	@Test(priority=5)
	public void ValidateDeleteFunctionalityOfService()
	{
		test=getTest(Screenname + ":Validate delete functionality Of Service");
		ServiceAction serviceAction = new ServiceAction(driver);
		new LoginAction(driver).logoutLogin();
		serviceAction.goTOHiringTab();
		serviceAction.verifyServiceDeleteFunctionality();
	}
	@Test(priority=6)
	public void ValidateAssignServiceFunctionalityOfService()
	{
		test=getTest(Screenname + ":Validate Assign Service functionality Of Service");
		ServiceAction serviceAction = new ServiceAction(driver);
		new LoginAction(driver).logoutLogin();
		serviceAction.goTOHiringTab();
		serviceAction.verifyServiceAssignFunctionalityOnListingPAge();
	}

	@Test(priority=7)
	public void ValidateDeleteFunctionalityOfAssignService()
	{
		test=getTest(Screenname + ":Validate delete functionality Of Assign Service");
		ServiceAction serviceAction = new ServiceAction(driver);
		new LoginAction(driver).logoutLogin();
		serviceAction.goTOHiringTab();
		serviceAction.verifyServiceDeleteFunctionality();
	}
	
}
