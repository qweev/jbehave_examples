package wojtek.com;


import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MyStories3ScenarioWithParams {

    private String result;
    private int value;

    // scenario for story2
    @Given("story3 params scenario")
    public void givenASampleScenario() {
        // Set up your scenario
    }

    @When("a good story3 has value $two and $three") // params can be fetched from story step with $
    public void whenIPerformAnAction(int two, int three) {
        // Perform the action
        System.out.println("!!!!!!! 2 = " + two);
        System.out.println("!!!!!!! 3 = " + three);
        value = two + three;
        result = "Action performed";
    }

    @Then("I shall story3 make of value $five maybe $six") // params name fetching order can be changed with using @Named
    public void thenTheResultShouldBeAsExpected(@Named("six") int sixOtherName, @Named("five") int fiveOtherName) {
        // Verify the result
        System.out.println("!!!!!!! 6 = " + sixOtherName);
        System.out.println("!!!!!!! 5 = " + fiveOtherName);
        assertEquals("Action performed", result);
        assertEquals(fiveOtherName, value);
    }



}
