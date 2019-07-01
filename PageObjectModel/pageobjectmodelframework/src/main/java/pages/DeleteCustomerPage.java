package pages;

import org.openqa.selenium.By;

import library.CommonMethod;

public class DeleteCustomerPage 
{
	CommonMethod commonMethods=new CommonMethod();
	
	String deleteCustomerPageTitle="Guru99 Bank Delete Customer Page";
	String alertMsgToConfirm="Do you really want to delete this Customer?";
	String alertMsgDelSuccess="Customer deleted Successfully";
	
	By deleteCustomerLink=By.xpath("//*[text()=\"Delete Customer\"]");
	By customerIdObj=By.name("cusid");
	By submitBtn=By.name("AccSubmit");
	By resetBtn=By.name("res");
	
	public void verifyDeleteCustomerPageTitle()
	{
		commonMethods.verifyPageTitle(deleteCustomerPageTitle);
	}
	
	public void navigateToDeleteCustomer()
	{
		commonMethods.clickObject(deleteCustomerLink);
	}
	
	public void setCustomerId(String id)
	{
		commonMethods.setText(customerIdObj, id);
	}
	
	public void submitDel()
	{
		commonMethods.clickObject(submitBtn);
	}
	
	public void confirmDeletion()
	{
		commonMethods.verifyAlertMsg(alertMsgToConfirm);
		commonMethods.acceptAlert();
		commonMethods.verifyAlertMsg(alertMsgDelSuccess);
		commonMethods.acceptAlert();
	}
	
	public void deleteCustomer(String id)
	{
		
		verifyDeleteCustomerPageTitle();
		setCustomerId(id);
		submitDel();
		confirmDeletion();
	}
	
	
}
