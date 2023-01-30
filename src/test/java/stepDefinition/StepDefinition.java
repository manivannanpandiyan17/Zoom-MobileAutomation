package stepDefinition;

import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;

public class StepDefinition {

	HomePage hp = new HomePage();

	@Given("I launch the zoom mobile app")
	public void i_launch_the_mobile_app() {
		try {
			hp.launchApplication();

		} catch (Throwable e) {
			e.printStackTrace();
			Assert.fail("Error while launching the app");
		}
	}

	@When("I click on Join meeting button")
	public void i_click_on_join_meeting_button() {
		try {
			hp.tapJoinMeeting();

		} catch (Throwable e) {
			e.printStackTrace();
			Assert.fail("Error while clicking on join meeting button");
		}
	}

	@When("I enter Meeting Id less than nine digits {string}")
	public void i_enter_meeting_id_less_than_nine_digits(String incorrectMeetingId) {
		try {
			hp.typeMeetingId(incorrectMeetingId);
		} catch (Throwable e) {
			e.printStackTrace();
			Assert.fail("Error while entering meeting id");
		}
	}

	@When("Join button is disabled {string}")
	public void join_button_is_disabled(String incorrectMeetingId) {
		try {
			hp.verifyJoinButtonEnabled(incorrectMeetingId);
		} catch (Throwable e) {
			e.printStackTrace();
			Assert.fail("Error while verifying join button");
		}
	}

	@When("I enter the correct meeting id {string}")
	public void i_enter_the_correct_meeting_id(String correctMeetingId) {
		try {
			hp.typeMeetingId(correctMeetingId);
		} catch (Throwable e) {
			e.printStackTrace();
			Assert.fail("Error while entering meeting id");
		}
	}

	@When("Join button is enabled {string}")
	public void join_button_is_enabled(String correctMeetingId) {
		try {
			hp.verifyJoinButtonEnabled(correctMeetingId);
		} catch (Throwable e) {
			e.printStackTrace();
			Assert.fail("Error while verifying join button");
		}
	}

	@When("I click on Join button")
	public void i_click_on_join_button() {
		try {
			hp.tapJoinButton();

		} catch (Throwable e) {
			e.printStackTrace();
			Assert.fail("Error while clicking on join button");
		}
	}

	@Then("An Invalid Pop up message is displayed {string}")
	public void an_invalid_pop_up_message_is_displayed(String errorMsg) {
		try {
			hp.verifyPopUpMsg(errorMsg);

		} catch (Throwable e) {
			e.printStackTrace();
			Assert.fail("Error while verifying pop up message");
		}
	}
}