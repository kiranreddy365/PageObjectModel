package testcases;

import java.util.regex.Pattern;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;

import library.BaseClass;

import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test2 extends BaseClass {
	
	WebDriverWait wait;
	
	String tripType="Round Trip";
	//String from="new";
	String fromAirport="Biju";
	//String to="kolkata";
	String toAirport="MAA";
	String depDate="25/August/2019";
	String retDate="28/september/2019";
	String adultNos="5";
	String childrenNos="3";
	String infatNos="1";
	
	
	By tripTypeLocator=By.xpath("//*[@id=\"SearchForm\"]/nav/ul/li/label/strong");
	By fromCityLoc=By.id("FromTag");
	By toCityLoc=By.id("ToTag");
	By frmoSelectLoc=By.xpath("//*[@id=\"ui-id-1\"]/li");
	By toSelectLoc=By.xpath("//*[@id=\"ui-id-2\"]/li");
	
	
	By dayLoc=By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr/td/a");
	By monthLoc=By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/div/div/span[1]");
	By yearLoc=By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/div/div/span[2]");
	By nextMonthButton=By.xpath("//*[@id=\"ui-datepicker-div\"]/div[2]/div/a");
	By departureDateLoc=By.id("DepartDate");
	By returnDateLoc=By.id("ReturnDate");
	
	By adultDropdown=By.id("Adults");
	By childrenDropdown=By.id("Childrens");
	By infantDropdown=By.id("Infants");
	By submitBtn=By.id("SearchBtn");
	
	

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		BaseClass bs=new BaseClass();
		bs.getDriver();


	}

	@Test
	public void testMakeMytrip() throws Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.cleartrip.com/");
		waitSimply(3000);
		//driver.findElement(departureDateLoc).sendKeys(Keys.ESCAPE);
		selectTripType(tripTypeLocator, tripType);
		setCity(fromCityLoc, frmoSelectLoc, fromAirport);
		setCity(toCityLoc, toSelectLoc, toAirport);
		selectDate(departureDateLoc, depDate);
		selectDate(returnDateLoc, retDate);
		setdropdown(adultDropdown, adultNos);
		setdropdown(childrenDropdown, childrenNos);
		setdropdown(infantDropdown, infatNos);
		//driver.findElement(submitBtn).click();
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
	
	public void setCity(By cityLoc, By selectCityLoc, String airportName)
	{
		wait=new WebDriverWait(driver, 30);
		
		driver.findElement(cityLoc).sendKeys(airportName);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(selectCityLoc));
		List<WebElement> airports=driver.findElements(selectCityLoc);
		if(airports.size()!=0)
		{
			for (WebElement airport : airports) {
				
				if(airport.getText().toLowerCase().contains(airportName.toLowerCase()))
				{
					airport.click();
					break;
				}
				else
					System.out.println("No airports matching with requested one."+airport.getText());
			}
		}
	}
	
	public void selectDate(By locator, String ddmmyyyy)
	{
		wait=new WebDriverWait(driver, 30);
		String[] date=ddmmyyyy.split("/");
		for (String str : date) {
			System.out.println(str);
		}
		
		driver.findElement(locator).click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(yearLoc));
		
		//WebElement yearWE=driver.findElement(yearLoc);
		//WebElement monthWE=driver.findElement(monthLoc);
		//WebElement nextMonthWE=;
		
		
		
		while(!driver.findElement(yearLoc).getText().contains(date[2]))
		{
			driver.findElement(nextMonthButton).click();
		}
		
		while(!driver.findElement(monthLoc).getText().toLowerCase().contains(date[1].toLowerCase()))
		{
			driver.findElement(nextMonthButton).click();
		}
		
		List <WebElement> days= driver.findElements(dayLoc);
		
		for (WebElement day : days) {
			
			if(day.getText().contains(date[0])&&day.isEnabled())
			{
				day.click();
				break;
			}
				
		}
	}
	
	public void setdropdown(By locator, String value)
	{
		WebElement element=driver.findElement(locator);
		element.click();
		Select select=new Select(element);
		select.selectByValue(value);
	}
	
	public void waitSimply(int ms)
	{
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
