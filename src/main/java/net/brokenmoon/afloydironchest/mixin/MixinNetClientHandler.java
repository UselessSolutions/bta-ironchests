package net.brokenmoon.afloydironchest.mixin;

import net.brokenmoon.afloydironchest.IronChestMain;
import net.brokenmoon.afloydironchest.MixinInterfaces.IEntityPlayer;
import net.brokenmoon.afloydironchest.tileEntities.TileEntityDiamondChest;
import net.minecraft.client.Minecraft;
import net.minecraft.client.net.handler.PacketHandlerClient;
import net.minecraft.core.net.packet.PacketContainerOpen;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = PacketHandlerClient.class, remap = false)
public class MixinNetClientHandler {
    @Final
    @Shadow
    private Minecraft mc;

    @Inject(method = "handleOpenWindow", at = @At("TAIL"))
    public void injectMethod(PacketContainerOpen packet100openwindow, CallbackInfo info) {
        if (packet100openwindow.inventoryType == IronChestMain.config.getInt("ids.diamondWindowID")) {
            TileEntityDiamondChest dchest = new TileEntityDiamondChest();
            ((IEntityPlayer)this.mc.thePlayer).afloydironchest$displayGUIDiamondChest(dchest);
            this.mc.thePlayer.craftingInventory.containerId = packet100openwindow.windowId;
        }
    }
}
