package wojtek.com;


import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MyStories1Scenario {

    private String result;

    // scenario for story1
    @Given("story1 scenario")
    public void givenASampleScenario() {
        // Set up your scenario
    }

    @When("a good")
    public void whenIPerformAnAction() {
        // Perform the action
        result = "Action performed";
    }

    @Then("I shall be happy")
    public void thenTheResultShouldBeAsExpected() {
        // Verify the result
        assertEquals("Action performed", result);
    }


    // scenario for story11
    @Given("story11 scenario")
    public void givenASampleScenario11() {
        // Set up your scenario
    }

    @When("a good story11")
    public void whenIPerformAnAction11() {
        // Perform the action
        result = "Action performed";
    }

    @Then("I shall be happy story11")
    public void thenTheResultShouldBeAsExpected11() {
        // Verify the result
        assertEquals("Action performed", result);
    }

}
