package Last;


import java.net.MalformedURLException;

import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Miscellaneous extends BaseTest { // inherits all methods and attributes of the base class

		@Test
		public void clipBoardandRotation() throws MalformedURLException {
			
			
			// Carrying out the test, clicking on a menu
			driver.findElement(AppiumBy.accessibilityId("Preference")).click(); // using ppty of the baseClas to access a method
			driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
			driver.findElement(AppiumBy.id("android:id/checkbox")).click(); //check the checkbox
			driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).click();
			//Let's verify that the wifi modal is opened by applying some assertions
			String actual=driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
			Assert.assertEquals(actual, "WiFi settings");
			
			//we wanna rotate the screen before entering the wifi name
			DeviceRotation landscape=new DeviceRotation(0,0,90);
			driver.rotate(landscape);
			
			//we had to click to  lick the wifi settings page again because after rotation, the page went backward. This is a good catch for the devs to fix
			driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).click();
			
			//copying the wifi title page to clipboard
			driver.setClipboardText(driver.findElement(AppiumBy.id("android:id/alertTitle")).getText());
			
			driver.findElement(AppiumBy.id("android:id/edit")).sendKeys(driver.getClipboardText()); //pasting the copied text to sendKeys()
			driver.pressKey(new KeyEvent(AndroidKey.ENTER)); //hitting enter after pasting the name
			driver.findElement(AppiumBy.id("android:id/button1")).click();
			
			driver.pressKey(new KeyEvent(AndroidKey.HOME)); //hitting the home button
		} 
		
}

