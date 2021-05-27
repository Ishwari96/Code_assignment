# Code_assignment
Client expenses

We have 2 different springboot applications :

**Client** SpringBoot service which holds client data (id, name).

Endpoints exposed:
POST /client → create a user
GET /client/{clientId} → show the name of the client
GET /client/{clientId}/expenses/total → show a total of all the expenses of the client

**Expenses** SpringBoot service which holds expenses information for all clients (date, amount spent).

Endpoints exposed:
POST /expense → create an expense record
GET /expense/client/{clientId} → return a list of all the expenses for a clien

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

Client app will run on port 9000 and Expenses on 9001. We need both the services running for each response.

Once both the services are up and running, you can run curl or postman to get the response which will accept JSON body
As mentioned earlier similler paths we can follow for both the sevices

**POST**  http://localhost:9000/client and requestBody JSON for Client Service (Client Id is auto generated) 

{
"name" : "stefan",
"emailId": "stefan@kees"
}

**POST** http://localhost:9001/expense and requestBody JSON for Expense service (Expense Id is auto generated) 

{
"clientId": 1,
"amountSpent" : 5000,
"date": "26/05/2021"
}

**GET** http://localhost:9000/client/1

**GET** http://localhost:9000/client/1/expenses/total

**GET** http://localhost:9001/expense/client/1

Use swagger to test application using below URL
```
http://localhost:9000/swagger-ui.html#/client-controller
http://localhost:9001/swagger-ui.html#/expense-controller
```

## Copyright

Released under the Apache License 2.0. See the [LICENSE](https://github.com/codecentric/springboot-sample-app/blob/master/LICENSE) file.
