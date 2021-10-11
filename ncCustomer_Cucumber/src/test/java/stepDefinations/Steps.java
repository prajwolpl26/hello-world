package stepDefinations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.LoginPage;

public class Steps 
{
	public WebDriver driver;
	public LoginPage lp;
	@Given("^User Launch Chrome browser$")
	public void user_Launch_Chrome_browser()  
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Driver/chromedriver");
	    driver = new ChromeDriver();
	    lp= new LoginPage(driver);
	    
	}

	@When("^User opens URL \"([^\"]*)\"$")
	public void user_opens_URL(String url)  
	{
	   driver.get(url); 
	}

	@When("^User enters Email as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
	public void user_enters_Email_as_and_Password_as(String email, String password)  
	{
		lp.setUserName(email);
		lp.setPassword(password);
	    
	}

	@When("^Click on Login$")
	public void click_on_Login()  
	{
		lp.clickLogin();
	    
	}

	@Then("^page Title should be \"([^\"]*)\"$")
	public void page_Title_should_be(String tittle)  
	{
		if(driver.getPageSource().contains("Wrong email"))
		{
			driver.close();
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertEquals(tittle, "Dashboard / nopCommerce adminstration");
		}
	   
	}

	@When("^User click on Log out link$")
	public void user_click_on_Log_out_link() throws InterruptedException  {
		lp.clickLogout();
		
		Thread.sleep(3000);
	   
	}

	@Then("^close browser$")
	public void close_browser()  {
		driver.quit();
	    
	}


}
