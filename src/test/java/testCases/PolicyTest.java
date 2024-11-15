package testCases;

import static reporting.ComplexReportFactory.getTest;

import org.testng.annotations.Test;

import action.LoginAction;
import action.PolicyAction;
import utils.WebTestBase;

public class PolicyTest extends WebTestBase{
	static String Screenname ="<b> Hiring/b>";
	  
	@Test(priority=1)
	public void validationCheck()
	{
		test=getTest(Screenname + ": Validation message on Add Policy");
		PolicyAction policyAction = new PolicyAction(driver);
		new LoginAction(driver).logoutLogin();
		policyAction.goToHiringTab();
		policyAction.validationCheck();
	}
	@Test(priority=2)
	public void addPolicy()
	{
		test=getTest(Screenname + ": Add Policy ");
		PolicyAction policyAction = new PolicyAction(driver);
		new LoginAction(driver).logoutLogin();
		policyAction.goToHiringTab();
		policyAction.addPolicy();
	}
	@Test(priority=3,dependsOnMethods = {"addPolicy"})
	public void validatePolicyNameOnListingPAge()
	{
		test=getTest(Screenname + ":Validate Policy Name on listing page");
		PolicyAction policyAction = new PolicyAction(driver);
		new LoginAction(driver).logoutLogin();
		policyAction.goToHiringTab();
		policyAction.verifyPolicyNameOnListingPage();
	}
	@Test(priority=4)
	public void validateEditFunctionality()
	{
		test=getTest(Screenname + ":Validate Edit Functionality of policy");
		PolicyAction policyAction = new PolicyAction(driver);
		new LoginAction(driver).logoutLogin();
		policyAction.goToHiringTab();
		policyAction.verifyPolicyNameOnListingPage();
		policyAction.verifyEditFunctionality();
	}
	@Test(priority=5)
	public void validateStatusFunctionality()
	{
		test=getTest(Screenname + ":Validate Status Functionality of policy");
		PolicyAction policyAction = new PolicyAction(driver);
		new LoginAction(driver).logoutLogin();
		policyAction.goToHiringTab();
		policyAction.verifyPolicyNameOnListingPage();
		policyAction.verifyStatusFunctionality();
	}
	@Test(priority=6)
	public void validateProbationPeriodPage()
	{
		test=getTest(Screenname + ":Validate Probation Period Page");
		PolicyAction policyAction = new PolicyAction(driver);
		new LoginAction(driver).logoutLogin();
		policyAction.goToHiringTab();
		policyAction.verifyPolicyNameOnListingPage();
		policyAction.verifyProbationPeriodPage();
	}
	@Test(priority=7)
	public void validateNoticePeriodPage()
	{
		test=getTest(Screenname + ":Validate Notice Period Page");
		PolicyAction policyAction = new PolicyAction(driver);
		new LoginAction(driver).logoutLogin();
		policyAction.goToHiringTab();
		policyAction.verifyPolicyNameOnListingPage();
		policyAction.verifyNoticePeriodPage();
	}
	@Test(priority=8)
	public void validateDeleteFunctionality()
	{
		test=getTest(Screenname + ":Validate Delete Functionality of policy");
		PolicyAction policyAction = new PolicyAction(driver);
		new LoginAction(driver).logoutLogin();
		policyAction.goToHiringTab();
		policyAction.verifyPolicyNameOnListingPage();
		policyAction.verifyDeleteButtonFunctionalityOfPolicy();
	}


}
