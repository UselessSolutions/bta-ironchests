package midford.reinforcedchest.mixin.Entity;

import midford.reinforcedchest.IronChestMain;
import midford.reinforcedchest.MixinInterfaces.IEntityPlayer;
import midford.reinforcedchest.menu.MenuExtraWideChest;
import net.minecraft.core.net.packet.PacketContainerOpen;

import net.minecraft.core.player.inventory.container.Container;
import net.minecraft.server.entity.player.PlayerServer;
import net.minecraft.server.net.handler.PacketHandlerServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin(value = PlayerServer.class, remap = false, priority = 2000)
public class MixinEntityPlayerMP implements IEntityPlayer {

    @Shadow
    private void getNextWindowId() {}
    @Shadow
    private int currentWindowId;
    @Shadow
    public PacketHandlerServer playerNetServerHandler;
    @Unique
    private final PlayerServer thisAs = (PlayerServer)(Object)this;

    @Unique
    public void reinforcedchest$displayGUIReinforcedChest(Container iinventory) {
        this.getNextWindowId();
        IronChestMain.logNetwork(thisAs.username + " interacted with iron chest at (" + thisAs.x + ", " + thisAs.y + ", " + thisAs.z + ")");
        this.playerNetServerHandler.sendPacket(new PacketContainerOpen(this.currentWindowId, IronChestMain.config.getInt("ids.reinforcedWindowID"), iinventory.getNameTranslationKey(), iinventory.getContainerSize()));
        thisAs.craftingInventory = new MenuExtraWideChest(thisAs.inventory, iinventory);
        thisAs.craftingInventory.containerId = this.currentWindowId;
        thisAs.craftingInventory.addSlotListener(thisAs);
    }
}
