package net.brokenmoon.afloydironchest.mixin.Modded.BTWaila;

import net.minecraft.client.Minecraft;
import net.minecraft.client.render.entity.ItemEntityRenderer;
import net.minecraft.core.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import toufoumaster.btwaila.gui.GuiBlockOverlay;

import java.util.HashMap;

@Mixin(value = GuiBlockOverlay.class, remap = false)
public interface GuiBlockOverlayAccessor {
    @Accessor
    Minecraft getTheGame();
    @Accessor
    ItemEntityRenderer getItemRender();
    @Accessor
    HashMap<Class, Item> getEntityIconMap();

}
