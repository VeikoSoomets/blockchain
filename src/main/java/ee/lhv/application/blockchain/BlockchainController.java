package ee.lhv.application.blockchain;

import ee.lhv.application.chain.ChainService;
import ee.lhv.application.transaction.TransactionService;
import ee.lhv.domain.block.Block;
import ee.lhv.domain.chain.Chain;
import ee.lhv.domain.transaction.Transaction;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlockchainController {
    @Resource
    BlockchainService blockchainService;
    @Resource
    TransactionService transactionService;
    @Resource
    ChainService chainService;

    // TODO: Should be implemented
    @GetMapping("/mine")
    public Block mine() {
        return null;
    }

    @GetMapping("/nodes/resolve")
    public void resolveConsensus() throws URISyntaxException {
        chainService.resolveConflicts();
    }

    @GetMapping("/transactions")
    public List<Transaction> getTransactions() {
        return transactionService.getTransactions();
    }

    @PostMapping("/transactions/new")
    public Transaction addTransaction(@RequestBody Map<String, String> body) {
        return transactionService.addTransaction(body.get("sender"), body.get("recipient"), new BigDecimal(body.get("amount")));
    }

    @GetMapping("/chain")
    public Chain getChain() {
        return blockchainService.getBlockchain().getChain();
    }
}
