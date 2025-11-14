package stepDefinitions;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.coverfox.DriverConfig.DriverFactory;
import com.coverfox.Pages.CoverfoxAddressDetails;
import com.coverfox.Pages.CoverfoxHelthPlan;
import com.coverfox.Pages.CoverfoxHomePage;
import com.coverfox.Pages.CoverfoxMemberDetails;
import com.coverfox.Pages.CoverfoxResult;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HealthInsurance {
	CoverfoxHomePage coverfoxHomePage=new CoverfoxHomePage(DriverFactory.getDriver());
	CoverfoxHelthPlan coverfoxHelthPlan =new CoverfoxHelthPlan(DriverFactory.getDriver());
	CoverfoxMemberDetails coverfoxMemberDetails=new CoverfoxMemberDetails(DriverFactory.getDriver());
	CoverfoxAddressDetails coverfoxAddressDetails=new CoverfoxAddressDetails(DriverFactory.getDriver());
	CoverfoxResult coverfoxResult=new CoverfoxResult(DriverFactory.getDriver());
	SoftAssert softAssert =new SoftAssert();
	
	@Given("I am on home page")
	public void i_am_on_home_page() {
	    System.out.println("I am on home page");
	    
	}

	@When("I click on getStarted button")
	public void i_click_on_get_started_button() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println("I click on getStarted button");
		coverfoxHomePage.clickonGetStartedButton();
	}

	@When("I click on next button")
	public void i_click_on_next_button() throws InterruptedException {
		Thread.sleep(5000);
		System.out.println("I click on next button");
		coverfoxHelthPlan.clickOnNextButton();
	}

	@When("I Provide age as {string} and click on next button")
	public void i_provide_age_as_and_click_on_next_button(String age) throws EncryptedDocumentException, IOException, InterruptedException {
		Thread.sleep(7000);
		System.out.println("I Provide age as "+age+" and click on next button");
	   coverfoxMemberDetails.handleAgeDropDown(age);
	   coverfoxMemberDetails.clickOnNextButton();
	}

	@When("I provide pincode as {string},mobile number as {string} and click on continue button")
	public void i_provide_pincode_as_mobile_number_as_and_click_on_continue_button(String pinCode, String mobNo) throws EncryptedDocumentException, IOException, InterruptedException {
		Thread.sleep(5000);
		System.out.println("I provide pincode as "+pinCode+",mobile number as "+mobNo+"and click on continue button");
	   coverfoxAddressDetails.enterPincodeField(pinCode);
	   coverfoxAddressDetails.enterMobileNoFieldeField(mobNo);
	   coverfoxAddressDetails.clickOnContinueButton();
	   //Assert.fail();
	}

	@Then("Matching Health Insurance plans should be displayed as {string}")
	public void matching_health_insurance_plans_should_be_displayed_as(String result) throws InterruptedException {
		Thread.sleep(5000);
		System.out.println("Matching Health Insurance plans should be displayed as "+result);
	    String actualResult=coverfoxResult.getMatchingResultCount();
	    Reporter.log("actualResult is "+actualResult,true);
	    Assert.assertEquals(actualResult, result);
	}
	
	@When("I provide pincode and click on continue button")
	public void i_provide_pincode_and_click_on_continue_button() throws InterruptedException {
		Thread.sleep(5000);
		coverfoxAddressDetails.clickOnContinueButton();
	    
	}

	@Then("Validate Error message")
	public void validate_error_message() throws InterruptedException {
		Thread.sleep(2000);
		String actualErrormsgPincode=coverfoxAddressDetails.getPincodeErrormsg();
		System.out.println(actualErrormsgPincode);
		String actualErrormsgMobile=coverfoxAddressDetails.getMobileErrormsg();
		System.out.println(actualErrormsgMobile);
		String expectedErrormsgPincode="Please enter a valid pincode";
		String expectedErrormsgMobile="Please enter a valid mobile no.";
		softAssert.assertEquals(actualErrormsgPincode,expectedErrormsgPincode,"Pincode error message is not matching");
		Reporter.log("Pincode error message is matching",true);
        softAssert.assertEquals(actualErrormsgMobile,expectedErrormsgMobile,"Mobile no. error message is not matching");
        Reporter.log("Mobile no. error message is matching",true);
        softAssert.assertAll();
        Reporter.log("add 4th scenario");
	
		

		
	    
	}


}
