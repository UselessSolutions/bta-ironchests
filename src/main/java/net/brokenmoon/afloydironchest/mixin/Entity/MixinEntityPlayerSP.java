package net.brokenmoon.afloydironchest.mixin.Entity;

import net.brokenmoon.afloydironchest.MixinInterfaces.IEntityPlayer;
import net.brokenmoon.afloydironchest.gui.ScreenDiamondChest;
import net.brokenmoon.afloydironchest.gui.ScreenIronChest;
import net.minecraft.client.Minecraft;

import net.minecraft.client.entity.player.PlayerLocal;
import net.minecraft.core.player.inventory.container.Container;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin(value = PlayerLocal.class, remap = false)
public class MixinEntityPlayerSP implements IEntityPlayer {
    @Unique
    private final PlayerLocal thisAs = (PlayerLocal)(Object)this;
    @Shadow
    protected Minecraft mc;
    public void afloydironchest$displayGUIIronChest(Container iinventory) {
        this.mc.displayScreen(new ScreenIronChest(thisAs.inventory, iinventory));
    }

    public void afloydironchest$displayGUIDiamondChest(Container iinventory) {
        this.mc.displayScreen(new ScreenDiamondChest(thisAs.inventory, iinventory));
    }
}
