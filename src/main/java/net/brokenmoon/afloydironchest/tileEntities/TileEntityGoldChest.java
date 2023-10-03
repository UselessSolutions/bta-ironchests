package net.brokenmoon.afloydironchest.tileEntities;

import net.minecraft.core.item.ItemStack;

public class TileEntityGoldChest extends TileEntityBigChest {
    public TileEntityGoldChest(){
        contents = new ItemStack[81];
    }
    @Override
    public String getInvName() {
        return "Gold Chest";
    }
}
