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



	@Test
	public void ApplicationTest2() {
		// use contants
		driver.get(ConfigurationReader.getProperty("url"));
		homePage.FillOutApplication2();
	}

	@Test
	public void ApplicationTest3() {

		//data driven
		driver.get(ConfigurationReader.getProperty("url"));
		homePage.FillOutApplication();
	}
}
