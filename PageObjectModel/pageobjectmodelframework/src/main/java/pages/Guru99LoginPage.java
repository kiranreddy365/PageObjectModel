package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import library.BaseClass;
import library.CommonMethod;
import library.UtilMethods;

public class Guru99LoginPage extends BaseClass
{
	CommonMethod commonMethods=new CommonMethod();
	UtilMethods util=new UtilMethods();
	
	
	String loginPageTitle="Guru99 Bank Home Page";
	
	By useridObj=By.name("uid");
	By passwordObj = By.name("password");
	By loginButton = By.name("btnLogin");
	By resetButton = By.name("btnReset");
	
	
	public boolean verifyLoginPageTitle()
	{
		return commonMethods.verifyPageTitle(loginPageTitle);
	}
	
	public void setUsername(String username)
	{
		commonMethods.setText(useridObj, username);
	}
	
	public void setPassword(String pwd)
	{
		commonMethods.setText(passwordObj, pwd);
	}
	
	public void clickLoginButton()
	{
		commonMethods.clickObject(loginButton);
	}
	
	public void clickResetButton()
	{
		commonMethods.clickObject(resetButton);
	}
	
	
	
	public void loginToGuru99Bank(String username, String password)
	{
		if(verifyLoginPageTitle())
		{
			setUsername(username);
			setPassword(password);
			clickLoginButton();
		}
	}
	
	public boolean loginToGuru99BankFails(String username, String password)
	{
		boolean status=false;
		if(verifyLoginPageTitle())
		{
			setUsername(username);
			setPassword(password);
			clickLoginButton();
			status=commonMethods.isAlertDisplayed();
			commonMethods.acceptAlert();
		}
		return status;
		
	}
}
