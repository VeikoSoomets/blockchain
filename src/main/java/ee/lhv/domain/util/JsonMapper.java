package ee.lhv.domain.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ee.lhv.domain.block.Block;
import ee.lhv.domain.transaction.Transaction;

public class JsonMapper {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String getJson(Block block) {
        String transactions = "";
        for (Transaction transaction: block.getTransactions()) {
            transactions += JsonMapper.getJson(transaction.getAmount()) + JsonMapper.getJson(transaction.getRecipient()) +
                    JsonMapper.getJson(transaction.getSender());
        }
        return JsonMapper.getJson(block.getIndex()) + JsonMapper.getJson(block.getPreviousHash()) +
                JsonMapper.getJson(block.getProof()) + JsonMapper.getJson(block.getTimestamp()) + transactions;
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
