# confluent-kafka-sb-demo-project
This is a demo application which helps in understanding of how messaging in Kafka works.
You have to configure and create Kafka Cluster using Confluent Cloud to work with this project.

WORKING:
There are 2 spring boot applications :
- KafkaProducerApplication:
    The Producer application produces data to the Kafka Cluster in the form of User object.
    It runs on the port 8080 and the endpoint http://localhost:8080/api/kafka/publish
    can be accessed to send data to the required topic in the Kafka Cluster using the POST method.
    The User Object should be in following JSON format in the body -
    {
      "id":101,
      "firstName":"Dnyanesh",
      "lastName":"Fegade"
    }
- KafkaConsumerApplication:
    The Consumer Application consumes the data from the required topic from the Kafka Cluster and logs it.
    It then saves the consumed data to a DynamoDB database on AWS.
    It runs on port 8083
CONFIGURATION :
(Please setup a Kafka Cluster on Confluent and generate Api key to access the topics from our Spring Boot Client Applications)
Also create a dynamoDB table named user_table on AWS.

- Producer Application has following Environment variables to be passed before running
  KAFKA_SERVER=123.456.123:9092              //The host id of the Kafka server
  CLUSTER_API_KEY=xyz                        //The API key for the cluster
  CLUSTER_API_SECRET=xyz                     //The SECRET KEY for the CLuster
  JSON_TOPIC=demo-topic                      //The topic from which data has to be consumed
- 
  KAFKA_SERVER=123.456.123:9092              //The host id of the Kafka server
  CLUSTER_API_KEY=xyz                        //The API key for the cluster
  CLUSTER_API_SECRET=xyz                     //The SECRET KEY for the CLuster
  JSON_TOPIC=demo-topic                      //The topic from which data has to be consumed
  GROUP_ID=myGroup                           //Group id
  SERVICE_ENDPOINT=dynamodb.region.amazonaws.com   //Replace the region with the region where your dynamoDB database is hosted
                                                  // Example: dynamodb.ap-south-1.amazonaws.com 
  SERVICE_REGION=ap-south-1    // The region where your dynamoDB database is hosted
  SERVICE_ACCESS_KEY=xyz       // The service access key for your AWS account (Configure the reqired IAM Permissions)
  SERVICE_SECRET_ACCESS_KEY=xyz //The secret access key for your AWS account
