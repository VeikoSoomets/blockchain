package ee.lhv.application.blockchain;

import ee.lhv.domain.block.Block;
import ee.lhv.domain.blockchain.Blockchain;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class BlockchainService {
    @Resource
    Blockchain blockchain;

    public Blockchain getBlockchain() {
        return blockchain;
    }

    public Block addBlock(long proof, String previousHash) {
        Block block = new Block(blockchain.getChain().getBlocks().size() + 1,
                                blockchain.getTransactions(),
                                proof,
                                previousHash);
        // Every time we add a block we need to reset the list of transactions that will be put to the next block
        blockchain.initTransactions();
        blockchain.getChain().addBlock(block);
        return block;
    }
}
