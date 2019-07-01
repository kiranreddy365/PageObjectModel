package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import library.BaseClass;
import library.CommonMethod;
import library.UtilMethods;

public class EditCustomerPage extends BaseClass
{
	//public static WebDriver driver;
	CommonMethod commonMethod=new CommonMethod();
	UtilMethods util=new UtilMethods();
	NewCustomerPage newCustomerPage=new NewCustomerPage();
	
	String pageTitle="Guru99 Bank Edit Customer Page";
	
	By editCustomerLink=By.xpath("//a[text()='Edit Customer']");
	By CustomerUpdateSuccess=By.xpath("//*[text()='Customer details updated Successfully!!!']");

	
	By customerIdObj=By.name("cusid");
	By submitBtnObj=By.name("AccSubmit");
	By resetBtnObj=By.name("res");
	By submitEditBtnObj=By.name("sub");
	By addrsObj=By.name("addr");
	
	String table1="//*[@id='customer']/tbody/tr[";
	String table2="]/td[2]";
	
	public void navigateToEditCustomer()
	{
		commonMethod.clickObject(editCustomerLink);
	}
	
	//verify edit customer page
	public boolean verifyEditCustomerPage()
	{
		return commonMethod.verifyPageTitle(pageTitle);
	}
	
	//set customer id for edit
	public void setCustomerId(String id)
	{
		commonMethod.setText(customerIdObj, id);
	}
	
	public void editCustomerAddress(String address)
	{
		
		commonMethod.setText(addrsObj, address);
	}
	
	public void editCustomerCity(String city)
	{
		commonMethod.setText(addrsObj, city);
	}
	
	public void editCustomerState(String state)
	{
		commonMethod.setText(addrsObj, state);
	}
	
	//submit edited customer information
	public void submitEditCustomer()
	{
		commonMethod.clickObject(submitEditBtnObj);
	}
	
	//submit customer for edit
	public void submitCustomerId()
	{
		commonMethod.clickObject(submitBtnObj);
	}
	
	
	//verify edit customer infomation
	
	public void verifyCustomerIdValue()
	{
		WebElement element=driver.findElement(By.xpath(table1+4+table2));
		Assert.assertEquals(element.getText(), util.getValueOf("customerId"));
	}
	
	public void verifyCustomerNameValue()
	{
		WebElement element=driver.findElement(By.xpath(table1+5+table2));
		Assert.assertEquals(element.getText(), util.getValueOf("customerName"));
	}
	
	public void verifyCustomerGenderValue()
	{
		WebElement element=driver.findElement(By.xpath(table1+6+table2));
		Assert.assertEquals(element.getText(), util.getValueOf("gender"));
	}
	
	public void verifyCustomerDOBValue()
	{
		WebElement element=driver.findElement(By.xpath(table1+7+table2));
		Assert.assertEquals(element.getText(), util.getValueOf("dob"));
	}
	
	public void verifyCustomerAddressValue()
	{
		WebElement element=driver.findElement(By.xpath(table1+8+table2));
		Assert.assertEquals(element.getText(), util.getValueOf("newAddress"));
	}
	
	public void verifyCustomerCityValue()
	{
		WebElement element=driver.findElement(By.xpath(table1+9+table2));
		Assert.assertEquals(element.getText(), util.getValueOf("city"));
	}
	
	public void verifyCustomerStateValue()
	{
		WebElement element=driver.findElement(By.xpath(table1+10+table2));
		Assert.assertEquals(element.getText(), util.getValueOf("state"));
	}
	
	public void verifyCustomerPinValue()
	{
		WebElement element=driver.findElement(By.xpath(table1+11+table2));
		Assert.assertEquals(element.getText(), util.getValueOf("pin"));
	}
	
	public void verifyCustomerMobileValue()
	{
		WebElement element=driver.findElement(By.xpath(table1+12+table2));
		Assert.assertEquals(element.getText(), util.getValueOf("mob"));
	}
	
	public void verifyCustomerEmailValue()
	{
		WebElement element=driver.findElement(By.xpath(table1+13+table2));
		Assert.assertEquals(element.getText(), util.getValueOf("email"));
	}
	
	public boolean verifyEditCustomerSuccessful()
	{
		return commonMethod.isObjectDisplayed(CustomerUpdateSuccess);
	}
	
	//edit customer information
	public void EditCustomer()
	{		
		navigateToEditCustomer();
		verifyEditCustomerPage();
		setCustomerId(util.getValueOf("customerId"));
		submitCustomerId();
		editCustomerAddress(util.getValueOf("newAddress"));
		submitEditCustomer();
		
	}
	
	public void verifyUpdatedCustomerData()
	{
		verifyCustomerNameValue();
		//verifyCustomerGenderValue();
		verifyCustomerDOBValue();
		verifyCustomerAddressValue();
		verifyCustomerCityValue();
		verifyCustomerStateValue();
		verifyCustomerPinValue();
		verifyCustomerMobileValue();
		verifyCustomerEmailValue();
	}
}
