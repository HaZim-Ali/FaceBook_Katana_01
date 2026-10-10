package TestRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/main/resources/Features",
        glue = "StepDefinitions",
        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        tags = "@Monkey🐒"
)
public class runners extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
    @Test(dataProvider = "scenarios", invocationCount = 0)
    public void runScenario(
            PickleWrapper pickleWrapper,
            FeatureWrapper featureWrapper
    ) {

        super.runScenario(pickleWrapper, featureWrapper);
    }
}
