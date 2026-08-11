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
import net.minecraft.core.world.ICarriable;
import net.minecraft.core.world.ICarrySource;
import net.minecraft.core.world.World;
import net.minecraft.core.world.pos.TilePosc;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class TileEntityBigChest extends TileEntityChest implements Container, ICarrySource {
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
    public @NotNull String getNameTranslationKey() {
        return "container."+ IronChestMain.MOD_ID +".bigChest";
    }


    public void readAdditionalData(CompoundTag nbttagcompound) {
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

    public void writeAdditionalData(@NotNull CompoundTag nbttagcompound) {
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
    public boolean stillValid(@NotNull Player entityPlayer) {
        if (this.worldObj.getTileEntity(tilePos) != this) {
            return false;
        } else {
            return entityPlayer.distanceToSqr((double)this.tilePos.x + 0.5, (double)this.tilePos.y + 0.5, (double)this.tilePos.z + 0.5) <= 64.0;
        }
    }


    public void sort() {
        InventorySorter.sortInventory(this.contents);
    }

	public @Nullable ICarriable pickup(@NotNull World world, @NotNull Entity holder, @NotNull TilePosc tilePos_) {
		return super.pickup(world, holder, tilePos_);
	}
}
