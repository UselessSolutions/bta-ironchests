package net.brokenmoon.afloydironchest.tileEntities;

import net.brokenmoon.afloydironchest.IronChestMain;
import net.minecraft.core.item.ItemStack;

public class TileEntitySteelChest extends TileEntityBigChest {
    public TileEntitySteelChest(){
        contents = new ItemStack[108];
    }
    @Override
    public String getNameTranslationKey() {
        return "container."+ IronChestMain.MOD_ID +".steelChest";
    }
}
