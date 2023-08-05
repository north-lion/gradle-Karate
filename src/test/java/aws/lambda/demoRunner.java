package aws.lambda;

import com.intuit.karate.junit5.Karate;
import org.junit.jupiter.api.BeforeAll;

public class demoRunner {

    @BeforeAll
    static void beforeAll() {
        System.setProperty("karate.env", "local");
    }

    @Karate.Test
    Karate testFeature() {
        /** Single Feature Test */
        return Karate.run("classpath:aws/lambda/demo.feature");
    }
}
