## samples-java/basic-cordapps

This folder features basic sample projects, each of them demonstrates low level cordapp functionalities, such [RPC connection](https://docs.corda.net/docs/corda-os/api-rpc.html#api-rpc-operations), messaging, etc.

### [cordapp-example](./cordapp-example):
A simple exploratory sample for the official [Corda online training](https://training.corda.net).

### [database access](./flow-database-access):
This CorDapp provides a simple example of how the node database can be accessed within flows. In this case, the flows maintain a table of cryptocurrency values in the node's database.

### [http access](./flow-http-access):
This CorDapp provides a simple example of how HTTP requests can be made in flows. In this case, the flow makes an HTTP request to retrieve the original BitCoin readme from GitHub.

### [ping](./ping-pong):
This CorDapp allows a node to ping any other node on the network that also has this CorDapp installed.  

### [rpc node info](./rpc-nodeinfo):
Allows one to get some rudimentary information about a running Corda node via RPC

### [spring-webserver](./spring-webserver):
This project defines a simple [Spring webserver](https://spring.io/projects/spring-boot#overview) that connects to a Corda node via [RPC](https://docs.corda.net/docs/corda-os/api-rpc.html#api-rpc-operations). 

### [yo cordapp](./yo-cordapp):
Send Yo's! to all your friends running Corda nodes!





