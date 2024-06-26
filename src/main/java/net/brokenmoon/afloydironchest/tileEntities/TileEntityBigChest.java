package net.brokenmoon.afloydironchest.tileEntities;

import com.mojang.nbt.ListTag;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.entity.TileEntityChest;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.player.inventory.IInventory;
import com.mojang.nbt.CompoundTag;
import net.minecraft.core.player.inventory.InventorySorter;

public abstract class TileEntityBigChest extends TileEntityChest implements IInventory {
    protected ItemStack[] contents;

    @Override
    public int getSizeInventory() {
        return contents.length;
    }

    @Override
    public ItemStack getStackInSlot(int i) {
        return this.contents[i];
    }

    @Override
    public ItemStack decrStackSize(int i, int j) {
        if (this.contents[i] != null) {
            ItemStack itemstack1;
            if (this.contents[i].stackSize <= j) {
                itemstack1 = this.contents[i];
                this.contents[i] = null;
                this.onInventoryChanged();
                return itemstack1;
            } else {
                itemstack1 = this.contents[i].splitStack(j);
                if (this.contents[i].stackSize == 0) {
                    this.contents[i] = null;
                }

                this.onInventoryChanged();
                return itemstack1;
            }
        } else {
            return null;
        }
    }

    @Override
    public void setInventorySlotContents(int i, ItemStack itemStack) {
        this.contents[i] = itemStack;
        if (itemStack != null && itemStack.stackSize > this.getInventoryStackLimit()) {
            itemStack.stackSize = this.getInventoryStackLimit();
        }

        this.onInventoryChanged();
    }

    @Override
    public String getInvName() {
        return "Big Chest";
    }

    public void readFromNBT(CompoundTag nbttagcompound) {
        super.readFromNBT(nbttagcompound);
        ListTag nbttaglist = nbttagcompound.getList("Items");
        this.contents = new ItemStack[this.getSizeInventory()];

        for(int i = 0; i < nbttaglist.tagCount(); ++i) {
            CompoundTag nbttagcompound1 = (CompoundTag)nbttaglist.tagAt(i);
            int j = nbttagcompound1.getByte("Slot") & 255;
            if (j >= 0 && j < this.contents.length) {
                this.contents[j] = ItemStack.readItemStackFromNbt(nbttagcompound1);
            }
        }

    }

    public void writeToNBT(CompoundTag nbttagcompound) {
        super.writeToNBT(nbttagcompound);
        ListTag nbttaglist = new ListTag();

        for(int i = 0; i < this.contents.length; ++i) {
            if (this.contents[i] != null) {
                CompoundTag nbttagcompound1 = new CompoundTag();
                nbttagcompound1.putByte("Slot", (byte)i);
                this.contents[i].writeToNBT(nbttagcompound1);
                nbttaglist.addTag(nbttagcompound1);
            }
        }

        nbttagcompound.putList("Items", nbttaglist);
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        if (this.worldObj.getBlockTileEntity(this.x, this.y, this.z) != this) {
            return false;
        } else {
            return entityPlayer.distanceToSqr((double)this.x + 0.5, (double)this.y + 0.5, (double)this.z + 0.5) <= 64.0;
        }
    }
    public void sortInventory(){
        InventorySorter.sortInventory(this.contents);
    }
}
