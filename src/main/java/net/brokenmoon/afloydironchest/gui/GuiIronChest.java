package net.brokenmoon.afloydironchest.gui;

import net.minecraft.client.gui.GuiContainer;
import net.minecraft.core.player.inventory.ContainerChest;
import net.minecraft.core.player.inventory.IInventory;
import org.lwjgl.opengl.GL11;

public class GuiIronChest extends GuiContainer {
    private final IInventory upperChestInventory;
    private final IInventory lowerChestInventory;
    private final int inventoryRows;

    public GuiIronChest(IInventory iinventory, IInventory iinventory1) {
        super(new ContainerChest(iinventory, iinventory1));
        this.upperChestInventory = iinventory;
        this.lowerChestInventory = iinventory1;
        this.allowIngameInput = false;
        int c = 222;
        int i = c - 108;
        this.inventoryRows = iinventory1.getSizeInventory() / 9;
        this.ySize = i + this.inventoryRows * 18;
    }

    @Override
    protected void drawGuiContainerForegroundLayer() {
        this.fontRenderer.drawString(this.lowerChestInventory.getInvName(), 8, 6, 0x404040);
        this.fontRenderer.drawString(this.upperChestInventory.getInvName(), 8, this.ySize - 96 + 2, 0x404040);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f) {
        int i = this.mc.renderEngine.getTexture("/gui/container.png");
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.renderEngine.bindTexture(i);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        int h1 = Math.min(this.inventoryRows, 6) * 18 + 17;
        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, h1);
        int rows = this.inventoryRows;
        while (rows > 6) {
            int h2 = Math.min(rows, 6) * 18;
            this.drawTexturedModalRect(x, y + h1, 0, 17, this.xSize, h2);
            rows -= 6;
            h1 += h2;
        }
        this.drawTexturedModalRect(x, y + this.inventoryRows * 18 + 17, 0, 126, this.xSize, 96);
    }
}
