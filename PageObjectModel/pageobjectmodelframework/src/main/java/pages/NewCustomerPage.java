package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import library.BaseClass;
import library.CommonMethod;
import library.UtilMethods;

public class NewCustomerPage extends BaseClass
{

	CommonMethod commonMethod=new CommonMethod();
	UtilMethods util;
	
	String pageTitle="Guru99 Bank New Customer Entry Page";	

	By newCustomerLink=By.xpath("//*[text()='New Customer']");
	
	By customerNameObj=By.name("name");
	By genderObj=By.name("rad1"); //returns all options
	By dobObj=By.name("dob");
	By addrsObj=By.name("addr");
	By cityObj=By.name("city");
	By stateObj=By.name("state");
	By pinObj=By.name("pinno");
	By mobObj=By.name("telephoneno");
	By emailObj=By.name("emailid");
	By passwordObj=By.name("password");
	By submitBtnObj=By.name("sub");
	By resetBtnObj=By.name("res");
	
	By CustomerRegistrationSuccess=By.xpath("//*[text()='Customer Registered Successfully!!!']");
	String customerTablePath= ".//*[@id='customer']/tbody/tr[";
	String tabColPath="]/td[2]";
	
	//Constructor
	public NewCustomerPage()
	{
		//this.driver=driver;
		//commonMethod=new CommonMethod(driver);
	}
	
	//Verify homepage title
	public boolean verifyNewCustomerPage()
	{
		return commonMethod.verifyPageTitle(pageTitle);
	}
	
	// clicking new customer link
	public void navigateToNewCustomerPage()
	{
		commonMethod.clickObject(newCustomerLink);
	}
	
	//Set New Customer form field values
	public void setCustomerName(String name)
	{
		commonMethod.setText(customerNameObj, name);
	}
	
	public void setGender(String gndr)
	{
		commonMethod.selectRadioBtnByValue(genderObj, gndr);
	}
	
	public void setDOB(String date)
	{
		commonMethod.setText(dobObj, date);
	}
	
	public void setAddress(String address)
	{
		commonMethod.setText(addrsObj, address);
	}
	
	public void setCity(String city)
	{
		commonMethod.setText(cityObj, city);
	}
	
	public void setState(String state)
	{
		commonMethod.setText(stateObj, state);
	}
	
	public void setPIN(String pin)
	{
		commonMethod.setText(pinObj, pin);
	}
	
	public void setMobileNo(String mob)
	{
		commonMethod.setText(mobObj, mob);
	}
	
	public void setEmail(String email)
	{
		commonMethod.setText(emailObj, email);
	}
	
	public void setPassword(String password)
	{
		commonMethod.setText(passwordObj, password);
	}
	
	public void clickSubmit()
	{
		commonMethod.clickObject(submitBtnObj);
	}
	
	public void clickReset()
	{
		commonMethod.clickObject(resetBtnObj);
	}
	
	//verify the successful registration of new customer
	public boolean verifyCustomerSuccessfulRegistration()
	{
		return commonMethod.isObjectDisplayed(CustomerRegistrationSuccess);
	}
	
	
	
	
	//Verify customer field values
	
	public boolean verifyCustomerIdValue()
	{
		WebElement element=driver.findElement(By.xpath(customerTablePath+4+tabColPath));
		if(element.getText()==util.getValueOf("customerId"))
			return true;
		else 
			return false;
	}
	
	public boolean verifyCustomerNameValue()
	{
		WebElement element=driver.findElement(By.xpath(customerTablePath+5+tabColPath));
		if(element.getText()==util.getValueOf("customerName"))
			return true;
		else 
			return false;
	}
	
	public boolean verifyCustomerGenderValue()
	{
		WebElement element=driver.findElement(By.xpath(customerTablePath+6+tabColPath));
		if(element.getText()==util.getValueOf("gender"))
			return true;
		else 
			return false;
	}
	
	public boolean verifyCustomerDOBValue()
	{
		WebElement element=driver.findElement(By.xpath(customerTablePath+7+tabColPath));
		if(element.getText()==util.getValueOf("dob"))
			return true;
		else 
			return false;
	}
	
	public boolean verifyCustomerAddressValue()
	{
		WebElement element=driver.findElement(By.xpath(customerTablePath+8+tabColPath));
		if(element.getText()==util.getValueOf("address"))
			return true;
		else 
			return false;
	}
	
	public boolean verifyCustomerCityValue()
	{
		WebElement element=driver.findElement(By.xpath(customerTablePath+9+tabColPath));
		if(element.getText()==util.getValueOf("city"))
			return true;
		else 
			return false;
	}
	
	public boolean verifyCustomerStateValue()
	{
		WebElement element=driver.findElement(By.xpath(customerTablePath+10+tabColPath));
		if(element.getText()==util.getValueOf("state"))
			return true;
		else 
			return false;
	}
	
	public boolean verifyCustomerPinValue()
	{
		WebElement element=driver.findElement(By.xpath(customerTablePath+11+tabColPath));
		if(element.getText()==util.getValueOf("pin"))
			return true;
		else 
			return false;
	}
	
	public boolean verifyCustomerMobileValue()
	{
		WebElement element=driver.findElement(By.xpath(customerTablePath+12+tabColPath));
		if(element.getText()==util.getValueOf("mob"))
			return true;
		else 
			return false;
	}
	
	public boolean verifyCustomerEmailValue()
	{
		WebElement element=driver.findElement(By.xpath(customerTablePath+13+tabColPath));
		if(element.getText()==util.getValueOf("email"))
			return true;
		else 
			return false;
	}
	
	
	
	//creating new customer
	public void createNewCustomer()
	{
		util=new UtilMethods();
		
		verifyNewCustomerPage();
		setCustomerName(util.getValueOf("customerName"));
		setGender(util.getValueOf("gender"));
		
		
		setDOB(util.getValueOf("dob"));
		setAddress(util.getValueOf("address"));
		setCity(util.getValueOf("city"));
		setState(util.getValueOf("state"));
		setPIN(util.getValueOf("pin"));
		setMobileNo(util.getValueOf("mob"));
		setEmail(util.getValueOf("email"));
		setPassword(util.getValueOf("password"));
		clickSubmit();
		verifyCustomerSuccessfulRegistration();
		
		util.setValueOf("customerId", driver.findElement(By.xpath(customerTablePath+4+tabColPath)).getText());
	}
	
	
	//verifying new registered customer data
	public void verifyNewCustomerData()
	{
		verifyCustomerSuccessfulRegistration();
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
