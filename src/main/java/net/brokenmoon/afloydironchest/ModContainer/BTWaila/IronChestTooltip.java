package net.brokenmoon.afloydironchest.ModContainer.BTWaila;

import net.brokenmoon.afloydironchest.mixin.Modded.BTWaila.GuiBlockOverlayAccessor;
import net.brokenmoon.afloydironchest.tileEntities.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.render.ItemRenderer;
import net.minecraft.client.render.entity.ItemEntityRenderer;
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
        drawInventory(guiBlockOverlay,inventory, 0, .5f);
    }
    private void drawInventory(GuiBlockOverlay guiBlockOverlay,IInventory inventory, int offX, float scale) {
        int itemX = 0;
        int itemY = 0;

        GuiBlockOverlayAccessor accessor = (GuiBlockOverlayAccessor)guiBlockOverlay;
        ItemEntityRenderer itemRender = accessor.getItemRender();
        Minecraft theGame = accessor.getTheGame();
        int posX = guiBlockOverlay.getPosX();
        int offY = guiBlockOverlay.getOffY();

        float invScale = 1/scale;
        int itemWidth = (int) (16 * scale);
        int itemsAcross = (int) (144f/(16 * scale));

        GL11.glScaled(scale, scale, scale);
        for(int i = 0; i < inventory.getSizeInventory(); ++i) {
            ItemStack itemStack = inventory.getStackInSlot(i);
            if (itemStack != null) {
                int itemXPos = (int) ((32 + posX + offX + itemX * itemWidth) * invScale);
                int itemYos = (int) ((offY + itemY * itemWidth) * invScale);
                itemRender.renderItemIntoGUI(theGame.fontRenderer, theGame.renderEngine, itemStack, itemXPos, itemYos, 1.0F);
                itemRender.renderItemOverlayIntoGUI(theGame.fontRenderer, theGame.renderEngine, itemStack, itemXPos, itemYos, 1.0F);
                GL11.glDisable(2896);
                ++itemX;
                if (itemX >= itemsAcross) {
                    itemX = 0;
                    ++itemY;
                }
            }
        }
        GL11.glScaled(invScale, invScale, invScale);
        guiBlockOverlay.addOffY(8 * (1 + itemY));
    }
}
