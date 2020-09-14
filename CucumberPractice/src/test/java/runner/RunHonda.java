package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features="src/test/java/feature/HondBike.feature", glue="stpes", monochrome = true)
public class RunHonda extends AbstractTestNGCucumberTests 
{

}
 