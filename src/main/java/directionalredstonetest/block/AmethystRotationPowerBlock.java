package directionalredstonetest.block;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class AmethystRotationPowerBlock extends DirectionalPowerBlock {

    public AmethystRotationPowerBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        stack = stack.copy();
        if (!stack.isOf(Items.AMETHYST_SHARD))
            return ItemActionResult.FAIL;
        if (world.isClient())
            return ItemActionResult.SUCCESS;
        stack.decrement(1);
        player.setStackInHand(hand, stack);
        BlockState newState = state.cycle(FACING);
        world.setBlockState(pos, newState);
        updatePowerFromState(state, newState, pos, world);
        return ItemActionResult.CONSUME;
    }

}
