package Last;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class SwipeGesture extends BaseTest {

	@Test
	public void swipeGesture() throws MalformedURLException, InterruptedException {
		
		
		// Carrying out the test, clicking on a menu
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
		
		WebElement firstimage= driver.findElement(AppiumBy.xpath("(//android.widget.ImageView)[1]")); //storing the image that i want to always use as a reference
		
		//checking that the initial value of focusable is true
		String beforeScroll =driver.findElement(AppiumBy.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"); // this will return the value of the attribute focusable which is true when view on appium inspector initially
		Assert.assertEquals(beforeScroll, "true"); //we are checking via assertion to be sure that the text returned is true
		
		swipeAction(firstimage,"left"); // scroll action is done here. I expect the focusable value of the firstimage to become change (become false) if scroll action was successful
		
		
		String afterScroll =driver.findElement(AppiumBy.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"); // this will return the value of the attribute focusable which is true when view on appium inspector initially
		Assert.assertEquals(afterScroll, "false");// the value of focusable for the first image is expected to be false if swipe action was successful
	}
}
