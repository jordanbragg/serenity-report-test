package reporting.test;

import net.thucydides.core.annotations.Step;
import static org.junit.Assert.*;

/**
 * Created by jbragg on 3/3/16.
 */
public class TestSteps {

    @Step("Given name {0}")
    public void given_name(String name){
        assertNotNull(name);
    }

    @Step("When ask name {0} question")
    public void when_name_asked_question(String name){
        assertNotNull(name);
    }

    @Step("Then given description {0}")
    public void then_description_provided(String description){
        assertNotNull(description);
    }
}
