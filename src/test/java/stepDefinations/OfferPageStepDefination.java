package stepDefinations;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utills.TestContextSetup;

public class OfferPageStepDefination {

	public String OfferPageProductName;
	TestContextSetup testContextSetup;
	
	public OfferPageStepDefination(TestContextSetup testContextSetup)
	{
	this.testContextSetup=testContextSetup;
	}

	
	@Then("user searched for {string} shortname in offers page")
	public void user_searched_for_shortname_in_offers_page(String shortName) throws InterruptedException {
		
		switchToOffersPage();
		testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		 Thread.sleep(2000);
		
		
		 OfferPageProductName= testContextSetup.driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr/td[1]")).getText();
		 Thread.sleep(2000);
		 System.out.println(OfferPageProductName);
	} 
	public void switchToOffersPage() throws InterruptedException
	{
		testContextSetup.driver.findElement(By.linkText("Top Deals")).click();
		 Thread.sleep(2000);
		 Set<String> s1= testContextSetup.driver.getWindowHandles();
		Iterator<String> i1=s1.iterator();
		String ParentWindow= i1.next();
		String ChildWindow= i1.next();
		testContextSetup.driver.switchTo().window(ChildWindow);
	}
	
	@And("validates product name in offers page matches with landing page")
	public void validates_product_name_in_offers_page_matches_with_landing_page() {
		Assert.assertEquals(testContextSetup.LandingPageProductName, OfferPageProductName);
		
		
		
	   
	}
	@After()
	public void CloseURL()
	{
		testContextSetup.driver.quit();
	}
	
}
