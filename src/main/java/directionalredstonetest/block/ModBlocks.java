package directionalredstonetest.block;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import static directionalredstonetest.DirectionalRedstoneTest.id;

public class ModBlocks {
    public static final Block DIRECTIONAL_POWER_BLOCK = registerWithItem("directional_power_block", new DirectionalPowerBlock(Block.Settings.copy(Blocks.STONE)));

    public static <T extends Block> T registerWithItem(String name, T block) {
        Registry.register(Registries.ITEM, id(name), new BlockItem(block, new Item.Settings()));
        return register(name, block);
    }

    public static <T extends Block> T register(String name, T block) {
        return Registry.register(Registries.BLOCK, id(name), block);
    }
    public static void init() {}
}
