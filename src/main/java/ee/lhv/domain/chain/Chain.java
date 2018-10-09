package ee.lhv.domain.chain;

import ee.lhv.domain.block.Block;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Chain {
    private List<Block> blocks;

    public Chain() {
        blocks = new ArrayList<>();
    }

    public Chain(List<Block> blocks) {
        this.blocks = blocks;
    }

    public void addBlock(Block block) {
        blocks.add(block);
    }

    public boolean isValidBlock() {
        return false;
    }
}
