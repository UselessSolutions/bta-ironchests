package net.brokenmoon.afloydironchest.blocks;

import net.brokenmoon.afloydironchest.MixinInterfaces.IEntityPlayer;
import net.brokenmoon.afloydironchest.tileEntities.TileEntityBigChest;
import net.brokenmoon.afloydironchest.tileEntities.TileEntityIronChest;
import net.minecraft.core.block.BlockTileEntityRotatable;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.EntityItem;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.player.inventory.IInventory;
import net.minecraft.core.world.World;

import java.util.Random;

public class IronChest extends BlockTileEntityRotatable {

    Random random = new Random();
    public IronChest(String key, int id, Material blockMaterial){
        super(key,id, blockMaterial);
    }

    @Override
    public void onBlockAdded(World world, int x, int y, int z) {
        super.onBlockAdded(world, x, y, z);
        this.setDefaultDirection(world, x, y, z);
    }

    @Override
    public void onBlockRemoved(World world, int x, int y, int z, int data) {
        TileEntityBigChest te = (TileEntityBigChest)world.getBlockTileEntity(x, y, z);
        for (int l = 0; l < te.getSizeInventory(); ++l) {
            ItemStack itemstack = te.getStackInSlot(l);
            if (itemstack == null) continue;
            float f = this.random.nextFloat() * 0.8f + 0.1f;
            float f1 = this.random.nextFloat() * 0.8f + 0.1f;
            float f2 = this.random.nextFloat() * 0.8f + 0.1f;
            while (itemstack.stackSize > 0) {
                int i1 = this.random.nextInt(21) + 10;
                if (i1 > itemstack.stackSize) {
                    i1 = itemstack.stackSize;
                }
                itemstack.stackSize -= i1;
                EntityItem entityitem = new EntityItem(world, (float)x + f, (float)y + f1, (float)z + f2, new ItemStack(itemstack.itemID, i1, itemstack.getMetadata()));
                float f3 = 0.05f;
                entityitem.xd = (float)this.random.nextGaussian() * f3;
                entityitem.yd = (float)this.random.nextGaussian() * f3 + 0.2f;
                entityitem.zd = (float)this.random.nextGaussian() * f3;
                world.entityJoinedWorld(entityitem);
            }
        }
        super.onBlockRemoved(world, x, y, z, data);
    }
    @Override
    public boolean blockActivated(World world, int x, int y, int z, EntityPlayer entityplayer) {
        IInventory chest = (TileEntityBigChest)world.getBlockTileEntity(x, y, z);
        if (!world.isClientSide) {
            this.displayGui(entityplayer, chest);
        }
        return true;
    }

    @Override
    protected TileEntity getNewBlockEntity() {
        return new TileEntityIronChest();
    }

    public void displayGui(EntityPlayer player, IInventory inventory){
        ((IEntityPlayer)player).displayGUIIronChest(inventory);
    }
}
