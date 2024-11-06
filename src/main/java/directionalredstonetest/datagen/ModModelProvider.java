package directionalredstonetest.datagen;

import directionalredstonetest.block.DirectionalPowerBlock;
import directionalredstonetest.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

import static directionalredstonetest.DirectionalRedstoneTest.id;
import static directionalredstonetest.datagen.ModelUtils.*;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.blockStateCollector.accept(
                MultipartBlockStateSupplier
                        .create(ModBlocks.DIRECTIONAL_POWER_BLOCK)
                        .with(
                                When.create()
                                        .set(
                                                DirectionalPowerBlock.FACING,
                                                Direction.SOUTH
                                        ),
                                model(
                                        y(0),
                                        id("block/directional_power_block")
                                )
                        )
                        .with(
                                When.create()
                                        .set(
                                                DirectionalPowerBlock.FACING,
                                                Direction.WEST
                                        ),
                                model(
                                        y(90),
                                        id("block/directional_power_block")
                                )
                        )
                        .with(
                                When.create()
                                        .set(
                                                DirectionalPowerBlock.FACING,
                                                Direction.NORTH
                                        ),
                                model(
                                        y(180),
                                        id("block/directional_power_block")
                                )
                        )
                        .with(
                                When.create()
                                        .set(
                                                DirectionalPowerBlock.FACING,
                                                Direction.EAST
                                        ),
                                model(
                                        y(270),
                                        id("block/directional_power_block")
                                )
                        )
        );
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
    }
}
