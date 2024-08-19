package testCases;

import static reporting.ComplexReportFactory.getTest;

import org.testng.annotations.Test;

import action.JobPostReportAction;
import action.LoginAction;
import utils.WebTestBase;

public class JobPostReportTest extends WebTestBase{
	static String Screenname ="<b> Hiring/b>";
	@Test(priority=1)
	public void validateHiringReportWithDesignation()
	{
		test=getTest(Screenname + ": Validate Hiring Report With Designation");
		JobPostReportAction jobPostReportAction = new JobPostReportAction(driver);
		new LoginAction(driver).logoutLogin();
		jobPostReportAction.goToHiringTab();
		jobPostReportAction.verifyHiringReportWithDesignation();
	}
	@Test(priority=2)
	public void validateHiringReportWithStatus()
	{
		test=getTest(Screenname + ": Validate Hiring Report With Status");
		JobPostReportAction jobPostReportAction = new JobPostReportAction(driver);
		new LoginAction(driver).logoutLogin();
		jobPostReportAction.goToHiringTab();
		jobPostReportAction.verifyHiringReportWithStatus();
	}
	@Test(priority=3)
	public void validateStatuisRadioButtonFunctionalityOfHiringReportWithDesignation()
	{
		test=getTest(Screenname + ": Validate Statuis  Radio Button Functionality O fHiring Report With Designation");
		JobPostReportAction jobPostReportAction = new JobPostReportAction(driver);
		new LoginAction(driver).logoutLogin();
		jobPostReportAction.goToHiringTab();
		jobPostReportAction.verifyStatusRadioButtonFunctionalityOfHiringReport();
	}
	@Test(priority=4)
	public void validateStatuisRadioButtonFunctionalityOfHiringReportWithStatus()
	{
		test=getTest(Screenname + ": Validate Statuis  Radio Button Functionality Of Hiring Report With Status");
		JobPostReportAction jobPostReportAction = new JobPostReportAction(driver);
		new LoginAction(driver).logoutLogin();
		jobPostReportAction.goToHiringTab();
		jobPostReportAction.verifyStatusRadioButtonFunctionality();
	}
}
