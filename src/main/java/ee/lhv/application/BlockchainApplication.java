package ee.lhv.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"ee.lhv.application", "ee.lhv.domain"})
public class BlockchainApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlockchainApplication.class, args);
    }
}
