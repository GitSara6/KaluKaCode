package stepDefinations;

import io.cucumber.java.en.Given;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.en.When;
import utills.TestContextSetup;

public class LandingPageStepDefination {
	public WebDriver driver;
	public  String LandingPageProductName;

	TestContextSetup testContextSetup;
	
	public LandingPageStepDefination(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
	}

	@Given("user is on GreenCart Landing Page")
	public void user_is_on_green_cart_landing_page() {
		testContextSetup.driver= new ChromeDriver();
		testContextSetup.driver.manage().window().maximize();
		testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		testContextSetup.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	}
	@When("user searched with shortname {string} and extracted actual name of product")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
		testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
	    Thread.sleep(2000);
	    testContextSetup.LandingPageProductName = testContextSetup.driver.findElement(By.cssSelector("h4[class='product-name']")).getText().split("-")[0].trim();
	  Thread.sleep(2000);
	   System.out.println(testContextSetup.LandingPageProductName);
	}
	
	
}
