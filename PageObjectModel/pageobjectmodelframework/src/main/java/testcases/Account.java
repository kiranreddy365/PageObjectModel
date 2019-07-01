package testcases;

import org.openqa.selenium.By;

import library.CommonMethod;

public class Account 
{
	CommonMethod commonMethods=new CommonMethod();
	
	String newAccountPageTitle="Guru99 bank add new account";
	
	By newAccountLink=By.xpath("//*[text()='New Account']");
	By customerIdObj=By.name("cusid");
	By accountType=By.name("selaccount");
	By initialDeposit=By.name("inideposit");
	By submitBtn=By.name("button2");
	By resetBtn=By.name("reset");
	
	By validationMsgAccountGenerated=By.xpath("//*[text()='Account Generated Successfully!!!']");
	
	public void verifyNewAccountPageTitle()
	{
		commonMethods.verifyPageTitle(newAccountPageTitle);
	}
	
	public void navigateToNewAccountPage()
	{
		commonMethods.clickObject(newAccountLink);
	}
	
	public void setCusomerId(String id)
	{
		commonMethods.setText(customerIdObj, id);
	}
	
	public void setAccountType(String type)
	{
		commonMethods.selectDropdownByValue(accountType, type);
	}
	
	public void setInitialDeposit(int amount)
	{
		commonMethods.setAmount(initialDeposit, amount);
	}
	
	public void clickSubmit()
	{
		commonMethods.clickObject(submitBtn);
	}
	
	public void clickReset()
	{
		commonMethods.clickObject(resetBtn);
	}
}
