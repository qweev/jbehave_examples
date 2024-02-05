package wojtek.com;


import org.jbehave.core.annotations.Configure;
import org.jbehave.core.annotations.UsingEmbedder;
import org.jbehave.core.annotations.UsingSteps;
import org.jbehave.core.configuration.AnnotationBuilder;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.parsers.RegexPrefixCapturingPatternParser;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.ParameterConverters;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import static org.jbehave.core.reporters.Format.*;

@Configure(storyLoader = ExampleOfAnnotatedEmbedderConf.MyStoryLoader.class, storyReporterBuilder = ExampleOfAnnotatedEmbedderConf.MyReportBuilder.class,
        parameterConverters = { ExampleOfAnnotatedEmbedderConf.MyDateConverter.class })
@UsingEmbedder(embedder = Embedder.class, generateViewAfterStories = true, ignoreFailureInStories = true, ignoreFailureInView = true, verboseFailures = true,
        threads = 1, metaFilters = "-skip")
@UsingSteps(instances = { MyStories1Scenario.class, MyStories2Scenario.class  })
public class ExampleOfAnnotatedEmbedderConf {

    // !!!
    // other way to create runner for tests, but more complicated, use better example in MyJBehaveUnitConf
    // !!!

    private Embedder embedder;

    public ExampleOfAnnotatedEmbedderConf(){
        embedder = new AnnotationBuilder(this.getClass()).buildEmbedder();
    }

    @Test
    public void run() {
        embedder.runStoriesAsPaths(Arrays.asList(
                "wojtek/com/stories/myStory1.story",
                "wojtek/com/stories/myStory2.story"
                // Add more story paths as needed
        ));
    }

    public static class MyReportBuilder extends StoryReporterBuilder {
        public MyReportBuilder() {
            this.withFormats(CONSOLE,  HTML).withDefaultFormats();
        }
    }

    public static class MyStoryLoader extends LoadFromClasspath {
        public MyStoryLoader() {
            super(ExampleOfAnnotatedEmbedderConf.class.getClassLoader());
        }
    }

    public static class MyRegexPrefixCapturingPatternParser extends RegexPrefixCapturingPatternParser {
        public MyRegexPrefixCapturingPatternParser() {
            super("%");
        }
    }

    public static class MyDateConverter extends ParameterConverters.DateConverter {
        public MyDateConverter() {
            super(new SimpleDateFormat("yyyy-MM-dd"));
        }
    }

}
