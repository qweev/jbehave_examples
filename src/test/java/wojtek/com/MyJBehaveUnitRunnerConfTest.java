package wojtek.com;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.junit.JUnit4StoryRunner;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

import static org.jbehave.core.reporters.Format.*;


@RunWith(JUnit4StoryRunner.class)
public class MyJBehaveUnitRunnerConfTest extends JUnitStories {
// this is runner for tests in MyStories1Scenario and myStory1.story etc...
// must end with Test in class name to be recognized correctly by mvn test goal

    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
                .useStoryReporterBuilder(new StoryReporterBuilder().withFormats( CONSOLE, HTML, STATS));
        //
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        // add here tests scenarios java files
        return new InstanceStepsFactory(configuration(),
                new MyStories1Scenario(),
                new MyStories2Scenario(),
                new MyStories3ScenarioWithParams(),
                new MyStories3ScenarioWithTableParams()
        );
    }

    @Override
    public List<String> storyPaths() {

        return Arrays.asList(
                "wojtek/com/stories/myStory1.story",
                "wojtek/com/stories/myStory2.story",
                "wojtek/com/stories/myStory3withParams.story",
                "wojtek/com/stories/myStory3withTableParams.story"
                // Add more story paths as needed
        );
    }

}
