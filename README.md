# DAR_Academy_Backend_Java

1) I created and configured post-discovery-server project for Eureka Discovery Service at the port 8010

2) I created and configured post-api-gateway project for API Gateway at the port 8082

3) Previously created post-core-api project have been configurated as Eureka Clint by editing configuration at application properties. 
Also, implemented dynamic port generation for creating several replicas of these post-core-api application

4) The performance of the project can be checked  using GET request at PostMan: http://localhost:8082/post-core-api/post/check. It will also indicate the port number at which application run.
