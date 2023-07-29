package aws.lambda;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.services.lambda.model.InvokeResult;
import com.intuit.karate.Logger;
import com.intuit.karate.core.ScenarioEngine;
import grpc.GrpcDriver;

import java.nio.charset.StandardCharsets;

public class LambdaDriver {

    private static final LambdaDriver INSTANCE = new LambdaDriver();

    private final AWSLambda awsLambda;

    private LambdaDriver() {
        try {
            awsLambda = AWSLambdaClientBuilder.defaultClient();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Logger logger() {
        ScenarioEngine engine = ScenarioEngine.get();
        return engine.logger;
    }

    // the logging will appear in the html report for grpc.feature
    public static String invoke(String functionName, String payload) {
        Logger logger = logger();
        logger.debug("aws lambda call start");
        logger.debug("=====================");
        logger.debug(">> invoke: {}", functionName);
        InvokeRequest invokeRequest = new InvokeRequest().withFunctionName(functionName).withPayload(payload);
        InvokeResult result = INSTANCE.awsLambda.invoke(invokeRequest);
        String ans = new String(result.getPayload().array(), StandardCharsets.UTF_8);
        logger.debug("<< response: {}", ans);
        return ans;
    }
}
