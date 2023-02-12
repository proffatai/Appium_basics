package Last;


import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class Finale extends BaseTest { // inherits all methods and attributes of the base class

		@Test
		public void setWifiName() throws MalformedURLException {
			
			
			// Carrying out the test, clicking on a menu
			driver.findElement(AppiumBy.accessibilityId("Preference")).click(); // using ppty of the baseClas to access a method
			driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
			driver.findElement(AppiumBy.id("android:id/checkbox")).click(); //check the checkbox
			driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).click();
			//Let's verify that the wifi modal is opened by applying some assertions
			String actual=driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
			Assert.assertEquals(actual, "WiFi settings");
			driver.findElement(AppiumBy.id("android:id/edit")).sendKeys("Ibrahim wifi");
			driver.findElement(AppiumBy.id("android:id/button1")).click();
		} 
		
}

