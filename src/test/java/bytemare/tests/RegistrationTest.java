package bytemare.tests;

import bytemare.pages.HomePage;
import bytemare.utils.ApplicationConstants;
import bytemare.utils.ConfigurationReader;
import bytemare.utils.Driver;
import bytemare.utils.TestBase;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {
	HomePage homePage = new HomePage();

	@Test
	public void ApplicationTest() {
		driver.get(ConfigurationReader.getProperty("url"));
		homePage.FillOutApplication();
	}
}
