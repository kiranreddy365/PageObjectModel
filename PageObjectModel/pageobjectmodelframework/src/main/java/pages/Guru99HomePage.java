package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import library.BaseClass;
import library.CommonMethod;

public class Guru99HomePage extends BaseClass
{
	//WebDriver driver;
	CommonMethod commonMethods=new CommonMethod();
	
	public String homepageTitle="Guru99 Bank Manager HomePage";
	
	
	
	public boolean verifyHomePage()
	{
		return commonMethods.verifyPageTitle(homepageTitle);
	}
}
