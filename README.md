### 2 ways to start an app
<br>
Using `UiAutomator2Options` and Using `DesiredCapabilities`
<br>
Method 1
<br>
//	UiAutomator2Options options = new UiAutomator2Options();
<br>
//	options.setApp("//Users//proffatai//Documents//Appium projects//Dua_Azkar_Appium_Automation//src//resources//DA.apk");
<br>
//	options.setDeviceName("Pixel4"); 
<br>
Method 2
<br>
//Alternative way of starting the app by setting all the app capabilites
<br>
	DesiredCapabilities capabilities = new DesiredCapabilities();
 <br>
	capabilities.setCapability("platformName", "Android"); // The platform you wanna run the app on whether Android or iOS
 <br>
        capabilities.setCapability("deviceName", "Pixel4"); // this is the name of the emulator you want to run the app on
	<br>
        capabilities.setCapability("appPackage", "com.ls.arabic");
	<br>
        capabilities.setCapability("appActivity", "com.ls.arabic.HomeActivity");
	<br>
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("noReset", true);
	<br>
        capabilities.setCapability("appWaitDuration", 10000); // 10 seconds
	<br>
	capabilities.setCapability("app", "//Users//proffatai//Documents//Appium projects//Dua_Azkar_Appium_Automation//src//resources//DA.apk"); // this is the location of the apk

### How to get appActivity and appPackage
Download the app: app info from playstore, open the downloaded app and from it, select the app that you want to get its properties (e.g boomplay)  and use it to extract the appActivity and appPackage name of the specific app.
<br>
The appPackage here is `com.afmobi.boomplayer` and the appActivity is `com.tecno.boomplayer.guide.ControllerActivity`
<img width="278" alt="image" src="https://github.com/proffatai/Appium_basics/assets/32229780/4fa43924-20cc-4c5d-b16b-97b8d550806c">
<br>
To get the appActivity, click on Activities from the homepage of the selected app and the first value that has the appName and ends in Activity `com.facebook.CustomTabActivity` which represents the first activity/screen.
<img width="298" alt="image" src="https://github.com/proffatai/Appium_basics/assets/32229780/26d41618-ab46-4202-bb08-de47ee116c9e">
<img width="314" alt="image" src="https://github.com/proffatai/Appium_basics/assets/32229780/6b3aed7f-4584-44d8-a637-284f71068f5d">

### Different types of selectors supported by Appium
XPath, id, className, accessibilityId and androidUiAutomator

accessibilityId and androidUiAutomator can be used with AppiumBy for findElement()
XPath, id and className are use with By. for findElement()

findElement(AppiumBy.accessibilityId("Preference"))




### Use of Appium Inspector : Ensure appium server is already running by running `appium` on CLI

With appium inspector, we can get the selectors of each element of the app. The appium inspector is synonymous to inspect tools in chrome.
parameters that we need to fill in the desired capabilities section includes:

app  -->  paste the url to the app, the same as what you passed to setApp()
deviceName   -->enter the name of the emulator, same as what we passed to the setDeviceName()
platformName  --> android //for android apps
automationName  --> UIAutomator2

Ensure that the remote host and remote port are 127.0.0.1 and 4723 by default

Click the start session button

### How to start appium server programmatically using AppiumServiceBuilder
This is nice as we dont need to manually start appium from command line any longer

We need to create an AppiumserviceBuilder and pass the path to appium main.js to it as shown below
AppiumDriverLocalService service = new AppiumServiceBuilder ().withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
														.withIPAddress("http://127.0.0.1").usingPort(4723).build();


`/usr/local/lib/node_modules/appium/build/lib/main.js`

`@BeforeClass` This is needed to run a specific class before every other class runs. When this annotation is used, the method it is being used on executes first before any other method executes
So in the subclass, we dont need to explicitly call the method, it gets called implicitly since the @BeforeClass annotation is used on it

we can decide not to call the configureAppium method in the subclass because it will be called automatically since we have inherited the content of the baseClass

Similar knowledge for the @AfterClass. Similar behavior as @BeforeClass

