package net.brokenmoon.afloydironchest.tileEntities;

import net.brokenmoon.afloydironchest.IronChestMain;
import net.minecraft.core.item.ItemStack;

public class TileEntityDiamondChest extends TileEntityBigChest {
    public TileEntityDiamondChest(){
        contents = new ItemStack[108];
    }

    @Override
    public String getNameTranslationKey() {
        return "container."+ IronChestMain.MOD_ID +".diamondChest.name";
    }

}
