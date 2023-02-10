package Last;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest { //this is a class
	
	
	//These are attributes of the class
	public AndroidDriver driver;
	AppiumDriverLocalService service;
	
	//We have 2 methods of the class: configureAppium and tearDown
	
	@BeforeClass //I made this configureAppium() a before class so this method runs before every other method
	public void configureAppium ()throws MalformedURLException  {
		//starting the server
		service = new AppiumServiceBuilder ().withAppiumJS(new File("//Users//mac//.nvm//versions//node//v14.17.3//lib//node_modules//appium//build//lib//main.js"))
													.withIPAddress("127.0.0.1").usingPort(4723).build();
//		service.start();
		UiAutomator2Options options= new UiAutomator2Options();
		options.setDeviceName("ApiDemos"); 
		options.setApp("//Users//mac//Documents//Appium_projects//Final//src//fixture//ApiDemos-debug.apk");
		
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	public void longPress(WebElement element) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) element).getId(),
			    "duration",2000
			));
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
//		service.stop(); // stop the appium server
	}
}
