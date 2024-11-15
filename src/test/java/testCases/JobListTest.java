package testCases;

import static reporting.ComplexReportFactory.getTest;

import org.testng.annotations.Test;

import action.JobListAction;
import action.LoginAction;
import utils.WebTestBase;

public class JobListTest extends WebTestBase{
	static String Screenname ="<b> Hiring/b>";
	  
	@Test(priority=1)
	public void validationCheck()
	{
		test=getTest(Screenname + ": Validation message on Add Job");
		JobListAction jobListAction = new JobListAction(driver);
		new LoginAction(driver).logoutLogin();
		jobListAction.goToHiringTab();
		jobListAction.validationCheck();
	}
	@Test(priority=2)
	public void addJobList()
	{
		test=getTest(Screenname + ":  Add Job");
		JobListAction jobListAction = new JobListAction(driver);
		new LoginAction(driver).logoutLogin();
		jobListAction.goToHiringTab();
		jobListAction.addJob();
	}
	@Test(priority=3)
	public void ValidateJobOnListingPage()
	{
		test=getTest(Screenname + ":Validate Job On Listing Page");
		JobListAction jobListAction = new JobListAction(driver);
		new LoginAction(driver).logoutLogin();
		jobListAction.goToHiringTab();
		jobListAction.verifyJobOnListingPAge();
	}
	@Test(priority=4)
	public void ValidateUpDateFunctionalityOfJob()
	{
		test=getTest(Screenname + ":Validate Update functionality Of Job");
		JobListAction jobListAction = new JobListAction(driver);
		new LoginAction(driver).logoutLogin();
		jobListAction.goToHiringTab();
		jobListAction.verifyJobUpDateFunctionality();
	}
	@Test(priority=5)
	public void ValidateCloneFunctionalityOfJob()
	{
		test=getTest(Screenname + ":Validate Clone functionality Of Job");
		JobListAction jobListAction = new JobListAction(driver);
		new LoginAction(driver).logoutLogin();
		jobListAction.goToHiringTab();
		jobListAction.verifyCloneFunctionality();
	}
	@Test(priority=6)
	public void ValidateAddNewCandidateFunctionalityOfJob()
	{
		test=getTest(Screenname + ":Validate Add New candidate functionality Of Job");
		JobListAction jobListAction = new JobListAction(driver);
		new LoginAction(driver).logoutLogin();
		jobListAction.goToHiringTab();
		jobListAction.verifyAddNewCandidateFunctionality();
	}
	@Test(priority=7)
	public void ValidateEditFunctionalityOfView()
	{
		test=getTest(Screenname + ":Validate Edit functionality Of View");
		JobListAction jobListAction = new JobListAction(driver);
		new LoginAction(driver).logoutLogin();
		jobListAction.goToHiringTab();
		jobListAction.verifyJobUpDateFunctionalityOfView();
	}
	@Test(priority=8)
	public void ValidateAddNewCandidateFunctionalityOfView()
	{
		test=getTest(Screenname + ":Validate Add New candidate functionality Of View");
		JobListAction jobListAction = new JobListAction(driver);
		new LoginAction(driver).logoutLogin();
		jobListAction.goToHiringTab();
		jobListAction.verifyAddAsCandidateFunctionalityOfView();
	}
	@Test(priority=9)
	public void ValidateDeleteFunctionalityOfJob()
	{
		test=getTest(Screenname + ":Validate delete functionality Of Job");
		JobListAction jobListAction = new JobListAction(driver);
		new LoginAction(driver).logoutLogin();
		jobListAction.goToHiringTab();
		jobListAction.verifyJobDeleteFunctionality();
	}
}
