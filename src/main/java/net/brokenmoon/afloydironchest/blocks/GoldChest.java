package net.brokenmoon.afloydironchest.blocks;

import net.brokenmoon.afloydironchest.tileEntities.TileEntityGoldChest;
import net.brokenmoon.afloydironchest.tileEntities.TileEntityIronChest;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;

public class GoldChest extends IronChest {
    public GoldChest(Block<?> block, Material material) {
        super(block, material);
        block.withEntity(TileEntityGoldChest::new);
    }
}
