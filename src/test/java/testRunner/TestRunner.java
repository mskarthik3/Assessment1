package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
        (
               
                features= {".//Features/Calculator.feature"},
                glue="stepDefinitions",
                plugin= {"pretty",
                        "html:reports/myreport.html",
                        "json:reports/myreport.json",
                       
                },
                dryRun=false,
                monochrome=true
           
        )

public class TestRunner {

}

