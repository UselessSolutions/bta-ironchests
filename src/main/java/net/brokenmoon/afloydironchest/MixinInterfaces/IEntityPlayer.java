package net.brokenmoon.afloydironchest.MixinInterfaces;

import net.minecraft.core.player.inventory.IInventory;

public interface IEntityPlayer {
    public void displayGUIIronChest(IInventory iinventory);

    public void displayGUIDiamondChest(IInventory iinventory);
}
