package Last;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class Project_1 extends BaseTest {
	
	@Test
	public void MultipleChoiceList() throws MalformedURLException, InterruptedException {
		// Carrying out the test, clicking on a menu
		
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
		driver.findElement(AppiumBy.accessibilityId("Repeat alarm")).click();
		
		
		//Adding assertions: Checking to affirm that  Saturday and Sunday were unchecked initially
		String saturday=driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[@text='Every Saturday']")).getAttribute("checked");
		Assert.assertEquals(saturday, "false");
				
		String sunday=driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[@text='Every Sunday']")).getAttribute("checked");
		Assert.assertEquals(sunday, "false");
		
		//Now checking and unchecking some of the days
		driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[@text='Every Saturday']")).click(); // check Saturday
		driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[@text='Every Sunday']")).click(); // check Sunday
		driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[@text='Every Tuesday']")).click(); // Uncheck Tuesday
		driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[@text='Every Thursday']")).click(); // Uncheck Thursday

		
		
		//Adding assertions: Checking if  Saturday and Sunday were selected
		 saturday=driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[@text='Every Saturday']")).getAttribute("checked");
		Assert.assertEquals(saturday, "true");
		
		sunday=driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[@text='Every Sunday']")).getAttribute("checked");
		Assert.assertEquals(sunday, "true");
		
		
		driver.findElement(AppiumBy.id("android:id/button1")).click();// click Ok
	}
	@Test
	public void SingleChoiceList() throws MalformedURLException, InterruptedException {
		// Carrying out the test, clicking on a menu
		driver.findElement(AppiumBy.accessibilityId("Single choice list")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[@index='2']")).click(); // click on Traffic
		
		
		//Adding assertions: Checking if  Traffic was selected
		String actual=driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[@index='2']")).getText();
		Assert.assertEquals(actual, "Traffic");
		
		
		driver.findElement(AppiumBy.id("android:id/button1")).click();// click Ok
		
	}

	// I clicked cancel from the last step so I am taken back to the list of dialog page. I dont have start from the beginning
	@Test
	public void diaglogBox_1() throws MalformedURLException, InterruptedException {
		
		driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with a message")).click();
		
		//Adding assertions
		String actual=driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
		Assert.assertEquals(actual, "Lorem ipsum dolor sit aie consectetur adipiscing\nPlloaso mako nuto siwuf cakso dodtos anr koop.");
		
		driver.findElement(AppiumBy.id("android:id/button2")).click(); // click cancel
	}
	@Test
	public void diaglogBox_2() throws MalformedURLException, InterruptedException {
		
		driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with a long message")).click();
		
		//Adding assertions: Checking if the icon exist
		String actual=driver.findElement(AppiumBy.id("android:id/icon")).getAttribute("resource-id");
		Assert.assertEquals(actual, "android:id/icon");
		driver.findElement(AppiumBy.id("android:id/button1")).click(); // click OK
	}
	
	@Test
	public void listDialog() throws MalformedURLException, InterruptedException {
		
		driver.findElement(AppiumBy.accessibilityId("List dialog")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@index='1']")).click(); // clicking the second option on the list
		
		
		//Adding assertions: Checking if the icon exist
		String actual=driver.findElement(AppiumBy.id("android:id/message")).getText();
		Assert.assertEquals(actual, "You selected: 1 , Command two");
		
	}
	

}


