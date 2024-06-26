package net.brokenmoon.afloydironchest.blocks;

import net.brokenmoon.afloydironchest.MixinInterfaces.IEntityPlayer;
import net.brokenmoon.afloydironchest.tileEntities.TileEntityDiamondChest;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.player.inventory.IInventory;

public class DiamondChest extends IronChest{
    public DiamondChest(String key, int id, Material blockMaterial) {
        super(key, id, blockMaterial);
    }
    @Override
    protected TileEntity getNewBlockEntity() {
        return new TileEntityDiamondChest();
    }

    public void displayGui(EntityPlayer player, IInventory inventory){
        ((IEntityPlayer)player).afloydironchest$displayGUIDiamondChest(inventory);
    }
}
