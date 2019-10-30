package bytemare.tests;

import bytemare.pages.HomePage;
import bytemare.utils.ApplicationConstants;
import bytemare.utils.ConfigurationReader;
import bytemare.utils.Driver;
import bytemare.utils.TestBase;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTest extends TestBase {
	HomePage homePage = new HomePage();

	@Test
	public void ApplicationTest1() {
		driver.get(ConfigurationReader.getProperty("url"));
		homePage.FillOutApplicationWithRandomData();
	}

	@Test
	public void ApplicationTest2() {
		driver.get(ConfigurationReader.getProperty("url"));
		homePage.FillOutApplicationWithConstantsData();
	}

	@Test
	public void ApplicationTest3() {
		driver.get(ConfigurationReader.getProperty("url"));
		Random random = new Random();
		int row = random.nextInt(100);
		homePage.FillOutApplicationWithExcelData(row);
	}
}
