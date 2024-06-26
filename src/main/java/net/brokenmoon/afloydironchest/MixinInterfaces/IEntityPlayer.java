package net.brokenmoon.afloydironchest.MixinInterfaces;

import net.minecraft.core.player.inventory.IInventory;

public interface IEntityPlayer {
    void afloydironchest$displayGUIIronChest(IInventory iinventory);

    void afloydironchest$displayGUIDiamondChest(IInventory iinventory);
}
