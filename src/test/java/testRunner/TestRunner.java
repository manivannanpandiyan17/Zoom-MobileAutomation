package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
//@ExtendedCucumberOptions(jsonReport = "target/rerun/cucumber.json", jsonUsageReport = "target/rerun/cucumber-usage.json", usageReport = true, detailedReport = true, detailedAggregatedReport = true, overviewReport = true, overviewChartsReport = true, pdfPageSize = "A4 Landscape", toPDF = true, outputFolder = "target/rerun", retryCount = 1)
@CucumberOptions(features = "classpath:Zoom.feature", glue = { "stepDefinition", "testRunner", "commonLibrary" }, plugin = {
		"pretty", "html:src/test/resources/reports/cucumber-reports.html" }, monochrome = true)

public class TestRunner extends AbstractTestNGCucumberTests {
}
