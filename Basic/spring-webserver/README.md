# Spring webserver

This project defines a simple [Spring webserver](https://spring.io/projects/spring-boot#overview) that connects to a Corda node via [RPC](https://docs.corda.net/docs/corda-os/api-rpc.html#api-rpc-operations).


# Structure:

The Spring web server is defined in the `server` module, and has two parts:

* `src/main/resources/static`, which defines the webserver's frontend
* `src/main/kotlin/net/corda/server`, which defines the webserver's backend

The backend has two controllers, defined in `server/src/main/kotlin/net/corda/server/Controller.kt`:

* `StandardController`, which provides generic (non-CorDapp specific) REST endpoints
* `CustomController`, which the user can extend to provide CorDapp-specific REST endpoints

# Pre-requisites:

See https://docs.corda.net/getting-set-up.html.

# Usage

## Running the nodes:

See https://docs.corda.net/tutorial-cordapp.html#running-the-example-cordapp.

* Windows: `./gradlew deployNodes` then `./build/nodes/runnodes`
* Unix: `gradlew.bat deployNodes` then `.\build\nodes\runnodes.bat`

## Running the webservers:

Once the nodes are running, there are several ways to run the webservers. All these approaches 
read their properties from the `src/main/resources/application.properties` file:

* `server.port`, which defines the HTTP port the webserver listens on
* `config.rpc.*`, which define the RPC settings the webserver uses to connect to the node

### With Gradle:

You can start the webserver for Party A using Gradle:

* Windows: `gradlew.bat server-java:runPartyAServer` or `gradlew.bat server-kotlin:runPartyAServer`
* Unix: `./gradlew server-java:runPartyAServer` or `./gradlew server-kotlin:runPartyAServer`

### As a self-contained JAR:

You can convert the webserver for Party A into a runnable JAR using:

* Windows: `gradlew.bat server-java:bootJar` or `gradlew.bat server-kotlin:bootJar`
* Unix: `./gradlew server-java:bootJar` or `./gradlew server-kotlin:bootJar`

And run the webserver using:

    java -jar server-<java/kotlin>/build/libs/corda-webserver.jar

### With IntelliJ

You can also start the webserver for Party A using the `Run PartyA Server` IntelliJ run configuration.

## Interacting with the nodes:

Once the nodes are started, you can access the node's frontend at the following address:

    localhost:10055

And you can access the REST endpoints at:

    localhost:10055/[ENDPOINT]

For example, you can check the node's status using:

    localhost:10055/status
