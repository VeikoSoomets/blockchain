package ee.lhv.domain.transaction;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transaction {
    private String sender;
    private String recipient;
    private BigDecimal amount;

    public Transaction() {}

    public Transaction(String sender, String recipient, BigDecimal amount) {
        this.sender = sender;
        this.recipient = recipient;
        this.amount = amount;
    }
}
