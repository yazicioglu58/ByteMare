package bytemare.pages;

import bytemare.utils.*;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Random;

public class HomePage {
    Faker faker = new Faker();
	ApplicationConstants applicationConstants = new ApplicationConstants();
	ExcelUtil excelUtil = new ExcelUtil("./DataBank/MOCK_DATA.xlsx", "MOCK_DATA" );

	public HomePage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(id = "comp-k29n3ahiinput")
    public WebElement firstNameField;

	@FindBy(id = "comp-k29n3ahqinput")
    public WebElement lastNameField;

	@FindBy(id = "comp-k29n3ahwinput")
    public WebElement phoneNumberField;

	@FindBy(id = "comp-k2dsdffqinput")
    public WebElement dobField;

	@FindBy(id = "comp-k29n3aidinput")
    public WebElement ssnField;

	@FindBy(id = "comp-k29n3ailinput")
    public WebElement emailField;

	@FindBy(id = "comp-k29n3aitlabel")
    public WebElement submitField;

    @FindBy(xpath = "//*[@id='comp-k29n3aj2']/span/p/span")
    public WebElement submittedMessage;

	public void FillOutApplicationWithRandomData() {
		Random random = new Random();
		int ssn1= random.nextInt(899)+100;
		int ssn2= random.nextInt(89)+10;
		int ssn3= random.nextInt(8999)+1000;
		firstNameField.sendKeys(faker.name().firstName());
		lastNameField.sendKeys(faker.name().lastName());
		phoneNumberField.sendKeys(faker.phoneNumber().cellPhone());
		dobField.sendKeys(faker.date().birthday(18,60).toString());
		ssnField.sendKeys(ssn1+"-"+ssn2+"-"+ssn3);
		emailField.sendKeys(faker.name().username()+"@gmail.com");
		submitField.click();
        Assert.assertTrue(submittedMessage.getText().equals("Thanks for submitting!"));
	}
	public void FillOutApplicationWithConstantsData() {

		firstNameField.sendKeys(ApplicationConstants.firstname);
		lastNameField.sendKeys(ApplicationConstants.lastname);
		phoneNumberField.sendKeys(ApplicationConstants.phonenumber);
		dobField.sendKeys(ApplicationConstants.dob);
		ssnField.sendKeys(ApplicationConstants.ssn);
		emailField.sendKeys(ApplicationConstants.email);
		submitField.click();
		Assert.assertTrue(submittedMessage.getText().equals("Thanks for submitting!"));
	}
	public void FillOutApplicationWithExcelData(int row) {
		int col = 0;
		firstNameField.sendKeys(excelUtil.getCellData(row,col++));
		lastNameField.sendKeys(excelUtil.getCellData(row,col++));
		phoneNumberField.sendKeys(excelUtil.getCellData(row,col++));
		dobField.sendKeys(excelUtil.getCellData(row,col++));
		ssnField.sendKeys(excelUtil.getCellData(row,col++));
		emailField.sendKeys(excelUtil.getCellData(row,col++));

		Assert.assertTrue(submittedMessage.getText().equals("Thanks for submitting!"));


	}


}
