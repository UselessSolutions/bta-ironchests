package net.brokenmoon.afloydironchest.tileEntities;

import net.brokenmoon.afloydironchest.IronChestMain;
import net.minecraft.core.item.ItemStack;

public class TileEntityGoldChest extends TileEntityBigChest {
    public TileEntityGoldChest(){
        contents = new ItemStack[81];
    }

    @Override
    public String getNameTranslationKey() {
        return "container."+ IronChestMain.MOD_ID +".goldChest";
    }
}
