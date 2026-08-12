package net.brokenmoon.afloydironchest.blocks;

import net.brokenmoon.afloydironchest.MixinInterfaces.IEntityPlayer;
import net.brokenmoon.afloydironchest.tileEntities.TileEntityBigChest;
import net.brokenmoon.afloydironchest.tileEntities.TileEntityIronChest;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicRotatable;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.EntityItem;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.ItemStack;

import net.minecraft.core.player.inventory.container.Container;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import net.minecraft.core.world.pos.TilePosc;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class IronChest extends BlockLogicRotatable {

    Random random = new Random();

    public IronChest(Block<?> block, Material material) {
        super(block, material);
        block.withEntity(TileEntityIronChest::new);
    }

    @Override
    public void onPlacedByWorld(@NotNull World world, @NotNull TilePosc tilePos) {
        super.onPlacedByWorld(world, tilePos);
       // setDefaultDirection(world, tilePos);
    }

    @Override
    public void onRemoved(World world, @NotNull TilePosc tilePos, int data) {
        TileEntityBigChest te = (TileEntityBigChest)world.getTileEntity(tilePos);
        for (int l = 0; l < te.getContainerSize(); ++l) {
            ItemStack itemstack = te.getItem(l);
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
                EntityItem entityitem = new EntityItem(world, (float)tilePos.x() + f, (float)tilePos.y() + f1, (float)tilePos.z() + f2, new ItemStack(itemstack.itemID, i1, itemstack.getMetadata()));
                float f3 = 0.05f;
                entityitem.xd = (float)this.random.nextGaussian() * f3;
                entityitem.yd = (float)this.random.nextGaussian() * f3 + 0.2f;
                entityitem.zd = (float)this.random.nextGaussian() * f3;
                world.entityJoinedWorld(entityitem);
            }
        }
        super.onRemoved(world, tilePos, data);
    }

    @Override
    public boolean onInteracted(World world, @NotNull TilePosc tilePosc, @NotNull Player player, Side side, double xHit, double yHit) {
        Container chest = (TileEntityBigChest)world.getTileEntity(tilePosc);
        if (!world.isClientSide) {
            this.displayGui(player, chest);
        }
        return true;
    }

    public void displayGui(Player player, Container inventory){
        ((IEntityPlayer)player).afloydironchest$displayGUIIronChest(inventory);
    }
}
