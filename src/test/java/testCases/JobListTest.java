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
}
