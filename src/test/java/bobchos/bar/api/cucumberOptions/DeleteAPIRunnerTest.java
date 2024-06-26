package bobchos.bar.api.cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features/bobchos-bar-api/DeleteOrder.feature",
plugin="json:target/jsonReports/cucumber-report.json",glue= {"bobchos.bar.api.stepdefinition"},
tags= "@DeleteOrderAPI",dryRun=false)
public class DeleteAPIRunnerTest {

}
