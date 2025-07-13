package net.brokenmoon.afloydironchest.tileEntities;

import com.mojang.nbt.tags.CompoundTag;
import com.mojang.nbt.tags.ListTag;
import net.brokenmoon.afloydironchest.IronChestMain;
import net.minecraft.core.block.entity.TileEntityChest;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.ItemStack;

import net.minecraft.core.player.inventory.InventorySorter;
import net.minecraft.core.player.inventory.container.Container;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.Nullable;

public abstract class TileEntityBigChest extends TileEntityChest implements Container {
    protected ItemStack[] contents;

    @Override
    public int getContainerSize() {
        return contents.length;
    }

    @Override
    public @Nullable ItemStack getItem(int index) {
        return this.contents[index];
    }

    @Override
    public @Nullable ItemStack removeItem(int index, int takeAmount) {
        if (this.contents[index] != null) {
            ItemStack itemstack1;
            if (this.contents[index].stackSize <= takeAmount) {
                itemstack1 = this.contents[index];
                this.contents[index] = null;
                this.setChanged();
                return itemstack1;
            } else {
                itemstack1 = this.contents[index].splitStack(takeAmount);
                if (this.contents[index].stackSize == 0) {
                    this.contents[index] = null;
                }

                this.setChanged();
                return itemstack1;
            }
        } else {
            return null;
        }
    }

    @Override
    public void setItem(int i, ItemStack itemStack) {
        this.contents[i] = itemStack;
        if (itemStack != null && itemStack.stackSize > this.getMaxStackSize()) {
            itemStack.stackSize = this.getMaxStackSize();
        }

        this.setChanged();
    }

    @Override
    public String getNameTranslationKey() {
        return "container."+ IronChestMain.MOD_ID +".bigChest";
    }

    public void readFromNBT(CompoundTag nbttagcompound) {
        super.readFromNBT(nbttagcompound);
        ListTag nbttaglist = nbttagcompound.getList("Items");
        this.contents = new ItemStack[this.getContainerSize()];

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
    public int getMaxStackSize() {
        return 64;
    }

    @Override
    public boolean stillValid(Player entityPlayer) {
        if (this.worldObj.getTileEntity(this.x, this.y, this.z) != this) {
            return false;
        } else {
            return entityPlayer.distanceToSqr((double)this.x + 0.5, (double)this.y + 0.5, (double)this.z + 0.5) <= 64.0;
        }
    }

    @Override
    public void sortContainer() {
        InventorySorter.sortInventory(this.contents);
    }

    @Override
    public boolean canBeCarried(World world, Entity potentialHolder) {
        return true;
    }
}
