package net.brokenmoon.afloydironchest.mixin.Entity;

import net.brokenmoon.afloydironchest.blocks.IronChest;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.entity.TileEntityTrommel;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.player.inventory.IInventory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(value = TileEntityTrommel.class,remap = false)
public class MixinTileEntityTrommel extends TileEntity {
    @Inject(method = "sieveItem(I)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/world/World;getBlockId(III)I", shift = At.Shift.BY, by = 2), locals = LocalCapture.CAPTURE_FAILSOFT, cancellable = true)
    private void addIronChestToTrommel(int slotIndex, CallbackInfo ci, ItemStack itemResult, int xOffset, int zOffset, int meta, int adjacentId){
        IInventory chest = null;
        if (Block.blocksList[adjacentId] instanceof IronChest) {
            chest = (IInventory) worldObj.getBlockTileEntity(this.xCoord + xOffset, this.yCoord, this.zCoord + zOffset);
        }
        if (chest != null) {
            ItemStack slot;
            int i;
            for (i = 0; i < chest.getSizeInventory(); ++i) {
                slot = chest.getStackInSlot(i);
                if (slot == null || slot.itemID != itemResult.itemID || slot.getMetadata() != itemResult.getMetadata()) continue;
                while (slot.stackSize + 1 <= slot.getMaxStackSize()) {
                    ++slot.stackSize;
                    chest.setInventorySlotContents(i, slot);
                    if (itemResult.stackSize <= 0) {
                        ci.cancel();
                        return;
                    }
                    --itemResult.stackSize;
                }
            }
            if (itemResult.stackSize <= 0) {
                ci.cancel();
                return;
            }
            for (i = 0; i < chest.getSizeInventory(); ++i) {
                slot = chest.getStackInSlot(i);
                if (slot != null) continue;
                chest.setInventorySlotContents(i, itemResult);
                ci.cancel();
                return;
            }
        }
    }
}
