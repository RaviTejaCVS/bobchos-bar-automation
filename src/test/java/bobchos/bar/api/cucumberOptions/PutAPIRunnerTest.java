package bobchos.bar.api.cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features/bobchos-bar-api/PutOrder.feature",
plugin="json:target/jsonReports/cucumber-report.json",glue= {"bobchos.bar.api.stepdefinition"},
tags= "@PutOrderAPI",dryRun=false)
public class PutAPIRunnerTest {

}
