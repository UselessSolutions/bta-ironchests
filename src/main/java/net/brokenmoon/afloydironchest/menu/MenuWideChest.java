package net.brokenmoon.afloydironchest.menu;

import net.minecraft.core.InventoryAction;
import net.minecraft.core.entity.player.Player;


import net.minecraft.core.player.inventory.container.Container;
import net.minecraft.core.player.inventory.menu.MenuAbstract;
import net.minecraft.core.player.inventory.slot.Slot;

import java.util.List;

public class MenuWideChest extends MenuAbstract {
    private final Container inventory;
    private final int numberOfRowsUpper;

    public MenuWideChest(Container lowerInventory, Container upperInventory) {
        this.inventory = upperInventory;
        this.numberOfRowsUpper = upperInventory.getContainerSize() / 12;
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
    public List<Integer> getMoveSlots(InventoryAction action, Slot slot, int target, Player player) {
        int chestSize = this.numberOfRowsUpper * 12;
        if (slot.index >= 0 && slot.index < chestSize) {
            return this.getSlots(0, chestSize, false);
        }
        if (action == InventoryAction.MOVE_ALL) {
            if (slot.index >= chestSize && slot.index < chestSize + 27) {
                return this.getSlots(chestSize, 27, false);
            }
            if (slot.index >= chestSize + 27 && slot.index < chestSize + 36) {
                return this.getSlots(chestSize + 27, 9, false);
            }
        } else if (slot.index >= chestSize && slot.index < chestSize + 36) {
            return this.getSlots(chestSize, 36, false);
        }
        return null;
    }

    @Override
    public List<Integer> getTargetSlots(InventoryAction action, Slot slot, int target, Player player) {
        int chestSize = this.numberOfRowsUpper * 12;
        if (slot.index < chestSize) {
            return this.getSlots(chestSize, 36, true);
        }
        return this.getSlots(0, chestSize, false);
    }

    @Override
    public boolean stillValid(Player entityplayer) {
        return this.inventory.stillValid(entityplayer);
    }
}