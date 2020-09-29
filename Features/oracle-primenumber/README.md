# corda oracle examples

This CorDapp implements an [oracle service](https://training.corda.net/corda-details/oracles) that allows nodes to:

* Request the Nth prime number
* Request the oracle's signature to prove that the number included in their transaction is actually the Nth prime
  number

Whilst the functionality is superfluous (as primes can be verified deterministically via the contract code), this
CorDapp is a simple example of how to structure an oracle service that provides querying and signing abilities. In the
real world, oracles would instead provide and sign statements about stock prices, exchange rates, and other data.



## Concepts

This repo is split into three CorDapps:

1. A [base CorDapp](./base-kotlin/src/main/kotlin/net/corda/examples/oracle/base/flow) which includes the state and contract definition, as well as some utility flows that need to be
   shared by both the Oracle service and the client
2. A client CorDapp which [implements a flow](./client-kotlin/src/main/kotlin/net/corda/examples/oracle/client/flow/CreatePrime.kt) to create numbers involving oracle-validated prime numbers
3. A [service](./service-kotlin/src/main/kotlin/net/corda/examples/oracle/service) which implements the primes oracle


## Usage


### Pre-requisites:

See https://docs.corda.net/getting-set-up.html.


### Deploy and run the node
```
./greadlew deployNodes
./build/node/runnodes
```

Go to the [CRaSH](https://docs.corda.net/docs/corda-os/shell.html) shell for PartyA, and request the 5th prime from the oracle using the `CreatePrime` flow:

    flow start CreatePrime index: 5

We can then see the state wrapping the 5th prime (11) in our vault by running:

    run vaultQuery contractStateType: net.corda.examples.oracle.base.contract.PrimeState

