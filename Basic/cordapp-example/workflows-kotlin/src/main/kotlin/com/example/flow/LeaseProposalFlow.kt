import co.paralleluniverse.fibers.Suspendable
import com.example.contract.ItemContract
import com.example.flow.ExampleFlow
import com.example.state.IOUState
import com.example.state.ItemState
import net.corda.core.contracts.Command
import net.corda.core.contracts.Requirements.using
import net.corda.core.contracts.requireThat
import net.corda.core.flows.*
import net.corda.core.identity.Party
import net.corda.core.transactions.SignedTransaction
import net.corda.core.transactions.TransactionBuilder

@InitiatingFlow
@StartableByRPC
class LeaseProposalFlow(
        val otherParty: Party
        /* TODO: Can pass price table as argument. */
) : FlowLogic<Void>() {
    @Suspendable
    override fun call(): Void {
        /* TODO: can call lesser only */
        /* TODO: can store price table to state. Price table state can be referred to later to
         *  check validity of contract. */
        TODO("not implemented yet")
    }
}

@InitiatedBy(ExampleFlow.Initiator::class)
class Acceptor(val otherPartySession: FlowSession) : FlowLogic<SignedTransaction>() {
    @Suspendable
    override fun call(): SignedTransaction {
        /* TODO: Check validity of proposal. */
        /* TODO-skip: Check that Flow is called by leasee */
        TODO("not implemented yet")
    }
}