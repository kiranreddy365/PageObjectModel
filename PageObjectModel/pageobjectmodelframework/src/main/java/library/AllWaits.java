package library;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllWaits {
	
	WebDriver driver;
	WebDriverWait wait;
	Wait<WebDriver> fluentWait;
	
	
	public AllWaits(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void waitSimply(int milliseconds)
	{
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void implicitlyWait(int seconds)
	{
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
	
//	public void waitUntilElementVisible(WebElement element)
//	{
//		wait.until(ExpectedConditions.visibilityOf(element));
//	}
	
	public void waitUntilElementVisible(By locator, int seconds)
	{
		wait=new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void waitUntilElementClickable(By locator, int seconds)
	{
		wait=new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public void waitUntilElementInvisible(By locator, int seconds)
	{
		wait=new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
	
	public void waitUntilPresenceOfElement(By locator, int seconds)
	{
		wait=new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public void waitUntilElementSelected(By locator, int seconds)
	{
		wait=new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.elementToBeSelected(locator));
	}
	
	public void waitUntilFrameToBeAvailableAndSwitchToIt(By locator, int seconds)
	{
		wait=new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}
	
	public void waitUntilTitleIs(String title, int seconds)
	{
		wait=new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.titleIs(title));
	}
	
	public void waitUntilTitleContains(String text, int seconds)
	{
		wait=new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.titleContains(text));
	}
	
	public void waitUntilVisiblityOfAllElements(By locator, int seconds)
	{
		wait=new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	public void waitUntilVisiblityOfAllElements(List<WebElement> elements, int seconds)
	{
		wait=new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}
	
	public void waitUntilAlertIsPresent(int seconds)
	{
		wait=new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void fluentWaitVisibilityOfElement(By locator, long waitTime_milliseconds, long pollTime_milliseconds)
	{
		fluentWait = new FluentWait<WebDriver>(driver)
		       .withTimeout(Duration.ofMillis(waitTime_milliseconds))
		       .pollingEvery(Duration.ofMillis(pollTime_milliseconds))
		       .ignoring(NoSuchElementException.class);

		fluentWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void fluentWaitElementClickable(By locator, long waitTime_milliseconds, long pollTime_milliseconds)
	{
		fluentWait = new FluentWait<WebDriver>(driver)
		       .withTimeout(Duration.ofMillis(waitTime_milliseconds))
		       .pollingEvery(Duration.ofMillis(pollTime_milliseconds))
		       .ignoring(NoSuchElementException.class);

		fluentWait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public void fluentWaitElementInvisible(By locator, long waitTime_milliseconds, long pollTime_milliseconds)
	{
		fluentWait = new FluentWait<WebDriver>(driver)
			       .withTimeout(Duration.ofMillis(waitTime_milliseconds))
			       .pollingEvery(Duration.ofMillis(pollTime_milliseconds))
			       .ignoring(NoSuchElementException.class);
		
		fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
	
	public void fluentWaitPresenceOfElement(By locator, long waitTime_milliseconds, long pollTime_milliseconds)
	{
		fluentWait = new FluentWait<WebDriver>(driver)
			       .withTimeout(Duration.ofMillis(waitTime_milliseconds))
			       .pollingEvery(Duration.ofMillis(pollTime_milliseconds))
			       .ignoring(NoSuchElementException.class);
		
		fluentWait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public void fluentWaitElementSelected(By locator, long waitTime_milliseconds, long pollTime_milliseconds)
	{
		fluentWait = new FluentWait<WebDriver>(driver)
			       .withTimeout(Duration.ofMillis(waitTime_milliseconds))
			       .pollingEvery(Duration.ofMillis(pollTime_milliseconds))
			       .ignoring(NoSuchElementException.class);
		
		fluentWait.until(ExpectedConditions.elementToBeSelected(locator));
	}
	
	public void fluentWaitFrameToBeAvailableAndSwitchToIt(By locator, long waitTime_milliseconds, long pollTime_milliseconds)
	{
		fluentWait = new FluentWait<WebDriver>(driver)
			       .withTimeout(Duration.ofMillis(waitTime_milliseconds))
			       .pollingEvery(Duration.ofMillis(pollTime_milliseconds))
			       .ignoring(NoSuchElementException.class);
		
		fluentWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}

}
