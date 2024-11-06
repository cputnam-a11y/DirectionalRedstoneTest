package directionalredstonetest.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class DirectionalPowerBlock extends Block {
    public static final DirectionProperty FACING = DirectionProperty.of("facing", Direction.NORTH, Direction.WEST, Direction.SOUTH, Direction.EAST);

    public DirectionalPowerBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(FACING, Direction.NORTH));
    }

    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        return getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing());
    }

    @Override
    protected int getStrongRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        return direction == state.get(FACING)
               ? 15
               : 0;
    }

    @Override
    protected int getWeakRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        return direction == state.get(FACING)
               ? 15
               : 0;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(FACING);
    }

    @Override
    protected boolean emitsRedstonePower(BlockState state) {
        return true;
    }

    protected void updatePowerFromState(BlockState oldState, BlockState newState, BlockPos pos, World world) {
        this.updateNeighbors(world, pos);
        world.updateListeners(pos, oldState, newState, Block.NOTIFY_ALL);
    }
    private void updateNeighbors(World world, BlockPos pos) {
        world.updateNeighborsAlways(pos, this);
        for (Direction dir : FACING.getValues())
            world.updateNeighborsAlways(pos.offset(dir), this);
    }
}
