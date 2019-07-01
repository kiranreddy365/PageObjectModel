package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import library.BaseClass;
import library.CommonMethod;

public class NewAccountPage extends BaseClass
{

	CommonMethod commonMethod;
	String pageTitle="Guru99 bank add new account";
	
	By newAccountLink=By.xpath("html/body/div[3]/div/ul/li[5]/a");
	By customerIdObj=By.name("cusid");
	By accountTypeObj=By.name("selaccount");
	By initialDeposit=By.name("inideposit");
	By submitBtnObj=By.name("button2");
	By resetBtnObj=By.name("reset");
	
	public NewAccountPage()
	{
		//this.driver=driver;
		commonMethod=new CommonMethod();
	}
	
	public void verifyNewAccountPage()
	{
		commonMethod.verifyPageTitle(pageTitle);
	}
	
	public void clickNewAccountLink()
	{
		commonMethod.clickObject(newAccountLink);
	}
	
	public void setCustomerId(String id)
	{
		commonMethod.setText(customerIdObj, id);
	}
	
	public void setAccountType(String type)
	{
		commonMethod.selectDropdownByValue(accountTypeObj, type);
	}
	
	public void setinitialDeposit(String initialDeposite)
	{
		commonMethod.setText(initialDeposit, initialDeposite);
	}
	
	public void clickSubmit()
	{
		commonMethod.clickObject(submitBtnObj);
	}
	
	public void clickReset()
	{
		commonMethod.clickObject(resetBtnObj);
	}
	
	//Create New Account
	
	public void createNewAccount()
	{
		clickNewAccountLink();
		verifyNewAccountPage();
		setCustomerId("12345");
		setAccountType("Current");
		setinitialDeposit("5213");
		clickSubmit();
	}
	
}
