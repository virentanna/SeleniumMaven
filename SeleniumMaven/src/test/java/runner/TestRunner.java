package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="features",
		tags= "@SC04",
		glue={"stepDefinition"},
		plugin={"pretty","html:target/cucumber-html-report"}
)

public class TestRunner {

	
}
