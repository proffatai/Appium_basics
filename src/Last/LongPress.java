package Last;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class LongPress extends BaseTest {

	@Test
	public void longPress() throws MalformedURLException, InterruptedException {
		
		
		// Carrying out the test, clicking on a menu
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		
		WebElement element= driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='People Names']"));
		longPress(element); // I want to longpress on this element
		
		//Let's add 1 assertions: We want to verify the title name, if correct, then we click on the option in the dropdown
		String actual =driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='android:id/title']")).getText();
		Assert.assertEquals(actual, "Sample menu");
		Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='android:id/title']")).isDisplayed()); // I can use this assertion instrad of comparing texts. I am checking if an element is displayed/visible
		
		driver.findElement(AppiumBy.id("android:id/content")).click();
		Thread.sleep(2000); // this is to ensure that the app does not close immediately after the long press is carried out, this will allow us see the menus under the longpress
	}
}
