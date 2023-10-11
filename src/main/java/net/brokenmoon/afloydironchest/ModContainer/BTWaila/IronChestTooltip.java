package net.brokenmoon.afloydironchest.ModContainer.BTWaila;

import net.brokenmoon.afloydironchest.tileEntities.*;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.player.inventory.IInventory;
import org.lwjgl.opengl.GL11;
import toufoumaster.btwaila.BTWaila;
import toufoumaster.btwaila.IBTWailaCustomBlockTooltip;
import toufoumaster.btwaila.TooltipGroup;
import toufoumaster.btwaila.TooltipRegistry;
import toufoumaster.btwaila.gui.GuiBlockOverlay;

public class IronChestTooltip implements IBTWailaCustomBlockTooltip {
    public void addTooltip() {
        BTWaila.LOGGER.info("Adding tooltips for: " + this.getClass().getSimpleName());
        TooltipGroup tooltipGroup = new TooltipGroup("minecraft", IInventory.class, this);
        tooltipGroup.addTooltip(TileEntityBigChest.class);
        tooltipGroup.addTooltip(TileEntityIronChest.class);
        tooltipGroup.addTooltip(TileEntityGoldChest.class);
        tooltipGroup.addTooltip(TileEntityDiamondChest.class);
        tooltipGroup.addTooltip(TileEntitySteelChest.class);
        TooltipRegistry.tooltipMap.add(tooltipGroup);
    }
    public void drawAdvancedTooltip(TileEntity tileEntity, GuiBlockOverlay guiBlockOverlay) {
        IInventory inventory = (IInventory)tileEntity;
        int max = inventory.getSizeInventory();
        int current = 0;

        for(int i = 0; i < max; ++i) {
            ItemStack itemStack = inventory.getStackInSlot(i);
            if (itemStack != null) {
                current += itemStack.stackSize;
            }
        }

        guiBlockOverlay.drawStringWithShadow("Stored items: " + current + "/" + max * inventory.getInventoryStackLimit(), 0);
        guiBlockOverlay.drawInventory(inventory, 0);
    }
}
