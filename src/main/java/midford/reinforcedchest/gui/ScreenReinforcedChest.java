package midford.reinforcedchest.gui;


import midford.reinforcedchest.menu.MenuExtraWideChest;
import net.minecraft.client.gui.container.ScreenContainerAbstract;
import net.minecraft.core.player.inventory.container.Container;
import org.lwjgl.opengl.GL11;

public class ScreenReinforcedChest extends ScreenContainerAbstract {

    public ScreenReinforcedChest(Container iinventory, Container iinventory1) {
        super(new MenuExtraWideChest(iinventory, iinventory1));
        this.passEvents = false;
        this.ySize = 256;
        this.xSize = 482;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f) {

        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        this.mc.textureManager.loadTexture("/assets/reinforcedchest/textures/gui/containerExtraWide.png").bind();
        this.drawTexturedModalRect(x, y, 0, 0, 512, this.ySize, 1/512d, 1/256d);
    }
}
