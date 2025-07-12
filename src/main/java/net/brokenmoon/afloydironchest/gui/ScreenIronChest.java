package net.brokenmoon.afloydironchest.gui;

import net.minecraft.client.gui.container.ScreenContainerAbstract;

import net.minecraft.core.lang.I18n;
import net.minecraft.core.player.inventory.container.Container;
import net.minecraft.core.player.inventory.menu.MenuContainer;
import org.lwjgl.opengl.GL11;

public class ScreenIronChest extends ScreenContainerAbstract {
    private final Container upperChestInventory;
    private final Container lowerChestInventory;
    private final int inventoryRows;

    public ScreenIronChest(Container iinventory, Container iinventory1) {
        super(new MenuContainer(iinventory, iinventory1));
        this.upperChestInventory = iinventory;
        this.lowerChestInventory = iinventory1;
        this.passEvents = false;
        int c = 222;
        int i = c - 108;
        this.inventoryRows = iinventory1.getContainerSize() / 9;
        this.ySize = i + this.inventoryRows * 18;
    }

    @Override
    protected void drawGuiContainerForegroundLayer() {
        this.font.drawString(I18n.getInstance().translateNameKey(this.lowerChestInventory.getNameTranslationKey()), 8, 6, 0x404040);
        this.font.drawString(I18n.getInstance().translateKey(this.upperChestInventory.getNameTranslationKey()), 8, this.ySize - 96 + 2, 0x404040);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f) {
        this.mc.textureManager.loadTexture("/gui/container.png").bind();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        int h1 = Math.min(this.inventoryRows, 6) * 18 + 17;
        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, h1);
        int rows = this.inventoryRows;
        while (rows > 6) {
            int h2 = 6 * 18;
            this.drawTexturedModalRect(x, y + h1, 0, 17, this.xSize, h2);
            rows -= 6;
            h1 += h2;
        }
        this.drawTexturedModalRect(x, y + this.inventoryRows * 18 + 17, 0, 126, this.xSize, 96);
    }
}
