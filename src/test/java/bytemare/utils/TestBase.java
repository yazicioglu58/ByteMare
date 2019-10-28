package bytemare.utils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public abstract class TestBase {
	protected WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	public void setupMethod() {
		//connect to the data base
		//DBUtils.createConnection();
		driver = Driver.getDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterMethod(alwaysRun = true)
	public void tearDownMethod(ITestResult result) throws IOException {
		Driver.closeDriver();
	}

}
