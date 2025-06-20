package net.brokenmoon.afloydironchest.mixin.Entity;

import net.brokenmoon.afloydironchest.MixinInterfaces.IEntityPlayer;

import net.minecraft.core.entity.player.Player;
import net.minecraft.core.player.inventory.container.Container;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value = Player.class, remap = false)
public class MixinEntityPlayer implements IEntityPlayer {
    @Override
    public void afloydironchest$displayGUIIronChest(Container iinventory) {}

    @Override
    public void afloydironchest$displayGUIDiamondChest(Container iinventory) {}
}
