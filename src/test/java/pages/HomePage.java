package pages;

import java.io.IOException;

import org.junit.Assert;
import commonLibrary.LibraryFunctions;
public class HomePage extends LibraryFunctions {

	String joinMeetingButton = "id=us.zoom.videomeetings:id/btnJoinConf";
	String meetingIdTextBox = "id=us.zoom.videomeetings:id/edtConfNumber";
	String joinButton = "id=us.zoom.videomeetings:id/btnJoin";
	String popUpMsg = "id=us.zoom.videomeetings:id/txtMsg";

	// Launch Application
	public void launchApplication() throws IOException, InterruptedException {
		System.out.println("Launched the app successfully");
	}

	// Tap on join meeting button
	public void tapJoinMeeting() {
		tap(joinMeetingButton);
	}

	// Type Meeting Id
	public void typeMeetingId(String meetingId) throws Exception {
		typeValue(meetingIdTextBox, meetingId);
	}

	// Verify join button enabled or not
	public void verifyJoinButtonEnabled(String meetingId) throws Exception {
		if (meetingId.length() < 9) {
			Assert.assertFalse(verifyElementEnabled(joinButton));
			System.out.println("Verify Element Enabled for less than 9 digits : " + verifyElementEnabled(joinButton));
		} else {
			Assert.assertTrue(verifyElementEnabled(joinButton));
			System.out.println("Verify Element Enabled for 9 digits : " + verifyElementEnabled(joinButton));
		}

	}

	// Tap on join button
	public void tapJoinButton() {
		tap(joinButton);
	}

	public void verifyPopUpMsg(String errorMsg) throws Exception {
		Assert.assertEquals(getText(popUpMsg), errorMsg);
	}
}
