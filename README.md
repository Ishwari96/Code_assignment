# Code_assignment
Client expenses

Create a Clients SpringBoot service. It holds client data (id, name).
Endpoints exposed:
POST /client → create a user
GET /client/{id} → show the name of the client
GET /client/{id}/expenses/total → show a total of all the expenses of the client

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.client.clients.ClientsApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```
If you want to access the app from outside your local workspace, you have to expose the springboot-sample-app service:

```shell
oc expose springboot-sample-app --hostname=www.example.com
```
## Getting started

Once application is up and running, you can run curl or postman to get the response or

Use swagger to test application using below URL

```
http://localhost:9000/swagger-ui.html#/
```

## Copyright

Released under the Apache License 2.0. See the [LICENSE](https://github.com/codecentric/springboot-sample-app/blob/master/LICENSE) file.
