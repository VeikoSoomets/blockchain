package ee.lhv.application.chain;

import java.net.URISyntaxException;
import org.springframework.stereotype.Service;

@Service
public class ChainService {
    public boolean resolveConflicts() throws URISyntaxException {
        return false;
    }
}
