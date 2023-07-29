package grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.examples.helloworld.GreeterGrpc;
import io.grpc.examples.helloworld.HelloReply;
import io.grpc.examples.helloworld.HelloRequest;

import java.util.concurrent.TimeUnit;

public class HelloClient {
    private final ManagedChannel channel;
    private final GreeterGrpc.GreeterBlockingStub stub;

    HelloClient(ManagedChannel channel) {
        this.channel = channel;
        stub = GreeterGrpc.newBlockingStub(channel);
    }

    public HelloClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port)
                // channels are secure by default (SSL / TLS)
                // we use plaintext to avoid needing certificates
                .usePlaintext()
                .build());
    }

    public String hello(String message) {
        HelloReply resp = stub.sayHello(HelloRequest.newBuilder().setName(message).build());
        return resp.getMessage();
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }
}
