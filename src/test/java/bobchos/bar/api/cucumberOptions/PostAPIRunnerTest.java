package bobchos.bar.api.cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features/bobchos-bar-api/PostOrder.feature",
plugin="json:target/jsonReports/cucumber-report.json", glue = {"classpath:bobchos/bar/api/stepdefinition"},
tags= "@PostOrderAPI",dryRun=false)
public class PostAPIRunnerTest {

}
