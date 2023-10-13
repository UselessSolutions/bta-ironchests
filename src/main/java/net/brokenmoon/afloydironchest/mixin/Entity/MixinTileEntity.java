package net.brokenmoon.afloydironchest.mixin.Entity;

import net.brokenmoon.afloydironchest.tileEntities.TileEntityDiamondChest;
import net.brokenmoon.afloydironchest.tileEntities.TileEntityGoldChest;
import net.brokenmoon.afloydironchest.tileEntities.TileEntityIronChest;
import net.brokenmoon.afloydironchest.tileEntities.TileEntitySteelChest;
import net.minecraft.core.block.entity.TileEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
@Mixin(value = TileEntity.class, remap = false)
public class MixinTileEntity {
    @Shadow
    private static void addMapping(Class class1, String s) {}

    static {
        addMapping(TileEntityIronChest.class, "Iron Chest");
        addMapping(TileEntityGoldChest.class, "Gold Chest");
        addMapping(TileEntityDiamondChest.class, "Diamond Chest");
        addMapping(TileEntitySteelChest.class, "Steel Chest");
    }

}
