package directionalredstonetest.datagen;

import net.minecraft.data.client.BlockStateVariant;
import net.minecraft.data.client.VariantSettings;
import net.minecraft.util.Identifier;

public class ModelUtils {
    public static BlockStateVariant y(BlockStateVariant variant, int degrees) {
        return variant.put(VariantSettings.Y, switch (degrees) {
            case 0 -> VariantSettings.Rotation.R0;
            case 90 -> VariantSettings.Rotation.R90;
            case 180 -> VariantSettings.Rotation.R180;
            case 270 -> VariantSettings.Rotation.R270;
            default -> throw new IllegalStateException(
                    "degrees must be inincrements of 90, starting from 0, no greater then 270, not: " + degrees
            );
        });
    }
    public static BlockStateVariant y(int degrees) {
        return y(BlockStateVariant.create(), degrees);
    }
    public static BlockStateVariant model(BlockStateVariant variant, Identifier model) {
        return variant.put(VariantSettings.MODEL, model);
    }
    public static BlockStateVariant model(Identifier id) {
        return model(BlockStateVariant.create(), id);
    }
}
