Feature: aws lambda Test Sample

Background:
    * def dirPath = karate.properties['user.dir']
    * def inputPath = '/src/test/resources/input/'

Scenario: Invoke Lambda
    * def payload = karate.readAsString('file:' + dirPath + inputPath + 'payload.json')
    * print payload
    * def result = Lambda.invoke('functionName', payload)
