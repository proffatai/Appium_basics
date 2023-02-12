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



