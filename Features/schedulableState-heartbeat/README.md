# Heartbeat CorDapp

This CorDapp is a simple showcase of [scheduled activities](https://docs.corda.net/docs/corda-os/event-scheduling.html#how-to-implement-scheduled-events) (i.e. activities started by a node at a specific time without
direct input from the node owner).

A node starts its com.heartbeat by calling the `StartHeartbeatFlow`. This creates a `HeartState` on the ledger. This 
`HeartState` has a scheduled activity to start the `HeatbeatFlow` one second later.

When the `HeartbeatFlow` runs one second later, it consumes the existing `HeartState` and creates a new `HeartState`. 
The new `HeartState` also has a scheduled activity to start the `HeatbeatFlow` in one second.

In this way, calling the `StartHeartbeatFlow` creates an endless chain of `HeartbeatFlow`s one second apart.

# Pre-requisites:
  
See https://docs.corda.net/getting-set-up.html.

# Usage

## Running the nodes:

See https://docs.corda.net/tutorial-cordapp.html#running-the-example-cordapp.

Kotlin use the `contracts-kotlin:deployNodes` task and `./contracts-kotlin/build/nodes/runnodes` script.

## Interacting with the nodes:

Go to the [CRaSH](https://docs.corda.net/docs/corda-os/shell.html) shell for PartyA, and run the `StartHeatbeatFlow`:

    start StartHeartbeatFlow

If you now start monitoring the node's flow activity...

    flow watch

...you will see the `Heartbeat` flow running every second until you close the Flow Watch window using `ctrl/cmd + c`:

    xxxxxxxx-xxxx-xxxx-xx Heartbeat xxxxxxxxxxxxxxxxxxxx Lub-dub