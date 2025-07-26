package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.*;

//@RunWith(Cucumber.class)
//@CucumberOptions( 
//		features = {".\\src\\test\\java\\features\\FlightEnquiry.feature"},
//		glue = "stepDefinitions",
//		plugin = {
//		        "pretty",
//		        "html:reports/cucumber-reports/cucumber.html",
//		        "json:reports/cucumber-reports/cucumber.json",
//		        "junit:reports/cucumber-reports/cucumber.xml"
//		    },
//		    monochrome = true
//)
//public class RunnerDemo {
////	plugin = {"pretty", "html:\\reports/reports.html"}
//}

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/features/flightBooking",
    glue = {"stepDefinitions", "hooks", "setup"},
    plugin = {"pretty",  "junit:reports/junitReport.xml"},
    monochrome = true,
    dryRun = false
)
public class RunnerDemo {}