package reporting.spring;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.junit.spring.integration.SpringIntegrationClassRule;
import net.serenitybdd.junit.spring.integration.SpringIntegrationMethodRule;
import net.thucydides.core.annotations.Steps;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import reporting.test.TestSteps;

/**
 * Created by jbragg on 3/10/16.
 */
@RunWith(SerenityRunner.class)
@ContextConfiguration(classes = {})
public class FailedSpringWiring {

   @Steps
   private TestSteps testSteps;

   @ClassRule
   public static SpringIntegrationClassRule springIntegration = new SpringIntegrationClassRule();

   @Rule
   public SpringIntegrationMethodRule springIntegrationMethodRule = new SpringIntegrationMethodRule();

   @Test
   public void verify_test_actually_gets_run(){
      testSteps.given_name("test");
      testSteps.when_name_asked_question("John");
      testSteps.then_description_provided("Hello");
   }
}
