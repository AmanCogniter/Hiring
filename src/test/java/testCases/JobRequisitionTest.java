package testCases;

import static reporting.ComplexReportFactory.getTest;

import org.testng.annotations.Test;

import action.JobRequisitionAction;
import action.LoginAction;
import utils.WebTestBase;

public class JobRequisitionTest extends WebTestBase{
	static String Screenname ="<b> Hiring/b>";
	  
	@Test(priority=1)
	public void validationCheck()
	{
		test=getTest(Screenname + ": Validation message on Add Group");
		JobRequisitionAction jobRequisitionAction = new JobRequisitionAction(driver);
		new LoginAction(driver).logoutLogin();
		jobRequisitionAction.goToHiringTab();
		jobRequisitionAction.validationCheck();
	}
	@Test(priority=2)
	public void addJobRequisition()
	{
		test=getTest(Screenname + ": Add Job requisition ");
		JobRequisitionAction jobRequisitionAction = new JobRequisitionAction(driver);
		new LoginAction(driver).logoutLogin();
		jobRequisitionAction.goToHiringTab();
		jobRequisitionAction.addjobRequisition();
	}
	@Test(priority=3,dependsOnMethods = {"addJobRequisition"})
	public void validateGroupNAmeOnListingPAge()
	{
		test=getTest(Screenname + ":Validate Job Requisition on listing page");
		JobRequisitionAction jobRequisitionAction = new JobRequisitionAction(driver);
		new LoginAction(driver).logoutLogin();
		jobRequisitionAction.goToHiringTab();
		jobRequisitionAction.verifyJobRequisitionOnListingPage();
	}
	@Test(priority=4,dependsOnMethods = {"addJobRequisition"})
	public void validateViewButtonFunctionality()
	{
		test=getTest(Screenname + ":Validate View Button Functionality");
		JobRequisitionAction jobRequisitionAction = new JobRequisitionAction(driver);

		new LoginAction(driver).logoutLogin();
		jobRequisitionAction.goToHiringTab();
		jobRequisitionAction.verifyViewButtonFunctionality();
	}
	@Test(priority=5,dependsOnMethods = {"addJobRequisition"})
	public void validateEditButtonFunctionality()
	{
		test=getTest(Screenname + ":Validate Edit Button Functionality");
		JobRequisitionAction jobRequisitionAction = new JobRequisitionAction(driver);

		new LoginAction(driver).logoutLogin();
		jobRequisitionAction.goToHiringTab();
		jobRequisitionAction.verifyEditButtonFunctionality();
	}
	@Test(priority=6,dependsOnMethods = {"addJobRequisition"})
	public void validateDeleteButtonFunctionality()
	{
		test=getTest(Screenname + ":Validate Delete Button Functionality");
		JobRequisitionAction jobRequisitionAction = new JobRequisitionAction(driver);

		new LoginAction(driver).logoutLogin();
		jobRequisitionAction.goToHiringTab();
		jobRequisitionAction.verifyDeleteButtonFunctionality();
	}
	@Test(priority=7)
	public void addJobRequisitionForRejectFunctionality()
	{
		test=getTest(Screenname + ": Add Job requisition For Reject Functionality");
		JobRequisitionAction jobRequisitionAction = new JobRequisitionAction(driver);
		new LoginAction(driver).logoutLogin();
		jobRequisitionAction.goToHiringTab();
		jobRequisitionAction.addjobRequisitionForRejectFunctionality();
	}
	@Test(priority=8)
	public void validateRejectButtonFunctionality()
	{
		test=getTest(Screenname + ":Validate Reject Button Functionality");
		JobRequisitionAction jobRequisitionAction = new JobRequisitionAction(driver);

		new LoginAction(driver).logoutLogin();
		jobRequisitionAction.goToHiringTab();
		jobRequisitionAction.verifyJobRequisitionOnListingPageForRejectFunctionality();
		jobRequisitionAction.verifyRejectButtonFunctionality();
	}
	@Test(priority=9,dependsOnMethods = {"addJobRequisition"})
	public void validateDeleteButtonFunctionalityOfRejectedRequisition()
	{
		test=getTest(Screenname + ":Validate Delete Button Functionality Of Rejected Requisition");
		JobRequisitionAction jobRequisitionAction = new JobRequisitionAction(driver);

		new LoginAction(driver).logoutLogin();
		jobRequisitionAction.goToHiringTab();
		jobRequisitionAction.verifyDeleteButtonFunctionalityOfRejectedRequisition();
	}
	
}
