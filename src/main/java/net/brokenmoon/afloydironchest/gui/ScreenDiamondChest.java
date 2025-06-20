package net.brokenmoon.afloydironchest.gui;


import net.minecraft.client.gui.container.ScreenContainerAbstract;
import net.minecraft.core.player.inventory.container.Container;
import org.lwjgl.opengl.GL11;

public class ScreenDiamondChest extends ScreenContainerAbstract {
    private Container upperChestInventory;
    private Container lowerChestInventory;
    private int inventoryRows;

    public ScreenDiamondChest(Container iinventory, Container iinventory1) {
        super(new MenuWideChest(iinventory, iinventory1));
        this.upperChestInventory = iinventory;
        this.lowerChestInventory = iinventory1;
        this.passEvents = false;
        this.inventoryRows = iinventory1.getContainerSize() / 12;
        this.ySize = 256;
        this.xSize = 230;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f) {
        this.mc.textureManager.loadTexture("/assets/ironchest/textures/gui/containerWide.png").bind();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
    }
}
