package runners;
import cucumber.api.junit.*;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@Cucumber.Options(
        features={"src/test/java/resources"}
        ,glue={"stepDefinition"}
)
public class RunCukesTest {}
