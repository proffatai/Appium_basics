package Last;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class dragDrop extends BaseTest {

	@Test
	public void swipeGesture() throws MalformedURLException, InterruptedException {
		
		
		// Carrying out the test, clicking on a menu
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		WebElement element=driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
		dragDrop(element,844,737);
		
		Thread.sleep(3000);
		
		String actual = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_result_text")).getText();
		Assert.assertEquals(actual, "Dropped!");
	}
}
