package stepDefinitions;

import java.time.Duration;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Home;

public class steps {
     WebDriver driver;
     Home hp;
     public Logger logger; //for logging
     public ResourceBundle rb; // for reading properties file
     public String br; //to store browser name


    @Before
    public void setup()    
    {
        //for logging
       logger= LogManager.getLogger(this.getClass());
        //Reading config.properties (for browser)
        rb=ResourceBundle.getBundle("config");
        br=rb.getString("browser");                
    }

    @After
    public void quit() {
       driver.quit();
    }

    @Given("User Launch browser")
    public void user_launch_browser() {
        if(br.equals("chrome"))
        {
           driver=new ChromeDriver();
        }
        else if (br.equals("firefox")) {
            driver = new FirefoxDriver();
        }
        else if (br.equals("edge")) {
            driver = new EdgeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Given("opens URL {string}")
    public void opens_url(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }
    
    @When("user enters required details")
    public void user_enters_required_details() {
        hp=new Home(driver);
        hp.sendAnnualIncome();
        hp.sendAnnualOtherIncome();
        hp.sendMonthlyLivingExpenses();
        hp.sendOtherLoanRepayments();
        hp.sendTotalCreditCardLimits();
        logger.info("user entered all the details");
              
    }

    @When("click on estimate button")
    public void click_on_estimate_button() {
    	 hp.clickButton();
    	 logger.info("user clicked on estimate button");
    }

    @Then("user should see the borrowing estimate")
    public void user_should_see_the_borrowing_estimate() throws InterruptedException {
    	Thread.sleep(5000);
    	 hp.getBorrowEstimate();  
        logger.info("user is able to see his borrowing estimate");	 
    }


    @When("click the start over button")
    public void click_the_button( ) {
        hp.clickStartOver();
        logger.info("user clicked on start over button");
    }

    @Then("the form should be cleared")
    public void the_form_should_be_cleared() throws InterruptedException {
    	
     boolean res= hp.clearForm();
     if(res)
     {
    	 System.out.println("The form is cleared");
     }
     else
     {
    	 System.out.println("The form is not cleared");
     }
    }
    
    
}

