package net.brokenmoon.afloydironchest.tileEntities;

import net.brokenmoon.afloydironchest.IronChestMain;
import net.minecraft.core.item.ItemStack;
public class TileEntityIronChest extends TileEntityBigChest {
    public TileEntityIronChest(){
        contents = new ItemStack[54];
    }

    @Override
    public String getNameTranslationKey() {
        return "container."+ IronChestMain.MOD_ID +".ironChest.name";
    }
}
