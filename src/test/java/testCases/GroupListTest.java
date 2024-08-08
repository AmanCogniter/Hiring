package testCases;

import static reporting.ComplexReportFactory.getTest;

import org.testng.annotations.Test;

import action.GroupListAction;
import action.LoginAction;
import utils.WebTestBase;

public class GroupListTest  extends WebTestBase{
	static String Screenname ="<b> Hiring/b>";
	  
	@Test(priority=1)
	public void validationCheck()
	{
		test=getTest(Screenname + ": Validation message on Add Group");
		GroupListAction groupListAction = new GroupListAction(driver);
		new LoginAction(driver).logoutLogin();
		groupListAction.goToHiringTab();
		groupListAction.validationCheck();
	}
	@Test(priority=2)
	public void addGroupList()
	{
		test=getTest(Screenname + ": Add Group ");
		GroupListAction groupListAction = new GroupListAction(driver);
		new LoginAction(driver).logoutLogin();
		groupListAction.goToHiringTab();
		groupListAction.addGroup();
	}
	@Test(priority=3,dependsOnMethods = {"addGroupList"})
	public void validateGroupNAmeOnListingPAge()
	{
		test=getTest(Screenname + ":Validate group name on listing page");
		GroupListAction groupListAction = new GroupListAction(driver);
		new LoginAction(driver).logoutLogin();
		groupListAction.goToHiringTab();
		groupListAction.verifyGroupNAmeOnListingPAge();
	}
	@Test(priority=4,dependsOnMethods = {"addGroupList","validateGroupNAmeOnListingPAge"})
	public void validateEditButtonFunctionality()
	{
		test=getTest(Screenname + ":Validate Edit Button Functionality");
		GroupListAction groupListAction = new GroupListAction(driver);
		new LoginAction(driver).logoutLogin();
		groupListAction.goToHiringTab();
		groupListAction.verifyEditButtonFunctionality();
	}
	@Test(priority=5,dependsOnMethods = {"addGroupList"})
	public void validateDeleteButtonFunctionality()
	{
		test=getTest(Screenname + ":Validate Delete Button Functionality");
		GroupListAction groupListAction = new GroupListAction(driver);
		new LoginAction(driver).logoutLogin();
		groupListAction.goToHiringTab();
		groupListAction.verifyDeleteButtonFunctionality();
	}
	
	
}
