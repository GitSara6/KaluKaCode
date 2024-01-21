package stepDefinations;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utills.TestContextSetup;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class hooks {
	TestContextSetup testContextSetup;
	
	public hooks(TestContextSetup testContextSetup)
	{
	this.testContextSetup=testContextSetup;
	}
	@AfterStep
	
	public void takeScreenshots(Scenario scenario) throws IOException
	{
		if (scenario.isFailed())
		{
		
			File sourcePath=((TakesScreenshot)testContextSetup.driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
			scenario.attach(fileContent, "image/png", "Image");
		}
	}
	
}
