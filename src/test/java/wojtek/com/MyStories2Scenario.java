package wojtek.com;


import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MyStories2Scenario {

    private String result;

    // scenario for story2
    @Given("story2 scenario")
    public void givenASampleScenario() {
        // Set up your scenario
    }

    @When("a good story2")
    public void whenIPerformAnAction() {
        // Perform the action
        result = "Action performed";
    }

    @Then("I shall story2")
    public void thenTheResultShouldBeAsExpected() {
        // Verify the result
        assertEquals("Action performed", result);
    }



}
