package testcases;

import java.util.regex.Pattern;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;

import library.BaseClass;

import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class MakeMytrip extends BaseClass {


	By tripTypeLocator=By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/ul/li");
	By roundtripFrom=By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div[1]/div[1]/label");
	By roundtripFromInput=By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div[1]/div[1]/div[1]/div/div/div/input");
	By roundtripTo=By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div[1]/div[2]/label");
	By roundtripToInput=By.xpath("");
	String tripType="round trip";
	String from="chennai";
	String to="kolkata";
	
	By firstCityNameLocator=By.xpath("//*[contains(text(), 'SUGGESTION')]/following::div[1]");
	
	By dayLoc=By.xpath("");
	By monthLoc=By.xpath("");
	By yearLoc=By.xpath("");
	By nextMonthButton=By.xpath("");
	By departureLoc=By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div[1]/div[3]/label");
	By returnLoc=By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div[1]/div[4]/label");
	
	String depDate="25/June/2019";
	String retDate="28/June/2019";

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		BaseClass bs=new BaseClass();
		bs.getDriver();


	}

	@Test
	public void testMakeMytrip() throws Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		selectTripType(tripTypeLocator, "round trip");
		//setText(roundtripFrom, firstCityNameLocator, from);
		//setText(roundtripTo, firstCityNameLocator, to);
		//selectDate(departureLoc, depDate);
		//selectDate(returnLoc, retDate);
		driver.findElement(roundtripFrom).sendKeys(from);
		driver.findElement(roundtripTo).sendKeys(to);
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		//driver.quit();

	}
	
	public void selectTripType(By locator, String type)
	{
		List <WebElement> tripTypes=driver.findElements(locator);
		for (WebElement tripType : tripTypes) {
			
			System.out.println(tripType.getText());
			if(tripType.getText().equalsIgnoreCase(type)&&!tripType.isSelected())
			{
				tripType.click();
				System.out.println("Trip type selected: "+tripType.isSelected());
			}
			
		}
	}
	
	public void setText(By locator, By autoPopulateLocator, String cityName)
	{
		//driver.findElement(locator).click();
		driver.findElement(locator).sendKeys(cityName);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement element=driver.findElement(autoPopulateLocator);
		int c=0;
		while(c<3)
		{
			if(element.isEnabled())
			{
				driver.findElement(autoPopulateLocator).click();
				System.out.println(c);
				break;
			}
			else
			{
				c++;
				continue;
			}
			
		}
	}
	
	public void selectDate(By locator, String ddmmyyyy)
	{
		String[] date=ddmmyyyy.split("/");
		for (String str : date) {
			System.out.println(str);
		}
		
		driver.findElement(locator).click();
		
		//WebElement yearWE=driver.findElement(yearLoc);
		//WebElement monthWE=driver.findElement(monthLoc);
		//WebElement nextMonthWE=driver.findElement(nextMonthButton);
		
		List <WebElement> days= driver.findElements(locator);
		
		/*while(!yearWE.getText().contains(date[2]))
		{
			nextMonthWE.click();
			if(yearWE.getText().contains(date[2]))
				break;
		}
		
		while(!monthWE.getText().toLowerCase().contains(date[2]))
		{
			nextMonthWE.click();
			if(yearWE.getText().contains(date[2]))
				break;
		}*/
		
		for (WebElement day : days) {
			
			if(day.getText().contains(date[0])&&day.isEnabled())
			{
				day.click();
				break;
			}
			else
				continue;
				
		}
	}

}



