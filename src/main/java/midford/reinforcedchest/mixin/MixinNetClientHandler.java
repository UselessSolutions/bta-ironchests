package midford.reinforcedchest.mixin;

import midford.reinforcedchest.IronChestMain;
import midford.reinforcedchest.MixinInterfaces.IEntityPlayer;
import midford.reinforcedchest.tileEntities.TileEntityReinforcedChest;
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
        if (packet100openwindow.inventoryType == IronChestMain.config.getInt("ids.reinforcedWindowID")) {
            TileEntityReinforcedChest rchest = new TileEntityReinforcedChest();
            ((IEntityPlayer)this.mc.thePlayer).reinforcedchest$displayGUIReinforcedChest(rchest);
            this.mc.thePlayer.craftingInventory.containerId = packet100openwindow.windowId;
        }
    }

}