## Syntax for writing xpath for a specific element
//tagname[@attribute="value"] e.g say we have an element with the following tag and attributes	
or simply: `//tagname` if the attr is unique or `(//tagname)[index], NB: index starts from 1 `(//tagname)[2]` if there are multiple elements using the same attr, we can use the index to navigate to the specific element we want
<android.widget.TextView content-desc ="3. Preference dependencies" resource-id="android:id/text1">

xpath for this element becomes: //android.widget.TextView[@content-desc="3. Preference dependencies"]
or we can say, simply: //android.widget.TextView

## How to navigate to another page and get the selector from the inspector

### method 1
Always start the inspector afresh >> Click on the menu you want to get its selector (xpath or accessibiltyId) on the appium inspector, 
if you wanna move to the next page, then click the `tap` button on the inspector to open the next page

### method 2
Firstly navigate to the page you want to get to on the emulator manually 
Then start the appium inspector 
Now, locate and click on the `Refresh Source & Screenshot` button on the inspector, the inspector opens up the page we are on the emulator then we can now click on any of the elements we need from the new page

## Typing on a field
.type("message") in cypress  but in appium .sendKeys("message")

## Reading labels of elements in Appium
use the .getText() to get the text of a selected element

## Setting defaultCommandTimeout i.e time taken to wait for an element to be visible
driver.manage().timeouts().implicityWait(Duration.ofSeconds(10)) // setting to 10secs


## Appium Gestures
Visit for `https://github.com/appium/appium-uiautomator2-driver/blob/master/docs/android-mobile-gestures.md `more info

### For long press
say `//android.widget.TextView[@text='People Names'` is the xpath of the element we want to click on:  We are storing that element in a WebElement variable as shown below and we will pass this variable to the copied code from appium gestures
WebElement element= driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='People Names']"));
	
	Copy this script from appium github gestures and import the necessary modules
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) element).getId(),
			    "duration",2000 // this implies we are holding down for 2secs
			));
I added `"duration",2000` to increase the longPress time.

## Scroll operation in Appium
There are two ways to archive this,


First is to use androidUIAutomator: this requires us to use an object of the class UiScrollable, which takes as an argument an object of UISelector. Then there is a method in UiScrollable (scrollIntoView(string arg))that we can access from the UiScrollable object. arg is the name/label/text that we wanna scrol to
 We need to pass the text which we want to scroll to as the arguments. NB: /(backslash) are used before   an example is shown below
driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text (\"Web View\"))"));


### For swipeGestures
// Java
((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
    "elementId", ((RemoteWebElement) element).getId() // where element is a WebElement variable storing the position of the first image
    "direction", "left", // this specifies the swipe direction
    "percent", 0.75 // this specifies the percentage of our thumb that we want to use to swipe
));

### Drag and Drop Gesture
// Java
((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
    "elementId", ((RemoteWebElement) element).getId(), element is the reference to the element that we want to drag
    "endX", 100,// get the coordinates of the drop location from appium inspector
    "endY", 100
));

To get the coordinates endX and endY from appium inspector, indicator to `tap by coordinates`

## Rotation of phone's screen using Appium

There is a method called called rotate in appium where we have to pass a DeviceRotation obj to
e.g: DeviceRotation landscape=new DeviceRotation(0,0,90);// this will rotate the screen by 90
driver.rotate(landscape);

## Copying text to clipboard
firstly, driver.setClipboardText("Hello world"); here, we are copying `hello world` to clipboard. We can use anywhhere else by pasting it
using driver.findElement(AppiumBy.id('hello')).sendKeys(driver.getClipboardText()); instead of hardcoding the value, we pasted whatever we have on the clipboard.

We can chose not to hard code hello world as the text we wanna copy if there is a specific text we want to copy during execution
We would just use driver.setClipboardText(driver.findElement(AppiumBy.id("android:id/alertTitle")).getText()). Here the argument is the title of the page

## KeyStrokeEvent functionalities in Appium
Assuming we wanna enter / press some keys from our screen such as hitting the home button, enter button on the keyboard or back button, this can be archieved as followed

driver.pressKey(new KeyEvent(AndroidKey.HOME)); // this will hit the home button of the android phone


## App Package and App  Activity
This will allow us to directly load the page we want to perform test on instead of step by step navigation to that point

App package is the name of the package in which several classes are created
App activity is simply talking about the actions / pages that exists on the app. So each page of an app is considered as an activity
To open a specific activity level or page: Firstly, navigate to the page you want to find its activity level (page you want to load)
secondly, ensure emulator is running and run this command on terminal `adb shell dumpsys window | grep -E 'mCurrentFocus'`

The output of the above command is your packageName and activityName with / separating the two
Create an object of Activity and pass these 2 args e.g Activity act= new Activity ('packageName', 'activityName')
Finally, driver.startActivity(act);




