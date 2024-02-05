package wojtek.com;


import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MyStories3ScenarioWithTableParams {

    private String result;

    // scenario for story3 table params
    @Given("story33 table params scenario")
    public void givenASampleScenario() {
        // Set up your scenario
    }

    @When("a good story33")
    public void whenIPerformAnAction() {
        // Perform the action
        result = "Action performed";
    }

    @Then("I shall $sum value $a and $b")
    public void thenTheResultShouldBeAsExpected(int sum, int a , int b) {
        // Verify the result
        int sumCounted = a+b;
        assertEquals("Action performed", result);
        assertEquals(sumCounted, sum);
    }



}
