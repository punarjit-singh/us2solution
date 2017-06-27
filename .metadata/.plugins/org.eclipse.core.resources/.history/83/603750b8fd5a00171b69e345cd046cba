package steps;

import io.appium.java_client.android.AndroidDriver;

import org.junit.Assert;

import org.openqa.selenium.remote.DesiredCapabilities;

import pages.pgDetail;
import pages.pgHome;
import utils.appiumDriverFactory;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ADisplayActivities_Steps {
	
	@SuppressWarnings("rawtypes")
	public static AndroidDriver driver;
	public static pgHome pgHome;
	public static pgDetail pgDetail;
	public static DesiredCapabilities capabilities;

	@Given("^gitHub sample app is launched$")
	public void github_sample_app_is_launched() throws Throwable {
	 System.out.println("Running step - gitHub sample app is launched");
	 
	 driver = appiumDriverFactory.getAndroidDriver();
	 
	 	pgHome = new pgHome(driver);
		pgDetail = new pgDetail(driver);
	}

	@When("^gitHub sample app is loaded$")
	public void github_sample_app_is_loaded() throws Throwable {
		System.out.println("Running step - gitHub sample app is loaded");
		Assert.assertEquals("US2FormValidator", pgHome.getTextView().getText());
	}

	@Then("^Project activity is displayed on home page$")
	public void project_activity_is_displayed_on_home_page() throws Throwable {
		System.out.println("Running step - Project activity is displayed on home page");
		System.out.println("Checking element Refresh");
		Assert.assertNotNull(pgHome.getListRefresh());
		System.out.println("Checking element TextViewTitle");
		Assert.assertEquals("Form validation framework for iOS.", pgHome.getTextViewTitle().getText());
		System.out.println("Checking element TextViewMessage");
		Assert.assertEquals("Added analytics", pgHome.getTextViewMsg().getText());
		System.out.println("Checking element TextViewDate");
		Assert.assertEquals("2013-11-29T17:04:08Z", pgHome.getTextViewDate().getText());
	}
		
}