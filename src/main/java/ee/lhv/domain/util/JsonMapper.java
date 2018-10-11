package ee.lhv.domain.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ee.lhv.domain.block.Block;
import ee.lhv.domain.transaction.Transaction;

/**
 * JsonMapper component is responsible for generating JSON out of the block component.
 *
 * @author Veiko Soomets
 */
public class JsonMapper {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String getJson(Block block) {
        String transactions = "";
        StringBuilder transactionsJSON = new StringBuilder();
        for (Transaction transaction: block.getTransactions()) {
            transactionsJSON.append(JsonMapper.getJson(transaction.getAmount()) + JsonMapper.getJson(transaction.getRecipient()) +
                                    JsonMapper.getJson(transaction.getSender()));
        }
        return JsonMapper.getJson(block.getIndex()) + JsonMapper.getJson(block.getPreviousHash()) +
               JsonMapper.getJson(block.getProof()) + JsonMapper.getJson(block.getTimestamp()) + transactionsJSON.toString();
    }

    private static String getJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
