package Org.stepdefinition;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Sample.feature", glue = "Org.stepdefinition", monochrome = true, dryRun = false)
public class TestRunnerclass 
{

}
