package commonLibrary;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class LibraryFunctions {

	public static AppiumDriver driver = null;
	private static AppiumDriverLocalService service = null;
	private static String AppiumNodeFilePath = "/opt/homebrew/bin/node";
	private static String AppiumJavaScriptServerFile = "/opt/homebrew/lib/node_modules/appium/build/lib/main.js";

	public void setup() throws IOException, InterruptedException {

		try {

			// startAppiumServer();
			File appDir = new File("src/test/resources/app");
			File app = new File(appDir, "zoom.apk");

			// Setting all the required desired capabilities for Main App
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("autoGrantPermissions", "true");
			capabilities.setCapability("appWaitPackage", "us.zoom.videomeetings");
			capabilities.setCapability("appWaitActivity", "com.zipow.videobox.LauncherActivity");
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("deviceName", "emulator-5554");
			capabilities.setCapability("automationName", "UIAutomator2");
			capabilities.setCapability("app", app.getAbsolutePath());
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		} catch (Throwable e) {
			e.printStackTrace();
			Assert.fail("Error while setting up appium");
		}
	}

	// Start appium server
	public static void startAppiumServer() throws IOException, InterruptedException {
		try {
			stopAppiumServer();
			System.out.println("Starting Appium Server .....");

			service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
					.usingDriverExecutable(new File(AppiumNodeFilePath))
					.withAppiumJS(new File(AppiumJavaScriptServerFile)).withIPAddress("127.0.0.1").usingPort(4723)
					.withLogFile(new File("** txt")).withArgument(GeneralServerFlag.BASEPATH, "/wd/hub/"));

			service.start();
			System.out.println("Appium Server Started !!");
		} catch (Throwable e) {
			e.printStackTrace();
			Assert.fail("Unable to start appium server");
		}
	}

	// stop appium server
	public static void stopAppiumServer() throws IOException {
		try {
			service.stop();
			System.out.println("Appium Server is now Stopped!!");
		} catch (Throwable e) {
			e.printStackTrace();
			System.out.println("Appium Server is already Stopped !!");
		}
	}

	public void closeapp() throws Exception {
		driver.quit();

	}

	// Frame Xpath
	public final WebElement getWebElementDisplay(final String locator) throws Exception {
		WebElement returnobj = null;
		try {
			String xpath;
			if (locator.contains("Xpath=") || locator.startsWith("//") || locator.startsWith("(")) {
				xpath = locator.replace("Xpath=", "");
				returnobj = driver.findElement(By.xpath(xpath));
			} else if (locator.contains("id=")) {
				xpath = locator.replace("id=", "");
				returnobj = driver.findElement(By.id(xpath));
			} else if (locator.contains("class=")) {
				xpath = locator.replace("class=", "");
				returnobj = driver.findElement(By.className(xpath));
			} else if (locator.contains("name=")) {
				xpath = locator.replace("name=", "");
				returnobj = driver.findElement(By.name(xpath));
			} else {
				return returnobj;
			}
			if (returnobj.isDisplayed()) {
				return returnobj;
			} else {
				return null;
			}

		} catch (Exception e) {
			return null;
		}
	}

	// Tap on any button
	public void tap(String locator) {

		try {
			WebElement obj = getWebElementDisplay(locator);
			if (obj == null) {
				throw new Exception();
			} else {
				obj.click();
			}
		} catch (Throwable e) {
			e.printStackTrace();
			Assert.fail("Error in fetching API response");
		}
	}

	// Enter value in text box
	public final void typeValue(final String locator, final String value) throws Exception {
		try {
			WebElement obj = getWebElementDisplay(locator);
			obj.sendKeys(value);
		} catch (Exception e) {
			throw new Exception();
		}
	}

	// Verify if the element is enabled or not
	public final boolean verifyElementEnabled(final String locator) throws Exception {
		boolean enabledFlag;
		try {
			WebElement obj = getWebElementDisplay(locator);
			enabledFlag = obj.isEnabled();
			return enabledFlag;
		} catch (Exception e) {
			throw new Exception();
		}
	}

	// Get Text
	public final String getText(final String locator) throws Exception {
		try {

			WebElement obj = getWebElementDisplay(locator);
			return obj.getText();
		} catch (Exception e) {
			throw new Exception();
		}
	}

}
