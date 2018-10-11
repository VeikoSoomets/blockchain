package ee.lhv.domain.block;

import ee.lhv.domain.transaction.Transaction;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * This is the block component which holds an index, a timestamp (in Unix time), a list of transactions, a proof and the hash of the
 * previous block.
 *
 * @author Veiko Soomets
 */
@Getter
@Setter
public class Block {
    private int index;
    private long timestamp;
    private List<Transaction> transactions;
    private long proof;
    private String previousHash;

    public Block() {}

    public Block(int index, List<Transaction> transactions, long proof, String previousHash) {
        this.index = index;
        this.transactions = transactions;
        this.proof = proof;
        this.previousHash = previousHash;
        this.timestamp = LocalDateTime.now().atZone(ZoneId.systemDefault()).toEpochSecond();
    }
}
