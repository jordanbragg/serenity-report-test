package reporting.test;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = "data/test.csv")
@Narrative(text = {"As a user", "I want to ask for a description", "In order to do a test"})
public class TestReportWithParameterTest {

    @Steps
    TestSteps testSteps;
    @Managed
    public WebDriver driver;

    private String name;
    private String description;

    @Qualifier
    public String getQualifier() {
        return description;
    }

    @Test
    public void name_responds_with_description() {
        testSteps.given_name(name);
        testSteps.when_name_asked_question(name);
        testSteps.then_description_provided(description);
    }
}
