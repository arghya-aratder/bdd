package runners;


import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty","html:target/htmlReport.html"
				,"json:target/cucumber-reports/Cucumber.json"
				},
            features = "./src/test/resource/features",
            glue = {"com.ndtv.qa.glue"}
		)

public class TestRunner {
	


}
