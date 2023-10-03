package net.brokenmoon.afloydironchest.mixin;

import net.brokenmoon.afloydironchest.IronChestMain;
import net.brokenmoon.afloydironchest.MixinInterfaces.IEntityPlayer;
import net.brokenmoon.afloydironchest.gui.ContainerWideChest;
import net.minecraft.core.net.packet.Packet100OpenWindow;
import net.minecraft.core.player.inventory.ContainerChest;
import net.minecraft.core.player.inventory.IInventory;
import net.minecraft.server.entity.player.EntityPlayerMP;
import net.minecraft.server.net.handler.NetServerHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin(value = EntityPlayerMP.class, remap = false)
public class MixinEntityPlayerMP implements IEntityPlayer {

    @Shadow
    private void getNextWindowId() {}
    @Shadow
    private int currentWindowId;
    @Shadow
    public NetServerHandler playerNetServerHandler;
    @Unique
    private EntityPlayerMP thisAs = (EntityPlayerMP)(Object)this;


    public void displayGUIIronChest(IInventory iinventory) {
        this.getNextWindowId();
        NetServerHandler.logger.info(thisAs.username + " interacted with iron chest at (" + thisAs.x + ", " + thisAs.y + ", " + thisAs.z + ")");
        this.playerNetServerHandler.sendPacket(new Packet100OpenWindow(this.currentWindowId, 0, iinventory.getInvName(), iinventory.getSizeInventory()));
        ((EntityPlayerMP)(Object)this).craftingInventory = new ContainerChest(((EntityPlayerMP)(Object)this).inventory, iinventory);
        ((EntityPlayerMP)(Object)this).craftingInventory.windowId = this.currentWindowId;
        ((EntityPlayerMP)(Object)this).craftingInventory.onContainerInit(((EntityPlayerMP)(Object)this));
    }

    public void displayGUIDiamondChest(IInventory iinventory) {
        this.getNextWindowId();
        NetServerHandler.logger.info(thisAs.username + " interacted with iron chest at (" + thisAs.x + ", " + thisAs.y + ", " + thisAs.z + ")");
        this.playerNetServerHandler.sendPacket(new Packet100OpenWindow(this.currentWindowId, IronChestMain.config.getInt("ids.diamondWindowID"), iinventory.getInvName(), iinventory.getSizeInventory()));
        ((EntityPlayerMP)(Object)this).craftingInventory = new ContainerWideChest(((EntityPlayerMP)(Object)this).inventory, iinventory);
        ((EntityPlayerMP)(Object)this).craftingInventory.windowId = this.currentWindowId;
        ((EntityPlayerMP)(Object)this).craftingInventory.onContainerInit(((EntityPlayerMP)(Object)this));
    }
}
