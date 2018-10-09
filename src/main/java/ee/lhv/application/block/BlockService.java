package ee.lhv.application.block;

import ee.lhv.application.blockchain.BlockchainService;
import ee.lhv.domain.block.Block;
import ee.lhv.domain.util.HashGenerator;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class BlockService {
    @Resource
    private BlockchainService blockchainService;

    public Block addBlock(long proof, String previousHash) {
        String hash = previousHash;
        if (hash == null) {
            hash = HashGenerator.createHash(getLastBlock());
        }
        return blockchainService.addBlock(proof, hash);
    }

    public Block getLastBlock() {
        List<Block> currentBlocks = blockchainService.getBlockchain().getChain().getBlocks();
        return currentBlocks.get(currentBlocks.size() - 1);
    }
}
