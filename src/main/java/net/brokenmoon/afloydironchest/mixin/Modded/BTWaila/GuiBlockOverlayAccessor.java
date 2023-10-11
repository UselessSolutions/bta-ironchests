package net.brokenmoon.afloydironchest.mixin.Modded.BTWaila;

import org.spongepowered.asm.mixin.Mixin;
import toufoumaster.btwaila.gui.GuiBlockOverlay;

@Mixin(value = GuiBlockOverlay.class, remap = false)
public interface GuiBlockOverlayAccessor {
}
