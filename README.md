# Getting Started
RabbitMQ is required to run this demo. It can be installed as container using following command:

    docker run -d --hostname my-rabbit --name some-rabbit -p 8088:15672 -p 5672:5672 rabbitmq:3-management

With this  RabbitMQ management console will be available on 
http://localhost:8088
Default user name and password will be:  
User name:guest  
Password: guest 

For non default configuration, please update application.properties file.

Run sprint boot application. Navigate to http://localhost:8080/

Follow the instructions given on page


### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/maven-plugin/reference/html/#build-image)
* [Spring for RabbitMQ](https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/reference/htmlsingle/#boot-features-amqp)
* [WebSocket](https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/reference/htmlsingle/#boot-features-websockets)

### Guides
The following guides illustrate how to use some features concretely:

* [Messaging with RabbitMQ](https://spring.io/guides/gs/messaging-rabbitmq/)
* [Using WebSocket to build an interactive web application](https://spring.io/guides/gs/messaging-stomp-websocket/)

