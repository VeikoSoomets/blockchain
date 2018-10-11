package ee.lhv.domain.blockchain;

import ee.lhv.domain.block.Block;
import ee.lhv.domain.chain.Chain;
import ee.lhv.domain.transaction.Transaction;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * Central component for holding the chain (which contains all the blocks). It will store transactions that will be added to the next block
 * and it also has some helper methods for adding new blocks and nodes to the chain.
 *
 * @author Veiko Soomets
 */
@Getter
@Setter
@Component
public class Blockchain {
    private Chain chain;
    private List<Transaction> transactions;

    public Blockchain() {
        chain = new Chain();
        initTransactions();
        // When our Blockchain is instantiated we’ll need to seed it with a genesis block
        Block block = new Block(1, getTransactions(), 100,"1");
        getChain().addBlock(block);
    }

    public void initTransactions() {
        transactions = new ArrayList<>();
    }
}
