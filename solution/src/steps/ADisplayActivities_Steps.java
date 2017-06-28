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

	@Given("^I launch github sample app$")
	public void i_launch_github_sample_app() throws Throwable {
		 System.out.println("Given I launch github sample app"); 
		 driver = appiumDriverFactory.getAndroidDriver();
		 pgHome = new pgHome(driver);
		 pgDetail = new pgDetail(driver);
	}

	@When("^github sample app is loaded$")
	public void github_sample_app_is_loaded() throws Throwable {
		System.out.println("\nWhen github sample app is loaded");
		Assert.assertEquals("US2FormValidator", pgHome.getTextView().getText());
	}

	@Then("^I see latest project activity listed on homepage$")
	public void i_see_latest_project_activity_listed_on_github_app_homepage() throws Throwable {
		System.out.println("\nThen I see latest project activity listed on homepage");
		
		System.out.println("\n-------- Homepage assertions --------");
		System.out.println("Checking visibility of Refresh element");
		Assert.assertNotNull(pgHome.getListRefresh());
		
		System.out.println("Checking visibility of TextViewTitle element");
		Assert.assertEquals("Form validation framework for iOS.", pgHome.getTextViewTitle().getText());
		
		System.out.println("Checking visibility of TextViewMessage element");
		Assert.assertEquals("Added analytics", pgHome.getTextViewMsg().getText());
		
		System.out.println("Checking visibility of TextViewDate element");
		Assert.assertEquals("2013-11-29T17:04:08Z", pgHome.getTextViewDate().getText());
	}
		
}