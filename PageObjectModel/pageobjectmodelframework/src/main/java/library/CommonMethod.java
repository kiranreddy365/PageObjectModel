package library;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CommonMethod extends BaseClass
{
	//WebDriver driver;
	WebDriverWait wait;
	

	
	//Clicks Element
	public void clickObject(By locator)
	{
		wait=new WebDriverWait(driver, 10);
		WebElement element=driver.findElement(locator);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
	//Set text in text field
	public void setText(By locator, String text)
	{
		wait=new WebDriverWait(driver, 10);
		WebElement element=driver.findElement(locator);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.clear();
		element.sendKeys(text);
	}
	
	//get object text
	public String getObjectText(By locator)
	{
		wait=new WebDriverWait(driver, 10);
		WebElement element=driver.findElement(locator);
		wait.until(ExpectedConditions.visibilityOf(element));
		return element.getText();
	}
	
	//Set numeric values
	public void setAmount(By locator, int amt)
	{
		wait=new WebDriverWait(driver, 10);
		WebElement element=driver.findElement(locator);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(String.valueOf(amt));
	}
	
	//select radio button by element text
	public void selectRadioBtnByText(By locator, String text)
	{
		text=text.toLowerCase();
		List <WebElement> elements= driver.findElements(locator);
		for (WebElement element : elements) {
			
			if(element.getText().toLowerCase().contains(text))
			{
				element.click();
			}
		}
	}
	
	//select radio button by value
	public void selectRadioBtnByValue(By locator, String text)
	{
		text=text.toLowerCase();
		List <WebElement> elements= driver.findElements(locator);
		for (WebElement element : elements) {
			
			if(element.getAttribute("value").toLowerCase().contains(text))
			{
				element.click();
			}
		}
	}
	
	// select dropdown by value
	public void selectDropdownByValue(By locator, String type)
	{
		WebElement element=driver.findElement(locator);
		Select options=new Select(element);
		options.selectByValue(type);
		//verifyElementText(element, type);
	}
	
	//select checkbox if not selected
	public void selectCheckbox(By locator)
	{
		WebElement element=driver.findElement(locator);
		int c=0;
		while(!element.isSelected())
		{
			element.click();
			System.out.println(c+1+" Attempt");
			c++;
			if(c>3)
				break;
			
		}
	}
	
	//select date DD MM YYYY
	//Yet to be implemented
	
	public void setDate(By locator, String date)
	{
		List<WebElement> elements=driver.findElements(locator);
		String[] dateValues=date.split("/");
		
	}
	
	
	//verify object displayed 
	public boolean isObjectDisplayed(By locator)
	{
		if(driver.findElement(locator).isDisplayed())
			return true;
		else
			return false;
	}
	
	//verify object enabled 
	public boolean IsObjectEnabled(By locator)
	{
		if(driver.findElement(locator).isDisplayed())
			return true;
		else
			return false;	
	}
	
	//verify object selected 
	public boolean isObjectSelected(By locator)
	{
		if(driver.findElement(locator).isDisplayed())
			return true;
		else
			return false;	
	}
	
	
	
	
	public boolean verifyPageTitle(String title)
	{
		if(driver.getTitle().contains(title))
			return true;
		else
			return false;
	}
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifyElementText(By locator, String text ) 
	{
		if(driver.findElement(locator).getText().contains(text))
			return true;
		else
			return false;
	}
	
	//Alerts
	
	public boolean verifyAlertMsg(String msg)
	{
		wait.until(ExpectedConditions.alertIsPresent());
		if(driver.switchTo().alert().getText().contains(msg))
			return true;
		else 
			return false;
	}
	
	public void acceptAlert()
	{
		driver.switchTo().alert().accept();
	}
	
	public void dismissAlert()
	{
		driver.switchTo().alert().dismiss();
	}
	
	public boolean isAlertDisplayed()
	{
		wait.until(ExpectedConditions.alertIsPresent());
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	//take screenshot
	public String captureScreenshot(String name)
	{
		String dateName =new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
		TakesScreenshot ts= (TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String destination="Screenshots/"+name+dateName+".png";
		try {
			FileUtils.copyFile(src, new File(destination));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destination;
	}
	
	//Switch frames
	
	public void swithToFrameByNameOrId(String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}
	public void swithToFrameByLocator(By locator)
	{
		WebElement element=driver.findElement(locator);
		driver.switchTo().frame(element);
	}
	
	public void swithToFrameByIndex(int index)
	{
		driver.switchTo().frame(index);
	} 
	
	public void swithToParentFrame()
	{
		driver.switchTo().parentFrame();
	}
	
	public void swithToDefaultContent()
	{
		driver.switchTo().defaultContent();
	}
	
	//Actions
	
	public void dragDrop(By source, By destination)
	{
		WebElement from=driver.findElement(source);
		WebElement to=driver.findElement(destination);
		Actions act=new Actions(driver);
		act.dragAndDrop(from, to).build().perform();
	}
	
	public void scrollToElement(By locator)
	{
		WebElement element=driver.findElement(locator);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public void scrollToBottom()
	{
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	
}
