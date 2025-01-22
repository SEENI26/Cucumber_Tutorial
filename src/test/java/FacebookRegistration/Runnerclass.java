package FacebookRegistration;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/FbRegistration.feature", 
glue = "FacebookRegistration", 
dryRun = false,
monochrome = true,
snippets = CucumberOptions.SnippetType.CAMELCASE,
plugin = { "html:target/Reports/cucumber-reports.html",
}
)
public class Runnerclass {

}
