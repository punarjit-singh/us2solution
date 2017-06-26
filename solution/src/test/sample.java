package test;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import pages.*;
public class sample {
	
		
		private static AndroidDriver driver;
		public static pgHome pgHome;
		public static pgDetail pgDetail;

		public static void main(String[] args) throws MalformedURLException, InterruptedException {

			File classpathRoot = new File(System.getProperty("user.dir"));
			
			File appDir = new File(classpathRoot, "/apk/");
			File app = new File(appDir, "app-sample.apk");

			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
			capabilities.setCapability("deviceName", "solutionDevice");
			capabilities.setCapability("platformVersion", "6.0");
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("app", app.getAbsolutePath());
			capabilities.setCapability("appPackage", "com.ustwo.sample");
			capabilities.setCapability("appActivity", "com.ustwo.sample.CommitListActivity");

			
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			
			pgHome = new pgHome(driver);
			pgDetail = new pgDetail(driver);
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			//Home page validations
			
			System.out.println(pgHome.getTextView().getText());
			System.out.println(pgHome.getListRefresh());
			System.out.println(pgHome.getTextViewTitle().getText());
			System.out.println(pgHome.getTextViewMsg().getText());
			System.out.println(pgHome.getTextViewDate().getText());

			//Details page validations
			pgHome.getTextViewMsg().click();
			
			System.out.println(pgDetail.getTextView().getText());
			System.out.println(pgDetail.getTextViewName().getText());
			System.out.println(pgDetail.getTextViewEmail().getText());
			System.out.println(pgDetail.getTextViewDate().getText());
			System.out.println(pgDetail.getTextViewMsg().getText());
			
			driver.quit();

	}

}