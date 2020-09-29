package com.example.state

import com.example.contract.ItemContract
import net.corda.core.contracts.BelongsToContract
import net.corda.core.contracts.LinearState
import net.corda.core.contracts.UniqueIdentifier
import net.corda.core.identity.AbstractParty
import net.corda.core.identity.Party


/**
 * The state object recording Lease Item.
 *
 * @param price the price of Item.
 * @param kind the kind of item
 * */
@BelongsToContract(ItemContract::class)
data class ItemState(
        val price: Int,
        val kind: String,
        val lender: Party,
        override val linearId: UniqueIdentifier = UniqueIdentifier()
) : LinearState {
    override val participants: List<AbstractParty>
        get() = listOf(lender)
}