import co.paralleluniverse.fibers.Suspendable
import com.example.contract.ItemContract
import com.example.state.ItemState
import net.corda.core.contracts.Command
import net.corda.core.flows.FinalityFlow
import net.corda.core.flows.FlowLogic
import net.corda.core.flows.InitiatingFlow
import net.corda.core.flows.StartableByRPC
import net.corda.core.identity.Party
import net.corda.core.transactions.SignedTransaction
import net.corda.core.transactions.TransactionBuilder

@InitiatingFlow
@StartableByRPC
class MyExampleFlow(
        val otherParty: Party
) : FlowLogic<Void>() {
    @Suspendable
    override fun call(): Void {
        val notary = serviceHub.networkMapCache.notaryIdentities[0]
        val outputState = ItemState(10, "", otherParty)
        /*ourIdentity*/
        /* signers are set py this*/
        /* Flow logic has reference to owingKey */
        /* set signers of command */
        val command = Command(
                ItemContract.Commands.Create(),
                ourIdentity.owningKey)
        val txBuilder = TransactionBuilder(notary = notary)
                .addOutputState(outputState, ItemContract.ID) // ItemContract should be specified
                .addCommand(command) // add command
        val signedTx = serviceHub.signInitialTransaction(txBuilder)
        /* otherPartySession */
        val otherPartySession = initiateFlow(otherParty)
        /* subFlow */
        subFlow(FinalityFlow(signedTx, otherPartySession))
        TODO("Not yet implemented")
    }
}