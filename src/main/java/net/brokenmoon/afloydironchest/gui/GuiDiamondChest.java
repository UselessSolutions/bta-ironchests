package net.brokenmoon.afloydironchest.gui;

import net.minecraft.client.gui.GuiContainer;
import net.minecraft.core.player.inventory.IInventory;
import org.lwjgl.opengl.GL11;

public class GuiDiamondChest extends GuiContainer {
    private IInventory upperChestInventory;
    private IInventory lowerChestInventory;
    private int inventoryRows;

    public GuiDiamondChest(IInventory iinventory, IInventory iinventory1) {
        super(new ContainerWideChest(iinventory, iinventory1));
        this.upperChestInventory = iinventory;
        this.lowerChestInventory = iinventory1;
        this.allowIngameInput = false;
        this.inventoryRows = iinventory1.getSizeInventory() / 12;
        this.ySize = 256;
        this.xSize = 230;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f) {
        int i = this.mc.renderEngine.getTexture("/assets/ironchest/textures/gui/containerWide.png");
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.renderEngine.bindTexture(i);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
    }
}
