package step_definitions;

import org.junit.runner.RunWith;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptionList;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
//import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;


@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions (
		jsonReport = "target/cucumber.json",
        retryCount = 0,
        detailedReport=true,
        detailedAggregatedReport=true,
        overviewReport=true	,
        coverageReport = true,
//        excludeCoverageTags = {"@flaky" },
//        includeCoverageTags = {"@passed" },
        reportPrefix = "dry-run",           
        outputFolder = "target"
        		//jsonReport = "target/cucumber.json",
//              toPDF = true,
//              knownErrorsReport = true,
//              knownErrorsConfig = "src/test/resources/known-errors-source/sample_model.json",
		)
@CucumberOptions(
		features = {"classpath:features"},
		glue = "classpath:step_definitions",
		plugin ={"html:target/cucumber-html-report", "json:target/cucumber.json", "pretty:target/cucumber-pretty.txt", "usage:target/cucumber-usage.json",
        "junit:target/cucumber-results.xml"},
			
			monochrome = true
		     
	//	{"pretty", "html:target/cucumber"},
		//dryRun=true,
			//Here in tags we will define tags with which scenario has to execute and which are not
//		tags = {"@SmokeTest,@RegressionTest",}
		)
public class RunCukesTest extends AbstractTestNGCucumberTests{
	
}

