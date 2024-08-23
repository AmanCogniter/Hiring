package testCases;

import static reporting.ComplexReportFactory.getTest;

import java.awt.AWTException;

import org.testng.annotations.Test;

import action.JobBoardSetupAction;
import action.LoginAction;
import utils.WebTestBase;

public class JobBoardSetupTest extends WebTestBase{
	static String Screenname ="<b> Hiring/b>";
	@Test(priority=1)
	public void validateLayoutPage()
	{
		test=getTest(Screenname + ": Validate Layout Page");
		JobBoardSetupAction jobBoardSetupAction = new JobBoardSetupAction(driver);
		new LoginAction(driver).logoutLogin();
		jobBoardSetupAction.goToHiringTab();
		jobBoardSetupAction.verifyLayoutPAge();
	}
	@Test(priority=2)
	public void validateGeneralPage()
	{
		test=getTest(Screenname + ": Validate General Page");
		JobBoardSetupAction jobBoardSetupAction = new JobBoardSetupAction(driver);
		new LoginAction(driver).logoutLogin();
		jobBoardSetupAction.goToHiringTab();
		jobBoardSetupAction.verifyGeneralPAge();
	}
	@Test(priority=3)
	public void validateAppearancePage()
	{
		test=getTest(Screenname + ": Validate Appearance Page");
		JobBoardSetupAction jobBoardSetupAction = new JobBoardSetupAction(driver);
		new LoginAction(driver).logoutLogin();
		jobBoardSetupAction.goToHiringTab();
		jobBoardSetupAction.verifyAppearancePAge();
	}
	@Test(priority=4)
	public void validateWebsiteAndSocialPage()
	{
		test=getTest(Screenname + ": Validate WebsiteAndSocial Page");
		JobBoardSetupAction jobBoardSetupAction = new JobBoardSetupAction(driver);
		new LoginAction(driver).logoutLogin();
		jobBoardSetupAction.goToHiringTab();
		jobBoardSetupAction.verifyWebsiteAndSocialPAge();
	}
	@Test(priority=5)
	public void validateLayoutPageWithDeatilRadioButtonFunctionalitty()
	{
		test=getTest(Screenname + ": Validate Layout Page With Deatil Radio Button Functionalitty");
		JobBoardSetupAction jobBoardSetupAction = new JobBoardSetupAction(driver);
		new LoginAction(driver).logoutLogin();
		jobBoardSetupAction.goToHiringTab();
		jobBoardSetupAction.verifyLayoutPAgeWithDeatilRadioButton();
	}
	@Test(priority=6)
	public void validateAppearancePageWithDeatilRadioButtonFunctionalitty()
	{
		test=getTest(Screenname + ": Validate Appearance Page With Deatil Radio Button Functionalitty");
		JobBoardSetupAction jobBoardSetupAction = new JobBoardSetupAction(driver);
		new LoginAction(driver).logoutLogin();
		jobBoardSetupAction.goToHiringTab();
		jobBoardSetupAction.verifyAppearancePAgeWithDeatilRadioButton();
	}
	@Test(priority=7)
	public void validateWebsiteAndSocialPageWithDeatilRadioButtonFunctionalitty()
	{
		test=getTest(Screenname + ": Validate WebsiteAndSocial Page With Deatil Radio Button Functionalitty");
		JobBoardSetupAction jobBoardSetupAction = new JobBoardSetupAction(driver);
		new LoginAction(driver).logoutLogin();
		jobBoardSetupAction.goToHiringTab();
		jobBoardSetupAction.verifyWebsiteAndSocialPAgeWithDeatilRadioButton();
	}
	@Test(priority=8)
	public void validateManageContentPageWithDeatilRadioButtonFunctionalitty()
	{
		test=getTest(Screenname + ": Validate Manage Content Page With Deatil Radio Button Functionalitty");
		JobBoardSetupAction jobBoardSetupAction = new JobBoardSetupAction(driver);
		new LoginAction(driver).logoutLogin();
		jobBoardSetupAction.goToHiringTab();
		jobBoardSetupAction.verifyManageContentWithDeatilRadioButton();
	}
	@Test(priority=9)
	public void validateTestimonialsPageWithDeatilRadioButtonFunctionalitty() throws AWTException
	{
		test=getTest(Screenname + ": Validate Testimonials Page With Deatil Radio Button Functionalitty");
		JobBoardSetupAction jobBoardSetupAction = new JobBoardSetupAction(driver);
		new LoginAction(driver).logoutLogin();
		jobBoardSetupAction.goToHiringTab();
		jobBoardSetupAction.verifyTestimonialsWithDeatilRadioButton();
	}
	@Test(priority=10)
	public void validateEmployeesPageWithDeatilRadioButtonFunctionalitty()
	{
		test=getTest(Screenname + ": Validate Employees Page With Deatil Radio Button Functionalitty");
		JobBoardSetupAction jobBoardSetupAction = new JobBoardSetupAction(driver);
		new LoginAction(driver).logoutLogin();
		jobBoardSetupAction.goToHiringTab();
		jobBoardSetupAction.verifyEmployeesWithDeatilRadioButton();
	}
	@Test(priority=11)
	public void validatePhotosAndVideosPageWithDeatilRadioButtonFunctionalitty()
	{
		test=getTest(Screenname + ": Validate Photos And Videos Page With Deatil Radio Button Functionalitty");
		JobBoardSetupAction jobBoardSetupAction = new JobBoardSetupAction(driver);
		new LoginAction(driver).logoutLogin();
		jobBoardSetupAction.goToHiringTab();
		jobBoardSetupAction.verifyPhotosAndVideosWithDeatilRadioButton();
	}
	@Test(priority=12)
	public void validateContentPageWithDeatilRadioButtonFunctionalitty()
	{
		test=getTest(Screenname + ": Validate Content Page With Deatil Radio Button Functionalitty");
		JobBoardSetupAction jobBoardSetupAction = new JobBoardSetupAction(driver);
		new LoginAction(driver).logoutLogin();
		jobBoardSetupAction.goToHiringTab();
		jobBoardSetupAction.verifyContentWithDeatilRadioButton();
	}
}
