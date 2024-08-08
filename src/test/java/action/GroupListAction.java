package action;

import org.openqa.selenium.WebDriver;

import pageObjects.GroupListPage;

public class GroupListAction {
	WebDriver driver;
	GroupListPage groupListPage;

	public GroupListAction(WebDriver driver) {
		this.driver = driver;
		groupListPage = new GroupListPage(driver);

	}

	public void goToHiringTab() {
		groupListPage.clickFullMenuDropDown();
		groupListPage.clickOnHiring();
		groupListPage.clickOnGroupList();

	}

	public void validationCheck() {
		groupListPage.clickOnAddGroupList();
		groupListPage.save();

		groupListPage.VerifyMandatoryFieldValidation();

	}
	public void  addGroup()
	{
		groupListPage.clickOnAddGroupList();
		groupListPage.enterGroupName();
		groupListPage.selectRecruiters();
		groupListPage.save();
		groupListPage.captureNotifyMessage();
		
		
	}
	public void  verifyGroupNAmeOnListingPAge()
	{
		groupListPage.enterGroupNameIntoSearchField();
		groupListPage.clickOnSearchButton();
		groupListPage.verifyGroupNameOnListingPage();
		
		
		
	}
	public void  verifyEditButtonFunctionality()
	{
		groupListPage.enterGroupNameIntoSearchField();
		groupListPage.clickOnSearchButton();
		groupListPage.verifyGroupNameOnListingPage();
		groupListPage.clickOnEdit();
		groupListPage.clickOnUpdate();
		groupListPage.captureUpdateNotifyMessage();
	}
	public void  verifyDeleteButtonFunctionality()
	{
		groupListPage.enterGroupNameIntoSearchField();
		groupListPage.clickOnSearchButton();
		groupListPage.verifyGroupNameOnListingPage();
		groupListPage.clickOnCheckBox();
		groupListPage.clickOnDelete();
		groupListPage.clickOnConfirmationButton();
		groupListPage.captureDeleteNotifyMessage();
	}
}
