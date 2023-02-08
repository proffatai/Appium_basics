package Last;


import java.net.URL;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Finale extends BaseTest { // inherits all methods and attributes of the base class

		@Test
		public void setWifiName() throws MalformedURLException {
			
			
			// Carrying out the test, clicking on a menu
			driver.findElement(AppiumBy.accessibilityId("Preference")).click(); // using ppty of the baseClas to access a method
			driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
			driver.findElement(AppiumBy.id("android:id/checkbox")).click(); //check the checkbox
			driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).click();
			driver.findElement(AppiumBy.id("android:id/edit")).sendKeys("Ibrahim wifi");
			driver.findElement(AppiumBy.id("android:id/button1")).click();
			
		} 
		
}

