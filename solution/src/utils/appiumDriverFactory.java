package utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class appiumDriverFactory {
	
	@SuppressWarnings("rawtypes")
	private static Map<String, AndroidDriver> drivers = new HashMap<String, AndroidDriver>();
	
	@SuppressWarnings("rawtypes")
	public static AndroidDriver getAndroidDriver() throws MalformedURLException {
		
		AndroidDriver driver = null;
		DesiredCapabilities capabilities;
		
		File classpathRoot = new File(System.getProperty("user.dir"));
		
		File appDir = new File(classpathRoot, "/apk/");
		File app = new File(appDir, "app-sample.apk");

		capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
		capabilities.setCapability("deviceName", "solutionDevice");
		capabilities.setCapability("platformVersion", "6.0");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", "com.ustwo.sample");
		capabilities.setCapability("appActivity", "com.ustwo.sample.CommitListActivity");

	 	
		
			driver = drivers.get("AndroidDriver");
			
			if (driver == null) {
				driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				drivers.put("AndroidDriver", driver);
			}
		
		return driver;
	}
	
	public static void closeAllDriver() {
		for (String key : drivers.keySet()) {
			drivers.get(key).close();
			drivers.get(key).closeApp();
			drivers.get(key).quit();
		}
	}

}
