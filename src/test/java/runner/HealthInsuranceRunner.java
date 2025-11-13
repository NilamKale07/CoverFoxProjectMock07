package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
(features = {
		"D:\\clone_Nilam\\CoverFoxProjectMock07\\src\\test\\resources\\CoverfoxFeature\\CoverfoxHelthPlan.feature"	 
		},

		glue = { "stepDefinitions","hooks" }, 
		plugin = {"pretty","html:target/Cucumber-reports/reports.html"}, publish = true,
		dryRun=false)

public class HealthInsuranceRunner extends AbstractTestNGCucumberTests {

}
