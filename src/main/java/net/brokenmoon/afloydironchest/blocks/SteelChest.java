package net.brokenmoon.afloydironchest.blocks;

import net.brokenmoon.afloydironchest.MixinInterfaces.IEntityPlayer;
import net.brokenmoon.afloydironchest.tileEntities.TileEntitySteelChest;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.player.inventory.IInventory;

public class SteelChest extends IronChest{
    public SteelChest(String key, int id, Material blockMaterial) {
        super(key, id, blockMaterial);
    }
    @Override
    protected TileEntity getNewBlockEntity() {
        return new TileEntitySteelChest();
    }
    public void displayGui(EntityPlayer player, IInventory inventory){
        ((IEntityPlayer)player).afloydironchest$displayGUIDiamondChest(inventory);
    }
}
