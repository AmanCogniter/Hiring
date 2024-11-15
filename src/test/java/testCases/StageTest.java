package testCases;

import static reporting.ComplexReportFactory.getTest;

import org.testng.annotations.Test;

import action.LoginAction;
import action.StageAction;
import utils.WebTestBase;

public class StageTest extends WebTestBase {
	static String Screenname = "<b> Hiring/b>";

	@Test(priority = 1)
	public void validationCheck() {
		test = getTest(Screenname + ": Validation message on Add Stage");
		StageAction stageAction = new StageAction(driver);
		new LoginAction(driver).logoutLogin();
		stageAction.goTOHiringTab();
		stageAction.validationCheck();
	}

	@Test(priority = 2)
	public void validationCheckOfUserGuide() {
		test = getTest(Screenname + ": Validation Check Of User Guide");
		StageAction stageAction = new StageAction(driver);
		new LoginAction(driver).logoutLogin();
		stageAction.goTOHiringTab();
		stageAction.validateUserGuide();
	}

	@Test(priority = 3)
	public void addService() {
		test = getTest(Screenname + ": Validate Add Stage Functionality");
		StageAction stageAction = new StageAction(driver);
		new LoginAction(driver).logoutLogin();
		stageAction.goTOHiringTab();
		stageAction.addStage();
	}

	@Test(priority = 4)
	public void ValidateStageNameOnListingPage() {
		test = getTest(Screenname + ":Validate Stage Name On Listing Page");
		StageAction stageAction = new StageAction(driver);
		new LoginAction(driver).logoutLogin();
		stageAction.goTOHiringTab();
		stageAction.verifyStageNameOnListingPAge();
	}
	@Test(priority = 5)
	public void ValidateEditFunctionalityOfStageName() {
		test = getTest(Screenname + ":Validate Edit Functionality Of Stage Name");
		StageAction stageAction = new StageAction(driver);
		new LoginAction(driver).logoutLogin();
		stageAction.goTOHiringTab();
		stageAction.verifyEditFunctionalityOfStageName();
	}
	@Test(priority = 6)
	public void ValidateInActiveSatatusButtonFunctionalityOfStageName() {
		test = getTest(Screenname + ":Validate InActive Status Button Functionality Of Stage Name");
		StageAction stageAction = new StageAction(driver);
		new LoginAction(driver).logoutLogin();
		stageAction.goTOHiringTab();
		stageAction.verifyInActiveStatusFunctionalityOfStageName();
	}
	@Test(priority = 7)
	public void ValidateActiveSatatusButtonFunctionalityOfStageName() {
		test = getTest(Screenname + ":Validate Active Status Button Functionality Of Stage Name");
		StageAction stageAction = new StageAction(driver);
		new LoginAction(driver).logoutLogin();
		stageAction.goTOHiringTab();
		stageAction.verifyActiveStatusFunctionalityOfStageName();
	}
	@Test(priority = 8)
	public void ValidateDropDownInActiveSatatusButtonFunctionalityOfStageName() {
		test = getTest(Screenname + ":Validate InActive Status Button Functionality Of Stage Name From Dropdown");
		StageAction stageAction = new StageAction(driver);
		new LoginAction(driver).logoutLogin();
		stageAction.goTOHiringTab();
		stageAction.verifyDropDownInActiveStatusFunctionalityOfStageName();
	}
	@Test(priority = 9)
		public void ValidateDropDownActiveSatatusButtonFunctionalityOfStageName() {
			test = getTest(Screenname + ":Validate Active Status Button Functionality Of Stage Name From Dropdown");
			StageAction stageAction = new StageAction(driver);
			new LoginAction(driver).logoutLogin();
			stageAction.goTOHiringTab();
			stageAction.verifyDropDownActiveStatusFunctionalityOfStageName();
		}
	/* Validate sorting functionality*/
	@Test(priority=10)
    public void verifySortingFunctionality() {
        test = getTest("TC_User_Storage_003");
        StageAction stageAction = new StageAction(driver);
        LoginAction login = new LoginAction(driver);

        login.logoutLogin();
        stageAction.goTOHiringTab();
        stageAction.stageSorting();
       
       
    }
	
	@Test(priority = 11)
	public void ValidateDeleteButtonFunctionalityOfStageName() {
		test = getTest(Screenname + ":Validate delete Button Functionality Of Stage Name");
		StageAction stageAction = new StageAction(driver);
		new LoginAction(driver).logoutLogin();
		stageAction.goTOHiringTab();
		stageAction.verifyDeleteFunctionalityOfStageName();
	}
}
