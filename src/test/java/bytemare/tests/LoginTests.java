package bytemare.tests;

import bytemare.utils.ConfigurationReader;
import bytemare.utils.TestBase;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
	
	@Test
	public void loginTest() {
		String username = ConfigurationReader.getProperty("username");
		String password = ConfigurationReader.getProperty("password");
	 	pages.signin().login(username, password);
	}

}
