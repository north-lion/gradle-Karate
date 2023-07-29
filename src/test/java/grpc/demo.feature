Feature: Grpc Test Sample
# Ref: https://github.com/karatelabs/karate-examples/tree/main/grpc/src/test/java/karate

Background:
    # ---------------------------------------------------------------------------------------------------------
    # Use Java Class Directly Pattern
    # ---------------------------------------------------------------------------------------------------------
    * def HelloClient = Java.type('grpc.HelloClient')
    * def client = new HelloClient('localhost', 6565)

    # ---------------------------------------------------------------------------------------------------------
    # Use Java Class Indirectly Pattern
    # ---------------------------------------------------------------------------------------------------------
    # If GrpcTestDriver is initialized on karate-condig.js and return value 'Grpc', You don't need define this.

Scenario: Use Java Class Directly Pattern
    * def result = client.hello('world')
    * match result == 'Hello world'
    * client.shutdown()

Scenario: Use Java Class Indirectly Pattern
    * match Grpc.hello('world') == 'Hello world'
