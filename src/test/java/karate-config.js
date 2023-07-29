function fn() {
  karate.configure('connectTimeout', 5000);　// milli second
  karate.configure('readTimeout', 5000); // milli second

  // If you change karate.env, Please run code System.setProperty(karate.env) on Runner Class.
  if (karate.env == "local") {
    console.log("karate.env is local!")
  }

  return { Grpc: Java.type('grpc.GrpcDriver'), Lambda: Java.type('aws.lambda.LambdaDriver') };
}