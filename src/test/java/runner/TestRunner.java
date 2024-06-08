 package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "./Features/AddNewCust.feature",
		glue="stepDefinations",
		dryRun = false,
		monochrome = true,
		publish = true,
		tags = "@Valid"
	
		
		
		
		)
public class TestRunner {

}
