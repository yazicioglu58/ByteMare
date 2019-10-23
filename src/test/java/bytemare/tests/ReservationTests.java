package bytemare.tests;

import bytemare.utils.DBUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import bytemare.utils.ConfigurationReader;
import bytemare.utils.TestBase;

public class ReservationTests extends TestBase {
	
	@Test
	public void reserveConference() {
		//test data
		String date = "March 5, 2019";
		String from = "5:00pm";
		String to = "6:00pm";
		String room = "yale";
		//test data from properties file
		String username = ConfigurationReader.getProperty("email");
		String password = ConfigurationReader.getProperty("password");

	 	pages.signin().login(username, password);

	 	Assert.assertTrue(date.endsWith("e"));
	 	
	}
}
