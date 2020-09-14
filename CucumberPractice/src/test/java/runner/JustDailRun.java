package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features="src/test/java/feature/justdail.feature", glue="steps", monochrome = true )

public class JustDailRun extends AbstractTestNGCucumberTests
{

}
