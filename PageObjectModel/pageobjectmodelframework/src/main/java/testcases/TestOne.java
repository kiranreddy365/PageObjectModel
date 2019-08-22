package testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import library.BaseClass;
import library.UtilMethods;
import library.AllWaits;

public class TestOne extends BaseClass
{
	@Test
	public void test1()
	{
		//library.UtilMethods utils=new library.UtilMethods();
		//System.out.println(utils.getExcelData());
		
		/*
		*
		*
		*
		*/
		
		getDriver();
		AllWaits waits=new AllWaits(driver);
		//waits.waitUntilElementVisible(driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input[12]")));
		//waits.waitUntilElementVisible(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input[12]"));
		//waits.waitUntilElementClickable(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input[12]"));
	}
}
