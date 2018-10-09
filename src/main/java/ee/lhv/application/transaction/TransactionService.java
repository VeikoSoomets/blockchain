package ee.lhv.application.transaction;

import ee.lhv.application.blockchain.BlockchainService;
import ee.lhv.domain.transaction.Transaction;
import java.math.BigDecimal;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Resource
    BlockchainService blockchainService;

    public Transaction addTransaction(String sender, String recipient, BigDecimal amount) {
        Transaction transaction = new Transaction(sender, recipient, amount);
        blockchainService.getBlockchain().getTransactions().add(transaction);
        return transaction;
    }
}
