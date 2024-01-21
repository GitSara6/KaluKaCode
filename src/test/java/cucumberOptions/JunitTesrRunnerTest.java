package cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(features= "src\\test\\java\\features", glue ="stepDefinations", monochrome=true, dryRun=false,
plugin= {"pretty", "html:target/saraReport.html", "json:target/safraReport.json", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class JunitTesrRunnerTest {

}
