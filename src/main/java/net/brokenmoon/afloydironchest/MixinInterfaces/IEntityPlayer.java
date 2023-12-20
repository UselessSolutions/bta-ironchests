package net.brokenmoon.afloydironchest.MixinInterfaces;

import net.minecraft.core.player.inventory.IInventory;

public interface IEntityPlayer {
    void displayGUIIronChest(IInventory iinventory);

    void displayGUIDiamondChest(IInventory iinventory);
}
