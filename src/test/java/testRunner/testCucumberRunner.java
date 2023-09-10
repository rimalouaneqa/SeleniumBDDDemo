package testRunner;
import org.junit.platform.suite.api.*;
import org.junit.platform.suite.api.IncludeEngines;
import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
@ConfigurationParameter(key = FEATURES_PROPERTY_NAME, value = "classpath:feature")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "StepDefinitions")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, json:target/cucumber-reports/Cucumber.json," +
        "junit:target/cucumber-reports/Cucumber.xml," +
        "html:target/cucumber-reports/report.html")
public class testCucumberRunner {
}
