package Last;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;

public class AppActivity extends BaseTest {
	
	@Test
	public void MultipleChoiceList() throws MalformedURLException, InterruptedException {
		// Carrying out the test, clicking on a menu
		Activity act= new Activity ("io.appium.android.apis", "io.appium.android.apis.app.AlertDialogSamples"); 
		driver.startActivity(act);
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
	
}

