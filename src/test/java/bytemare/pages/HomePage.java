package bytemare.pages;

import bytemare.utils.ApplicationConstants;
import bytemare.utils.BrowserUtils;
import bytemare.utils.ConfigurationReader;
import bytemare.utils.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {
    Faker faker = new Faker();
	ApplicationConstants applicationConstants = new ApplicationConstants();
	public HomePage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(id = "comp-k29n3ahiinput")
    public WebElement firstNameField;

	@FindBy(id = "comp-k29n3ahqinput")
    public WebElement lastNameField;

	@FindBy(id = "comp-k29n3ahwinput")
    public WebElement phoneNumberField;

	@FindBy(id = "comp-k29n3ai5inputWrapper")
    public WebElement dobField;

    @FindBy(id = "comp-k29n3ai5calendarmonthweek42day3dayContent")
    public WebElement dobSelectField;

	@FindBy(id = "comp-k29n3aidinput")
    public WebElement ssnField;

	@FindBy(id = "comp-k29n3ailinput")
    public WebElement emailField;

	@FindBy(id = "comp-k29n3aitlabel")
    public WebElement submitField;

    @FindBy(xpath = "//*[@id='comp-k29n3aj2']/span/p/span")
    public WebElement submittedMessage;

	public void FillOutApplication() {

		firstNameField.sendKeys(faker.name().firstName());
		lastNameField.sendKeys(faker.name().lastName());
		phoneNumberField.sendKeys(faker.phoneNumber().cellPhone());
		dobField.click();
        dobSelectField.click();
		ssnField.sendKeys(faker.number().numberBetween(20000000, 999999999)+"0");
		emailField.sendKeys(faker.name().username()+"@gmail.com");
		submitField.click();
        Assert.assertTrue(submittedMessage.getText().equals("Thanks for submitting!"));
	}
	public void FillOutApplication2() {

		firstNameField.sendKeys(ApplicationConstants.firstname);
		lastNameField.sendKeys(ApplicationConstants.lastname);
		phoneNumberField.sendKeys(ApplicationConstants.phonenumber);
		dobField.click();
		dobSelectField.click();
		ssnField.sendKeys(ApplicationConstants.ssn);
		emailField.sendKeys(ApplicationConstants.email);
		submitField.click();
		Assert.assertTrue(submittedMessage.getText().equals("Thanks for submitting!"));
	}
}
