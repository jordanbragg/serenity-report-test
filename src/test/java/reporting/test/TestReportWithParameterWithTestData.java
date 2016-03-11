package reporting.test;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.TestData;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.Collection;

@RunWith(SerenityParameterizedRunner.class)
@Narrative(text = {"As a user", "I want to ask for a description", "In order to do a test"})
public class TestReportWithParameterWithTestData {

    @TestData
    public static Collection<Object[]> testData(){
        return Arrays.asList(new Object[][]{
                {"Name1", "Desc1"},
                {"Name2", "Desc2"},
                {"Name3", "Desc3"},
                {"Name4", "Desc4"},
                {"Name5", "Desc5"}
        });
    }

    @Steps
    TestSteps testSteps;

    private String name;
    private String description;

    public TestReportWithParameterWithTestData(String name, String description){
        this.name = name;
        this.description = description;
    }

    @Qualifier
    public String getQualifier() {
        return name + "-" + description;
    }

    @Test
    public void name_responds_with_description_use_test_data() {
        testSteps.given_name(name);
        testSteps.when_name_asked_question(name);
        testSteps.then_description_provided(description);
    }

    @Test
    public void name_responds_with_description2_use_test_data() {
        testSteps.given_name(name);
        testSteps.given_name(name);
        testSteps.when_name_asked_question(name);
        testSteps.then_description_provided(description);
        testSteps.then_description_provided(description);
    }
}
