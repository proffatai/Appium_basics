package Last;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class scrollAction extends BaseTest {

	@Test
	public void scrollIntoView() throws MalformedURLException, InterruptedException {
		
		
		// Carrying out the test, clicking on a menu
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text (\"WebView\"))")).click();
		String pageTitle= driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='This page is a Selenium sandbox']")).getText();
		Assert.assertEquals(pageTitle, "This page is a Selenium sandbox");
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='i_am_a_textbox']")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='i_am_a_textbox']")).sendKeys("Ibrahim Fatai");
		Thread.sleep(3000);
	}
}
