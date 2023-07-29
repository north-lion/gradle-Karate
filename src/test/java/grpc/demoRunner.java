package grpc;

import com.intuit.karate.junit5.Karate;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class demoRunner {

    @BeforeAll
    static void beforeAll() {
        System.setProperty("karate.env", "local");
    }

    @Karate.Test
    Karate testFeature() {
        /** If you want Parallel Test, use below code
         * Ref: https://note.com/shift_tech/n/n2588d2826f60
         *
        Results results = Runner.path("classpath:grpc/demo.feature").parallel(1);
        assertEquals(0, results.getFailCount(), results.getErrorMessages());
         */

        /** Test All in Package
        Karate run() { return Karate.run().relativeTo(getClass());
         */

        /** Single Feature Test */
        return Karate.run("classpath:grpc/demo.feature");
    }
}
