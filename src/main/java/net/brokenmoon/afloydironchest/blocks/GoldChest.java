package net.brokenmoon.afloydironchest.blocks;

import net.brokenmoon.afloydironchest.tileEntities.TileEntityGoldChest;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;

public class GoldChest extends IronChest {
    public GoldChest(String key, int id, Material blockMaterial){
        super(key,id, blockMaterial);
    }
    @Override
    protected TileEntity getNewBlockEntity() {
        return new TileEntityGoldChest();
    }
}
