package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home extends BasePage {

	public Home(WebDriver driver) {
		super(driver);
	}

	// Elements
	@FindBy(xpath = "//div[contains(@class,'container__main borrow--homeloan')]//div[2]//div[1]//div[1]//div[1]//input[1]")
	WebElement annualIncome;

	@FindBy(xpath = "//div[1]//div[2]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]//div[1]//div[2]//div[1]//div[2]//div[1]//input[1]")
	WebElement annualOtherIncome;
	
	@FindBy(xpath="//input[@id='expenses']")  
	WebElement monthlyLivingExpenses;
	
	@FindBy(xpath="//input[@id='otherloans']")
	WebElement otherLoanRepayments;

	@FindBy(xpath="//input[@id='credit']")
	WebElement totalCreditCardLimit;                 
	
	@FindBy(xpath="//button[@id='btnBorrowCalculater']")
	WebElement button;
	
	@FindBy(xpath="//span[@id='borrowResultTextAmount']")  
	WebElement borrowEstimate;
	@FindBy(xpath="//button[contains(text(),'Start over')]//span[contains(@class,'icon icon_restart')]")
	WebElement startOver;
	
	
	// Action Methods
	public void sendAnnualIncome() {
		annualIncome.sendKeys("80000");
	}

	public void sendAnnualOtherIncome() {
		annualOtherIncome.sendKeys("10000");
	}
	
	public void sendMonthlyLivingExpenses()   
	{
		monthlyLivingExpenses.sendKeys("500");            
	}
	public void sendOtherLoanRepayments() {              
		 otherLoanRepayments.sendKeys("100");
	}
	public void sendTotalCreditCardLimits()   
	{
		 totalCreditCardLimit.sendKeys("10000");            
	}
	public void clickButton() {            
		 button.click();
	}
	public void getBorrowEstimate()    
	{
		System.out.println("The borrow estimate of this user is:" +borrowEstimate.getText());            
	}
	
	
	public void clickStartOver()
	{
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		jsExecutor.executeScript("arguments[0].click();",startOver);
	}
	
	public boolean clearForm() {
		
		return button.isDisplayed();
	}
	
	
}
