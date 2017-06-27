package steps;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;

import org.junit.Assert;
import org.openqa.selenium.remote.DesiredCapabilities;

import pages.*;
import utils.appiumDriverFactory;

public class BDisplayActivityDetails_Steps {
	
	@SuppressWarnings("rawtypes")
	public static AndroidDriver driver;
	public static pgHome pgHome;
	public static pgDetail pgDetail;
	public static DesiredCapabilities capabilities;
	
	@Given("^I am on ustwo sample app homepage$")
	public void i_am_on_ustwo_sample_app_homepage() throws Throwable {
		driver = appiumDriverFactory.getAndroidDriver();
	 	pgHome = new pgHome(driver);
		pgDetail = new pgDetail(driver);
	    System.out.println("\nGiven I am on ustwo sample app homepage");
	    Assert.assertEquals("US2FormValidator", pgHome.getTextView().getText());
	}

	@When("^I navigate to activity details page$")
	public void i_navigate_to_activity_details_page() throws Throwable {
		System.out.println("\nWhen I navigate to activity details page");
		pgHome.getTextViewMsg().click();
		Assert.assertEquals("Full Cycle App Testing Sample", pgDetail.getTextView().getText());
	}

	@Then("^I see project activity details$")
	public void i_see_project_activity_details() throws Throwable {
		System.out.println("\nThen I see project activity details");
		System.out.println("\n-------- Details page assertions --------");
		System.out.println("Checking visibility of Name element");
		Assert.assertEquals("Martin Stolz", pgDetail.getTextViewName().getText());
		
		System.out.println("Checking visibility of Email element");
		Assert.assertEquals("martin@ustwo.co.uk", pgDetail.getTextViewEmail().getText());
		
		System.out.println("Checking visibility of Date element");
		Assert.assertEquals("2013-11-29T17:04:08Z", pgDetail.getTextViewDate().getText());
		
		System.out.println("Checking visibility of Message element");
		Assert.assertEquals("Added analytics", pgDetail.getTextViewMsg().getText());	
	}
	
	@After
	public void teardown() {
		if (driver != null) {
			driver.closeApp();
			driver.quit();
		}
	}
	
}