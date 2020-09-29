package com.example.contract

import com.example.state.IOUState
import com.example.state.ItemState
import net.corda.core.contracts.CommandData
import net.corda.core.contracts.Contract
import net.corda.core.contracts.requireSingleCommand
import net.corda.core.contracts.requireThat
import net.corda.core.transactions.LedgerTransaction

/**
 * A implementation of a basic smart contract in Corda.
 *
 * This contract enforces rules regarding the creation of a valid [IOUState], which in turn encapsulates an [IOUState].
 *
 * For a new [IOUState] to be issued onto the ledger, a transaction is required which takes:
 * - Zero input states.
 * - One output state: the new [IOUState].
 * - An Create() command with the public keys of both the lender and the borrower.
 *
 * All contracts must sub-class the [Contract] interface.
 */
class ItemContract : Contract {
    companion object {
        val ID = "com.example.contract.ItemContract"
    }

    override fun verify(tx: LedgerTransaction) {
        val command = tx.commands.requireSingleCommand<Commands.Create>()
        val out = tx.outputsOfType<ItemState>().single()
        "price should be more "
        val outState = out.price
        command.signers.containsAll(out.participants.map { it.owningKey })
        TODO("Not yet implemented")
    }

    interface Commands : CommandData {
        class Create : Commands
    }
}
