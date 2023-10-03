package net.brokenmoon.afloydironchest.gui;

import net.minecraft.core.InventoryAction;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.player.inventory.Container;
import net.minecraft.core.player.inventory.IInventory;
import net.minecraft.core.player.inventory.slot.Slot;

import java.util.List;

public class ContainerWideChest extends Container {
    private IInventory inventory;
    private int numberOfRowsUpper;

    public ContainerWideChest(IInventory lowerInventory, IInventory upperInventory) {
        this.inventory = upperInventory;
        this.numberOfRowsUpper = upperInventory.getSizeInventory() / 12;
        //Upper
        for (int j = 0; j < this.numberOfRowsUpper; ++j) {
            for (int i1 = 0; i1 < 12; ++i1) {
                this.addSlot(new Slot(upperInventory, i1 + j * 12, 8 + i1 * 18, 8 + j * 18));
            }
        }
        //Lower
        for (int k = 0; k < 3; ++k) {
            for (int j1 = 0; j1 < 9; ++j1) {
                this.addSlot(new Slot(lowerInventory, j1 + k * 9 + 9, 8 + 18 + 9 + j1 * 18, 174 + k * 18));
            }
        }
        //Taskbar
        for (int l = 0; l < 9; ++l) {
            this.addSlot(new Slot(lowerInventory, l, 8 + 18 + 9 + l * 18, 232));
        }
    }

    @Override
    public List<Integer> getMoveSlots(InventoryAction inventoryAction, Slot slot, int i, EntityPlayer entityPlayer) {
        return null;
    }

    @Override
    public List<Integer> getTargetSlots(InventoryAction inventoryAction, Slot slot, int i, EntityPlayer entityPlayer) {
        return null;
    }

    @Override
    public boolean isUsableByPlayer(EntityPlayer entityplayer) {
        return this.inventory.canInteractWith(entityplayer);
    }
}