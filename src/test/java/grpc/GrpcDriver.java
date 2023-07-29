package grpc;

import com.intuit.karate.Logger;
import com.intuit.karate.core.ScenarioEngine;

public class GrpcDriver {
    private static final GrpcDriver INSTANCE = new GrpcDriver();

    private final HelloClient client;

    private GrpcDriver() {
        try {
            client = new HelloClient("localhost", 6565);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Logger logger() {
        ScenarioEngine engine = ScenarioEngine.get();
        return engine.logger;
    }

    // the logging will appear in the html report for grpc.feature
    public static String hello(String message) {
        Logger logger = logger();
        logger.debug("grpc call to hello()");
        logger.debug("====================");
        logger.debug(">> hello: {}", message);
        String result = INSTANCE.client.hello(message);
        logger.debug("<< hello: {}", result);
        return result;
    }
}
